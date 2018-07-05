var TradeDetail = {
	"toSearch": function() {
		TradeDetail.initTradeDetailList(0, Page.size, "doSearch");
	},
	
	"initTradeDetailList": function(start, pageSize, method) {
		var data = {};
		var data2 = {};
		method = method || "getList";
		data["startTime"] = $("#startTime").val();
		data["endTime"] = $("#endTime").val();
		data["tradeNO"] = $("#tradeNO").val();
		data["tradeType"] = $("#tradeType").val();
		data["tradeStatus"] = $("#tradeStatus").val();
		data["tradeUserType"] = $("#tradeUserType").val();
		data["userID"] = $("#userID").val();
		$.extend(data2,data);
		data["pageStart"] = start;
		data["pageSize"] = pageSize;
		$.ajax({
			type: "get",
			url: contextPath + "/tradeDetail/" + method,
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
			url: contextPath + "/tradeDetail/count",
			async: true,
			data: data2,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "TradeDetail.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager": function(start, pageSize) {
		TradeDetail.initTradeDetailList(start, pageSize, "doSearch");
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/tradeDetail/toUpdate?id=" + id;
	},


	"checkForm": function() {
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/tradeDetail/list";
	},

	"end": null
};