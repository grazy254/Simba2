var PayBill = {

	"search": function() {
		PayBill.initPayBillList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/payBill/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='payBill']").each(function() {
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
			url: contextPath + "/payBill/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("关闭订单成功");
					PayBill.initPayBillList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initPayBillList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/payBill/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"outTradeNo": $("#outTradeNo").val(),
				"goodsTag": $("#goodsTag").val(),
				"tradeType": $("#tradeType").val(),
				"productId": $("#productId").val(),
				"openid": $("#openid").val(),
				"status": $("#status").val(),
				"prepayId": $("#prepayId").val(),
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
			url: contextPath + "/payBill/count",
			async: true,
			data: {
				"outTradeNo": $("#outTradeNo").val(),
				"goodsTag": $("#goodsTag").val(),
				"tradeType": $("#tradeType").val(),
				"productId": $("#productId").val(),
				"openid": $("#openid").val(),
				"status": $("#status").val(),
				"prepayId": $("#prepayId").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "PayBill.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		PayBill.initPayBillList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/payBill/toUpdate?id=" + id;
	},

	"deletePayBill": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/payBill/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("删除订单成功");
					PayBill.initPayBillList(0, Page.size);
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
		window.self.location.href = contextPath + "/payBill/list";
	},
	
	"refund": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/payBill/refund",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("退款提交成功");
					PayBill.search();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	
	"close": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/payBill/close",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("关闭订单成功");
					PayBill.search();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"end": null
};