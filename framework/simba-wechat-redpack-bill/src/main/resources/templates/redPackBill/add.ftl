<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/redPackBill/redPackBill.js"></script>
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
									<h3 class="box-title">微信发红包</h3>
								</div>
								<div class="box-body">
									<div class="form-group">
										<label for="type">红包类型</label>
										<select id="type" name="type" class="form-control" onchange="RedPackBill.changeType();">
											<#list types as type>
												<option value="${type.getName()}">${type.description}</option>
											</#list>
										</select>
									</div>
									<div class="form-group">
										<label for="sendName">商户名称</label>
										<input type="text" class="form-control" id="sendName" name="sendName" placeholder="请输入商户名称">
									</div>
									<div class="form-group">
										<label for="openid">用户openid</label>
										<input type="text" class="form-control" id="openid" name="openid" placeholder="请输入用户openid">
									</div>
									<div class="form-group">
										<label for="amount">付款金额(分)</label>
										<input type="text" class="form-control" id="amount" name="amount" placeholder="请输入付款金额">
									</div>
									<div class="form-group" id="numDiv">
										<label for="num">红包发放总人数</label>
										<input type="text" class="form-control" id="num" name="num" placeholder="请输入红包发放总人数" value="1">
									</div>
									<div class="form-group">
										<label for="wishing">红包祝福语</label>
										<input type="text" class="form-control" id="wishing" name="wishing" placeholder="请输入红包祝福语">
									</div>
									<div class="form-group">
										<label for="actName">活动名称</label>
										<input type="text" class="form-control" id="actName" name="actName" placeholder="请输入活动名称">
									</div>
									<div class="form-group">
										<label for="remark">备注</label>
										<input type="text" class="form-control" id="remark" name="remark" placeholder="请输入备注">
									</div>
									<div class="form-group">
										<label for="sceneId">场景id</label>
										<select id="sceneId" name="sceneId" class="form-control">
											<#list scenes as scene>
												<option value="${scene.getName()}">${scene.description}</option>
											</#list>
										</select>
									</div>
								</div>
								<!-- /.box-body -->

								<div class="box-footer">
									<button type="button" class="btn btn-success" onclick="RedPackBill.add();">提交</button>
									<button type="button" class="btn" onclick="RedPackBill.toList();">取消</button>
								</div>

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
			RedPackBill.changeType();
		});
	</script>

</html>