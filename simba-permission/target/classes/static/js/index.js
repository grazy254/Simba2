$(document).ready(function() {
	changeFrameHeight();
	initMenu();
	initUser();
});

function changeFrameHeight() {
	var ifm = document.getElementById("contentiframe");
	ifm.height = document.documentElement.clientHeight - 38 - $(".main-header").height() - $(".main-footer").height();
}

window.onresize = function() {
	changeFrameHeight();
}

function initUser() {
	$.ajax({
		type : "get",
		url : contextPath + "/user/getCurrentUserInfo",
		async : true,
		dataType : "json",
		success : function(data) {
			if (data.code == 200) {
				$("#loginName").html(data.data.userName);
				if (data.data.isAdmin) {
					$("#profile").hide();
				}
			} else {
				showInfo(data.msg);
			}
		}
	});
}

function initMenu() {
	$.ajax({
		type : "get",
		url : contextPath + "/menu/showAllMenus",
		async : true,
		dataType : "html",
		success : function(html) {
			$("#menuTree").append(html);
		}
	});

}

function forwardMenu(url) {
	if (!!url) {
		$("#contentiframe").attr("src", url);
	}
}

function logout() {
	window.self.location.href = contextPath + "/login/logout";
}

/**
 * 显示模态窗口
 * 
 * @param title
 *            窗口标题
 * @param url
 *            窗口内容地址
 * @param height
 *            窗口高度
 * @returns
 */
function showModal(title, url, height) {
	$("#myModalLabel").html(title);
	$("#modalbodyiframe").prop("src", url);
	if (!!height) {
		$("#modalbodyiframe").css("height", height);
	} else {
		$("#modalbodyiframe").css("height", 500);
	}
	$("#modalButton").click();
}

/**
 * 隐藏模态窗口
 * 
 * @returns
 */
function hideModal() {
	$("#modalDialog").find(".close").click();
}

function toModifyInfo() {
	showModal("修改个人信息", contextPath + "/user/toModifyInfo", 650);
}

function toModifyPwd() {
	showModal("修改密码", contextPath + "/user/toModifyPwd", 400);
}

/**
 * 显示错误提示信息
 * 
 * @param info
 *            信息内容
 * @returns
 */
function showInfo(info) {
	$("#errInfo").html(info);
	$("#errDiv").fadeIn();
	setTimeout("hideInfo();", 3000);
}

/**
 * 隐藏错误提示信息
 * 
 * @returns
 */
function hideInfo() {
	$("#errDiv").fadeOut();
}

/**
 * 显示成功提示信息
 * 
 * @param info
 *            信息内容
 * @returns
 */
function showSuccessInfo(info) {
	$("#successInfo").html(info);
	$("#successDiv").fadeIn();
	setTimeout("hideSuccessInfo();", 2500);
}

/**
 * 隐藏成功提示信息
 * 
 * @returns
 */
function hideSuccessInfo() {
	$("#successDiv").fadeOut();
}