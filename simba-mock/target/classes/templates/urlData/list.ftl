<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../iCheck.ftl"/>
		<script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
		<script type="text/javascript" src="${base}/js/common/page.js"></script>
		<script type="text/javascript" src="${base}/js/urlData/urlData.js"></script>
		<script type="text/javascript" src="${base}/js/project/project.js"></script>
	</head>

	<body>
		<div>
			<!-- Content Wrapper. Contains page content -->
			<div class="">
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<input type="hidden" id="projectId" name="projectId" value="${Session['projectId']}" />
								<div class="box-header with-border">
									<h3 class="box-title" id="projectTitle1">本项目下的内容</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
										<!-- Check all button -->
										<button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="UrlData.toAdd();"><i class="fa fa-plus"></i>
                新增</button>
										<button type="button" class="btn btn-default btn-sm" onclick="UrlData.batchDelete();"><i class="fa fa-remove"></i>删除</button>
										<a href="${base}/urlData/getExcel" target="_blank"><button type="button" class="btn btn-default btn-sm"><i class="fa fa-download"></i>导出</button></a>
										<button type="button" class="btn btn-default btn-sm" onclick="UrlData.importExcel();"><i class="fa fa-upload"></i>导入</button>
										<form style="display:inline-block" id="form" method="post" enctype="multipart/form-data" action="${base}/urlData/importExcel">
										<input style="display:inline-block" type="file" id="file" name="file">
										<input class="checkbox" type="checkbox" name="isRewrite">是否覆盖
										</form>
										<div class="pull-right">

										</div>
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
												<th>路径</th>
												<th>数据</th>
												<th>描述</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<!-- /.table -->
									<div id="page">
									</div>
										<div class="box-footer">
											<button type="button" class="btn" onclick="Project.toList();">取消</button>
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
			UrlData.initUrlDataList(0, Page.size,"${Session['projectId']}");
		});
	</script>

</html>