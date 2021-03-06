<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/notify/notify.js"></script>
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
									<h3 class="box-title">新增通知表</h3>
								</div>
								<form role="form" onsubmit="return Notify.checkForm();" id="form" action="${base}/notify/add">
									<div class="box-body">
										<div class="form-group">
											<label for="title">通知标题</label>
											<input type="text" class="form-control" id="title" name="title" placeholder="请输入通知标题">
										</div>
										<div class="form-group">
											<label for="content">通知内容</label>
											<textarea class="form-control"  rows="7" id="content" name="content" placeholder="请输入通知内容"></textarea>
										</div>
										<div class="form-group">
											<label for="type">类型</label>
                                            <select class="form-control" id="type" name="type" value=1>
                                                <option value=0>紧急通知</option>
                                                <option value=1>普通通知</option>
                                            </select>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="Notify.toList();">取消</button>
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