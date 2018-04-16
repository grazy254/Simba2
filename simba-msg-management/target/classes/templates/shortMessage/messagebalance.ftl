<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>余量用量查询</title>
<#include "../adminlte.ftl"/>
<#include "../iCheck.ftl"/>
    <link rel="stylesheet" href="${base}/js/plugins/datetimepicker/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="${base}/js/plugins/datetimepicker/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript"
            src="${base}/js/plugins/datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript" src="${base}/js/common/checkbox.js"></script>
    <script type="text/javascript" src="${base}/js/common/page.js"></script>
    <script type="text/javascript" src="${base}/js/messagebalance/messagebalance.js"></script>
    <script type="text/javascript" src="${base}/js/echartsUtil/bar/barUtil.js"></script>
    <script type="text/javascript" src="${base}/js/lib/echarts/echarts.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${base}/css/balanceMsg/style.css"/>
</head>

<body>
<div id="balance-table"></div>

<div class="col-md-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            <div><b>短信用量图表</b></div>
        </div>
        <div class="box-body no-padding">
            <div class="mailbox-controls" id="chart-search-form">
                <label for="projectId">项目:</label>
                <select style="width: 160px; height: 30px" id="projectId" name="projectId">
                </select>
            <#--<label for="interval">时间间隔:</label>-->
            <#--<select style="width: 80px; height: 30px" id="interval" name="interval">-->
            <#--<option value="day">日</option>-->
            <#--<option value="month">月</option>-->
            <#--</select>-->
                <label for="startTime">开始时间:</label>
                <input type="text" class="datetimepicker form_datetime" id="startTime" name="startTime"
                       placeholder="请输入开始时间">
                <label for="endTime">结束时间:</label>
                <input type="text" class="datetimepicker form_datetime" id="endTime" name="endTime"
                       placeholder="请输入结束时间">
                <button type="button" class="btn btn-default btn-sm checkbox-toggle" onclick="MessageBalance.draw();">
                    <i class="fa fa-search"></i>查询
                </button>
                <div class="pull-right">
                </div>
                <hr style="margin: 10px">
            </div>
        </div>
        <div id="usemsg-chart" style="width: 1200px; height: 400px;"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        MessageBalance.init();
        MessageBalance.draw();
    });
</script>

</html>