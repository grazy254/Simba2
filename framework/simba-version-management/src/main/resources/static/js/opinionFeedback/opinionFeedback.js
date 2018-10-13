var OpinionFeedback = {
	
	"search": function() {
		var testAccount = /^[0-9]*$/
		if(!testAccount.test($("#userId").val())) {
			alert("用户id为数字");
		}else{
			OpinionFeedback.initOpinionFeedbackList(0, Page.size);
		}
	},
	
	"toAdd": function() {
		window.self.location.href = contextPath + "/opinionFeedback/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='opinionFeedback']").each(function() {
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
			url: contextPath + "/opinionFeedback/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					OpinionFeedback.initOpinionFeedbackList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initOpinionFeedbackList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/opinionFeedback/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"userId": $("#userId").val(),
				"title": $("#title").val(),
				"text": $("#text").val(),
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
			url: contextPath + "/opinionFeedback/count",
			async: true,
			data: {
				"userId": $("#userId").val(),
				"title": $("#title").val(),
				"text": $("#text").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "OpinionFeedback.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		OpinionFeedback.initOpinionFeedbackList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/opinionFeedback/toUpdate?id=" + id;
	},

	"deleteOpinionFeedback": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/opinionFeedback/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					OpinionFeedback.initOpinionFeedbackList(0, Page.size);
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
		window.self.location.href = contextPath + "/opinionFeedback/list";
	},

	"end": null
};