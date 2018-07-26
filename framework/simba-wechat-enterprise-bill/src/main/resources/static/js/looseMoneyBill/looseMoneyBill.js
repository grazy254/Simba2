var LooseMoneyBill = {

	"search": function() {
		LooseMoneyBill.initLooseMoneyBillList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/looseMoneyBill/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='looseMoneyBill']").each(function() {
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
			url: contextPath + "/looseMoneyBill/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					LooseMoneyBill.initLooseMoneyBillList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initLooseMoneyBillList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/looseMoneyBill/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"partnerTradeNo": $("#partnerTradeNo").val(),
				"openid": $("#openid").val(),
				"reUserName": $("#reUserName").val(),
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
			url: contextPath + "/looseMoneyBill/count",
			async: true,
			data: {
				"partnerTradeNo": $("#partnerTradeNo").val(),
				"openid": $("#openid").val(),
				"reUserName": $("#reUserName").val(),
				"status": $("#status").val(),
				"paymentNo": $("#paymentNo").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "LooseMoneyBill.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		LooseMoneyBill.initLooseMoneyBillList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/looseMoneyBill/toUpdate?id=" + id;
	},

	"deleteLooseMoneyBill": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/looseMoneyBill/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					LooseMoneyBill.initLooseMoneyBillList(0, Page.size);
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
		window.self.location.href = contextPath + "/looseMoneyBill/list";
	},

	"add": function() {
		var openid = $("#openid").val();
		if(!openid) {
			parent.showInfo("用户openid不能为空");
			return false;
		}
		var amount = $("#amount").val();
		if(!amount) {
			parent.showInfo("金额不能为空");
			return false;
		}
		parent.showSuccessInfo("请求正在处理中");
		$.ajax({
			type: "post",
			url: contextPath + "/api/wechatEnterprisePay/transfersLooseMoney",
			async: true,
			dataType: "json",
			data: {
				openid: openid,
				amount: amount,
				check_name: $("#check_name").val(),
				re_user_name: $("#re_user_name").val(),
				desc: $("#desc").val()
			},
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("请求处理完成");
					LooseMoneyBill.toList();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"end": null
};