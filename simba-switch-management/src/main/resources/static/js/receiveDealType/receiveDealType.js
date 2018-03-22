var ReceiveDealType = {

	"search": function() {
		ReceiveDealType.initReceiveDealTypeList(0, Page.size);
	},

	"toAdd": function() {
		window.self.location.href = contextPath + "/receiveDealType/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='receiveDealType']").each(function() {
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
			url: contextPath + "/receiveDealType/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ReceiveDealType.initReceiveDealTypeList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initReceiveDealTypeList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/receiveDealType/getList",
			data: {
				"pageStart": start,
				"pageSize": pageSize,
				"beanId": $("#beanId").val(),
				"name": $("#name").val(),
				"sync": $("#sync").val()
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
			url: contextPath + "/receiveDealType/count",
			async: true,
			data: {
				"beanId": $("#beanId").val(),
				"name": $("#name").val(),
				"sync": $("#sync").val()
			},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ReceiveDealType.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		ReceiveDealType.initReceiveDealTypeList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/receiveDealType/toUpdate?id=" + id;
	},

	"deleteReceiveDealType": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/receiveDealType/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ReceiveDealType.initReceiveDealTypeList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		var beanId = $("#beanId").val();
		var name = $("#name").val();
		if(!name) {
			parent.showInfo("名称不能为空");
			return false;
		}
		if(!beanId) {
			parent.showInfo("Bean ID不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/receiveDealType/list";
	},

	"end": null
};