<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/tradeChannelDetail/tradeChannelDetail.js"></script>
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
									<h3 class="box-title">新增交易的渠道信息</h3>
								</div>
								<form role="form" onsubmit="return TradeChannelDetail.checkForm();" id="form" action="${base}/tradeChannelDetail/add">
									<div class="box-body">
										<div class="form-group">
											<label for="tradeAccountID">帐号ID</label>
											<input type="text" class="form-control" id="tradeAccountID" name="tradeAccountID" placeholder="请输入帐号ID">
										</div>
										<div class="form-group">
											<label for="channelID">渠道ID</label>
											<input type="text" class="form-control" id="channelID" name="channelID" placeholder="请输入渠道ID">
										</div>
										<div class="form-group">
											<label for="orderCreateTime">渠道提交时间</label>
											<input type="text" class="form-control" id="orderCreateTime" name="orderCreateTime" placeholder="请输入渠道提交时间">
										</div>
										<div class="form-group">
											<label for="paymentTime">渠道支付时间</label>
											<input type="text" class="form-control" id="paymentTime" name="paymentTime" placeholder="请输入渠道支付时间">
										</div>
										<div class="form-group">
											<label for="orderNO">渠道订单号</label>
											<input type="text" class="form-control" id="orderNO" name="orderNO" placeholder="请输入渠道订单号">
										</div>
										<div class="form-group">
											<label for="openID">用户的openID</label>
											<input type="text" class="form-control" id="openID" name="openID" placeholder="请输入用户的openID">
										</div>
										<div class="form-group">
											<label for="errorMsg">errorMsg</label>
											<input type="text" class="form-control" id="errorMsg" name="errorMsg" placeholder="请输入errorMsg">
										</div>
										<div class="form-group">
											<label for="errorCode">errorCode</label>
											<input type="text" class="form-control" id="errorCode" name="errorCode" placeholder="请输入errorCode">
										</div>
										<div class="form-group">
											<label for="createTime">错误信息</label>
											<input type="text" class="form-control" id="createTime" name="createTime" placeholder="请输入错误信息">
										</div>
										<div class="form-group">
											<label for="lastUpdateTime">错误代号</label>
											<input type="text" class="form-control" id="lastUpdateTime" name="lastUpdateTime" placeholder="请输入错误代号">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="TradeChannelDetail.toList();">取消</button>
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