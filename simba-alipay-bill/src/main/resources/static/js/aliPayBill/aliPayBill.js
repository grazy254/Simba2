var AliPayBill = {

	"close": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/aliPayBill/close",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("关闭订单成功");
					AliPayBill.toSearch();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"refund": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/aliPayBill/refund",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("退款提交成功");
					AliPayBill.toSearch();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"cancel": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/aliPayBill/cancel",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("撤销订单成功");
					AliPayBill.toSearch();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"toSearch": function() {
		AliPayBill.initAliPayBillList(0, Page.size, "doSearch");
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/aliPayBill/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='aliPayBill']").each(function() {
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
			url: contextPath + "/aliPayBill/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("删除订单成功");
					AliPayBill.toSearch();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"initAliPayBillList": function(start, pageSize, method) {
		var data = {};
		var data2 = {};
		method = method || "getList";
		data["productCode"] = $("#productCode").val();
		data["ourTradeNo"] = $("#ourTradeNo").val();
		data["tradeNo"] = $("#tradeNo").val();
		data["startCreateTime"] = $("#startCreateTime").val();
		data["endCreateTime"] = $("#endCreateTime").val();
		data["status"] = $("#status").val();
		$.extend(data2, data);
		data["pageStart"] = start;
		data["pageSize"] = pageSize;
		$.ajax({
			type: "get",
			url: contextPath + "/aliPayBill/" + method,
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
			url: contextPath + "/aliPayBill/count",
			async: true,
			data: data2,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "AliPayBill.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager": function(start, pageSize) {
		AliPayBill.initAliPayBillList(start, pageSize, "doSearch");
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/aliPayBill/toUpdate?id=" + id;
	},

	"deleteAliPayBill": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/aliPayBill/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("删除订单成功");
					AliPayBill.toSearch();
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
		window.self.location.href = contextPath + "/aliPayBill/list";
	},

	"end": null
};