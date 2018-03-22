var WxMenu = {

	"publishMenuToWx": function() {
		$.ajax({
			type: "post",
			url: contextPath + "/wxMenu/publishMenuToWx",
			async: true,
			dataType: "json",
			async: true,
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("发布到微信服务器成功");
				} else {
					parent.showInfo("发布到微信服务器异常");
				}
			}
		});
	},

	"initSelectWxMenuTree": function(id, text) {
		TreeViewUtil.initTree("tree", contextPath + "/wxMenu/getWxMenuTree", function(data) {
			$("#parentName").val(data.text);
			$("#parentID").val(data.id);
			$('#tree').fadeOut();
		}, function() {
			if(!!id && !!text) {
				TreeViewUtil.selectTreeNode("tree", id, text);
			}
		});
	},

	"initWxMenuTree": function(id, text) {
		TreeViewUtil.initTree("tree", contextPath + "/wxMenu/getWxMenuTree", function(data) {
			$("#parentName").val(data.text);
			$("#parentID").val(data.id);
			WxMenu.initWxMenuList();
		}, function() {
			if(!!id && !!text) {
				TreeViewUtil.selectTreeNode("tree", id, text);
			}
		});
	},

	"initWxMenuList": function() {
		$.ajax({
			type: "get",
			url: contextPath + "/wxMenu/getWxMenuList",
			data: {
				"parentID": $("#parentID").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
				CheckBox.init();
				setTimeout("CheckBox.bindCheckAll();", 1000);
			}
		});
	},

	"toAdd": function() {
		$.ajax({
			type: "get",
			url: contextPath + "/wxMenu/validateAdd",
			data: {
				"parentID": $("#parentID").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200 && data.data) {
					window.self.location.href = contextPath + "/wxMenu/toAdd?parentID=" + $("#parentID").val();
				} else {
					parent.showInfo("已经达到微信公众号创建菜单的上限，一级菜单只能创建3个，二级菜单5个!");
				}
			}
		});
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/wxMenu/toUpdate?id=" + id;
	},

	"deleteWxMenu": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/wxMenu/delete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					WxMenu.initWxMenuList();
					WxMenu.initWxMenuTree($("#parentID").val(), $("#parentName").val());
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='wxMenu']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0) {
			parent.showInfo("请选择要删除的记录");
			return false;
		}
		$.ajax({
			type: "post",
			url: contextPath + "/wxMenu/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					WxMenu.initWxMenuList();
					WxMenu.initWxMenuTree($("#parentID").val(), $("#parentName").val());
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"toList": function() {
		window.self.location.href = contextPath + "/wxMenu/list?parentID=" + $("#parentID").val();
	},

	"checkForm": function() {
		var text = $("#text").val();
		if(!text) {
			parent.showInfo("名称不能为空");
			return false;
		}
		var parentID = $("#parentID").val();
		if(!parentID) {
			parent.showInfo("父微信菜单不能为空");
			return false;
		}
		if($("#parentID").val() == -1) {
			if(text.length > 4) {
				parent.showInfo("菜单名不能超过4个字");
				return false;
			}
		} else {
			if(text.length > 7) {
				parent.showInfo("菜单名不能超过7个字");
				return false;
			}
		}
		var menuKey = $("#menuKey").val();
		if(!menuKey) {
			parent.showInfo("菜单KEY值不能为空!");
			return false;
		}
		if(menuKey.length > 128) {
			parent.showInfo("菜单KEY值不能超过128!");
			return false;
		}
		var type = $("#type").val();
		if(type == "miniprogram") {
			var appid = $("#appid").val();
			var pagepath = $("#pagepath").val();
			if(!appid) {
				parent.showInfo("小程序appid不能为空");
				return false;
			}
			if(!pagepath) {
				parent.showInfo("小程序页面路径不能为空");
				return false;
			}
		}
		return true;
	},

	"end": null

};