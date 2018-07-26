var RedPackBill = {

	"search": function() {
		RedPackBill.initRedPackBillList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/redPackBill/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='redPackBill']").each(function() {
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
			url: contextPath + "/redPackBill/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					RedPackBill.initRedPackBillList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initRedPackBillList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/redPackBill/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"type": $("#type").val(),
				"billNo": $("#billNo").val(),
				"openid": $("#openid").val(),
				"actName": $("#actName").val(),
				"sceneId": $("#sceneId").val(),
				"status": $("#status").val(),
				"sendListId": $("#sendListId").val(),
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
			url: contextPath + "/redPackBill/count",
			async: true,
			data: {
				"type": $("#type").val(),
				"billNo": $("#billNo").val(),
				"openid": $("#openid").val(),
				"actName": $("#actName").val(),
				"sceneId": $("#sceneId").val(),
				"status": $("#status").val(),
				"sendListId": $("#sendListId").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "RedPackBill.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		RedPackBill.initRedPackBillList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/redPackBill/toUpdate?id=" + id;
	},

	"deleteRedPackBill": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/redPackBill/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					RedPackBill.initRedPackBillList(0, Page.size);
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
		window.self.location.href = contextPath + "/redPackBill/list";
	},

	"add": function() {
		var url = contextPath + "/api/wechatRedPack/";
		var type = $("#type").val();
		if(type == "NORMAL") {
			url += "sendNormalRedPack";
		} else {
			url += "sendGroupRedPack";
		}
		var num = $("#num").val();
		var sendName = $("#sendName").val();
		var openid = $("#openid").val();
		var amount = $("#amount").val();
		var wishing = $("#wishing").val();
		var actName = $("#actName").val();
		var remark = $("#remark").val();
		var sceneId = $("#sceneId").val();
		if(!sendName) {
			parent.showInfo("商户名称不能为空");
			return false;
		}
		if(!openid) {
			parent.showInfo("用户openid不能为空");
			return false;
		}
		if(!amount) {
			parent.showInfo("付款金额不能为空");
			return false;
		}
		if(type == "GROUP" && !num) {
			parent.showInfo("红包发放总人数不能为空");
			return false;
		}
		if(!wishing) {
			parent.showInfo("红包祝福语不能为空");
			return false;
		}
		if(!actName) {
			parent.showInfo("活动名称不能为空");
			return false;
		}
		if(!sceneId) {
			parent.showInfo("场景id不能为空");
			return false;
		}
		parent.showSuccessInfo("请求正在处理中");
		$.ajax({
			type: "post",
			url: url,
			async: true,
			dataType: "json",
			data: {
				total_amount: amount,
				total_num: num,
				wishing: wishing,
				act_name: actName,
				scene_id: sceneId,
				re_openid: openid,
				send_name: sendName,
				remark: remark
			},
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("请求处理完成");
					RedPackBill.toList();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"changeType": function() {
		var type = $("#type").val();
		if(type == "NORMAL") {
			$("#numDiv").hide();
		} else {
			$("#numDiv").show();
		}
	},

	"end": null
};