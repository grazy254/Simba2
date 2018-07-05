var ReceiveEvent = {

	"search": function() {
		ReceiveEvent.initReceiveEventList(0, Page.size);
	},

	"showXML": function(id) {
		parent.showModal("查看完整XML", contextPath + "/receiveEvent/showXML?id=" + id, 550);
	},
	"toAdd": function() {
		window.self.location.href = contextPath + "/receiveEvent/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='receiveEvent']").each(function() {
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
			url: contextPath + "/receiveEvent/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ReceiveEvent.initReceiveEventList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initReceiveEventList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/receiveEvent/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"openid": $("#openid").val(),
				"type": $("#type").val(),
				"eventKey": $("#eventKey").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/receiveEvent/count",
			async: true,
			data: {
				"openid": $("#openid").val(),
				"type": $("#type").val(),
				"eventKey": $("#eventKey").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ReceiveEvent.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		ReceiveEvent.initReceiveEventList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/receiveEvent/toUpdate?id=" + id;
	},

	"deleteReceiveEvent": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/receiveEvent/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ReceiveEvent.initReceiveEventList(0, Page.size);
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
		window.self.location.href = contextPath + "/receiveEvent/list";
	},

	"end": null
};