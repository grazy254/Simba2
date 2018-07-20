var PermissionUtil = {

	/**
	 * 判断是否拥有某个权限，如果有权限，则dom元素显示，否则的话删掉
	 */
	"hasPermission" : function(uri, id) {
		$.ajax({
			"url" : contextPath + "/permission/hasPermission",
			"data" : {
				"uri" : uri
			},
			"method" : "get",
			"async" : true,
			"dataType" : "json",
			"success" : function(data) {
				if (data.code == 200) {
					var enable = data.data;
					if (!enable) {
						$("#" + id).remove();
					}
				}
			}
		});
	},

	/**
	 * 判断是否拥有某个权限,然后回调方法fn，参数为true|false,有权限参数为true
	 */
	"hasPermissionCallback" : function(uri, fn) {
		$.ajax({
			"url" : contextPath + "/permission/hasPermission",
			"data" : {
				"uri" : uri
			},
			"method" : "get",
			"async" : true,
			"dataType" : "json",
			"success" : function(data) {
				if (data.code == 200) {
					var enable = data.data;
					fn(enable);
				}
			}
		});
	},

	"end" : null

}