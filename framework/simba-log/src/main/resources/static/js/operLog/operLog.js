var OperLog = {
	
	"search": function() {
		OperLog.initOperLogList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/operLog/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='operLog']").each(function() {
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
			url: contextPath + "/operLog/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					OperLog.initOperLogList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initOperLogList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/operLog/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"ip": $("#ip").val(),
				"account": $("#account").val(),
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/operLog/count",
			async: true,
			data: {
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"ip": $("#ip").val(),
				"account": $("#account").val(),
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "OperLog.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		OperLog.initOperLogList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/operLog/toUpdate?id=" + id;
	},

	"deleteOperLog": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/operLog/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					OperLog.initOperLogList(0, Page.size);
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
		window.self.location.href = contextPath + "/operLog/list";
	},

	"end": null
};