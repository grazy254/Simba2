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
		<script type="text/javascript" src="${base}/js/sendMessage/sendMessage.js"></script>
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
									<h3 class="box-title">发消息管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<label for="openid">微信用户ID:</label>
										<input type="text" id="openid" name="openid" placeholder="请输入微信用户ID">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Fans.selectFans('openid');"><i class="fa fa-search"></i></button>
										<label for="account">发送者账号:</label>
										<input type="text" id="account" name="account" placeholder="请输入发送者账号">
										<label for="type">类型:</label>
										<select id="type" name="type">
											<option value="">无</option>
											<#list types as type>
												<option value="${type.getName()}">${type.description}</option>
											</#list>
										</select>
										<label for="startTime">开始时间:</label>
										<input type="text" class="datetimepicker" id="startTime" name="startTime" placeholder="请输入开始时间">
										<label for="endTime">结束时间:</label>
										<input type="text" class="datetimepicker" id="endTime" name="endTime" placeholder="请输入结束时间">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.search();"><i class="fa fa-search"></i>
                						查询</button>
										<!-- Check all button -->
										<div class="pull-right">
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="SendMessage.toAdd();"><i class="fa fa-plus"></i>
                新增</button>
										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>微信用户ID</th>
												<th>消息类型</th>
												<th>时间</th>
												<th>发送者</th>
												<th>文本消息内容</th>
												<th>媒体ID</th>
												<th>缩略图的媒体ID</th>
												<th>标题</th>
												<th>描述</th>
												<th>音乐链接</th>
												<th>高品质音乐链接</th>
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
			SendMessage.initSendMessageList(0, Page.size);
		});
	</script>

</html>