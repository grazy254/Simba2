var TempMedia = {

	"selectImages": function(id) {
		top.contentiframe.window.Article.selectImage(id);
		top.hideModal();
	},

	"searchImage": function() {
		TempMedia.initTempMediaImageList(0, Page.size);
	},

	"initTempMediaImageList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/tempMedia/getImageList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"type": $("#type").val(),
				"name": $("#name").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/tempMedia/count",
			async: true,
			data: {
				"type": $("#type").val(),
				"name": $("#name").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "TempMedia.clickImagePager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickImagePager": function(start, pageSize) {
		TempMedia.initTempMediaImageList(start, pageSize);
	},

	"executeSelect": function(mediaId) {
		var domId = $("#domId").val();
		$(top.frames["contentiframe"].document).find("#" + domId).val(mediaId);
		parent.showSuccessInfo("选择成功");
		top.hideModal();
	},

	"searchSelect": function() {
		TempMedia.initSelectTempMediaList(0, Page.size);
	},

	"initSelectTempMediaList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/tempMedia/getSelectList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"type": $("#type").val(),
				"name": $("#name").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/tempMedia/count",
			async: true,
			data: {
				"type": $("#type").val(),
				"name": $("#name").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "TempMedia.clickSelectPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickSelectPager": function(start, pageSize) {
		TempMedia.initSelectTempMediaList(start, pageSize);
	},

	"search": function() {
		TempMedia.initTempMediaList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/tempMedia/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='tempMedia']").each(function() {
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
			url: contextPath + "/tempMedia/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TempMedia.initTempMediaList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initTempMediaList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/tempMedia/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"type": $("#type").val(),
				"name": $("#name").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/tempMedia/count",
			async: true,
			data: {
				"type": $("#type").val(),
				"name": $("#name").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"mediaId": $("#mediaId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "TempMedia.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		TempMedia.initTempMediaList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/tempMedia/toUpdate?id=" + id;
	},

	"deleteTempMedia": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/tempMedia/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					TempMedia.initTempMediaList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var name = $("#name").val();
		var type = $("#type").val();
		var file = $("#file").val();
		if(!name) {
			parent.showInfo("名称不能为空");
			return false;
		}
		if(!type) {
			parent.showInfo("类型不能为空");
			return false;
		}
		if(!file) {
			parent.showInfo("文件不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/tempMedia/list";
	},

	"end": null
};