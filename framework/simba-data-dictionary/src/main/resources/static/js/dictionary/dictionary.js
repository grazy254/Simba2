var Dictionary = {

	"toAdd" : function() {
		window.self.location.href = contextPath + "/dictionary/toAdd?typeId=" + $("#typeId").val();
	},

	"batchDelete" : function() {
		var ids = new Array();
		$("input[name='dictionary']").each(function() {
			if (true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if (ids.length == 0) {
			Dictionary.showInfo("请选择要删除的记录");
			return false;
		}
		$.ajax({
			type : "post",
			url : contextPath + "/dictionary/batchDelete",
			data : {
				"id" : ids.join(",")
			},
			async : true,
			dataType : "json",
			success : function(data) {
				if (data.code == 200) {
					Dictionary.initDictionaryList(0, Page.size);
				} else {
					Dictionary.showInfo(data.msg);
				}
			}
		});
	},
	"initDictionaryList" : function(start, pageSize, method) {
		var data = {};
		var data2 = {};
		method = method || "getList";
		$.extend(data2, data);
		data["pageStart"] = start;
		data["pageSize"] = pageSize;
		data["typeId"] = $("#typeId").val();
		data2["typeId"] = $("#typeId").val();
		$.ajax({
			type : "get",
			url : contextPath + "/dictionary/" + method,
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
			url : contextPath + "/dictionary/count",
			async : true,
			data : data2,
			dataType : "json",
			success : function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Dictionary.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},
	"clickPager" : function(start, pageSize) {
		Dictionary.initDictionaryList(start, pageSize);
	},

	"toUpdate" : function(id) {
		window.self.location.href = contextPath + "/dictionary/toUpdate?id=" + id;
	},

	"deleteDictionary" : function(id) {
		$.ajax({
			type : "post",
			url : contextPath + "/dictionary/batchDelete",
			data : {
				"id" : id
			},
			async : true,
			dataType : "json",
			success : function(data) {
				if (data.code == 200) {
					Dictionary.initDictionaryList(0, Page.size);
				} else {
					Dictionary.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm" : function() {
		var name = $("#name").val();
		if (!name) {
			Dictionary.showInfo("名称不能为空");
			return false;
		}
		var value = $("#value").val();
		if (!value) {
			Dictionary.showInfo("值不能为空");
			return false;
		}
		return true;
	},

	"toList" : function() {
		window.self.location.href = contextPath + "/dictionary/list?typeId=" + $("#typeId").val();
	},

	"showInfo" : function(content) {
		$("#errInfo").html(content);
		$("#errInfo").fadeIn();
		setTimeout("Dictionary.hideInfo();", 1500);
	},

	"hideInfo" : function() {
		$("#errInfo").fadeOut();
	},

	"end" : null
};