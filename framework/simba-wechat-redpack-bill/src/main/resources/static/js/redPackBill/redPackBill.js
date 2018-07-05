var RedPackBill = {

	"search": function() {
		RedPackBill.initRedPackBillList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/redPackBill/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='redPackBill']").each(function() {
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
			url: contextPath + "/redPackBill/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					RedPackBill.initRedPackBillList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initRedPackBillList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/redPackBill/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"type": $("#type").val(),
				"billNo": $("#billNo").val(),
				"openid": $("#openid").val(),
				"actName": $("#actName").val(),
				"sceneId": $("#sceneId").val(),
				"status": $("#status").val(),
				"sendListId": $("#sendListId").val(),
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
			url: contextPath + "/redPackBill/count",
			async: true,
			data: {
				"type": $("#type").val(),
				"billNo": $("#billNo").val(),
				"openid": $("#openid").val(),
				"actName": $("#actName").val(),
				"sceneId": $("#sceneId").val(),
				"status": $("#status").val(),
				"sendListId": $("#sendListId").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "RedPackBill.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		RedPackBill.initRedPackBillList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/redPackBill/toUpdate?id=" + id;
	},

	"deleteRedPackBill": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/redPackBill/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					RedPackBill.initRedPackBillList(0, Page.size);
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
		window.self.location.href = contextPath + "/redPackBill/list";
	},

	"end": null
};