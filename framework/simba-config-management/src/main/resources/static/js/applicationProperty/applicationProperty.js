var ApplicationProperty = {
	
	"auth": function(id) {
		top.showModal("权限设置", contextPath + "/applicationProperty/auth?id=" + id, 600);
	},

	"showDevProperty": function(id) {
		top.showModal("查看开发版配置", contextPath + "/applicationProperty/showDevProperty?id=" + id, 600);
	},
	"showProdProperty": function(id) {
		top.showModal("查看生产环境配置", contextPath + "/applicationProperty/showProdProperty?id=" + id, 600);
	},
	"showTestProperty": function(id) {
		top.showModal("查看测试版配置", contextPath + "/applicationProperty/showTestProperty?id=" + id, 600);
	},

	"getTemplate": function() {
		$.ajax({
			type: "post",
			url: contextPath + "/applicationProperty/getTemplate",
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {} else {
					parent.showInfo("获取模板失败");
				}
			}
		});
	},

	"setTemplate": function(val,selectedIndex) {
		if(confirm("切换模板将会把原来的配置文件重置，确定要这样做吗？")) {
			$.ajax({
				type: "post",
				url: contextPath + "/template/getTemplate",
				data: {
					id: val.value
				},
				async: true,
				dataType: "json",
				success: function(data) {
					if(data.code == 200) {
						document.getElementById("dev").value=data.data.template;
						document.getElementById("test").value=data.data.template;
						document.getElementById("prod").value=data.data.template;
					} else {
						parent.showInfo("获取模板失败");
					}
				}
			});
		} else {
			alert(selectedIndex);
			document.getElementById("templateId").selectedIndex =selectedIndex; 
		}

	},
	
	"setTemplateDev": function(val,selectedIndex) {
		if(confirm("切换模板将会把原来的配置文件重置，确定要这样做吗？")) {
			$.ajax({
				type: "post",
				url: contextPath + "/template/getTemplate",
				data: {
					id: val.value
				},
				async: true,
				dataType: "json",
				success: function(data) {
					if(data.code == 200) {
						document.getElementById("dev").value=data.data.template;
					} else {
						parent.showInfo("获取模板失败");
					}
				}
			});
		} else {
			alert(selectedIndex);
			document.getElementById("templateId").selectedIndex =selectedIndex; 
		}

	},
	"setTemplateProd": function(val,selectedIndex) {
		if(confirm("切换模板将会把原来的配置文件重置，确定要这样做吗？")) {
			$.ajax({
				type: "post",
				url: contextPath + "/template/getTemplate",
				data: {
					id: val.value
				},
				async: true,
				dataType: "json",
				success: function(data) {
					if(data.code == 200) {
						document.getElementById("prod").value=data.data.template;
					} else {
						parent.showInfo("获取模板失败");
					}
				}
			});
		} else {
			alert(selectedIndex);
			document.getElementById("templateId").selectedIndex =selectedIndex; 
		}

	},
	
	"setTemplateTest": function(val,selectedIndex) {
		if(confirm("切换模板将会把原来的配置文件重置，确定要这样做吗？")) {
			$.ajax({
				type: "post",
				url: contextPath + "/template/getTemplate",
				data: {
					id: val.value
				},
				async: true,
				dataType: "json",
				success: function(data) {
					if(data.code == 200) {
						document.getElementById("test").value=data.data.template;
					} else {
						parent.showInfo("获取模板失败");
					}
				}
			});
		} else {
			alert(selectedIndex);
			document.getElementById("templateId").selectedIndex =selectedIndex; 
		}

	},
	
	

	"toAdd": function() {
		window.self.location.href = contextPath + "/applicationProperty/toAdd";
	},

	"batchDelete": function() {
		var ids = new Array();
		$("input[name='applicationProperty']").each(function() {
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
			url: contextPath + "/applicationProperty/batchDelete",
			data: {
				"id": ids.join(",")
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ApplicationProperty.initApplicationPropertyList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"initApplicationPropertyList": function(start, pageSize) {
		$.ajax({
			type: "get",
			url: contextPath + "/applicationProperty/getList",
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
			url: contextPath + "/applicationProperty/count",
			async: true,
			data: {},
			async: true,
			dataType: "json",
			success: function(data) {
				var total = data.data;
				var pageHtml = Page.init(total, start, pageSize, "ApplicationProperty.clickPager");
				$("#page").html(pageHtml);
			}
		});
	},

	"clickPager": function(start, pageSize) {
		ApplicationProperty.initApplicationPropertyList(start, pageSize);
	},

	"toUpdate": function(id) {
		window.self.location.href = contextPath + "/applicationProperty/toUpdate?id=" + id;
	},
	"toUpdateDev": function(id) {
		window.self.location.href = contextPath + "/applicationProperty/toUpdateDev?id=" + id;
	},
	"toUpdateProd": function(id) {
		window.self.location.href = contextPath + "/applicationProperty/toUpdateProd?id=" + id;
	},
	"toUpdateTest": function(id) {
		window.self.location.href = contextPath + "/applicationProperty/toUpdateTest?id=" + id;
	},

	"deleteApplicationProperty": function(id) {
		$.ajax({
			type: "post",
			url: contextPath + "/applicationProperty/batchDelete",
			data: {
				"id": id
			},
			async: true,
			dataType: "json",
			success: function(data) {
				if(data.code == 200) {
					ApplicationProperty.initApplicationPropertyList(0, Page.size);
				} else {
					parent.showInfo(data.msg);
				}
			}
		});
	},

	"checkForm": function() {
		if(document.getElementById("name").value == "") {
			parent.showInfo("应用名不能为空");
			return false;
		}
		return true;
	},

	"toList": function() {
		window.self.location.href = contextPath + "/applicationProperty/list";
	},

	"end": null
};