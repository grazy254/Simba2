var OperLogger = {
	
	"toSearch": function() {
		OperLogger.initOperLoggerSearchList(0, Page.size);
	},
	
	"toAdd": function() {
		window.self.location.href = contextPath + "/operLogger/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='operLogger']").each(function() {
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
			url: contextPath + "/operLogger/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					OperLogger.initOperLoggerList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"initOperLoggerList": function(start, pageSize, method) {
		var data = {}
		var data2 = {}
		method = method || "getList"
		data["ip"] = $("#ip").val()
		data["startTime"] = $("#startTime").val()
		data["endTime"] = $("#endTime").val()
		data["account"] = $("#account").val()
		$.extend(data2,data);
		data["pageStart"] = start
		data["pageSize"] = pageSize
		$.ajax({
			type: "get",
			url: contextPath + "/operLogger/" + method,
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
			url: contextPath + "/operLogger/count",
			async: true,
			data: data2,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "OperLogger.clickPager");
				alert(pageHtml)
				$("#page").html(pageHtml);
			}
		});
	},
	"initOperLoggerSearchList": function(start, pageSize,) {
		OperLogger.initOperLoggerList(start, pageSize, "doSearch");
	},
	"clickPager": function(start, pageSize) {
		OperLogger.initOperLoggerList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/operLogger/toUpdate?id=" + id;
	},

	"deleteOperLogger": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/operLogger/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					OperLogger.initOperLoggerList(0, Page.size);
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
		window.self.location.href = contextPath + "/operLogger/list";
	},

	"end": null
};