var AutoId = {

	"search" : function() {
		AutoId.initAutoIdList();
	},

	"toAdd" : function() {
		window.self.location.href = contextPath + "/autoId/toAdd";
	},

	"batchDelete" : function() {
		var ids = new Array();
		$("input[name='autoId']").each(function() {
			if (true == $(this).is(':checked')) {
				ids.push($(this).val());
			}
		});
		if (ids.length == 0) {
			parent.showInfo("请选择要删除的记录");
			return false;
		}
		$.ajax({
			type : "post",
			url : contextPath + "/autoId/batchDelete",
			data : {
				"id" : ids.join(",")
			},
			async : true,
			dataType : "json",
			success : function(data) {
				if (data.code == 200) {
					AutoId.initAutoIdList();
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initAutoIdList" : function() {
		$.ajax({
			type : "get",
			url : contextPath + "/autoId/getList",
			data : {
				"key" : $("#key").val()
			},
			async : true,
			dataType : "html",
			success : function(html) {
				$("#table").find("tbody").html(html);
				CheckBox.init();
				setTimeout("CheckBox.bindCheckAll();", 1000);
			}
		});
	},

	"toUpdate" : function(id) {
		window.self.location.href = contextPath + "/autoId/toUpdate?id=" + id;
	},

	"deleteAutoId" : function(id) {
		$.ajax({
			type : "post",
			url : contextPath + "/autoId/batchDelete",
			data : {
				"id" : id
			},
			async : true,
			dataType : "json",
			success : function(data) {
				if (data.code == 200) {
					AutoId.initAutoIdList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm" : function() {
		return true;
	},

	"toList" : function() {
		window.self.location.href = contextPath + "/autoId/list";
	},

	"end" : null
};