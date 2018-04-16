<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../datetimepicker.ftl"/>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/receiveMessage/receiveMessage.js"></script>
		<script type="text/javascript" src="${base}/js/fans/fans.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">收到消息管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<label for="openid">微信用户ID:</label>
										<input type="text" id="openid" name="openid" placeholder="请输入微信用户ID">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Fans.selectFans('openid');"><i class="fa fa-search"></i></button>
										<label for="type">类型:</label>
										<input type="text" id="type" name="type" placeholder="请输入类型">
										<label for="startTime">开始时间:</label>
										<input type="text" class="datetimepicker" id="startTime" name="startTime" placeholder="请输入开始时间">
										<label for="endTime">结束时间:</label>
										<input type="text" class="datetimepicker" id="endTime" name="endTime" placeholder="请输入结束时间">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="ReceiveMessage.search();"><i class="fa fa-search"></i>
                						查询</button>
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<th>用户微信ID</th>
												<th>时间</th>
												<th>类型</th>
												<th>消息id</th>
												<th>文本消息内容</th>
												<th>图片链接</th>
												<th>消息媒体id</th>
												<th>媒体文件地址</th>
												<th>语音格式</th>
												<th>语音识别结果</th>
												<th>视频消息缩略图的媒体id</th>
												<th>视频消息缩略图的媒体文件地址</th>
												<th>地理位置维度</th>
												<th>地理位置经度</th>
												<th>地图缩放大小</th>
												<th>地理位置信息</th>
												<th>消息标题</th>
												<th>消息描述</th>
												<th>消息链接</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<!-- /.table -->
									<div id="page">
									</div>
								</div>
								<!-- /.mail-box-messages -->
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
			ReceiveMessage.initReceiveMessageList(0, Page.size);
		});
	</script>

</html>