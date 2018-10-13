var TradeSmartUser = {
	"toSearch" : function() {
		TradeSmartUser.initTradeSmartUserList(0, Page.size, "doSearch");
		},
	"toAdd": function() {
		window.self.location.href = contextPath + "/tradeSmartUser/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='tradeSmartUser']").each(function() {
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
			url: contextPath + "/tradeSmartUser/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeSmartUser.initTradeSmartUserList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"initTradeSmartUserList": function(start, pageSize, method) {
		var data = {}
		var data2 = {}
		method = method || "getList"
		$.extend(data2,data);
		data["pageStart"] = start
		data["pageSize"] = pageSize
		data["userID"] = $("#userID").val()
		$.ajax({
			type: "get",
			url: contextPath + "/tradeSmartUser/" + method,
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
			url: contextPath + "/tradeSmartUser/count",
			async: true,
			data: data2,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "TradeSmartUser.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager": function(start, pageSize) {
		TradeSmartUser.initTradeSmartUserList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/tradeSmartUser/toUpdate?id=" + id;
	},

	"checkForm": function() {
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/tradeChannel/list";
	},
	"frozeSmartUserPayment":function(account) {
		var data = {}
		method = "frozeSmartUserPayment"
		data["account"] = account
		
		$.ajax({
			type: "get",
			url: contextPath + "/tradeSmartUser/" + method,
			data: data,
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeSmartUser.initTradeSmartUserList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"activateSmartUserPayment":function(account) {
		var data = {}
		method = "activateSmartUserPayment"
		data["account"] = account
		
		$.ajax({
			type: "get",
			url: contextPath + "/tradeSmartUser/" + method,
			data: data,
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeSmartUser.initTradeSmartUserList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"frozeSmartUserAccount":function(account) {
		var data = {}
		method = "frozePersonalAccount"
		data["account"] = account
		
		$.ajax({
			type: "get",
			url: contextPath + "/tradeAccount/" + method,
			data: data,
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeSmartUser.initTradeSmartUserList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"activateSmartUserAccount":function(account) {
		var data = {}
		method = "activatePersonalAccount"
		data["account"] = account
		
		$.ajax({
			type: "get",
			url: contextPath + "/tradeAccount/" + method,
			data: data,
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeSmartUser.initTradeSmartUserList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"end": null
};