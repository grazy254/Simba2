var UserGroup = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/userGroup/toAdd";
	},

	"group": function(groupId, smartUserId) {
		$.ajax({
			type: "post",
			url: contextPath + "/smartUser/group",
			data: {
				"groupId": groupId,
				"smartUserId": smartUserId
			},
			async: false,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("分组成功");
					top.hideModal();
					top.contentiframe.window.location.href=contextPath + "/smartUser/list";
					
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='userGroup']").each(function() {
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
			url: contextPath + "/userGroup/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UserGroup.initUserGroupList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"initUserGroupList": function(start, pageSize, method) {
		var data = {}
		var data2 = {}
		method = method || "getList"
		$.extend(data2, data);
		data["pageStart"] = start
		data["pageSize"] = pageSize
		$.ajax({
			type: "get",
			url: contextPath + "/userGroup/" + method,
			data: data,
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
				CheckBox.init();
				setTimeout("CheckBox.bindCheckAll();", 1000);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/userGroup/count",
			async: true,
			data: data2,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "UserGroup.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager": function(start, pageSize) {
		UserGroup.initUserGroupList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/userGroup/toUpdate?id=" + id;
	},

	"deleteUserGroup": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/userGroup/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UserGroup.initUserGroupList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/userGroup/list";
	},

	"end": null
};