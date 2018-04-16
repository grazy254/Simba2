var FileVersion = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/fileVersion/toAdd?typeId=" + $("#typeId").val();
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='fileVersion']").each(function() {
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
			url: contextPath + "/fileVersion/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					FileVersion.initFileVersionList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initFileVersionList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/fileVersion/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"typeId": $("#typeId").val()
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
			url: contextPath + "/fileVersion/count",
			async: true,
			data: {
				"typeId": $("#typeId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "FileVersion.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		FileVersion.initFileVersionList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/fileVersion/toUpdate?id=" + id;
	},

	"deleteFileVersion": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/fileVersion/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					FileVersion.initFileVersionList(0, Page.size);
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
		return true;
	},

	"checkFile": function() {
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/fileVersion/list?typeId=" + $("#typeId").val();
	},

	"end": null
};