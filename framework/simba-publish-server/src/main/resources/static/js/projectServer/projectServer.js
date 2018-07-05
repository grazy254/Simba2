var ProjectServer = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/projectServer/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='projectServer']").each(function() {
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
			url: contextPath + "/projectServer/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ProjectServer.initProjectServerList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initProjectServerList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/projectServer/getList",
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
			url: contextPath + "/projectServer/count",
			async: true,
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ProjectServer.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		ProjectServer.initProjectServerList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/projectServer/toUpdate?id=" + id;
	},

	"deleteProjectServer": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/projectServer/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ProjectServer.initProjectServerList(0, Page.size);
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
		var ip = $("#ip").val();
		if(!ip) {
			parent.showInfo("IP不能为空");
			return false;
		}
		var port = $("#port").val();
		if(!port) {
			parent.showInfo("端口号不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/projectServer/list";
	},

	"end": null
};