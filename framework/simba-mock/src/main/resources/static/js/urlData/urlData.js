var UrlData = {

	"toAdd": function() {
		window.self.location.href = contextPath + "/urlData/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='urlData']").each(function() {
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
			url: contextPath + "/urlData/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UrlData.initUrlDataList(0, Page.size, $("#projectId").val());
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initUrlDataList": function(start, pageSize, projectId) {
		$.ajax({
			type: "get",
			url: contextPath + "/urlData/getList",
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
			url: contextPath + "/urlData/count",
			async: true,
			data: {
				"projectId": projectId
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "UrlData.clickPager");
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
				$("h3#projectTitle1").text(projectName + "项目数据");
			}
		});
	},

	"clickPager": function(start, pageSize) {
		UrlData.initUrlDataList(start, pageSize, $("#projectId").val());
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/urlData/toUpdate?id=" + id;
	},

	"deleteUrlData": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/urlData/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					UrlData.initUrlDataList(0, Page.size, $("#projectId").val());
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},
	"importExcel":function(){
		if(! $("#file").val()){
			parent.showInfo("请先选择文件再点击导入！");
			return ;
		}
		$("#form").submit();
	},

	"checkForm": function() {
		var url = $("#url").val();
		if(!url) {
			parent.showInfo("路径不能为空");
			return false;
		}
		var data = $("#data").val();
		if(!data) {
			parent.showInfo("数据不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/urlData/list";
	},

	"toBackList": function() {
		window.self.location.href = contextPath + "/urlData/backList";
	},

	"initAddUrlForm": function(projectId) {
		$("input#projectId").val(projectId);
		$("input#projectId").attr("readonly", "readonly");
		$("input#projectId").attr("type", "hidden");
		$("label[for='projectId']").attr("hidden", "hidden");
	},

	"initModifyUrlForm": function(projectId) {
		$("input#projectId").val(projectId);
		$("input#projectId").attr("readonly", "readonly");
		$("input#projectId").attr("type", "hidden");
		$("label[for='projectId']").attr("hidden", "hidden");
	},

	"showAddUrlDataModel": function() {
		//代替toAdd()
		parent.showModal("添加项目数据", contextPath + "/urlData/toAdd", 400);
	},

	"end": null
};