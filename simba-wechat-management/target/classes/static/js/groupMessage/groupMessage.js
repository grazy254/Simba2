var GroupMessage = {

	"preview": function() {
		var check = GroupMessage.checkForm();
		if(!check) {
			return false;
		}
		var previewOpenid = $("#previewOpenid").val();
		if(!previewOpenid) {
			parent.showInfo("预览粉丝不能为空");
			return false;
		}
		var data = $("#form").serialize();
		$.ajax({
			type: "post",
			url: contextPath + "/groupMessage/preview",
			async: true,
			dataType: "json",
			data: data,
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("发送预览成功");
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"changeType": function() {
		var type = $("#type").val();
		if(type == "text") {
			$("#contentDiv").show();
			$("#imageDiv").hide();
			$("#voiceDiv").hide();
			$("#videoDiv").hide();
			$("#mpNewsDiv").hide();
		} else if(type == "image") {
			$("#contentDiv").hide();
			$("#imageDiv").show();
			$("#voiceDiv").hide();
			$("#videoDiv").hide();
			$("#mpNewsDiv").hide();
		} else if(type == "voice") {
			$("#contentDiv").hide();
			$("#imageDiv").hide();
			$("#voiceDiv").show();
			$("#videoDiv").hide();
			$("#mpNewsDiv").hide();
		} else if(type == "video") {
			$("#contentDiv").hide();
			$("#imageDiv").hide();
			$("#voiceDiv").hide();
			$("#videoDiv").show();
			$("#mpNewsDiv").hide();
		} else if(type == "news") {
			$("#contentDiv").hide();
			$("#imageDiv").hide();
			$("#voiceDiv").hide();
			$("#videoDiv").hide();
			$("#mpNewsDiv").show();
		}
	},

	"changeAll": function() {
		var isAll = $("#isAll").val();
		if(isAll == "1") {
			$("#wxTagDiv").hide();
			$("#openidsDiv").hide();
		} else if(isAll == "2") {
			$("#wxTagDiv").show();
			$("#openidsDiv").show();
		}
	},

	"selectForverImage": function() {
		parent.showModal("选择永久图片", contextPath + "/foreverMedia/select?type=image&domId=mediaId", 500);
	},

	"selectForeverVoice": function() {
		parent.showModal("选择永久语音", contextPath + "/foreverMedia/select?type=voice&domId=mediaId", 500);
	},

	"selectTempVideo": function() {
		parent.showModal("选择视频", contextPath + "/uploadVideo/select?domId=mediaId", 500);
	},

	"selectNews": function() {
		parent.showModal("选择图文", contextPath + "/uploadNews/select?domId=mediaId", 500);
	},

	"showJson": function(id) {
		parent.showModal("查看完整Json内容", contextPath + "/groupMessage/showJson?id=" + id, 500);
	},

	"search": function() {
		GroupMessage.initGroupMessageList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/groupMessage/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='groupMessage']").each(function() {
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
			url: contextPath + "/groupMessage/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					GroupMessage.initGroupMessageList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initGroupMessageList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/groupMessage/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"isAll": $("#isAll").val(),
				"wxTagId": $("#wxTagId").val(),
				"account": $("#account").val(),
				"type": $("#type").val(),
				"status": $("#status").val(),
				"mediaId": $("#mediaId").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/groupMessage/count",
			async: true,
			data: {
				"isAll": $("#isAll").val(),
				"wxTagId": $("#wxTagId").val(),
				"account": $("#account").val(),
				"type": $("#type").val(),
				"status": $("#status").val(),
				"mediaId": $("#mediaId").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "GroupMessage.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		GroupMessage.initGroupMessageList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/groupMessage/toUpdate?id=" + id;
	},

	"deleteGroupMessage": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/groupMessage/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					GroupMessage.initGroupMessageList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var type = $("#type").val();
		var mediaId = $("#mediaId").val();
		var content = $("#content").val();
		if(type == "text") {
			if(!content) {
				parent.showInfo("内容不能为空");
				return false;
			}
		} else {
			if(!mediaId) {
				parent.showInfo("必须选择素材");
				return false;
			}
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/groupMessage/list";
	},

	"end": null
};