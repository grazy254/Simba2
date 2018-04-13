/**
 * Created by linshuo on 2017/12/11.
 */
var MessageBalance = {

    "toAdd": function () {
        window.self.location.href = contextPath + "/project/toAdd";
    },

    "init": function () {
        this.initProjectList();
        this.initDatetimepicker();
        $("select#projectId").change(function () {
            MessageBalance.draw();
        });
        $.ajax({
            type: "get",
            url: contextPath + "/shortMessage/balanceTable",
            async: true,
            data: {},
            dataType: "html",
            success: function (html) {
                if (html != "") {
                    $("#balance-table").html(html);
                    $.ajax({
                        type: "get",
                        url: contextPath + "/shortMessage/balanceTotal",
                        async: true,
                        data: {"platform": "jpush"},
                        dataType: "json",
                        success: function (data) {
                            if (data.code === 200) {
                                var balance = data.data;
                                $("#极光短信").html(balance + "条");
                            } else {
                                top.showInfo(data.msg);
                            }
                        }
                    });
                } else {
                    parent.showInfo("查询不到短信余量");
                }
            }
        });

    },

    "draw": function () {
        var dateJson = {
            "projectId": $("#projectId").val(),
            "startTime": $("#startTime").val(),
            "endTime": $("#endTime").val()
        };
        if (dateJson.startTime <= dateJson.endTime) {
            BarUtil.init('usemsg-chart', '/chart/eachDayAmount', dateJson);
        } else {
            top.showInfo("结束日期不得小于开始日期");
        }
    },

    "initProjectList": function () {
        $("#projectId").empty();
        $("#projectId").append("<option value=-1>项目总和</option>");
        $.ajax({
            type: "get",
            url: contextPath + "/msgProject/listJson",
            async: true,
            data: {},
            async: true,
            dataType: "json",
            success: function (data) {
                var projectList = JSON.parse(data.data);
                for (var i = 0; i < projectList.length; i++) {
                    var newOption = "<option value=" + projectList[i].id + ">" + projectList[i].name + "</option>";
                    $("#projectId").append(newOption);
                }
            }
        });
    },

    /* 前置补零 */
    "zfill": function (num, n) {
        return (Array(n).join(0) + num).slice(-n);
    },

    /* 今天的日期 */
    "getTodayDate": function () {
        var date = new Date();
        date = date.getFullYear() + "-" + this.zfill((date.getMonth() + 1), 2) + "-" + this.zfill(date.getDate(), 2);
        return date;
    },

    /* 本月的第一天的日期 */
    "getCurMonthHeadDate": function () {
        var date = new Date();
        date = date.getFullYear() + "-" + this.zfill((date.getMonth() + 1), 2) + "-" + "01";
        return date;
    },

    "initDatetimepicker": function () {
        $(".datetimepicker").datetimepicker({
            autoclose: true,
            minView: "month",
            format: 'yyyy-mm-dd',
            clearBtn: true,
            todayBtn: true,
            todayHighlight: true,
            language: "zh-CN"
        });
        var todayDate = this.getTodayDate();
        var curMonthHeadDate = this.getCurMonthHeadDate();
        $("#startTime").val(curMonthHeadDate);
        $("#endTime").val(todayDate);
    },


    "end": null
};