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
		<script type="text/javascript" src="${base}/js/groupMessage/groupMessage.js"></script>
		<script type="text/javascript" src="${base}/js/tag/tag.js"></script>
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
									<h3 class="box-title">群发消息管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<label for="isAll">全发:</label>
										<select id="isAll" name="isAll">
											<option value="">无</option>
											<option value="1">是</option>
											<option value="2">否</option>
										</select>
										<label for="wxTagId">标签ID:</label>
										<input type="text" id="wxTagId" name="wxTagId" placeholder="请输入标签ID">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="Tag.selectTag('wxTagId');"><i class="fa fa-search"></i></button>
										<label for="account">发送者账号:</label>
										<input type="text" id="account" name="account" placeholder="请输入发送者账号">
										<label for="type">类型:</label>
										<select id="type" name="type">
											<option value="">无</option>
											<#list types as type>
												<option value="${type.getName()}">${type.description}</option>
											</#list>
										</select>
										<label for="status">状态:</label>
										<select id="status" name="status">
											<option value="">无</option>
											<#list statuses as status>
												<option value="${status.id}">${status.getName()}</option>
											</#list>
										</select>
										<label for="mediaId">素材ID:</label>
										<input type="text" id="mediaId" name="mediaId" placeholder="请输入素材ID">
										<label for="startTime">开始时间:</label>
										<input type="text" class="datetimepicker" id="startTime" name="startTime" placeholder="请输入开始时间">
										<label for="endTime">结束时间:</label>
										<input type="text" class="datetimepicker" id="endTime" name="endTime" placeholder="请输入结束时间">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="GroupMessage.search();"><i class="fa fa-search"></i>
                						查询</button>
										<div class="pull-right">
											<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="GroupMessage.toAdd();"><i class="fa fa-plus"></i>
                新增</button>
										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>时间</th>
												<th>消息类型</th>
												<th>发送者账号 </th>
												<th>发送内容 </th>
												<th>素材ID</th>
												<th>微信标签ID</th>
												<th>全发</th>
												<th>微信用户ID列表</th>
												<th>状态</th>
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
			GroupMessage.initGroupMessageList(0, Page.size);
		});
	</script>

</html>