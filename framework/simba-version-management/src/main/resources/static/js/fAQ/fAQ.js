var FAQ = {

	"search" : function() {
		FAQ.initFAQList(0, Page.size);
	},

	"toAdd" : function() {
		window.self.location.href = contextPath + "/fAQ/toAdd";
	},

	"batchDelete" : function() {
		var ids = new Array();
		$("input[name='fAQ']").each(function() {
			if (true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if (ids.length == 0) {
			parent.showInfo("请选择要删除的记录");
			return false;
		}
		$.ajax({
			type : "post",
			url : contextPath + "/fAQ/batchDelete",
			data : {
				"id" : ids.join(",")
			},
			async : true,
			dataType : "json",
			success : function(data) {
				if (data.code == 200) {
					FAQ.initFAQList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initFAQList" : function(start, pageSize) {
		$.ajax({
			type : "get",
			url : contextPath + "/fAQ/getList",
			data : {
				"pageStart" : start,
				"pageSize" : pageSize,
				"type" : $("#type").val(),
				"title" : $("#title").val(),
				"text" : $("#text").val(),
				"startTime" : $("#startTime").val(),
				"endTime" : $("#endTime").val()
			},
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
			url : contextPath + "/fAQ/count",
			async : true,
			data : {
				"type" : $("#type").val(),
				"title" : $("#title").val(),
				"text" : $("#text").val(),
				"startTime" : $("#startTime").val(),
				"endTime" : $("#endTime").val()
			},
			async : true,
			dataType : "json",
			success : function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "FAQ.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager" : function(start, pageSize) {
		FAQ.initFAQList(start, pageSize);
	},

	"toUpdate" : function(id) {
		window.self.location.href = contextPath + "/fAQ/toUpdate?id=" + id;
	},

	"deleteFAQ" : function(id) {
		$.ajax({
			type : "post",
			url : contextPath + "/fAQ/batchDelete",
			data : {
				"id" : id
			},
			async : true,
			dataType : "json",
			success : function(data) {
				if (data.code == 200) {
					FAQ.initFAQList(0, Page.size);
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
		window.self.location.href = contextPath + "/fAQ/list";
	},

	"end" : null
};