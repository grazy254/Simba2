<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="table-responsive">
				<table class="table table-hover table-striped table-bordered" id="table">
					<thead>
						<tr>
							<th>标题</th>
							<th>描述</th>
							<th>点击后跳转的链接</th>
							<th>图片链接</th>
						</tr>
					</thead>
					<tbody>
						<#list list as article>
							<tr>
								<td>${article.title}</td>
								<td>${article.description}</td>
								<td>${article.url}</td>
								<td>${article.picurl}</td>
							</tr>
						</#list>
					</tbody>
				</table>
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
		$(document).ready(function() {});
	</script>

</html>