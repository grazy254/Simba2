<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/sendMessage/sendMessage.js"></script>
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
									<h3 class="box-title">修改发消息</h3>
								</div>
								<form role="form" onsubmit="return SendMessage.checkForm();" id="form" action="${base}/sendMessage/update">
									<input type="hidden" id="id" name="id" value="${sendMessage.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="openid">微信用户ID</label>
											<input type="text" class="form-control" id="openid" name="openid" value="${sendMessage.openid}" placeholder="请输入微信用户ID">
										</div>
										<div class="form-group">
											<label for="content">文本消息内容</label>
											<input type="text" class="form-control" id="content" name="content" value="${sendMessage.content}" placeholder="请输入文本消息内容">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${sendMessage.createTime}" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="mediaId">媒体ID</label>
											<input type="text" class="form-control" id="mediaId" name="mediaId" value="${sendMessage.mediaId}" placeholder="请输入媒体ID">
										</div>
										<div class="form-group">
											<label for="type">消息类型</label>
											<input type="text" class="form-control" id="type" name="type" value="${sendMessage.type}" placeholder="请输入消息类型">
										</div>
										<div class="form-group">
											<label for="thumbMediaId">缩略图的媒体ID</label>
											<input type="text" class="form-control" id="thumbMediaId" name="thumbMediaId" value="${sendMessage.thumbMediaId}" placeholder="请输入缩略图的媒体ID">
										</div>
										<div class="form-group">
											<label for="title">标题</label>
											<input type="text" class="form-control" id="title" name="title" value="${sendMessage.title}" placeholder="请输入标题">
										</div>
										<div class="form-group">
											<label for="descritption">描述</label>
											<input type="text" class="form-control" id="descritption" name="descritption" value="${sendMessage.descritption}" placeholder="请输入描述">
										</div>
										<div class="form-group">
											<label for="musicUrl">音乐链接</label>
											<input type="text" class="form-control" id="musicUrl" name="musicUrl" value="${sendMessage.musicUrl}" placeholder="请输入音乐链接">
										</div>
										<div class="form-group">
											<label for="hqMusicUrl">高品质音乐链接</label>
											<input type="text" class="form-control" id="hqMusicUrl" name="hqMusicUrl" value="${sendMessage.hqMusicUrl}" placeholder="请输入高品质音乐链接">
										</div>
										<div class="form-group">
											<label for="news">图文消息（点击跳转到外链） </label>
											<input type="text" class="form-control" id="news" name="news" value="${sendMessage.news}" placeholder="请输入图文消息（点击跳转到外链） ">
										</div>
										<div class="form-group">
											<label for="mpnews">图文消息（点击跳转到图文消息页面）</label>
											<input type="text" class="form-control" id="mpnews" name="mpnews" value="${sendMessage.mpnews}" placeholder="请输入图文消息（点击跳转到图文消息页面）">
										</div>
										<div class="form-group">
											<label for="json">完整的Json内容</label>
											<input type="text" class="form-control" id="json" name="json" value="${sendMessage.json}" placeholder="请输入完整的Json内容">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="SendMessage.toList();">取消</button>
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