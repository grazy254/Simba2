<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/groupMessage/groupMessage.js"></script>
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
									<h3 class="box-title">修改群发消息</h3>
								</div>
								<form role="form" onsubmit="return GroupMessage.checkForm();" id="form" action="${base}/groupMessage/update">
									<input type="hidden" id="id" name="id" value="${groupMessage.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${groupMessage.createTime}" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="type">消息类型</label>
											<input type="text" class="form-control" id="type" name="type" value="${groupMessage.type}" placeholder="请输入消息类型">
										</div>
										<div class="form-group">
											<label for="account">发送者账号 </label>
											<input type="text" class="form-control" id="account" name="account" value="${groupMessage.account}" placeholder="请输入发送者账号 ">
										</div>
										<div class="form-group">
											<label for="content">发送内容 </label>
											<input type="text" class="form-control" id="content" name="content" value="${groupMessage.content}" placeholder="请输入发送内容 ">
										</div>
										<div class="form-group">
											<label for="mediaId">素材ID</label>
											<input type="text" class="form-control" id="mediaId" name="mediaId" value="${groupMessage.mediaId}" placeholder="请输入素材ID">
										</div>
										<div class="form-group">
											<label for="wxTagId">微信标签ID</label>
											<input type="text" class="form-control" id="wxTagId" name="wxTagId" value="${groupMessage.wxTagId}" placeholder="请输入微信标签ID">
										</div>
										<div class="form-group">
											<label for="isAll">是否全发</label>
											<input type="text" class="form-control" id="isAll" name="isAll" value="${groupMessage.isAll}" placeholder="请输入是否全发">
										</div>
										<div class="form-group">
											<label for="openids">微信用户ID列表</label>
											<input type="text" class="form-control" id="openids" name="openids" value="${groupMessage.openids}" placeholder="请输入微信用户ID列表">
										</div>
										<div class="form-group">
											<label for="status">状态</label>
											<input type="text" class="form-control" id="status" name="status" value="${groupMessage.status}" placeholder="请输入状态">
										</div>
										<div class="form-group">
											<label for="msgId">任务ID</label>
											<input type="text" class="form-control" id="msgId" name="msgId" value="${groupMessage.msgId}" placeholder="请输入任务ID">
										</div>
										<div class="form-group">
											<label for="msgDataId">数据ID</label>
											<input type="text" class="form-control" id="msgDataId" name="msgDataId" value="${groupMessage.msgDataId}" placeholder="请输入数据ID">
										</div>
										<div class="form-group">
											<label for="json">完整Json内容</label>
											<input type="text" class="form-control" id="json" name="json" value="${groupMessage.json}" placeholder="请输入完整Json内容">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="GroupMessage.toList();">取消</button>
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