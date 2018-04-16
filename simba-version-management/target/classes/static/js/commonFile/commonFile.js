var CommonFile = {

	"search": function() {
		CommonFile.initCommonFileList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/commonFile/toAdd?typeId=" + $("#typeId").val();
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='commonFile']").each(function() {
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
			url: contextPath + "/commonFile/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					CommonFile.initCommonFileList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initCommonFileList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/commonFile/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"name": $("#name").val(),
				"typeId": $("#typeId").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
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
			url: contextPath + "/commonFile/count",
			async: true,
			data: {
				"name": $("#name").val(),
				"typeId": $("#typeId").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "CommonFile.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		CommonFile.initCommonFileList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/commonFile/toUpdate?id=" + id;
	},

	"deleteCommonFile": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/commonFile/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					CommonFile.initCommonFileList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var name = $("#name").val();
		if(!name) {
			parent.showInfo("名称不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/commonFile/list?typeId=" + $("#typeId").val();
	},

	"end": null
};