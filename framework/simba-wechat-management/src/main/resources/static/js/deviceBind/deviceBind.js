var DeviceBind = {

	"search": function() {
		DeviceBind.initDeviceBindList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/deviceBind/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='deviceBind']").each(function() {
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
			url: contextPath + "/deviceBind/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					DeviceBind.initDeviceBindList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initDeviceBindList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/deviceBind/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"openid": $("#openid").val(),
				"wxDeviceId": $("#wxDeviceId").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/deviceBind/count",
			async: true,
			data: {
				"openid": $("#openid").val(),
				"wxDeviceId": $("#wxDeviceId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "DeviceBind.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		DeviceBind.initDeviceBindList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/deviceBind/toUpdate?id=" + id;
	},

	"deleteDeviceBind": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/deviceBind/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					DeviceBind.initDeviceBindList(0, Page.size);
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
		window.self.location.href = contextPath + "/deviceBind/list";
	},

	"end": null
};