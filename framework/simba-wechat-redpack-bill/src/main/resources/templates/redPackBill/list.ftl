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
		<script type="text/javascript" src="${base}/js/redPackBill/redPackBill.js"></script>
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
									<h3 class="box-title">红包账单管理</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<label for="type">红包类型:</label>
										<input type="text" id="type" name="type" placeholder="请输入红包类型">
										<label for="billNo">商户订单号:</label>
										<input type="text" id="billNo" name="billNo" placeholder="请输入商户订单号">
										<label for="openid">用户openid:</label>
										<input type="text" id="openid" name="openid" placeholder="请输入用户openid">
										<label for="actName">活动名称:</label>
										<input type="text" id="actName" name="actName" placeholder="请输入活动名称">
										<label for="sceneId">场景id:</label>
										<input type="text" id="sceneId" name="sceneId" placeholder="请输入场景id">
										<label for="status">状态:</label>
										<select id ="status" name="status">
											<#list redPackBill?keys as key>
												<option value="${key}">${redPackBill["${key}"]}</option>
											</#list>
											
										</select>
										<label for="sendListId">微信单号:</label>
										<input type="text" id="sendListId" name="sendListId" placeholder="请输入微信单号">
										<label for="startTime">开始时间:</label>
										<input type="text" class="datetimepicker" id="startTime" name="startTime" placeholder="请输入开始时间">
										<label for="endTime">结束时间:</label>
										<input type="text" class="datetimepicker" id="endTime" name="endTime" placeholder="请输入结束时间">
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="RedPackBill.search();"><i class="fa fa-search"></i>
                						查询</button>
										<!-- Check all button -->
										
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
												<th>红包类型</th>
												<th>商户订单号</th>
												<th>商户名称</th>
												<th>用户openid</th>
												<th>付款金额</th>
												<th>红包发放总人数</th>
												<th>红包祝福语</th>
												<th>活动名称</th>
												<th>备注</th>
												<th>场景id</th>
												<th>活动信息</th>
												<th>资金授权商户号</th>
												<th>状态</th>
												<th>错误信息</th>
												<th>微信单号</th>
												<th>时间</th>
												<th>付款者</th>
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
			RedPackBill.initRedPackBillList(0, Page.size);
		});
	</script>

</html>