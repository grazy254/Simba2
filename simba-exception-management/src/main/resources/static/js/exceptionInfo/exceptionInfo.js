var ExceptionInfo = {

	"show": function(id) {
		parent.showModal("查看内容", contextPath + "/exceptionInfo/show?id=" + id, 550);
	},

	"search": function() {
		ExceptionInfo.initExceptionInfoList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/exceptionInfo/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='exceptionInfo']").each(function() {
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
			url: contextPath + "/exceptionInfo/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ExceptionInfo.initExceptionInfoList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initExceptionInfoList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/exceptionInfo/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"ip": $("#ip").val()
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
			url: contextPath + "/exceptionInfo/count",
			async: true,
			data: {
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"ip": $("#ip").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ExceptionInfo.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		ExceptionInfo.initExceptionInfoList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/exceptionInfo/toUpdate?id=" + id;
	},

	"deleteExceptionInfo": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/exceptionInfo/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ExceptionInfo.initExceptionInfoList(0, Page.size);
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
		window.self.location.href = contextPath + "/exceptionInfo/list";
	},

	"end": null
};