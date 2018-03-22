<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/plugins/bootstrap-treeview.min.js"></script>
		<script type="text/javascript" src="${base}/js/util/treeviewutil.js"></script>
		<script type="text/javascript" src="${base}/js/receiveMessage/receiveMessage.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<section class="content">
					<div class="row">

						<!-- /.col -->
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">修改收到消息</h3>
								</div>
								<form role="form" onsubmit="return ReceiveMessage.checkForm();" id="form" action="${base}/receiveMessage/update">
									<input type="hidden" id="id" name="id" value="${receiveMessage.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="openid">用户微信ID</label>
											<input type="text" class="form-control" id="openid" name="openid" value="${receiveMessage.openid}" placeholder="请输入用户微信ID">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${receiveMessage.createTime}" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="type">类型</label>
											<input type="text" class="form-control" id="type" name="type" value="${receiveMessage.type}" placeholder="请输入类型">
										</div>
										<div class="form-group">
											<label for="msgId">消息id</label>
											<input type="text" class="form-control" id="msgId" name="msgId" value="${receiveMessage.msgId}" placeholder="请输入消息id">
										</div>
										<div class="form-group">
											<label for="content">文本消息内容</label>
											<input type="text" class="form-control" id="content" name="content" value="${receiveMessage.content}" placeholder="请输入文本消息内容">
										</div>
										<div class="form-group">
											<label for="picUrl">图片链接</label>
											<input type="text" class="form-control" id="picUrl" name="picUrl" value="${receiveMessage.picUrl}" placeholder="请输入图片链接">
										</div>
										<div class="form-group">
											<label for="mediaId">消息媒体id</label>
											<input type="text" class="form-control" id="mediaId" name="mediaId" value="${receiveMessage.mediaId}" placeholder="请输入消息媒体id">
										</div>
										<div class="form-group">
											<label for="fileUrl">媒体文件地址</label>
											<input type="text" class="form-control" id="fileUrl" name="fileUrl" value="${receiveMessage.fileUrl}" placeholder="请输入媒体文件地址">
										</div>
										<div class="form-group">
											<label for="format">语音格式</label>
											<input type="text" class="form-control" id="format" name="format" value="${receiveMessage.format}" placeholder="请输入语音格式">
										</div>
										<div class="form-group">
											<label for="recognition">语音识别结果</label>
											<input type="text" class="form-control" id="recognition" name="recognition" value="${receiveMessage.recognition}" placeholder="请输入语音识别结果">
										</div>
										<div class="form-group">
											<label for="thumbMediaId">视频消息缩略图的媒体id</label>
											<input type="text" class="form-control" id="thumbMediaId" name="thumbMediaId" value="${receiveMessage.thumbMediaId}" placeholder="请输入视频消息缩略图的媒体id">
										</div>
										<div class="form-group">
											<label for="thumbFileUrl">视频消息缩略图的媒体文件地址</label>
											<input type="text" class="form-control" id="thumbFileUrl" name="thumbFileUrl" value="${receiveMessage.thumbFileUrl}" placeholder="请输入视频消息缩略图的媒体文件地址">
										</div>
										<div class="form-group">
											<label for="locationX">地理位置维度</label>
											<input type="text" class="form-control" id="locationX" name="locationX" value="${receiveMessage.locationX}" placeholder="请输入地理位置维度">
										</div>
										<div class="form-group">
											<label for="locationY">地理位置经度</label>
											<input type="text" class="form-control" id="locationY" name="locationY" value="${receiveMessage.locationY}" placeholder="请输入地理位置经度">
										</div>
										<div class="form-group">
											<label for="scale">地图缩放大小</label>
											<input type="text" class="form-control" id="scale" name="scale" value="${receiveMessage.scale}" placeholder="请输入地图缩放大小">
										</div>
										<div class="form-group">
											<label for="messageLabel">地理位置信息</label>
											<input type="text" class="form-control" id="messageLabel" name="messageLabel" value="${receiveMessage.messageLabel}" placeholder="请输入地理位置信息">
										</div>
										<div class="form-group">
											<label for="title">消息标题</label>
											<input type="text" class="form-control" id="title" name="title" value="${receiveMessage.title}" placeholder="请输入消息标题">
										</div>
										<div class="form-group">
											<label for="description">消息描述</label>
											<input type="text" class="form-control" id="description" name="description" value="${receiveMessage.description}" placeholder="请输入消息描述">
										</div>
										<div class="form-group">
											<label for="url">消息链接</label>
											<input type="text" class="form-control" id="url" name="url" value="${receiveMessage.url}" placeholder="请输入消息链接">
										</div>
										<div class="form-group">
											<label for="xml">完整XML内容</label>
											<input type="text" class="form-control" id="xml" name="xml" value="${receiveMessage.xml}" placeholder="请输入完整XML内容">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="ReceiveMessage.toList();">取消</button>
									</div>
								</form>

							</div>
						</div>
						<!-- /. box -->
					</div>
					<!-- /.col -->
			</div>
			<!-- /.row -->
			</section>
			<!-- /.content -->

		</div>
		<!-- /.content-wrapper -->
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		</div>
		<!-- ./wrapper -->

	</body>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>

</html>