<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<script type="text/javascript" src="${base}/js/msgTemplate/templateAli.js"></script>
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
									<h3 class="box-title">修改短信模板</h3>
								</div>
								<form role="form" onsubmit="return Template.checkForm();" id="form" action="${base}/msgTemplate/updateAli">
									<input type="hidden" id="id" name="id" value="${template.id}" />
									<div class="box-body">
										<div class="form-group">
											<label for="name">模板名称</label>
											<input type="text" class="form-control" id="name" name="name" value="${template.name}" placeholder="请输入模板名称">
										</div>
										<div class="form-group">
											<label for="content">模板内容</label>
											<input type="text" class="form-control" id="content" name="content" value="${template.content}" placeholder="请输入模板内容">
										</div>
										<div class="form-group" style="display: none">
											<label for="createTime">创建时间</label>
											<input type="text" class="form-control" id="createTime" name="createTime" value="${template.createTime}" placeholder="请输入创建时间">
										</div>
										<div class="form-group">
											<label for="statusAli">阿里审核状态</label>
											<select class="form-control" id="statusAli" name="statusAli" >
                                                <option value="0">未审未通过</option>
                                                <option value="1">审核通过</option>
                                                <option value="2">审核中</option>
                                                <option value="3">无</option>
											</select>
										</div>
                                        <div class="form-group" style="display: none">
                                            <label for="statusJpush">极光审核状态</label>
                                            <select class="form-control" id="statusJpush" name="statusJpush" >
                                                <option value="0">未审未通过</option>
                                                <option value="1">审核通过</option>
                                                <option value="2">审核中</option>
                                                <option value="3">无</option>
                                            </select>
                                        </div>
										<div class="form-group">
											<label for="aliTemplateId">阿里模板ID</label>
											<input type="text" class="form-control" id="aliTemplateId" name="aliTemplateId" value="${template.aliTemplateId}" placeholder="请输入阿里模板ID">
										</div>
										<div class="form-group" style="display: none">
											<label for="jpushTemplateId">极光模板ID</label>
											<input type="text" class="form-control" id="jpushTemplateId" name="jpushTemplateId" value="${template.jpushTemplateId}" placeholder="请输入极光模板ID">
										</div>
										<div class="form-group">
											<label for="selfId">自定ID</label>
											<input type="text" class="form-control" id="selfId" name="selfId" value="${template.selfId}" placeholder="请输入自定ID">
										</div>
									</div>
									<!-- /.box-body -->

									<div class="box-footer">
										<button type="submit" class="btn btn-success">提交</button>
										<button type="button" class="btn" onclick="Template.toList();">取消</button>
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
		    $("#statusAli").val(${template.statusAli});
            $("#statusJpush").val(${template.statusJpush});
		});
	</script>

</html>