var RealTimeMessage = {
	
	"search": function() {
		var testAccount = /^[0-9]*$/
		if(!testAccount.test($("#userId").val())) {
			alert("用户id为数字");
		}else{
			RealTimeMessage.initRealTimeMessageList(0, Page.size);
		}
	},
	
	"toAdd": function() {
		window.self.location.href = contextPath + "/realTimeMessage/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='realTimeMessage']").each(function() {
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
			url: contextPath + "/realTimeMessage/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					RealTimeMessage.initRealTimeMessageList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initRealTimeMessageList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/realTimeMessage/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"userId": $("#userId").val(),
				"message": $("#message").val(),
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
			url: contextPath + "/realTimeMessage/count",
			async: true,
			data: {
				"userId": $("#userId").val(),
				"message": $("#message").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "RealTimeMessage.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		RealTimeMessage.initRealTimeMessageList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/realTimeMessage/toUpdate?id=" + id;
	},

	"deleteRealTimeMessage": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/realTimeMessage/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					RealTimeMessage.initRealTimeMessageList(0, Page.size);
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
		window.self.location.href = contextPath + "/realTimeMessage/list";
	},

	"end": null
};