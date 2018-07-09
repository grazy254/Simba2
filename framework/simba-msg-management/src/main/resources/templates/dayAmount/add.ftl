<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/dayAmount/dayAmount.js"></script>
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
									<h3 class="box-title">新增</h3>
								</div>
								<form role="form" onsubmit="return DayAmount.checkForm();" id="form" action="${base}/dayAmount/add">
									<div class="box-body">
										<div class="form-group">
											<label for="dayDate">dayDate</label>
											<input type="text" class="form-control" id="dayDate" name="dayDate" placeholder="请输入dates">
										</div>
										<div class="form-group">
											<label for="amount">amount</label>
											<input type="text" class="form-control" id="amount" name="amount" placeholder="请输入totalAmount">
										</div>
										<div class="form-group">
											<label for="aliAmount">aliAmount</label>
											<input type="text" class="form-control" id="aliAmount" name="aliAmount" placeholder="请输入aliAmount">
										</div>
										<div class="form-group">
											<label for="jpushAmount">jpushAmount</label>
											<input type="text" class="form-control" id="jpushAmount" name="jpushAmount" placeholder="请输入jpushAmount">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="DayAmount.toList();">取消</button>
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