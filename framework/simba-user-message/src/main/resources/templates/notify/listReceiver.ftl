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
        <#assign freeNotifyId="${notifyId}"/>
    <script type="text/javascript">
        var freeNotifyId = "${freeNotifyId}";
    </script>
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
                        <div class="table-responsive">
                            <table class="table table-hover table-striped table-bordered" id="table">
                                <thead>
                                <tr>
                                    <th>账号</th>
                                    <th>名称</th>
                                    <th>邮箱</th>
                                    <th>手机号</th>
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
        SmartUser.initReceiverList(0, Page.size);
    });
</script>

</html>