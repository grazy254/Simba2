var Template = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/msgTemplate/toAddJpush";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='template']").each(function() {
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
			url: contextPath + "/msgTemplate/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Template.initTemplateList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initTemplateList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/msgTemplate/getListJpush",
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
			url: contextPath + "/msgTemplate/count",
			async: true,
			data: {
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Template.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		Template.initTemplateList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/msgTemplate/toUpdateJpush?id=" + id;
	},

	"deleteTemplate": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/msgTemplate/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Template.initTemplateList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		if ($("#selfId").val()=="" || $("#content").val()=="") {
			top.showInfo("自定Id和模板内容不能留空!");
			return false;
		}
		return true;
	},

    "toBack": function () {
        window.history.back()
    },

	"toList": function() {
		window.self.location.href = contextPath + "/msgTemplate/listJpush";
	},

	"end": null
};