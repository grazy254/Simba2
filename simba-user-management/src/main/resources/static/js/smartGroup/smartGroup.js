var SmartGroup = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/smartGroup/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='smartGroup']").each(function() {
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
			url: contextPath + "/smartGroup/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					SmartGroup.initSmartGroupList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initSmartGroupList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/smartGroup/getList",
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
			url: contextPath + "/smartGroup/count",
			async: true,
			data: {
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "SmartGroup.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		SmartGroup.initSmartGroupList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/smartGroup/toUpdate?id=" + id;
	},

	"deleteSmartGroup": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/smartGroup/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					SmartGroup.initSmartGroupList(0, Page.size);
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
		window.self.location.href = contextPath + "/smartGroup/list";
	},

	"end": null
};