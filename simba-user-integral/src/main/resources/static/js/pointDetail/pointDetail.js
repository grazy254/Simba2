var PointDetail = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/pointDetail/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='pointDetail']").each(function() {
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
			url: contextPath + "/pointDetail/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					PointDetail.initPointDetailList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initPointDetailList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/pointDetail/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize
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
			url: contextPath + "/pointDetail/count",
			async: true,
			data: {
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "PointDetail.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		PointDetail.initPointDetailList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/pointDetail/toUpdate?id=" + id;
	},

	"deletePointDetail": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/pointDetail/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					PointDetail.initPointDetailList(0, Page.size);
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
		window.self.location.href = contextPath + "/pointDetail/list";
	},

	"end": null
};