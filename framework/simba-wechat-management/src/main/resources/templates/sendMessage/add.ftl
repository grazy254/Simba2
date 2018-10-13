<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/sendMessage/sendMessage.js"></script>
		<script type="text/javascript" src="${base}/js/fans/fans.js"></script>
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
									<h3 class="box-title">发消息</h3>
								</div>
								<form role="form" onsubmit="return SendMessage.checkForm();" id="form" action="${base}/sendMessage/add">
									<div class="box-body">
										<div class="form-group">
											<label for="type">类型</label>
											<select id="type" name="type" onchange="SendMessage.changeType();" class="form-control">
												<#list types as type>
													<option value="${type.getName()}">${type.description}</option>
												</#list>
											</select>
										</div>
										<div class="form-group">
											<label for="openid">微信用户ID</label>
											<input type="text" class="form-control" id="openid" name="openid" placeholder="请输入微信用户ID">
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Fans.selectFans('openid');"><i class="fa fa-search"></i></button>
										</div>
										<div class="form-group" id="textDiv">
											<label for="content">文本消息内容</label>
											<input type="text" class="form-control" id="content" name="content" placeholder="请输入文本消息内容">
										</div>
										<div class="form-group" id="titleDiv">
											<label for="title">标题</label>
											<input type="text" class="form-control" id="title" name="title" placeholder="请输入标题">
										</div>
										<div class="form-group" id="descriptionDiv">
											<label for="descritption">描述</label>
											<input type="text" class="form-control" id="descritption" name="descritption" placeholder="请输入描述">
										</div>
										<div class="form-group" id="musicUrlDiv">
											<label for="musicUrl">音乐链接</label>
											<input type="text" class="form-control" id="musicUrl" name="musicUrl" placeholder="请输入音乐链接">
										</div>
										<div class="form-group" id="hqMusicUrlDiv">
											<label for="hqMusicUrl">高品质音乐链接</label>
											<input type="text" class="form-control" id="hqMusicUrl" name="hqMusicUrl" placeholder="请输入高品质音乐链接">
										</div>
										<input type="hidden" id="mediaId" name="mediaId" value="" />
										<input type="hidden" id="thumbMediaId" name="thumbMediaId" value="" />
										<div class="form-group" id="imageDiv">
											<label for="imageSelect">图片</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.selectTempImage();"><i class="fa fa-search"></i>临时图片</button>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.selectForeverImage();"><i class="fa fa-search"></i>永久图片</button>
										</div>
										<div class="form-group" id="voiceDiv">
											<label for="voiceSelect">语音</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.selectTempVoice();"><i class="fa fa-search"></i>临时语音</button>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.selectForeverVoice();"><i class="fa fa-search"></i>永久语音</button>
										</div>
										<div class="form-group" id="videoDiv">
											<label for="videoSelect">视频</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.selectTempVideo();"><i class="fa fa-search"></i>临时视频</button>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.selectForeverVideo();"><i class="fa fa-search"></i>永久视频</button>
										</div>
										<div class="form-group" id="thumbDiv">
											<label for="thumbSelect">缩略图</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.selectTempThumb();"><i class="fa fa-search"></i>临时缩略图</button>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.selectForeverThumb();"><i class="fa fa-search"></i>永久缩略图</button>
										</div>
										<div class="form-group" id="mpNewsDiv">
											<label for="mpNewsSelect">图文</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.selectForeverMpNews();"><i class="fa fa-search"></i>永久图文</button>
										</div>
										<div class="form-group" id="newsDiv">
											<label for="newsSelect">图文</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.addNews();"><i class="fa fa-plus"></i>新增图文</button>
											<br />
											<input type="hidden" id="news" name="news" value="" />
											<div class="table-responsive">
												<table class="table table-hover table-striped table-bordered" id="table">
													<thead>
														<tr>
															<th>标题</th>
															<th>描述</th>
															<th>点击后跳转的链接</th>
															<th>图片链接</th>
															<th>操作</th>
														</tr>
													</thead>
													<tbody>

													</tbody>
												</table>
												<!-- /.table -->
											</div>
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
			SendMessage.changeType();
		});
	</script>

</html>