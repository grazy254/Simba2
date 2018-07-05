var Project = {

	"search": function() {
		Project.initProjectList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/userProject/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='project']").each(function() {
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
			url: contextPath + "/userProject/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Project.initProjectList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initProjectList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/userProject/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"code": $("#code").val(),
				"name": $("#name").val(),
				"account": $("#account").val(),
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
			url: contextPath + "/userProject/count",
			async: true,
			data: {
				"code": $("#code").val(),
				"name": $("#name").val(),
				"account": $("#account").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Project.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		Project.initProjectList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/userProject/toUpdate?id=" + id;
	},

	"deleteProject": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/userProject/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					Project.initProjectList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var code = $("#code").val();
		if(!code) {
			parent.showInfo("编码不能为空");
			return false;
		}
		var name = $("#name").val();
		if(!name) {
			parent.showInfo("名称不能为空");
			return false;
		}
		var projectKey = $("#projectKey").val();
		if(!projectKey) {
			parent.showInfo("加密密钥不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/userProject/list";
	},

	"end": null
};