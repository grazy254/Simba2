package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.bootstrap.model.TreeViewData;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.WxMenu;
import com.simba.model.constant.ConstantData;
import com.simba.model.wx.menu.Menu;
import com.simba.model.wx.menu.MenuButton;
import com.simba.model.wx.menu.MenuType;
import com.simba.service.WxMenuService;
import com.simba.util.send.MenuWxUtil;

/**
 * 微信菜单控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/wxMenu")
public class WxMenuController {

	@Autowired
	private WxMenuService wxMenuService;

	@Autowired
	private MenuWxUtil menuWxUtil;

	/**
	 * 将所有菜单发布到微信服务器
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/publishMenuToWx")
	public JsonResult publishMenuToWx() {
		List<WxMenu> topMenus = wxMenuService.listBy("parentID", ConstantData.TREE_ROOT_ID);
		Menu menu = new Menu();
		List<MenuButton> buttons = new ArrayList<>(topMenus.size());
		menu.setButton(buttons);
		topMenus.forEach((wxMenu) -> {
			MenuButton button = buildWxMenu(wxMenu);
			List<WxMenu> secondMenus = wxMenuService.listBy("parentID", wxMenu.getId());
			List<MenuButton> subButtons = new ArrayList<>(secondMenus.size());
			secondMenus.forEach((secondMenu) -> {
				MenuButton secondButton = buildWxMenu(secondMenu);
				subButtons.add(secondButton);
			});
			button.setSub_button(subButtons);
			buttons.add(button);
		});
		menuWxUtil.create(menu);
		return new JsonResult();
	}

	private MenuButton buildWxMenu(WxMenu wxMenu) {
		MenuButton button = new MenuButton();
		button.setName(wxMenu.getText());
		button.setType(wxMenu.getType());
		button.setKey(wxMenu.getMenuKey());
		button.setMedia_id(wxMenu.getMediaId());
		button.setUrl(wxMenu.getUrl());
		button.setAppid(wxMenu.getAppid());
		button.setPagepath(wxMenu.getPagepath());
		return button;
	}

	/**
	 * 检查这个父菜单下是否能新增子菜单
	 * 
	 * @param parentID
	 * @return
	 */
	private boolean canOper(int parentID) {
		int count = wxMenuService.countBy("parentID", parentID);
		boolean allow = true;
		if (parentID == ConstantData.TREE_ROOT_ID) {
			if (count > 2) {
				allow = false;
			}
		} else {
			if (count > 4) {
				allow = false;
			}
		}
		if (allow && parentID != ConstantData.TREE_ROOT_ID) {
			WxMenu parentMenu = wxMenuService.get(parentID);
			if (parentMenu.getParentID() != ConstantData.TREE_ROOT_ID) {
				allow = false;
			}
		}
		return allow;
	}

	/**
	 * 验证是否可以增加菜单
	 * 
	 * @param parentID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/validateAdd")
	public JsonResult validateAdd(int parentID) {
		return new JsonResult(canOper(parentID));
	}

	@RequestMapping("/list")
	public String list(Integer parentID, ModelMap model) {
		if (parentID == null) {
			parentID = ConstantData.TREE_ROOT_ID;
		}
		String parentName = "微信菜单树";
		if (parentID != ConstantData.TREE_ROOT_ID) {
			parentName = wxMenuService.get(parentID).getText();
		}
		model.put("parentID", parentID);
		model.put("parentName", parentName);
		return "wxMenu/list";
	}

	@ResponseBody
	@RequestMapping("/getWxMenuTree")
	public List<TreeViewData> getWxMenuTree() {
		TreeViewData root = new TreeViewData();
		root.setId(ConstantData.TREE_ROOT_ID);
		root.setText("微信菜单树");
		root.setTags(ConstantData.TREE_ROOT_ID + "");
		List<WxMenu> allWxMenus = wxMenuService.listAll();
		Map<Integer, TreeViewData> nodeMap = new HashMap<>();
		allWxMenus.forEach((WxMenu wxMenu) -> {
			TreeViewData node = new TreeViewData();
			node.setId(wxMenu.getId());
			node.setText(wxMenu.getText());
			node.setTags(wxMenu.getId() + "");
			node.setParentID(wxMenu.getParentID());
			nodeMap.put(wxMenu.getId(), node);
		});
		nodeMap.put(root.getId(), root);
		allWxMenus.forEach((WxMenu wxMenu) -> {
			TreeViewData node = nodeMap.get(wxMenu.getId());
			TreeViewData parentNode = nodeMap.get(wxMenu.getParentID());
			parentNode.addChildren(node);
		});
		List<TreeViewData> list = new ArrayList<>(1);
		list.add(root);
		return list;
	}

	@RequestMapping("/getWxMenuList")
	public String getWxMenuList(int parentID, ModelMap model) {
		List<WxMenu> list = wxMenuService.listBy("parentID", parentID);
		model.put("list", list);
		return "wxMenu/table";
	}

	/**
	 * 新增微信菜单
	 * 
	 * @param wxMenu
	 * @return
	 */
	@RequestMapping("/add")
	public String add(WxMenu wxMenu) {
		check(wxMenu);
		wxMenuService.add(wxMenu);
		return "redirect:/wxMenu/list?parentID=" + wxMenu.getParentID();
	}

	private void check(WxMenu wxMenu) {
		if (!canOper(wxMenu.getParentID())) {
			throw new RuntimeException("此父菜单下已经到达微信创建菜单上限，不能再创建新菜单了!");
		}
		checkParam(wxMenu);
	}

	private void checkParam(WxMenu wxMenu) {
		if (wxMenu.getParentID() == ConstantData.TREE_ROOT_ID && wxMenu.getText().length() > 4) {
			throw new RuntimeException("菜单名不能超过4个字!");
		}
		if (wxMenu.getParentID() != ConstantData.TREE_ROOT_ID && wxMenu.getText().length() > 7) {
			throw new RuntimeException("菜单名不能超过7个字!");
		}
		if (StringUtils.isEmpty(wxMenu.getMenuKey())) {
			throw new RuntimeException("菜单KEY值不能为空!");
		}
		if (wxMenu.getMenuKey().length() > 128) {
			throw new RuntimeException("菜单KEY值不能超过128!");
		}
		if (wxMenu.getType().equals(MenuType.MINIPROGRAM)) {
			if (StringUtils.isEmpty(wxMenu.getAppid())) {
				throw new RuntimeException("小程序appid不能为空!");
			}
			if (StringUtils.isEmpty(wxMenu.getPagepath())) {
				throw new RuntimeException("小程序页面路径不能为空!");
			}
		}
	}

	@RequestMapping("/toAdd")
	public String toAdd(int parentID, ModelMap model) {
		String parentName = "微信菜单树";
		if (parentID != ConstantData.TREE_ROOT_ID) {
			parentName = wxMenuService.get(parentID).getText();
		}
		model.put("parentID", parentID);
		model.put("parentName", parentName);
		model.put("types", MenuType.values());
		return "wxMenu/add";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(int id, ModelMap model) {
		WxMenu wxMenu = wxMenuService.get(id);
		String parentName = "微信菜单树";
		int parentID = wxMenu.getParentID();
		if (parentID != ConstantData.TREE_ROOT_ID) {
			parentName = wxMenuService.get(parentID).getText();
		}
		model.put("wxMenu", wxMenu);
		model.put("parentName", parentName);
		model.put("types", MenuType.values());
		return "wxMenu/update";
	}

	@RequestMapping("/update")
	public String update(WxMenu wxMenu) {
		checkParam(wxMenu);
		WxMenu oldMenu = wxMenuService.get(wxMenu.getId());
		if (wxMenu.getParentID() != oldMenu.getParentID()) {
			if (!canOper(wxMenu.getParentID())) {
				throw new RuntimeException("此父菜单下已经到达微信创建菜单上限，不能再创建新菜单了!");
			}
		}
		wxMenuService.update(wxMenu);
		return "redirect:/wxMenu/list?parentID=" + wxMenu.getParentID();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(int id, ModelMap model) {
		wxMenuService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Integer[] id, ModelMap model) {
		wxMenuService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
