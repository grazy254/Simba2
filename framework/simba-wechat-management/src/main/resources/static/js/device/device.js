var Device = {

	"search": function() {
		Device.initDeviceList(0, Page.size);
	},

	"requestQrCode": function() {
		parent.showModal("请求微信设备二维码", contextPath + "/device/showQuestQrCode", 300);
	},

	"cancelQrCode": function() {
		top.hideModal();
	},

	"exeQrCode": function() {
		var wxProductId = $("#wxProductId").val();
		var num = $("#num").val();
		if(!wxProductId) {
			$("#errMsg").html("微信产品ID不能为空");
			return false;
		}
		if(!num) {
			$("#errMsg").html("个数不能为空");
			return false;
		}
		$.ajax({
			type: "post",
			url: contextPath + "/device/exeQrCode",
			async: true,
			dataType: "json",
			data: {
				wxProductId: wxProductId,
				num: num
			},
			success: function(data) {
				if(data.code == 200) {
					top.showSuccessInfo("请求发送成功，请耐心等待......");
					top.hideModal();
				} else {
					$("#errMsg").html(data.msg);
				}
			}
		});
	},

	"setProperties": function() {
		var ids = new Array();
		$("input[name='device']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0) {
			parent.showInfo("请选择要设置的设备");
			return false;
		}
		var selectedDevice = ids.join(",");
		$("#selectedDevice").val(selectedDevice);
		parent.showModal("设置微信设备属性", contextPath + "/device/setProperties?selectedDevice=" + selectedDevice, 650);
	},

	"submitSetProperties": function() {
		var auth_key = $("#auth_key").val();
		if(!auth_key) {
			$("#errMsg").html("auth及通信的加密key不能为空");
			return false;
		}
		$.ajax({
			type: "post",
			url: contextPath + "/device/setWxProperties",
			async: true,
			data: $("#form").serialize(),
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					top.showSuccessInfo("设置微信设备属性成功");
					top.hideModal();
				} else {
					$("#errMsg").html(data.msg);
				}
			}
		});
	},

	"cancelSetProperties": function() {
		top.hideModal();
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/device/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='device']").each(function() {
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
			url: contextPath + "/device/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Device.initDeviceList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initDeviceList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/device/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"status": $("#status").val(),
				"wxDeviceId": $("#wxDeviceId").val(),
				"qrcode": $("#qrcode").val(),
				"wxProductId": $("#wxProductId").val()
			},
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
			url: contextPath + "/device/count",
			async: true,
			data: {
				"status": $("#status").val(),
				"wxDeviceId": $("#wxDeviceId").val(),
				"qrcode": $("#qrcode").val(),
				"wxProductId": $("#wxProductId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Device.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		Device.initDeviceList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/device/toUpdate?id=" + id;
	},

	"deleteDevice": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/device/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Device.initDeviceList(0, Page.size);
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
		window.self.location.href = contextPath + "/device/list";
	},

	"end": null
};