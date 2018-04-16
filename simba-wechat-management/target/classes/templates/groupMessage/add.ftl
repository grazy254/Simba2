<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/groupMessage/groupMessage.js"></script>
		<script type="text/javascript" src="${base}/js/tag/tag.js"></script>
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
									<h3 class="box-title">新增群发消息</h3>
								</div>
								<form role="form" onsubmit="return GroupMessage.checkForm();" id="form" action="${base}/groupMessage/add">
									<input type="hidden" id="mediaId" name="mediaId" value="">
									<div class="box-body">
										<div class="form-group">
											<label for="type">消息类型</label>
											<select id="type" name="type" onchange="GroupMessage.changeType();">
												<#list types as type>
													<option value="${type.getName()}">${type.description}</option>
												</#list>
											</select>
										</div>
										<div class="form-group">
											<label for="isAll">全发</label>
											<select id="isAll" name="isAll" onchange="GroupMessage.changeAll();">
												<option value="1">是</option>
												<option value="2">否</option>
											</select>
										</div>
										<div class="form-group" id="wxTagDiv">
											<label for="wxTagId">微信标签ID</label>
											<input type="text" class="form-control" id="wxTagId" name="wxTagId" placeholder="请输入微信标签ID">
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Tag.selectTag('wxTagId');"><i class="fa fa-search"></i></button>
										</div>
										<div class="form-group" id="openidsDiv">
											<label>微信粉丝列表</label>
											<input type="hidden" id="openids" name="openids">
											<div id="selectedFansList"></div>
											<button type="button" class="btn" onclick="Fans.selectedFanses();"><i class="fa fa-search"></i>选择粉丝</button>
										</div>
										<div class="form-group" id="contentDiv">
											<label for="content">发送内容 </label>
											<input type="text" class="form-control" id="content" name="content" placeholder="请输入发送内容 ">
										</div>
										<div class="form-group" id="imageDiv">
											<label for="imageSelect">图片</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="GroupMessage.selectForverImage();"><i class="fa fa-search"></i>永久图片</button>
										</div>
										<div class="form-group" id="voiceDiv">
											<label for="voiceSelect">语音</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="GroupMessage.selectForeverVoice();"><i class="fa fa-search"></i>永久语音</button>
										</div>
										<div class="form-group" id="videoDiv">
											<label for="videoSelect">视频</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="GroupMessage.selectTempVideo();"><i class="fa fa-search"></i>视频</button>
										</div>
										<div class="form-group" id="mpNewsDiv">
											<label for="mpNewsSelect">图文</label>
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="GroupMessage.selectNews();"><i class="fa fa-search"></i>图文</button>
										</div>
										<div class="form-group">
											<label>预览粉丝</label>
											<input type="text" class="form-control" id="previewOpenid" name="previewOpenid" placeholder="请输入预览粉丝openid">
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Fans.selectFans('previewOpenid');"><i class="fa fa-search"></i></button>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="GroupMessage.toList();">取消</button>
										<button type="button" class="btn btn-success" onclick="GroupMessage.preview();">预览</button>
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
			GroupMessage.changeType();
			GroupMessage.changeAll();
		});
	</script>

</html>