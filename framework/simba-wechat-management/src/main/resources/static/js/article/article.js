var Article = {

	"searchSelect": function() {
		Article.initSelectedArticleList(0, Page.size);
	},

	"showSelectedArticles": function(ids) {
		$("#articles").val(ids);
		$.ajax({
			type: "get",
			url: contextPath + "/article/getArticles",
			async: true,
			data: {
				ids: ids
			},
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					var articlesHtml = "";
					$.each(data.data, function(i, article) {
						var id = article.id;
						var title = article.title;
						var selectedHtml = "<a id='article_" + id + "' href='#' onclick='Article.deleteShowSelectedArticle(" + id + ")'>" + title + "<i class=\"fa fa-remove\"></i></button>&nbsp;&nbsp;</a>";
						articlesHtml += selectedHtml;
					});
					$("#articleContent").html(articlesHtml);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"deleteShowSelectedArticle": function(id) {
		$("#article_" + id).remove();
		var selectedArticleIds = $("#articles").val();
		var articleArray = selectedArticleIds.split(",");
		var newArticleArray = new Array();
		for(var i = 0; i < articleArray.length; i++) {
			if(id != articleArray[i]) {
				newArticleArray.push(articleArray[i]);
			}
		}
		$("#articles").val(newArticleArray.join(","));
	},

	"selectedArticles": function() {
		var selectedArticleIds = $("#selectedArticleIds").val();
		top.contentiframe.window.Article.showSelectedArticles(selectedArticleIds);
		top.hideModal();
	},

	"initSelected": function() {
		var selectedArticleIds = $(top.frames["contentiframe"].document).find("#articles").val();
		$("#selectedArticleIds").val(selectedArticleIds);
		$.ajax({
			type: "get",
			url: contextPath + "/article/getArticles",
			async: true,
			data: {
				ids: selectedArticleIds
			},
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					$.each(data.data, function(i, article) {
						var id = article.id;
						var title = article.title;
						var selectedHtml = "<a id='article_" + id + "' href='#' onclick='Article.deleteSelectedArticle(" + id + ")'>" + title + "<i class=\"fa fa-remove\"></i></button>&nbsp;&nbsp;</a>";
						$("#selectedArticles").append(selectedHtml);
					});
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"deleteSelectedArticle": function(id) {
		$("#article_" + id).remove();
		var selectedArticleIds = $("#selectedArticleIds").val();
		var articleArray = selectedArticleIds.split(",");
		var newArticleArray = new Array();
		for(var i = 0; i < articleArray.length; i++) {
			if(id != articleArray[i]) {
				newArticleArray.push(articleArray[i]);
			}
		}
		$("#selectedArticleIds").val(newArticleArray.join(","));
	},

	"selectedArticle": function(id, title) {
		var selectedArticleIds = $("#selectedArticleIds").val();
		var articleArray = selectedArticleIds.split(",");
		var isContain = false;
		for(var i = 0; i < articleArray.length; i++) {
			if(id == articleArray[i]) {
				isContain = true;
				break;
			}
		}
		if(isContain) {
			return false;
		}
		articleArray.push(id);
		$("#selectedArticleIds").val(articleArray.join(","));
		var selectedHtml = "<a id='article_" + id + "' href='#' onclick='Article.deleteSelectedArticle(" + id + ")'>" + title + "<i class=\"fa fa-remove\"></i></button>&nbsp;&nbsp;</a>";
		$("#selectedArticles").append(selectedHtml);
	},

	"initSelectedArticleList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/article/getSelectList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"title": $("#title").val(),
				"author": $("#author").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"type": $("#type").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/article/count",
			async: true,
			data: {
				"title": $("#title").val(),
				"author": $("#author").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"type": $("#type").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Article.clickSelectPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickSelectPager": function(start, pageSize) {
		Article.initSelectedArticleList(start, pageSize);
	},

	"showImages": function() {
		var type = $("#type").val();
		if(type == 1) {
			parent.showModal("选择图片", contextPath + "/tempMedia/showImages", 700);
		} else if(type == 2) {
			parent.showModal("选择图片", contextPath + "/foreverMedia/showImages", 700);
		}
	},

	"selectImage": function(id) {
		var type = $("#type").val();
		var url = "";
		if(type == 1) {
			url = contextPath + "/tempMedia/get";
		} else if(type == 2) {
			url = contextPath + "/foreverMedia/get";
		}
		$.ajax({
			type: "get",
			url: url,
			async: true,
			data: {
				id: id
			},
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					$("#thumbMediaId").val(data.data.mediaId);
					$("#selectedImage").attr("src", data.data.fileUrl);
					$("#imageDiv").show();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"showContent": function(id) {
		parent.showModal("查看内容", contextPath + "/article/showContent?id=" + id, 600);
	},

	"search": function() {
		Article.initArticleList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/article/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='article']").each(function() {
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
			url: contextPath + "/article/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Article.initArticleList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initArticleList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/article/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"title": $("#title").val(),
				"author": $("#author").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"type": $("#type").val()
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
			url: contextPath + "/article/count",
			async: true,
			data: {
				"title": $("#title").val(),
				"author": $("#author").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"type": $("#type").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Article.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		Article.initArticleList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/article/toUpdate?id=" + id;
	},

	"deleteArticle": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/article/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Article.initArticleList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var title = $("#title").val();
		if(!title) {
			parent.showInfo("标题不能为空");
			return false;
		}
		var author = $("#author").val();
		if(!author) {
			parent.showInfo("作者不能为空");
			return false;
		}
		var digest = $("#digest").val();
		if(!digest) {
			parent.showInfo("描述不能为空");
			return false;
		}
		var showCoverPic = $("#showCoverPic").val();
		if(!showCoverPic) {
			parent.showInfo("显示封面不能为空");
			return false;
		}
		var content = $("#content").val();
		if(!content) {
			parent.showInfo("内容不能为空");
			return false;
		}
		var contentSourceUrl = $("#contentSourceUrl").val();
		if(!contentSourceUrl) {
			parent.showInfo("原文地址不能为空");
			return false;
		}
		var file = $("#file").val();
		var thumbMediaId = $("#thumbMediaId").val();
		if(!file && !thumbMediaId) {
			parent.showInfo("请上传图片或者选择一张图片");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/article/list";
	},

	"end": null
};