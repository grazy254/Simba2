var AutoReply = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/autoReply/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='autoReply']").each(function() {
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
			url: contextPath + "/autoReply/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					AutoReply.initAutoReplyList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initAutoReplyList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/autoReply/getList",
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
			url: contextPath + "/autoReply/count",
			async: true,
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "AutoReply.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		AutoReply.initAutoReplyList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/autoReply/toUpdate?id=" + id;
	},

	"deleteAutoReply": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/autoReply/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					AutoReply.initAutoReplyList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var content = $("#content").val();
		if(!content) {
			parent.showInfo("回复内容不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/autoReply/list";
	},

	"end": null
};