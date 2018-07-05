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
			<div class="">
				<section class="content">
					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-header with-border">
									<h3 class="box-title">图文内容列表</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body no-padding">
									<div class="mailbox-controls">
									</div>
									<!-- /.pull-right -->
								</div>
								<div class="table-responsive">
									<table class="table table-hover table-striped table-bordered" id="table">
										<thead>
											<tr>
												<th>标题</th>
												<th>缩略图的media_id</th>
												<th>作者</th>
												<th>描述</th>
												<th>显示封面</th>
												<th>原文地址</th>
												<th>类型</th>
												<th>时间</th>
											</tr>
										</thead>
										<tbody>
											<#list list as article>
												<tr>
													<td>${article.title}</td>
													<td>${article.thumbMediaId!}
														<#if article.imageUrl??>
															<a href="${article.imageUrl}" title="${article.imageUrl}" target="_blank"><img src="${article.imageUrl}" style="width: 30px;height: 30px;" /></a>
														</#if>
													</td>
													<td>${article.author!}</td>
													<td>${article.digest!}</td>
													<td>
														<#if article.showCoverPic==0>否</#if>
														<#if article.showCoverPic==1>是</#if>
													</td>
													<td>${article.contentSourceUrl!}</td>
													<td>
														<#if article.type==1>临时</#if>
														<#if article.type==2>永久</#if>
													</td>
													<td>${article.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
												</tr>
											</#list>
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
		$(document).ready(function() {});
	</script>

</html>