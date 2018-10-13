<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/plugins/bootstrap-treeview.min.js"></script>
		<script type="text/javascript" src="${base}/js/util/treeviewutil.js"></script>
		<script type="text/javascript" src="${base}/js/fans/fans.js"></script>
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
									<h3 class="box-title">修改粉丝</h3>
								</div>
								<form role="form" onsubmit="return Fans.checkForm();" id="form" action="${base}/fans/update">
									<input type="hidden" id="id" name="id" value="${fans.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="openid">微信用户ID</label>
											<input type="text" class="form-control" id="openid" name="openid" value="${fans.openid}" placeholder="请输入微信用户ID">
										</div>
										<div class="form-group">
											<label for="remark">备注</label>
											<input type="text" class="form-control" id="remark" name="remark" value="${fans.remark}" placeholder="请输入备注">
										</div>
										<div class="form-group">
											<label for="nickname">昵称</label>
											<input type="text" class="form-control" id="nickname" name="nickname" value="${fans.nickname}" placeholder="请输入昵称">
										</div>
										<div class="form-group">
											<label for="sex">性别</label>
											<input type="text" class="form-control" id="sex" name="sex" value="${fans.sex}" placeholder="请输入性别">
										</div>
										<div class="form-group">
											<label for="city">城市</label>
											<input type="text" class="form-control" id="city" name="city" value="${fans.city}" placeholder="请输入城市">
										</div>
										<div class="form-group">
											<label for="province">省份</label>
											<input type="text" class="form-control" id="province" name="province" value="${fans.province}" placeholder="请输入省份">
										</div>
										<div class="form-group">
											<label for="country">国家</label>
											<input type="text" class="form-control" id="country" name="country" value="${fans.country}" placeholder="请输入国家">
										</div>
										<div class="form-group">
											<label for="headimgurl">头像</label>
											<input type="text" class="form-control" id="headimgurl" name="headimgurl" value="${fans.headimgurl}" placeholder="请输入头像">
										</div>
										<div class="form-group">
											<label for="subscribeTime">关注时间</label>
											<input type="text" class="form-control" id="subscribeTime" name="subscribeTime" value="${fans.subscribeTime}" placeholder="请输入关注时间">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="Fans.toList();">取消</button>
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