<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/msgTemplate/templateJpush.js"></script>
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
									<h3 class="box-title">新增极光模板</h3>
								</div>
								<form role="form" onsubmit="return Template.checkForm();" id="form" action="${base}/msgTemplate/addJpush">
									<div class="box-body">
                                        <div class="form-group">
                                            <label for="selfId">自定ID</label>
                                            <input type="text" class="form-control" id="selfId" name="selfId" placeholder="请输入自定ID">
                                        </div>
										<div class="form-group">
											<label for="name">模板名称</label>
											<input type="text" class="form-control" id="name" name="name" placeholder="请输入模板名称">
										</div>
										<div class="form-group">
											<label for="content">模板内容</label>
											<textarea rows="5" class="form-control" id="content" name="content" placeholder="请输入模板内容"></textarea>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="Template.toBack();">取消</button>
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