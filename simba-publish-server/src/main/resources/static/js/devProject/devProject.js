var DevProject = {

	"showRollbackSome": function(id) {
		parent.showModal("选择需要回滚的服务器", contextPath + "/devProject/showRollbackSome?id=" + id, 500);
	},

	"rollbackSome": function() {
		var ids = new Array();
		$("input[name='projectServer']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0) {
			showInfo("请选择需要回滚的服务器");
			return false;
		}
		showInfo("正在回滚，请耐心等待，回滚成功之后将有邮件提醒...");
		var projectId = $("#projectId").val();
		$.ajax({
			type: "post",
			url: contextPath + "/devProject/rollbackSomeServers",
			async: true,
			data: {
				"projectId": projectId,
				"serverIds": ids.join(",")
			},
			success: function(data) {
				if(data.code == 200) {
					top.showSuccessInfo("回滚发布完成");
					top.hideModal();
				} else {
					showInfo(data.msg);
				}
			}
		});
	},

	"rollbackAll": function(id) {
		parent.showSuccessInfo("正在回滚，请耐心等待，回滚成功之后将有邮件提醒...");
		$.ajax({
			type: "post",
			url: contextPath + "/devProject/rollbackAll",
			async: true,
			data: {
				"id": id
			},
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("回滚完成");
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"copy": function(id) {
		parent.showSuccessInfo("正在拷贝项目，请耐心等待...");
		$.ajax({
			type: "post",
			url: contextPath + "/devProject/copy",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("拷贝项目完成");
					DevProject.initDevProjectList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"refreshCode": function(id) {
		parent.showSuccessInfo("正在重新初始化库，请耐心等待...");
		$.ajax({
			type: "post",
			url: contextPath + "/devProject/refreshCode",
			async: true,
			data: {
				"id": id
			},
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("重新初始化库成功");
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"deleteRow": function(obj) {
		$(obj).parent().remove();
	},

	"addRow": function() {
		var row = "<div class=\"form-group\"><label>打包结果文件路径:</label><input type=\"text\" class=\"form-control\" name=\"targetFile\" placeholder=\"请输入打包结果文件路径\"><button type=\"button\" class=\"btn btn-default btn-sm\" onclick=\"DevProject.deleteRow(this);\"><i class=\"fa fa-remove\"></i>删除</button></div>";
		$("#targetFiles").append(row);
	},

	"showBindServers": function(id) {
		parent.showModal("绑定服务器", contextPath + "/devProject/showBindServers?id=" + id, 500);
	},

	"bindServers": function() {
		var ids = new Array();
		$("input[name='projectServer']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		var projectId = $("#projectId").val();
		$.ajax({
			type: "post",
			url: contextPath + "/devProject/bindServers",
			async: true,
			data: {
				"projectId": projectId,
				"serverIds": ids.join(",")
			},
			success: function(data) {
				if(data.code == 200) {
					top.contentiframe.DevProject.initDevProjectList(0, Page.size);
					top.hideModal();
				} else {
					showInfo(data.msg);
				}
			}
		});
	},

	"cancelBindServers": function() {
		top.hideModal();
	},

	"showPublishSome": function(id) {
		parent.showModal("选择需要发布的服务器", contextPath + "/devProject/showPublishSome?id=" + id, 500);
	},

	"publishSomeServers": function() {
		var ids = new Array();
		$("input[name='projectServer']").each(function() {
			if(true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if(ids.length == 0) {
			showInfo("请选择需要发布的服务器");
			return false;
		}
		showInfo("正在打包发布，请耐心等待，发布成功之后将有邮件提醒...");
		var projectId = $("#projectId").val();
		$.ajax({
			type: "post",
			url: contextPath + "/devProject/publishSomeServers",
			async: true,
			data: {
				"projectId": projectId,
				"serverIds": ids.join(",")
			},
			success: function(data) {
				if(data.code == 200) {
					top.showSuccessInfo("打包发布完成");
					top.hideModal();
				} else {
					showInfo(data.msg);
				}
			}
		});
	},

	"cancelPublishSomeServers": function() {
		top.hideModal();
	},

	"publishAll": function(id) {
		parent.showSuccessInfo("正在打包发布，请耐心等待，发布成功之后将有邮件提醒...");
		$.ajax({
			type: "post",
			url: contextPath + "/devProject/publishAll",
			async: true,
			data: {
				"id": id
			},
			success: function(data) {
				if(data.code == 200) {
					parent.showSuccessInfo("打包发布完成");
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"search": function() {
		DevProject.initDevProjectList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/devProject/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='devProject']").each(function() {
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
			url: contextPath + "/devProject/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					DevProject.initDevProjectList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initDevProjectList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/devProject/getList",
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
			url: contextPath + "/devProject/count",
			async: true,
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "DevProject.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		DevProject.initDevProjectList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/devProject/toUpdate?id=" + id;
	},

	"deleteDevProject": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/devProject/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					DevProject.initDevProjectList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var code = $("#code").val();
		if(!code) {
			parent.showInfo("编号不能为空");
			return false;
		}
		var name = $("#name").val();
		if(!name) {
			parent.showInfo("名称不能为空");
			return false;
		}
		var account = $("#account").val();
		if(!account) {
			parent.showInfo("账号不能为空");
			return false;
		}
		var pwd = $("#pwd").val();
		if(!pwd) {
			parent.showInfo("密码不能为空");
			return false;
		}
		var versionUrl = $("#versionUrl").val();
		if(!versionUrl) {
			parent.showInfo("版本管理地址不能为空");
			return false;
		}
		var packageCommandFile = $("#packageCommandFile").val();
		if(!packageCommandFile) {
			parent.showInfo("打包命令文件路径不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/devProject/list";
	},

	"cancelRollbackSomeServers": function() {
		top.hideModal();
	},

	"end": null
};