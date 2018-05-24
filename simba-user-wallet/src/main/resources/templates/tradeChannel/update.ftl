<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/tradeChannel/tradeChannel.js"></script>
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
									<h3 class="box-title">修改渠道信息</h3>
								</div>
								<form role="form" onsubmit="return TradeChannel.checkForm();" id="form" action="${base}/tradeChannel/update">
									<input type="hidden" id="id" name="id" value="${tradeChannel.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="name">渠道名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${tradeChannel.name}" placeholder="请输入渠道名称">
										</div>
										<div class="form-group">
											<label for="type">渠道类型</label>
											<input type="text" class="form-control" id="type" name="type" value="${tradeChannel.type}" placeholder="请输入渠道类型">
										</div>
										<div class="form-group">
											<lable for="openAccount">账户操作</label>
											<select class="input-group-sm" id="openAccount" name="openAccount">
												<option value ="1">激活</option> 
  												<option value ="0">冻结</option>
  											</select>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="TradeChannel.toList();">取消</button>
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