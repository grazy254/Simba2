var CardMoneyBill = {

	"search": function() {
		CardMoneyBill.initCardMoneyBillList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/cardMoneyBill/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='cardMoneyBill']").each(function() {
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
			url: contextPath + "/cardMoneyBill/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					CardMoneyBill.initCardMoneyBillList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initCardMoneyBillList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/cardMoneyBill/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"partnerTradeNo": $("#partnerTradeNo").val(),
				"bankNo": $("#bankNo").val(),
				"trueName": $("#trueName").val(),
				"status": $("#status").val(),
				"paymentNo": $("#paymentNo").val(),
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
			url: contextPath + "/cardMoneyBill/count",
			async: true,
			data: {
				"partnerTradeNo": $("#partnerTradeNo").val(),
				"bankNo": $("#bankNo").val(),
				"trueName": $("#trueName").val(),
				"status": $("#status").val(),
				"paymentNo": $("#paymentNo").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "CardMoneyBill.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		CardMoneyBill.initCardMoneyBillList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/cardMoneyBill/toUpdate?id=" + id;
	},

	"deleteCardMoneyBill": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/cardMoneyBill/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					CardMoneyBill.initCardMoneyBillList(0, Page.size);
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
		window.self.location.href = contextPath + "/cardMoneyBill/list";
	},

	"end": null
};