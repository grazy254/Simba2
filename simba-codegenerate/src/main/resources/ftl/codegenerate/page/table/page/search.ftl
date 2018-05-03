<!DOCTYPE html>
<html>
<#assign dollar = '$'>
<#assign pound = '#'>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<${pound}include "../adminlte.ftl"/>
		<${pound}include "../iCheck.ftl"/>
		<script type="text/javascript" src="${dollar}{base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${dollar}{base}/js/common/page.js"></script>
		<script type="text/javascript" src="${dollar}{base}/js/${firstLower}/${firstLower}.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">${classDesc}搜索</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<#if searchFormFields?exists>
										<#list searchFormFields?keys as field> 
										<label for="${field}">${searchFormFields[field]}:</label>
										<input type="text" id="${field}" name="${field}" placeholder="请输入${searchFormFields[field]}">
										&nbsp;&nbsp;
										</#list> 
										</#if>
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm" onclick="${className}.toSearch();"><i class="fa fa-search"></i>查询</button>
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
											<tr>
												<#list filedsWithPage as field> 
												<th>${field.desc}</th>
												</#list> 
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<!-- /.table -->
									<div id="page">
									</div>
								</div>
								<!-- /.mail-box-messages -->
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
			${className}.init${className}SearchList(0, Page.size);
		});
	</script>

</html>