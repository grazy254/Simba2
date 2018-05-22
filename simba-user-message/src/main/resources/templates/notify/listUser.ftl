<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>系统首页</title>
		<#include "../adminlte.ftl"/>
		<#include "../datetimepicker.ftl"/>
		<#include "../iCheck.ftl"/>
    <script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
    <script type="text/javascript" src="${base}/js/common/page.js"></script>
    <script type="text/javascript" src="${base}/js/notify/smartUser.js"></script>
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
                            <h3 class="box-title">发送通知</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="mailbox-controls">
                                <!-- Check all button -->
                                <label for="account">账号:</label>
                                <input type="text" id="account" name="account" placeholder="请输入账号">
                                <label for="name">名称:</label>
                                <input type="text" id="name" name="name" placeholder="请输入名称">
                                <label for="email">邮箱:</label>
                                <input type="text" id="email" name="email" placeholder="请输入邮箱">
                                <label for="telNo">手机号:</label>
                                <input type="text" id="telNo" name="telNo" placeholder="请输入手机号">
                                <button type="button" class="btn btn-default btn-sm checkbox-toggle"
                                        onclick="SmartUser.search();"><i class="fa fa-search"></i>
                                    查询
                                </button>
                            </div>
                            <!-- /.pull-right -->
                        </div>
                        <br>
                        <button type="button" class="btn btn-default btn-sm checkbox-toggle"
                                onclick="SmartUser.batchSendNotify();"><i class="fa fa-send"></i>
                            发送通知到勾选用户
                        </button>
                        <button type="button" class="btn btn-default btn-sm checkbox-toggle"
                                onclick="SmartUser.AllSendNotify();"><i class="fa fa-send"></i>
                            发送通知到所有用户
                        </button>
                        <br><br>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped table-bordered" id="table">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" name="checkAll" id="checkAll">全选</th>
                                    <th>账号</th>
                                    <th>名称</th>
                                    <th>邮箱</th>
                                    <th>手机号</th>
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
        SmartUser.initSmartUserList(0, Page.size);
    });
</script>

</html>