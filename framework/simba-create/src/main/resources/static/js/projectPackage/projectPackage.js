var ProjectPackage = {

	"checkForm": function() {
		var versionNo = $("#versionNo").val();
		if(!versionNo) {
			parent.showInfo("版本号不能为空");
			return false;
		}
		var projectCode = $("#projectCode").val();
		if(!projectCode) {
			parent.showInfo("项目名称不能为空");
			return false;
		}
		var packageName = $("#packageName").val();
		if(!packageName) {
			parent.showInfo("包名不能为空");
			return false;
		}
		var account = $("#account").val();
		if(!account) {
			parent.showInfo("超级管理员账号不能为空");
			return false;
		}
		var pwd = $("#pwd").val();
		if(!pwd) {
			parent.showInfo("超级管理员密码不能为空");
			return false;
		}
		var defaultPwd = $("#defaultPwd").val();
		if(!defaultPwd) {
			parent.showInfo("普通用户密码不能为空");
			return false;
		}
		var encryptKey = $("#encryptKey").val();
		if(!encryptKey) {
			parent.showInfo("加密秘钥不能为空");
			return false;
		}
		var adminPort = $("#adminPort").val();
		if(!adminPort) {
			parent.showInfo("管理系统端口号不能为空");
			return false;
		}
		var userPort = $("#userPort").val();
		if(!userPort) {
			parent.showInfo("用户系统端口号不能为空");
			return false;
		}
		parent.showSuccessInfo("正在打包中，请耐心等待......");
		return true;
	},

	"end": null

};