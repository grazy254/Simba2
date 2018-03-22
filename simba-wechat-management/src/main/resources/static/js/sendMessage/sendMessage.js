var SendMessage = {

	"cancalAddNews": function() {
		top.hideModal();
	},

	"deteleNews": function(obj) {
		var trObject = $(obj).parent().parent();
		var title = $(trObject).find("td").eq(0).html();
		var descritption = $(trObject).find("td").eq(1).html();
		var clickUrl = $(trObject).find("td").eq(2).html();
		var picUrl = $(trObject).find("td").eq(3).html();
		trObject.remove();
		var content = title + "&~&" + descritption + "&~&" + clickUrl + "&~&" + picUrl;
		var news = $("#news").val();
		var newsArray = news.split("@~@");
		var nArray = new Array();
		for(var i = 0; i < newsArray.length; i++) {
			if(content != newsArray[i]) {
				nArray.push(newsArray[i]);
			}
		}
		$("#news").val(nArray.join("@~@"));
	},

	"executeAddNews": function() {
		var title = $("#title").val();
		var descritption = $("#descritption").val();
		var clickUrl = $("#clickUrl").val();
		var picUrl = $("#picUrl").val();
		var trHtml = "<tr>";
		trHtml += "<td>" + title + "</td>";
		trHtml += "<td>" + descritption + "</td>";
		trHtml += "<td>" + clickUrl + "</td>";
		trHtml += "<td>" + picUrl + "</td>";
		var deleteButton = "<button type=\"button\" class=\"btn btn-default btn-sm\" onclick=\"SendMessage.deteleNews(this);\" > <i class=\"fa fa-remove\"></i>删除 </button>";
		trHtml += "<td>" + deleteButton + "</td>";
		trHtml += "</tr>";
		$(top.frames["contentiframe"].document).find("#table").find("tbody").append(trHtml);
		var content = title + "&~&" + descritption + "&~&" + clickUrl + "&~&" + picUrl;
		var news = $(top.frames["contentiframe"].document).find("#news").val();
		var newsArray = news.split("@~@");
		newsArray.push(content);
		$(top.frames["contentiframe"].document).find("#news").val(newsArray.join("@~@"));
		top.hideModal();
	},

	"changeType": function() {
		var type = $("#type").val();
		if(type == "text") {
			$("#textDiv").show();
			$("#titleDiv").hide();
			$("#descriptionDiv").hide();
			$("#musicUrlDiv").hide();
			$("#hqMusicUrlDiv").hide();
			$("#imageDiv").hide();
			$("#voiceDiv").hide();
			$("#videoDiv").hide();
			$("#thumbDiv").hide();
			$("#mpNewsDiv").hide();
			$("#newsDiv").hide();
		} else if(type == "image") {
			$("#textDiv").hide();
			$("#titleDiv").hide();
			$("#descriptionDiv").hide();
			$("#musicUrlDiv").hide();
			$("#hqMusicUrlDiv").hide();
			$("#imageDiv").show();
			$("#voiceDiv").hide();
			$("#videoDiv").hide();
			$("#thumbDiv").hide();
			$("#mpNewsDiv").hide();
			$("#newsDiv").hide();
		} else if(type == "voice") {
			$("#textDiv").hide();
			$("#titleDiv").hide();
			$("#descriptionDiv").hide();
			$("#musicUrlDiv").hide();
			$("#hqMusicUrlDiv").hide();
			$("#imageDiv").hide();
			$("#voiceDiv").show();
			$("#videoDiv").hide();
			$("#thumbDiv").hide();
			$("#mpNewsDiv").hide();
			$("#newsDiv").hide();
		} else if(type == "video") {
			$("#textDiv").hide();
			$("#titleDiv").show();
			$("#descriptionDiv").show();
			$("#musicUrlDiv").hide();
			$("#hqMusicUrlDiv").hide();
			$("#imageDiv").hide();
			$("#voiceDiv").hide();
			$("#videoDiv").show();
			$("#thumbDiv").show();
			$("#mpNewsDiv").hide();
			$("#newsDiv").hide();
		} else if(type == "music") {
			$("#textDiv").hide();
			$("#titleDiv").show();
			$("#descriptionDiv").show();
			$("#musicUrlDiv").show();
			$("#hqMusicUrlDiv").show();
			$("#imageDiv").hide();
			$("#voiceDiv").hide();
			$("#videoDiv").hide();
			$("#thumbDiv").show();
			$("#mpNewsDiv").hide();
			$("#newsDiv").hide();
		} else if(type == "news") {
			$("#textDiv").hide();
			$("#titleDiv").hide();
			$("#descriptionDiv").hide();
			$("#musicUrlDiv").hide();
			$("#hqMusicUrlDiv").hide();
			$("#imageDiv").hide();
			$("#voiceDiv").hide();
			$("#videoDiv").hide();
			$("#thumbDiv").hide();
			$("#mpNewsDiv").hide();
			$("#newsDiv").show();
		} else if(type == "mpnews") {
			$("#textDiv").hide();
			$("#titleDiv").hide();
			$("#descriptionDiv").hide();
			$("#musicUrlDiv").hide();
			$("#hqMusicUrlDiv").hide();
			$("#imageDiv").hide();
			$("#voiceDiv").hide();
			$("#videoDiv").hide();
			$("#thumbDiv").hide();
			$("#mpNewsDiv").show();
			$("#newsDiv").hide();
		}
	},

	"selectTempImage": function() {
		parent.showModal("选择临时图片", contextPath + "/tempMedia/select?type=image&domId=mediaId", 500);
	},

	"selectForeverImage": function() {
		parent.showModal("选择永久图片", contextPath + "/foreverMedia/select?type=image&domId=mediaId", 500);
	},

	"selectTempVoice": function() {
		parent.showModal("选择临时语音", contextPath + "/tempMedia/select?type=voice&domId=mediaId", 500);
	},

	"selectForeverVoice": function() {
		parent.showModal("选择永久语音", contextPath + "/foreverMedia/select?type=voice&domId=mediaId", 500);
	},

	"selectTempVideo": function() {
		parent.showModal("选择临时视频", contextPath + "/tempMedia/select?type=video&domId=mediaId", 500);
	},

	"selectForeverVideo": function() {
		parent.showModal("选择永久视频", contextPath + "/foreverMedia/select?type=video&domId=mediaId", 500);
	},

	"selectTempThumb": function() {
		parent.showModal("选择临时缩略图", contextPath + "/tempMedia/select?type=thumb&domId=thumbMediaId", 500);
	},

	"selectForeverThumb": function() {
		parent.showModal("选择永久缩略图", contextPath + "/foreverMedia/select?type=thumb&domId=thumbMediaId", 500);
	},

	"selectForeverMpNews": function() {
		parent.showModal("选择永久图文", contextPath + "/foreverMedia/select?type=news&domId=mediaId", 500);
	},

	"addNews": function() {
		parent.showModal("新增图文内容", contextPath + "/sendMessage/toAddNews", 440);
	},

	"showJson": function(id) {
		parent.showModal("查看完整Json内容", contextPath + "/sendMessage/showJson?id=" + id, 500);
	},

	"showNews": function(id) {
		parent.showModal("查看图文内容", contextPath + "/sendMessage/showNews?id=" + id, 500);
	},

	"search": function() {
		SendMessage.initSendMessageList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/sendMessage/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='sendMessage']").each(function() {
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
			url: contextPath + "/sendMessage/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					SendMessage.initSendMessageList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initSendMessageList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/sendMessage/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"openid": $("#openid").val(),
				"type": $("#type").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"account": $("#account").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/sendMessage/count",
			async: true,
			data: {
				"openid": $("#openid").val(),
				"type": $("#type").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val(),
				"account": $("#account").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "SendMessage.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		SendMessage.initSendMessageList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/sendMessage/toUpdate?id=" + id;
	},

	"deleteSendMessage": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/sendMessage/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					SendMessage.initSendMessageList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var type = $("#type").val();
		var openid = $("#openid").val();
		var content = $("#content").val();
		var title = $("#title").val();
		var descritption = $("#descritption").val();
		var musicUrl = $("#musicUrl").val();
		var hqMusicUrl = $("#hqMusicUrl").val();
		var mediaId = $("#mediaId").val();
		var thumbMediaId = $("#thumbMediaId").val();
		var news = $("#news").val();
		if(!openid) {
			parent.showInfo("微信用户ID不能为空");
			return false;
		}
		if(type == "text") {
			if(!content) {
				parent.showInfo("文本消息内容不能为空");
				return false;
			}
		} else if(type == "image") {
			if(!mediaId) {
				parent.showInfo("图片不能为空");
				return false;
			}
		} else if(type == "voice") {
			if(!mediaId) {
				parent.showInfo("语音不能为空");
				return false;
			}
		} else if(type == "video") {
			if(!mediaId) {
				parent.showInfo("视频不能为空");
				return false;
			}
			if(!thumbMediaId) {
				parent.showInfo("缩略图不能为空");
				return false;
			}
			if(!title) {
				parent.showInfo("标题不能为空");
				return false;
			}
			if(!descritption) {
				parent.showInfo("描述不能为空");
				return false;
			}
		} else if(type == "music") {
			if(!musicUrl) {
				parent.showInfo("音乐链接不能为空");
				return false;
			}
			if(!hqMusicUrl) {
				parent.showInfo("高品质音乐链接不能为空");
				return false;
			}
			if(!thumbMediaId) {
				parent.showInfo("缩略图不能为空");
				return false;
			}
			if(!title) {
				parent.showInfo("标题不能为空");
				return false;
			}
			if(!descritption) {
				parent.showInfo("描述不能为空");
				return false;
			}
		} else if(type == "news") {
			if(!news) {
				parent.showInfo("图文内容不能为空");
				return false;
			}
		} else if(type == "mpnews") {
			if(!mediaId) {
				parent.showInfo("图文内容不能为空");
				return false;
			}
		} else {
			parent.showInfo("类型错误");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/sendMessage/list";
	},

	"end": null
};