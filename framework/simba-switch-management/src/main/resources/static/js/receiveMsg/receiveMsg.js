var ReceiveMsg = {

	"showContent": function(id) {
		parent.showModal("查看内容", contextPath + "/receiveMsg/showContent?id=" + id, 350);
	},

	"search": function() {
		ReceiveMsg.initReceiveMsgList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/receiveMsg/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='receiveMsg']").each(function() {
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
			url: contextPath + "/receiveMsg/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ReceiveMsg.initReceiveMsgList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initReceiveMsgList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/receiveMsg/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"source": $("#source").val(),
				"type": $("#type").val(),
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
			url: contextPath + "/receiveMsg/count",
			async: true,
			data: {
				"source": $("#source").val(),
				"type": $("#type").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ReceiveMsg.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		ReceiveMsg.initReceiveMsgList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/receiveMsg/toUpdate?id=" + id;
	},

	"deleteReceiveMsg": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/receiveMsg/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ReceiveMsg.initReceiveMsgList(0, Page.size);
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
		window.self.location.href = contextPath + "/receiveMsg/list";
	},

	"end": null
};