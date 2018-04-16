var ProjectVersion = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/projectVersion/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='projectVersion']").each(function() {
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
			url: contextPath + "/projectVersion/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ProjectVersion.initProjectVersionList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initProjectVersionList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/projectVersion/getList",
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
			url: contextPath + "/projectVersion/count",
			async: true,
			data: {
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ProjectVersion.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		ProjectVersion.initProjectVersionList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/projectVersion/toUpdate?id=" + id;
	},

	"deleteProjectVersion": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/projectVersion/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ProjectVersion.initProjectVersionList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var versionNo = $("#versionNo").val();
		if(!versionNo){
			parent.showInfo("版本号不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/projectVersion/list";
	},
	
	"download" : function(id){
			window.self.location.href = contextPath + "/projectVersion/download?id=" + id;
	},

	"end": null
};