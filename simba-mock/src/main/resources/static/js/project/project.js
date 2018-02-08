var Project = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/project/toAdd";
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
			url: contextPath + "/project/batchDelete",
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

	"initProjectList": function(start, pageSize, account) {
		$.ajax({
			type: "get",
			url: contextPath + "/project/getList",
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
				Project.initUserLimit(account);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/project/count",
			async: true,
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Project.clickPager");
				$("#page").html(pageHtml);
			}
		});

	},

	"initUserLimit": function(account) {
		$("input[type='checkbox']").attr("disabled", "disabled");
		$("td[id='tdProjectId']").each(function() {
			var tdThis = this;
			$.ajax({
				type: "get",
				url: contextPath + "/projectUser/getUserType",
				async: true,
				data: { "account": account, "projectId": $(this).find("[name='project']").val() },
				async: true,
				dataType: "json",
				success: function(data) {
					var type = data.data;
					if(type == 1) {
						$(tdThis).nextUntil("td button#distributeBtn").find("#distributeBtn").show();
						$(tdThis).nextUntil("td button#delBtn").find("#delBtn").show();
						$(tdThis).nextUntil("td button#updateBtn").find("#updateBtn").show();
					} else {
						$(tdThis).nextUntil("td button#distributeBtn").find("#distributeBtn").hide();
						$(tdThis).nextUntil("td button#delBtn").find("#delBtn").hide();
						$(tdThis).nextUntil("td button#updateBtn").find("#updateBtn").hide();
					}
				}
			});
		});
	},

	"clickPager": function(start, pageSize) {
		Project.initProjectList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/project/toUpdate?id=" + id;
	},

	"deleteProject": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/project/delete",
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
				Project.toList();
			}
		});
	},

	"checkForm": function() {
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/project/list";
	},


	"toShowProjectUrlData": function(projectId) {
		window.self.location.href = contextPath + "/urlData/list?projectId=" + projectId;
	},

	
	"toAssignUser": function(projectId) {
		//代替 showUserModel(${project.id})
		top.showModal("人员分配", contextPath + "/projectUser/toAssignUser?projectId=" + projectId, 500);
	},

	"end": null
};