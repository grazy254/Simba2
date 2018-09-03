var UTUI= {};
/*
 * 成功，正确的提示信息
 * content 提示内容
 */
UTUI.succMsg=function(content){
	layer.msg(content, {icon: 1});
}
/*
 * 失败，错误的提示信息
 * content 提示内容
 */
UTUI.failMsg=function(content){
	layer.msg(content, {icon: 2});
}
/*
 * 阻止，帮助的提示信息
 * content 提示内容
 */
UTUI.promMsg=function(content){
	layer.msg(content, {icon: 0});
}

/*
 * 提示框，并设置弹出时间
 */
UTUI.promMsg=function(content,time){
	 layer.msg(content, {
		 icon: 0,time: time
	    });
}
/**
 * alert提示框
 */
UTUI.promAlert=function(content,time){
	 layer.alert(content, {
		 icon: 0,time: time
	    });
}
