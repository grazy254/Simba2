var Fans = {

	"selectedFanses": function() {
		parent.showModal("选择粉丝列表", contextPath + "/fans/selectedFanses", 500);
	},

	"searchSelectFanses": function() {
		Fans.initSelectFansesList(0, Page.size);
	},

	"deleteSelectedFans": function(openid) {
		$("#fans_" + openid).remove();
		var openids = $("#openids").val();
		var openidArray = openids.split(",");
		var newOpenidArray = new Array();
		for(var i = 0; i < openidArray.length; i++) {
			if(openid != openidArray[i]) {
				newOpenidArray.push(openidArray[i]);
			}
		}
		$("#openids").val(newOpenidArray.join(","));
	},

	"executeSelectFanses": function(openid, nickname) {
		var openids = $("#openids").val();
		var openidArray = openids.split(",");
		var isContain = false;
		for(var i = 0; i < openidArray.length; i++) {
			if(openid == openidArray[i]) {
				isContain = true;
				break;
			}
		}
		if(isContain) {
			return false;
		}
		openidArray.push(openid);
		$("#openids").val(openidArray.join(","));
		var selectedHtml = "<a id='fans_" + openid + "' href='#' onclick='Fans.deleteSelectedFans(\"" + openid + "\")'>" + nickname + "<i class=\"fa fa-remove\"></i></button>&nbsp;&nbsp;</a>";
		$("#selectedFansList").append(selectedHtml);
	},

	"selectedFansesBack": function() {
		var openids = $("#openids").val();
		top.contentiframe.window.Fans.showSelectedFanses(openids);
		top.hideModal();
	},

	"showSelectedFanses": function(openids) {
		$("#openids").val(openids);
		$.ajax({
			type: "get",
			url: contextPath + "/fans/getFanses",
			async: true,
			data: {
				openids: openids
			},
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					var fansHtml = "";
					$.each(data.data, function(i, fans) {
						var openid = fans.openid;
						var nickname = fans.nickname;
						var selectedHtml = "<a id='fans_" + openid + "' href='#' onclick='Fans.deleteSelectedFans(\"" + openid + "\")'>" + nickname + "<i class=\"fa fa-remove\"></i></button>&nbsp;&nbsp;</a>";
						fansHtml += selectedHtml;
					});
					$("#selectedFansList").html(fansHtml);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initSelectedFanses": function() {
		var openids = $(top.frames["contentiframe"].document).find("#openids").val();
		$("#openids").val(openids);
		$.ajax({
			type: "get",
			url: contextPath + "/fans/getFanses",
			async: true,
			data: {
				openids: openids
			},
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					$.each(data.data, function(i, fans) {
						var openid = fans.openid;
						var nickname = fans.nickname;
						var selectedHtml = "<a id='fans_" + openid + "' href='#' onclick='Fans.deleteSelectedFans(\"" + openid + "\")'>" + nickname + "<i class=\"fa fa-remove\"></i></button>&nbsp;&nbsp;</a>";
						$("#selectedFansList").append(selectedHtml);
					});
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initSelectFansesList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/fans/getSelectFansesList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"openid": $("#openid").val(),
				"remark": $("#remark").val(),
				"nickname": $("#nickname").val(),
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
			url: contextPath + "/fans/count",
			async: true,
			data: {
				"openid": $("#openid").val(),
				"remark": $("#remark").val(),
				"nickname": $("#nickname").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Fans.clickSelectFansesPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickSelectFansesPager": function(start, pageSize) {
		Fans.initSelectFansesList(start, pageSize);
	},

	"executeSelect": function(openid) {
		var domId = $("#domId").val();
		$(top.frames["contentiframe"].document).find("#" + domId).val(openid);
		top.hideModal();
	},

	"searchSelect": function() {
		Fans.initSelectFansList(0, Page.size);
	},

	"initSelectFansList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/fans/getSelectList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"openid": $("#openid").val(),
				"remark": $("#remark").val(),
				"nickname": $("#nickname").val(),
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
			url: contextPath + "/fans/count",
			async: true,
			data: {
				"openid": $("#openid").val(),
				"remark": $("#remark").val(),
				"nickname": $("#nickname").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Fans.clickSelectPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickSelectPager": function(start, pageSize) {
		Fans.initSelectFansList(start, pageSize);
	},

	"selectFans": function(domId) {
		parent.showModal("选择粉丝", contextPath + "/fans/selectFans?domId=" + domId, 500);
	},

	"batchTag": function() {
		var ids = new Array();
		$("input[name='fans']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0) {
			parent.showInfo("请选择要设置标签的粉丝");
			return false;
		}
		parent.showModal("设置标签", contextPath + "/fans/toBatchSetTag?ids=" + ids.join(","), 300);
	},

	"batchClearTag": function() {
		var ids = new Array();
		$("input[name='fans']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0) {
			parent.showInfo("请选择要清空标签的粉丝");
			return false;
		}
		$.ajax({
			type: "post",
			url: contextPath + "/fans/batchClearTag",
			data: {
				"ids": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("清空标签成功");
					Fans.initFansList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"clearTag": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/fans/clearTag",
			async: true,
			dataType: "json",
			data: {
				id: id
			},
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("清空标签成功");
					Fans.initFansList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"setTag": function(id) {
		parent.showModal("设置标签", contextPath + "/fans/toSetTag?id=" + id, 300);
	},

	"executeSetTag": function() {
		var ids = new Array();
		$("input[name='tagId']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0) {
			$("#errInfo").html("请选择要分配的标签");
			return false;
		}
		$.ajax({
			type: "post",
			url: contextPath + "/fans/setTag",
			data: {
				"tagIds": ids.join(","),
				"fansId": $("#fansId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					top.contentiframe.window.Fans.initFansList(0, Page.size);
					top.hideModal();
				} else {
					$("#errInfo").html(data.msg);
				}
			}
		});
	},

	"cancelSetTag": function() {
		top.hideModal();
	},

	"toUpdateRemark": function(id) {
		parent.showModal("设置备注", contextPath + "/fans/toUpdateRemark?id=" + id, 300);
	},

	"updateRemark": function() {
		var remark = $("#remark").val();
		if(!remark) {
			$("#errDiv").html("备注不能为空");
			return false;
		}
		$.ajax({
			url: contextPath + "/fans/updateRemark",
			data: {
				id: $("#id").val(),
				remark: remark
			},
			dataType: "json",
			type: "post",
			async: true,
			success: function(data) {
				if(data.code == 200) {
					top.contentiframe.window.Fans.initFansList(0, Page.size);
					top.hideModal();
				} else {
					$("#errDiv").html(data.msg);
				}
			}
		});

	},

	"cancelUpdateRemark": function() {
		top.hideModal();
	},

	"syncFromWx": function() {
		$.ajax({
			url: contextPath + "/fans/syncFromWx",
			type: "post",
			dataType: "json",
			async: true,
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("正在执行同步，可能需要较长时间，请耐心等待，不要重复点击......");
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"blackBatch": function() {
		var ids = new Array();
		$("input[name='fans']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0) {
			parent.showInfo("请选择要拉黑的粉丝");
			return false;
		}
		$.ajax({
			type: "post",
			url: contextPath + "/fans/batchBlack",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("拉黑成功");
					Fans.initFansList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"search": function() {
		Fans.initFansList(0, Page.size);
	},

	"blackFans": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/fans/batchBlack",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("拉黑成功");
					Fans.initFansList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/fans/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='fans']").each(function() {
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
			url: contextPath + "/fans/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Fans.initFansList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initFansList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/fans/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"openid": $("#openid").val(),
				"remark": $("#remark").val(),
				"nickname": $("#nickname").val(),
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
			url: contextPath + "/fans/count",
			async: true,
			data: {
				"openid": $("#openid").val(),
				"remark": $("#remark").val(),
				"nickname": $("#nickname").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Fans.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		Fans.initFansList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/fans/toUpdate?id=" + id;
	},

	"deleteFans": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/fans/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Fans.initFansList(0, Page.size);
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
		window.self.location.href = contextPath + "/fans/list";
	},

	"end": null
};