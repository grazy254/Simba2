var DeployLog = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/deployLog/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='deployLog']").each(function() {
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
			url: contextPath + "/deployLog/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					DeployLog.initDeployLogList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initDeployLogList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/deployLog/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/deployLog/count",
			async: true,
			data: {
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "DeployLog.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		DeployLog.initDeployLogList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/deployLog/toUpdate?id=" + id;
	},

	"deleteDeployLog": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/deployLog/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					DeployLog.initDeployLogList(0, Page.size);
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
		window.self.location.href = contextPath + "/deployLog/list";
	},

	"end": null
};