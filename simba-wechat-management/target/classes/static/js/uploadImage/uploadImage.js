var UploadImage = {

	"search": function() {
		UploadImage.initUploadImageList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/uploadImage/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='uploadImage']").each(function() {
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
			url: contextPath + "/uploadImage/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UploadImage.initUploadImageList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initUploadImageList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/uploadImage/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"name": $("#name").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
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
			url: contextPath + "/uploadImage/count",
			async: true,
			data: {
				"name": $("#name").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "UploadImage.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		UploadImage.initUploadImageList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/uploadImage/toUpdate?id=" + id;
	},

	"deleteUploadImage": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/uploadImage/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UploadImage.initUploadImageList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var name = $("#name").val();
		if(!name) {
			parent.showInfo("名称不能为空");
			return false;
		}
		var file = $("#file").val();
		if(!file) {
			parent.showInfo("文件不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/uploadImage/list";
	},

	"end": null
};