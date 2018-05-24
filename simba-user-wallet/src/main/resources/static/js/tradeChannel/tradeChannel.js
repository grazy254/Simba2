var TradeChannel = {
	
	"toAdd": function() {
		window.self.location.href = contextPath + "/tradeChannel/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='tradeChannel']").each(function() {
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
			url: contextPath + "/tradeChannel/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeChannel.initTradeChannelList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"initTradeChannelList": function(start, pageSize, method) {
		var data = {}
		var data2 = {}
		method = method || "getList"
		$.extend(data2,data);
		data["pageStart"] = start
		data["pageSize"] = pageSize
		$.ajax({
			type: "get",
			url: contextPath + "/tradeChannel/" + method,
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
			url: contextPath + "/tradeChannel/count",
			async: true,
			data: data2,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "TradeChannel.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager": function(start, pageSize) {
		TradeChannel.initTradeChannelList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/tradeChannel/toUpdate?id=" + id;
	},

	"deleteTradeChannel": function(type) {
		$.ajax({
			type: "post",
			url: contextPath + "/tradeChannel/delete",
			data: {
				"type": type,
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeChannel.initTradeChannelList(0, Page.size);
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
		window.self.location.href = contextPath + "/tradeChannel/list";
	},
	"openChannelAccount":function(type, name, phone) {
		var data = {}
		method = "openChannelAccount"
		data["type"] = type
		data["name"] = name
		data["password"] = ""
		data["payPhone"] = "" || phone
		data["payEmail"] = ""
						
		$.ajax({
			type: "get",
			url: contextPath + "/tradeAccount/" + method,
			data: data,
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeChannel.initTradeChannelList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"frozeChannelAccount":function(type) {
		var data = {}
		method = "frozeChannelAccount"
		data["type"] = type
		
		$.ajax({
			type: "get",
			url: contextPath + "/tradeAccount/" + method,
			data: data,
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeChannel.initTradeChannelList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"end": null
};