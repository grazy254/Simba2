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
    <script type="text/javascript" src="${base}/js/shortMessage/shortMessage.js"></script>
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
                            <h3 class="box-title">短信记录</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <div class="mailbox-controls" id="chart-search-form">
                                <!-- Check all button -->
                                <label for="mobile">手机:</label>
                                <input type="text" id="mobile" name="mobile" placeholder="请输入手机号" style="width: 100px">
                                <label for="templateId">模板ID:</label>
                                <input type="text" id="templateId" name="templateId" placeholder="请输入模板ID">
                                <label for="projectId">项目:</label>
                                <select style="width: 120px; height: 30px" id="projectId" name="projectId">
                                    <option value="">全部项目</option>
                                </select>
                                <label for="interval">平台:</label>
                                <select style="width: 80px; height: 30px" id="platform" name="platform">
                                    <option value="">全部</option>
                                    <option value="jpush">极光</option>
                                    <option value="ali">阿里</option>
                                </select>
                                <label for="status">发送状态:</label>
                                <select style="width: 80px; height: 30px" id="status" name="status">
                                    <option value="">全部</option>
                                    <option value="0">发送失败</option>
                                    <option value="1">发送成功</option>
                                    <option value="2">发送中</option>
                                </select>
                                <label for="startTime">开始时间:</label>
                                <input type="text" class="datetimepicker" id="startTime" name="startTime"
                                       placeholder="请输入开始时间">
                                <label for="endTime">结束时间:</label>
                                <input type="text" class="datetimepicker" id="endTime" name="endTime"
                                       placeholder="请输入结束时间">
                                <button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="ShortMessage.search(0,Page.size)">
                                    <i class="fa fa-search"></i>查询
                                </button>
                                <div class="pull-right">
                                </div>
                                <hr style="margin: 8px">
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped table-bordered" id="table">
                                <thead>
                                <tr>
                                    <th>手机号</th>
                                    <th>项目</th>
                                    <th>模板ID</th>
                                    <th>发送状态</th>
                                    <th>插值</th>
                                    <th>平台</th>
                                    <th>SMS短信ID</th>
                                    <th>发送时间</th>
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
        ShortMessage.initShortMessageList(0, Page.size);
        ShortMessage.getProjectList();
    });
</script>

</html>