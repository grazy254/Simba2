var TradeDepartment = {
	
	"toAdd": function() {
		window.self.location.href = contextPath + "/tradeDepartment/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='tradeDepartment']").each(function() {
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
			url: contextPath + "/tradeDepartment/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeDepartment.initTradeDepartmentList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"initTradeDepartmentList": function(start, pageSize, method) {
		var data = {}
		var data2 = {}
		method = method || "getList"
		$.extend(data2,data);
		data["pageStart"] = start
		data["pageSize"] = pageSize
		$.ajax({
			type: "get",
			url: contextPath + "/tradeDepartment/" + method,
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
			url: contextPath + "/tradeDepartment/count",
			async: true,
			data: data2,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "TradeDepartment.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager": function(start, pageSize) {
		TradeDepartment.initTradeDepartmentList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/tradeDepartment/toUpdate?id=" + id;
	},

	"deleteTradeDepartment": function(deptNO) {
		$.ajax({
			type: "post",
			url: contextPath + "/tradeDepartment/delete",
			data: {
				"deptNO": deptNO,
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeDepartment.initTradeDepartmentList(0, Page.size);
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
		window.self.location.href = contextPath + "/tradeDepartment/list";
	},
	"openDepartmentAccount":function(deptNO, deptName, phone) {
		var data = {}
		method = "openDepartmentAccount"
		data["deptNO"] = deptNO
		data["deptName"] = deptName
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
					TradeDepartment.initTradeDepartmentList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},	
	"frozeDepartmentAccount":function(deptNO) {
		var data = {}
		method = "frozeDepartmentAccount"
		data["deptNO"] = deptNO
		
		$.ajax({
			type: "get",
			url: contextPath + "/tradeAccount/" + method,
			data: data,
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TradeDepartment.initTradeDepartmentList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"end": null
};