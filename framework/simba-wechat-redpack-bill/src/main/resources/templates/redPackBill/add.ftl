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
									<h3 class="box-title">新增红包账单</h3>
								</div>
								<form role="form" onsubmit="return RedPackBill.checkForm();" id="form" action="${base}/redPackBill/add">
									<div class="box-body">
										<div class="form-group">
											<label for="type">红包类型</label>
											<input type="text" class="form-control" id="type" name="type" placeholder="请输入红包类型">
										</div>
										<div class="form-group">
											<label for="billNo">商户订单号</label>
											<input type="text" class="form-control" id="billNo" name="billNo" placeholder="请输入商户订单号">
										</div>
										<div class="form-group">
											<label for="mchId">商户号</label>
											<input type="text" class="form-control" id="mchId" name="mchId" placeholder="请输入商户号">
										</div>
										<div class="form-group">
											<label for="appid">公众账号appid</label>
											<input type="text" class="form-control" id="appid" name="appid" placeholder="请输入公众账号appid">
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
											<label for="amount">付款金额</label>
											<input type="text" class="form-control" id="amount" name="amount" placeholder="请输入付款金额">
										</div>
										<div class="form-group">
											<label for="num">红包发放总人数</label>
											<input type="text" class="form-control" id="num" name="num" placeholder="请输入红包发放总人数">
										</div>
										<div class="form-group">
											<label for="wishing">红包祝福语</label>
											<input type="text" class="form-control" id="wishing" name="wishing" placeholder="请输入红包祝福语">
										</div>
										<div class="form-group">
											<label for="clientIp">Ip地址</label>
											<input type="text" class="form-control" id="clientIp" name="clientIp" placeholder="请输入Ip地址">
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
											<input type="text" class="form-control" id="sceneId" name="sceneId" placeholder="请输入场景id">
										</div>
										<div class="form-group">
											<label for="riskInfo">活动信息</label>
											<input type="text" class="form-control" id="riskInfo" name="riskInfo" placeholder="请输入活动信息">
										</div>
										<div class="form-group">
											<label for="consumeMchId">资金授权商户号</label>
											<input type="text" class="form-control" id="consumeMchId" name="consumeMchId" placeholder="请输入资金授权商户号">
										</div>
										<div class="form-group">
											<label for="status">状态</label>
											<input type="text" class="form-control" id="status" name="status" placeholder="请输入状态">
										</div>
										<div class="form-group">
											<label for="errMsg">错误信息</label>
											<input type="text" class="form-control" id="errMsg" name="errMsg" placeholder="请输入错误信息">
										</div>
										<div class="form-group">
											<label for="sendListId">微信单号</label>
											<input type="text" class="form-control" id="sendListId" name="sendListId" placeholder="请输入微信单号">
										</div>
										<div class="form-group">
											<label for="createTime">时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" placeholder="请输入时间">
										</div>
										<div class="form-group">
											<label for="createUser">付款者</label>
											<input type="text" class="form-control" id="createUser" name="createUser" placeholder="请输入付款者">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="RedPackBill.toList();">取消</button>
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