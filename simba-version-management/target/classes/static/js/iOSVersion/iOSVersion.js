var IOSVersion = {

	"publish": function(id) {
		parent.showSuccessInfo("正在发布，请耐心等待...");
		$.ajax({
			type: "post",
			url: contextPath + "/iOSVersion/publish",
			async: true,
			data: {
				id: id
			},
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("发布ISOApp安装包成功");
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/iOSVersion/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='iOSVersion']").each(function() {
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
			url: contextPath + "/iOSVersion/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					IOSVersion.initIOSVersionList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initIOSVersionList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/iOSVersion/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize
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
			url: contextPath + "/iOSVersion/count",
			async: true,
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "IOSVersion.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		IOSVersion.initIOSVersionList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/iOSVersion/toUpdate?id=" + id;
	},

	"deleteIOSVersion": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/iOSVersion/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					IOSVersion.initIOSVersionList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {

		var version = $("#version").val();
		if(!version) {
			parent.showInfo("版本号不能为空");
			return false;
		}
		var ipaFile = $("#ipaFile").val();
		if(!ipaFile) {
			parent.showInfo("IPA不能为空");
			return false;
		}
		var identifer = $("#identifer").val();
		if(!identifer) {
			parent.showInfo("IOS版本identifer属性不能为空");
			return false;
		}
		var title = $("#title").val();
		if(!title) {
			parent.showInfo("标题不能为空");
			return false;
		}

		var fullImageFile = $("#fullImageFile").val();
		if(!fullImageFile) {
			parent.showInfo("大图片文件不能为空");
			return false;
		}
		var logFile = $("#logFile").val();
		if(!logFile) {
			parent.showInfo("logo文件不能为空");
			return false;
		}

		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/iOSVersion/list";
	},

	"end": null
};