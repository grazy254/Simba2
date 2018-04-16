<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/fans/fans.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
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
									<input type="hidden" id="id" name="id" value="${fans.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="remark">备注</label>
											<input type="text" class="form-control" id="remark" name="remark" value="${fans.remark}" placeholder="请输入备注">
										</div>
										<div class="form-group">
											<div style="color: red;" id="errDiv"></div>
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="button" class="btn btn-success" onclick="Fans.updateRemark();">设置</button>
										<button type="button" class="btn" onclick="Fans.cancelUpdateRemark();">取消</button>
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