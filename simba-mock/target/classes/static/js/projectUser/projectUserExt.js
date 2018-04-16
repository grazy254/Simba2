var ProjectUserExt = {

	"initUserList": function(start, pageSize, projectId) {
		$.ajax({
			type: "get",
			url: contextPath + "/projectUser/getUserList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"projectId": projectId
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
			url: contextPath + "/projectUser/countUser",
			async: true,
			data: {
				"projectId": projectId
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "Project.clickUserPager");
				$("#page").html(pageHtml);
			}
		});
		$.ajax({
			type: "get",
			url: contextPath + "/project/getProjectName",
			async: true,
			data: {
				"projectId": projectId
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var projectName = data.data;
				$("h3#projectTitle").text(projectName + "项目人员");
			}
		});
	},

	"initAddForm": function(projectId, account) {
		$("input#projectId").val(projectId);
		$("input#projectId").attr("readonly", "readonly");
		$("input#projectId").attr("type", "hidden");
		$("label[for='name']").attr("hidden", "hidden");
		$("select#type").val(2);
	},

	"toListUser": function(projectId) {
		window.self.location.href = contextPath + "/projectUser/userList?projectId=" + projectId;
	},

	"toAddUser": function() {
		window.self.location.href = contextPath + "/projectUser/toAddUser";
	},

	"clickUserPager": function(start, pageSize, projectId) {
		ProjectUserExt.initUserList(start, pageSize, projectId);
	},

	"deleteUser": function(account, projectId) {
		$.ajax({
			type: "post",
			url: contextPath + "/projectUser/deleteUser",
			data: {
				"account": account,
				"projectId": projectId
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ProjectUserExt.initUserList(0, Page.size, projectId);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});;
	},

	"batchDeleteUser": function(projectId) {
		var ids = new Array();
		$("input[name='userListProject']").each(function() {
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
			url: contextPath + "/projectUser/batchDeleteUser",
			data: {
				"accountList": ids.join(","),
				"projectId": projectId
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ProjectUserExt.initUserList(0, Page.size, projectId);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		return true;
	},

	"showAddUserModel": function() {
		//代替toAddUser()
		parent.showModal("添加开发者", contextPath + "/projectUser/toAddUser", 400);
	},

	"assignUser": function(projectId) {
		var ids = new Array();
		$("input[name='user']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		$.ajax({
			type: "post",
			url: contextPath + "/projectUser/assignUser",
			data: {
				"accountsChecked": ids.join(","),
				"projectId":projectId
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					top.hideModal();
				} else {
					showInfo(data.msg);
				}
			}
		});
	},

	"end": null

};