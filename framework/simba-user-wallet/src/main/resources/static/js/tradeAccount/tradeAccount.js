var TradeAccount = {
	"toSearch" : function() {
		TradeAccount.initTradeAccountList(0, Page.size, "doSearch");
	},
	"initTradeAccountList" : function(start, pageSize, method) {
		var data = {}
		var data2 = {}
		method = method || "getList"
		data["pageStart"] = start
		data["pageSize"] = pageSize
		data["userID"] = $("#userID").val();
		data["accountType"] = $("#accountType").val();
		$.extend(data2, data);
		$.ajax({
			type : "get",
			url : contextPath + "/tradeAccount/" + method,
			data : data,
			async : true,
			dataType : "html",
			success : function(html) {
				$("#table").find("tbody").html(html);
				CheckBox.init();
				setTimeout("CheckBox.bindCheckAll();", 1000);
			}
		});
		$.ajax({
			type : "get",
			url : contextPath + "/tradeAccount/count",
			async : true,
			data : data2,
			dataType : "json",
			success : function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize,
						"TradeAccount.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager" : function(start, pageSize) {
		TradeAccount.initTradeAccountList(start, pageSize);
	},
	"deleteTradeAccount" : function(id) {
		$.ajax({
			type : "post",
			url : contextPath + "/tradeAccount/batchDelete",
			data : {
				"id" : id
			},
			async : true,
			dataType : "json",
			success : function(data) {
				if (data.code == 200) {
					TradeAccount.initTradeAccountList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm" : function() {
		return true;
	},

	"toList" : function() {
		window.self.location.href = contextPath + "/tradeAccount/list";
	},
	"end" : null
};