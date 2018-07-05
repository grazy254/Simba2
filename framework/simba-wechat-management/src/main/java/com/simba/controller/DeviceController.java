package com.simba.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.controller.form.DevicePropertiesForm;
import com.simba.framework.util.common.StringUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.Device;
import com.simba.model.form.DeviceSearchForm;
import com.simba.model.wxHardware.send.DeviceInfo;
import com.simba.service.DeviceService;
import com.simba.util.send.NewAuthWxUtil;

/**
 * 设备控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/device")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private NewAuthWxUtil newAuthWxUtil;

	/**
	 * 设置微信设备属性
	 * 
	 * @return
	 */
	@RequestMapping("/setProperties")
	public String setProperties(String selectedDevice, ModelMap model) {
		model.put("selectedDevice", selectedDevice);
		return "device/setProperties";
	}

	@ResponseBody
	@RequestMapping("/setWxProperties")
	public JsonResult setWxProperties(String[] selectedDevice, String mac, DevicePropertiesForm form) {
		String[] connect_protocol = form.getConnect_protocol();
		String connectProtocol = null;
		if (connect_protocol.length == 1) {
			connectProtocol = connect_protocol[0];
		} else {
			connectProtocol = StringUtil.join(Arrays.asList(connect_protocol), "|");
		}
		for (String deviceId : selectedDevice) {
			if (StringUtils.isEmpty(deviceId)) {
				continue;
			}
			Device device = deviceService.get(NumberUtils.toLong(deviceId));
			if (StringUtils.isEmpty(mac)) {
				throw new RuntimeException("设备[" + device.getWxDeviceId() + "]还没有绑定产品，不能设置微信设备属性");
			}
			DeviceInfo deviceInfo = new DeviceInfo();
			deviceInfo.setDevice_num("1");
			deviceInfo.setOp_type("1");
			List<com.simba.model.wxHardware.send.Device> device_list = new ArrayList<>(1);
			com.simba.model.wxHardware.send.Device wxDevice = new com.simba.model.wxHardware.send.Device();
			wxDevice.setAuth_key(form.getAuth_key());
			wxDevice.setAuth_ver(wxDevice.getAuth_ver());
			wxDevice.setBle_simple_protocol(form.getBle_simple_protocol());
			wxDevice.setClose_strategy(form.getClose_strategy());
			wxDevice.setConn_strategy(form.getConn_strategy());
			wxDevice.setConnect_protocol(connectProtocol);
			wxDevice.setCrypt_method(form.getCrypt_method());
			wxDevice.setId(device.getWxDeviceId());
			wxDevice.setMac(mac);
			wxDevice.setManu_mac_pos(form.getManu_mac_pos());
			wxDevice.setSer_mac_pos(form.getSer_mac_pos());
			device_list.add(wxDevice);
			deviceInfo.setDevice_list(device_list);
			newAuthWxUtil.updateDeviceInfo(deviceInfo);
		}
		return new JsonResult();
	}

	/**
	 * 显示请求微信二维码页面
	 * 
	 * @return
	 */
	@RequestMapping("/showQuestQrCode")
	public String showQuestQrCode() {
		return "device/showQuestQrCode";
	}

	/**
	 * 执行微信请求二维码
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/exeQrCode")
	public JsonResult exeQrCode(String wxProductId, int num) {
		deviceService.requestQrCode(wxProductId, num);
		return new JsonResult();
	}

	@RequestMapping("/list")
	public String list() {
		return "device/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, DeviceSearchForm searchForm, ModelMap model) {
		List<Device> list = deviceService.page(pager, searchForm);
		model.put("list", list);
		return "device/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count(DeviceSearchForm searchForm) {
		int count = deviceService.count(searchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "device/add";
	}

	@RequestMapping("/add")
	public String add(Device device) {
		deviceService.add(device);
		return "redirect:/device/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		Device device = deviceService.get(id);
		model.put("device", device);
		return "device/update";
	}

	@RequestMapping("/update")
	public String update(Device device) {
		deviceService.update(device);
		return "redirect:/device/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		deviceService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		deviceService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

}
