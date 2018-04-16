var Tag = {

	"selectedTag": function(wxTagId) {
		var domId = $("#domId").val();
		$(top.frames["contentiframe"].document).find("#" + domId).val(wxTagId);
		top.hideModal();
	},

	"initSelectTagList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/tag/getSelectList",
			data: {
				"pageStart": start,
				"pageSize": pageSize
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/tag/count",
			async: true,
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Tag.clickSelectPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickSelectPager": function(start, pageSize) {
		Tag.initSelectTagList(start, pageSize);
	},

	"selectTag": function(domId) {
		parent.showModal("选择标签", contextPath + "/tag/selectTag?domId=" + domId, 500);
	},

	"batchClearFans": function() {
		var ids = new Array();
		$("input[name='tag']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0) {
			parent.showInfo("请选择要清空粉丝的标签");
			return false;
		}
		Tag.clearFans(ids.join(","));
	},

	"clearFans": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/tag/batchClearFans",
			async: true,
			dataType: "json",
			data: {
				id: id
			},
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("清空标签下粉丝成功");
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initFansList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/tag/getFansList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"tagId": $("#tagId").val()
			},
			async: true,
			dataType: "html",
			success: function(html) {
				$("#table").find("tbody").html(html);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/tag/countFans",
			async: true,
			data: {
				"tagId": $("#tagId").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Tag.clickFansPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickFansPager": function(start, pageSize) {
		Tag.initFansList(start, pageSize);
	},

	"showFans": function(id) {
		parent.showModal("查看标签下的粉丝列表", contextPath + "/tag/showFans?id=" + id, 700);
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

	"toAdd": function() {
		$.ajax({
			type: "get",
			url: contextPath + "/tag/count",
			async: true,
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.data < 100) {
					window.self.location.href = contextPath + "/tag/toAdd";
				} else {
					parent.showInfo("最多只能创建100个标签");
				}
			}
		});
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='tag']").each(function() {
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
			url: contextPath + "/tag/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Tag.initTagList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initTagList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/tag/getList",
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
			url: contextPath + "/tag/count",
			async: true,
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Tag.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		Tag.initTagList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/tag/toUpdate?id=" + id;
	},

	"deleteTag": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/tag/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Tag.initTagList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var name = $("#name").val();
		if(!name) {
			parent.showInfo("标签名不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/tag/list";
	},

	"end": null
};