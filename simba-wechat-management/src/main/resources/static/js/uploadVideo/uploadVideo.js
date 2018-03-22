var UploadVideo = {

	"executeSelect": function(mediaId) {
		var domId = $("#domId").val();
		$(top.frames["contentiframe"].document).find("#" + domId).val(mediaId);
		top.showSuccessInfo("选择成功");
		top.hideModal();
	},

	"selectSearch": function() {
		UploadVideo.initSelectUploadVideoList(0, Page.size);
	},

	"initSelectUploadVideoList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/uploadVideo/getSelectList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"title": $("#title").val(),
				"mediaId": $("#mediaId").val(),
				"targetMediaId": $("#targetMediaId").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/uploadVideo/count",
			async: true,
			data: {
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"title": $("#title").val(),
				"mediaId": $("#mediaId").val(),
				"targetMediaId": $("#targetMediaId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "UploadVideo.clickSelectPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickSelectPager": function(start, pageSize) {
		UploadVideo.initSelectUploadVideoList(start, pageSize);
	},

	"selectTempVideo": function() {
		parent.showModal("选择临时视频", contextPath + "/tempMedia/select?type=video&domId=mediaId", 500);
	},

	"search": function() {
		UploadVideo.initUploadVideoList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/uploadVideo/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='uploadVideo']").each(function() {
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
			url: contextPath + "/uploadVideo/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UploadVideo.initUploadVideoList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initUploadVideoList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/uploadVideo/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"title": $("#title").val(),
				"mediaId": $("#mediaId").val(),
				"targetMediaId": $("#targetMediaId").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/uploadVideo/count",
			async: true,
			data: {
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"title": $("#title").val(),
				"mediaId": $("#mediaId").val(),
				"targetMediaId": $("#targetMediaId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "UploadVideo.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		UploadVideo.initUploadVideoList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/uploadVideo/toUpdate?id=" + id;
	},

	"deleteUploadVideo": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/uploadVideo/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UploadVideo.initUploadVideoList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var mediaId = $("#mediaId").val();
		if(!mediaId) {
			parent.showInfo("视频不能为空");
			return false;
		}
		var title = $("#title").val();
		if(!title) {
			parent.showInfo("标题不能为空");
			return false;
		}
		var description = $("#description").val();
		if(!description) {
			parent.showInfo("描述不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/uploadVideo/list";
	},

	"end": null
};