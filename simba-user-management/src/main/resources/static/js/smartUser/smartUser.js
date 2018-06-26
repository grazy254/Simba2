var SmartUser = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/smartUser/toAdd";
	},
	
	"toGroup": function(smartUserId) {
		 top.showModal("选择分组", contextPath + "/smartGroup/toGroupList?smartUserId="+smartUserId, 600);
	},
	
	"addUser2Group":function(groupId,smartUserId){
		$.ajax({
			type: "post",
			url: contextPath + "/smartUser/group",
			data: {
				"groupId": groupId,
				"smartUserId":smartUserId
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					top.showSuccessInfo(data.msg);
					top.hideModal();
					window.top.location.href = contextPath + "/smartUser/list";
					
					
				} else {
					alert(data.msg);
				}
			}
		});
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='smartUser']").each(function() {
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
			url: contextPath + "/smartUser/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					SmartUser.initSmartUserList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initSmartUserList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/smartUser/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"account": $("#account").val(),
				"name": $("#name").val(),
				"email": $("#email").val(),
				"telNo": $("#telNo").val(),
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
			url: contextPath + "/smartUser/count",
			async: true,
			data: {
				"account": $("#account").val(),
				"name": $("#name").val(),
				"email": $("#email").val(),
				"telNo": $("#telNo").val(),
				"startTime": $("#startTime").val(),
				"endTime": $("#endTime").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "SmartUser.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		SmartUser.initSmartUserList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/smartUser/toUpdate?id=" + id;
	},

	"deleteSmartUser": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/smartUser/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					SmartUser.initSmartUserList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	
	"resetPwd1": function(id) {
		window.self.location.href = contextPath + "/smartUser/resetPwd?id=" + id;
	},
	
	"resetPwd": function(id) {
		$.ajax({
			type: "get",
			url: contextPath + "/smartUser/resetPwd",
			data: {
				"id": id
			},
			async: true,
			dataType: "html",
			success: function(html) {
				parent.showSuccessInfo("重置密码成功");
			}
		});
	},
	"checkForm": function() {
		var account = $("#account").val();
		if(!account) {
			parent.showInfo("账号不能为空");
			return false;
		}
		var testAccount= /^[a-zA-z]\w{3,15}$/;
		if(!testAccount.test(account)){
			parent.showInfo("账号不合法");
			return false;
		}
		var name = $("#name").val();
		if(!name) {
			parent.showInfo("名称不能为空");
			return false;
		}
		var email = $("#email").val();
		if(!email) {
			parent.showInfo("邮箱不能为空");
			return false;
		}
		var testEmail=/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
		if(!testEmail.test(email)){
			parent.showInfo("邮箱不合法");
			return false;
		}
		var telNo = $("#telNo").val();
		if(!telNo) {
			parent.showInfo("手机号不能为空");
			return false;
		}
		var testTelNo=/^1\d{10}$/;
		if(!testTelNo.test(telNo)){
			parent.showInfo("手机不合法");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/smartUser/list";
	},
	
	"search": function() {
		SmartUser.initSmartUserList(0, Page.size);
	},
	
	
	"end": null
};