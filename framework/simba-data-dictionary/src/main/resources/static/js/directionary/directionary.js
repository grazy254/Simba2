var Directionary = {
	
	"toAdd": function() {
		window.self.location.href = contextPath + "/directionary/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='directionary']").each(function() {
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
			url: contextPath + "/directionary/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Directionary.initDirectionaryList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"initDirectionaryList": function(start, pageSize, method) {
		var data = {};
		var data2 = {};
		method = method || "getList";
		$.extend(data2,data);
		data["pageStart"] = start;
		data["pageSize"] = pageSize;
		$.ajax({
			type: "get",
			url: contextPath + "/directionary/" + method,
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
			url: contextPath + "/directionary/count",
			async: true,
			data: data2,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Directionary.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager": function(start, pageSize) {
		Directionary.initDirectionaryList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/directionary/toUpdate?id=" + id;
	},

	"deleteDirectionary": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/directionary/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Directionary.initDirectionaryList(0, Page.size);
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
		window.self.location.href = contextPath + "/directionary/list";
	},

	"end": null
};