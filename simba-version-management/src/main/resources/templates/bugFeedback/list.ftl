<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../iCheck.ftl"/>
		<#include "../datetimepicker.ftl"/>
		<script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/bugFeedback/bugFeedback.js"></script>
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
									<h3 class="box-title">bug反馈管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<label for="userId">反馈bug用户Id:</label>
										<input type="text" id="userId" name="userId" placeholder="请输入反馈bug用户Id">
										<label for="title">bug名称:</label>
										<input type="text" id="title" name="title" placeholder="请输入bug名称">
										<label for="text">bug内容:</label>
										<input type="text" id="text" name="text" placeholder="请输入bug内容">
										<label for="startTime">开始时间:</label>
										<input type="text" class="datetimepicker" id="startTime" name="startTime" placeholder="请输入开始时间">
										<label for="endTime">结束时间:</label>
										<input type="text" class="datetimepicker" id="endTime" name="endTime" placeholder="请输入结束时间">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="BugFeedback.search();"><i class="fa fa-search"></i>
                查询</button>
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="BugFeedback.toAdd();"><i class="fa fa-plus"></i>
                新增</button>
										<button type="button" class="btn btn-default btn-sm" onclick="BugFeedback.batchDelete();"><i class="fa fa-remove"></i>删除</button>
										
										
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
												<th>反馈bug的用户id</th>
												<th>bug名称</th>
												<th>bug内容</th>
												<th>bug截图</th>
												<th>时间</th>
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
			BugFeedback.initBugFeedbackList(0, Page.size);
		});
	</script>

</html>