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

	"add": function() {
		var enc_bank_no = $("#enc_bank_no").val();
		if(!enc_bank_no) {
			parent.showInfo("收款方银行卡号不能为空");
			return false;
		}
		var trueName = $("#trueName").val();
		if(!trueName) {
			parent.showInfo("收款方用户名不能为空");
			return false;
		}
		var bank_code = $("#bank_code").val();
		if(!bank_code) {
			parent.showInfo("收款方开户行不能为空");
			return false;
		}
		var amount = $("#amount").val();
		if(!amount) {
			parent.showInfo("付款金额不能为空");
			return false;
		}
		parent.showSuccessInfo("请求正在处理中");
		$.ajax({
			type: "post",
			url: contextPath + "/api/wechatEnterprisePay/transfersCard",
			async: true,
			dataType: "json",
			data: {
				enc_bank_no: enc_bank_no,
				amount: amount,
				trueName: trueName,
				bank_code: bank_code,
				desc: $("#desc").val()
			},
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("请求处理完成");
					CardMoneyBill.toList();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"end": null
};