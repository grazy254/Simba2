<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>系统首页</title>
<#include "../adminlte.ftl"/>
<#include "../iCheck.ftl"/>
    <script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
    <script type="text/javascript" src="${base}/js/common/page.js"></script>
    <script type="text/javascript" src="${base}/js/msgTemplate/template.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/css/template/style.css"/>
</head>

<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <a href="${base}/template/list" class="navbar-brand" id="nav-brand">模板管理</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="${base}/template/list">全部模板</a></li>
            <li><a href="${base}/msgTemplate/listJpush">极光模板</a></li>
            <li><a href="${base}/msgTemplate/listAli">阿里模板</a></li>
        </ul>
    </div>
</nav>

<div>
    <!-- Content Wrapper. Contains page content -->
    <div class="">

        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">全部模板</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <button type="button" class="btn btn-default btn-sm checkbox-toggle"
                                        onclick="Template.toAdd();"><i class="fa fa-plus"></i>
                                    录入模板
                                </button>
                                <button type="button" class="btn btn-default btn-sm checkbox-toggle"
                                        onclick="Template.toAddAli();"><i class="fa fa-plus"></i>
                                    新增阿里模板
                                </button>
                                <button type="button" class="btn btn-default btn-sm checkbox-toggle"
                                        onclick="Template.toAddJpush();"><i class="fa fa-plus"></i>
                                    新增极光模板
                                </button>
                                <button type="button" class="btn btn-default btn-sm" onclick="Template.batchDelete();">
                                    <i class="fa fa-remove"></i>删除
                                </button>
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
                                    <th>自定ID</th>
                                    <th>模板名称</th>
                                    <th>模板内容</th>
                                    <th>阿里审核状态</th>
                                    <th>极光审核状态</th>
                                    <th>阿里模板ID</th>
                                    <th>极光模板ID</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
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
    $(document).ready(function () {
        Template.initTemplateList(0, Page.size);
    });
</script>

</html>