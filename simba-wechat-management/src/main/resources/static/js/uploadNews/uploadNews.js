var UploadNews = {

	"executeSelect": function(mediaId) {
		var domId = $("#domId").val();
		$(top.frames["contentiframe"].document).find("#" + domId).val(mediaId);
		top.showSuccessInfo("选择成功");
		top.hideModal();
	},

	"selectSearch": function() {
		UploadNews.initSelectUploadNewsList(0, Page.size);
	},

	"initSelectUploadNewsList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/uploadNews/getSelectList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val(),
				"name": $("#name").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/uploadNews/count",
			async: true,
			data: {
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val(),
				"name": $("#name").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "UploadNews.clickSelectPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickSelectPager": function(start, pageSize) {
		UploadNews.initSelectUploadNewsList(start, pageSize);
	},

	"showArticle": function(id) {
		parent.showModal("查看图文内容", contextPath + "/article/showArticleForNews?id=" + id, 500);
	},

	"selectArticle": function() {
		parent.showModal("选择图文内容", contextPath + "/article/selectArticle?type=1", 500);
	},

	"search": function() {
		UploadNews.initUploadNewsList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/uploadNews/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='uploadNews']").each(function() {
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
			url: contextPath + "/uploadNews/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UploadNews.initUploadNewsList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initUploadNewsList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/uploadNews/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val(),
				"name": $("#name").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/uploadNews/count",
			async: true,
			data: {
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val(),
				"name": $("#name").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "UploadNews.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		UploadNews.initUploadNewsList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/uploadNews/toUpdate?id=" + id;
	},

	"deleteUploadNews": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/uploadNews/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UploadNews.initUploadNewsList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var name = $("#name").val();
		var articles = $("#articles").val();
		if(!name) {
			parent.showInfo("名称不能为空");
			return false;
		}
		if(!articles) {
			parent.showInfo("图文内容不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/uploadNews/list";
	},

	"end": null
};