var DictionaryType = {

	"exportSql": function() {
		window.self.location.href = contextPath + "/dictionaryType/exportSql";
	},

	"showDictionary": function() {
		parent.showModal("显示列表项", contextPath + "/dictionary/list?typeId=" + id, 500);
	},

	"toSearch": function() {
		DictionaryType.initDictionaryTypeList(0, Page.size, "doSearch");
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/dictionaryType/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='dictionaryType']").each(function() {
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
			url: contextPath + "/dictionaryType/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					DictionaryType.initDictionaryTypeList(0, Page.size, "doSearch");
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"initDictionaryTypeList": function(start, pageSize, method) {
		var data = {};
		var data2 = {};
		method = method || "getList";
		data["code"] = $("#code").val();
		$.extend(data2, data);
		data["pageStart"] = start;
		data["pageSize"] = pageSize;
		$.ajax({
			type: "get",
			url: contextPath + "/dictionaryType/" + method,
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
			url: contextPath + "/dictionaryType/count",
			async: true,
			data: data2,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "DictionaryType.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager": function(start, pageSize) {
		DictionaryType.initDictionaryTypeList(start, pageSize, "doSearch");
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/dictionaryType/toUpdate?id=" + id;
	},

	"deleteDictionaryType": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/dictionaryType/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					DictionaryType.initDictionaryTypeList(0, Page.size, "doSearch");
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
		window.self.location.href = contextPath + "/dictionaryType/list";
	},

	"end": null
};