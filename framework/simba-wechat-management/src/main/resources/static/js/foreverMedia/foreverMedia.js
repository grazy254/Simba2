var ForeverMedia = {

	"initCount": function() {
		$.ajax({
			type: "get",
			url: contextPath + "/foreverMedia/countWxMedia",
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					var videoCount = data.data.video_count;
					var voiceCount = data.data.voice_count;
					var newsCount = data.data.news_count;
					var imageCount = data.data.image_count;
					var html = "图文 : " + newsCount + " / 5000 , 图片 : " + imageCount + " / 5000 , 视频 :" + videoCount + " / 1000 ,语音 : " + voiceCount + " / 1000";
					$("#mediaCount").html(html);
				}
			}
		});
	},

	"searchSelect": function() {
		ForeverMedia.initSelectForeverMediaList(0, Page.size);
	},

	"initSelectForeverMediaList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/foreverMedia/getSelectList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"type": $("#type").val(),
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
			url: contextPath + "/foreverMedia/count",
			async: true,
			data: {
				"type": $("#type").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val(),
				"name": $("#name").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ForeverMedia.clickSelectPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickSelectPager": function(start, pageSize) {
		ForeverMedia.initSelectForeverMediaList(start, pageSize);
	},

	"executeSelect": function(mediaId) {
		var domId = $("#domId").val();
		$(top.frames["contentiframe"].document).find("#" + domId).val(mediaId);
		parent.showSuccessInfo("选择成功");
		top.hideModal();
	},

	"selectImages": function(id) {
		top.contentiframe.window.Article.selectImage(id);
		top.hideModal();
	},

	"searchImages": function() {
		ForeverMedia.initForeverMediaImageList(0, Page.size);
	},

	"initForeverMediaImageList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/foreverMedia/getImageList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"type": $("#type").val(),
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
			url: contextPath + "/foreverMedia/count",
			async: true,
			data: {
				"type": $("#type").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val(),
				"name": $("#name").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ForeverMedia.clickImagePager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickImagePager": function(start, pageSize) {
		ForeverMedia.initForeverMediaImageList(start, pageSize);
	},

	"changeType": function() {
		var type = $("#type").val();
		if(type == "news") {
			$("#fileDiv").hide();
			$("#titleDiv").hide();
			$("#introductionDiv").hide();
			$("#newsDiv").show();
		} else if(type == "video") {
			$("#fileDiv").show();
			$("#titleDiv").show();
			$("#introductionDiv").show();
			$("#newsDiv").hide();
		} else {
			$("#fileDiv").show();
			$("#titleDiv").hide();
			$("#introductionDiv").hide();
			$("#newsDiv").hide();
		}
	},

	"selectArticle": function() {
		parent.showModal("选择图文内容", contextPath + "/article/selectArticle?type=2", 500);
	},

	"showArticle": function(id) {
		parent.showModal("查看图文内容", contextPath + "/article/showArticle?id=" + id, 500);
	},

	"search": function() {
		ForeverMedia.initForeverMediaList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/foreverMedia/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='foreverMedia']").each(function() {
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
			url: contextPath + "/foreverMedia/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ForeverMedia.initForeverMediaList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initForeverMediaList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/foreverMedia/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"type": $("#type").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val(),
				"name": $("#name").val()
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
			url: contextPath + "/foreverMedia/count",
			async: true,
			data: {
				"type": $("#type").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val(),
				"name": $("#name").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ForeverMedia.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		ForeverMedia.initForeverMediaList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/foreverMedia/toUpdate?id=" + id;
	},

	"deleteForeverMedia": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/foreverMedia/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ForeverMedia.initForeverMediaList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var type = $("#type").val();
		if(!type) {
			parent.showInfo("类型不能为空");
			return false;
		}
		var name = $("#name").val();
		if(!name) {
			parent.showInfo("名称不能为空");
			return false;
		}
		var file = $("#file").val();
		if(type != "news") {
			if(!file) {
				parent.showInfo("文件不能为空");
				return false;
			}
		}
		var introduction = $("#introduction").val();
		var title = $("#title").val();
		if(type == "video") {
			if(!title) {
				parent.showInfo("标题不能为空");
				return false;
			}
			if(!introduction) {
				parent.showInfo("描述不能为空");
				return false;
			}
		}
		var articles = $("#articles").val();
		if(type == "news") {
			if(!articles) {
				parent.showInfo("图文内容不能为空");
				return false;
			}
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/foreverMedia/list";
	},

	"end": null
};