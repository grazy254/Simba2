var SmartUser = {

    "initSmartUserList": function (start, pageSize) {
        $.ajax({
            type: "get",
            url: contextPath + "/notify/getUserList",
            data: {
                "pageStart": start,
                "pageSize": pageSize,
                "account": $("#account").val(),
                "name": $("#name").val(),
                "email": $("#email").val(),
                "telNo": $("#telNo").val()
            },
            async: true,
            dataType: "html",
            success: function (html) {
                $("#table").find("tbody").html(html);
                CheckBox.init();
                setTimeout("CheckBox.bindCheckAll();", 1000);
            }
        });
        $.ajax({
            type: "get",
            url: contextPath + "/notify/userCount",
            async: true,
            data: {
                "account": $("#account").val(),
                "name": $("#name").val(),
                "email": $("#email").val(),
                "telNo": $("#telNo").val()
            },
            dataType: "json",
            success: function (data) {
                var total = data.data;
                var pageHtml = Page.init(total, start, pageSize, "SmartUser.clickPager");
                $("#page").html(pageHtml);
            }
        });
    },

    "initReceiverList": function (start, pageSize) {
        $.ajax({
            type: "get",
            url: contextPath + "/notify/listReceiver",
            data: {
                "pageStart": start,
                "pageSize": pageSize,
                "notifyId":freeNotifyId
            },
            async: true,
            dataType: "html",
            success: function (html) {
                $("#table").find("tbody").html(html);
                CheckBox.init();
                setTimeout("CheckBox.bindCheckAll();", 1000);
            }
        });
        $.ajax({
            type: "get",
            url: contextPath + "/notify/receiverCount",
            async: true,
            data: {
                "notifyId": freeNotifyId
            },
            dataType: "json",
            success: function (data) {
                var total = data.data;
                var pageHtml = Page.init(total, start, pageSize, "SmartUser.clickPagerReceiver");
                $("#page").html(pageHtml);
            }
        });
    },

    "clickPagerReceiver": function (start, pageSize) {
        SmartUser.initReceiverList(start, pageSize);
    },

    "clickPager": function (start, pageSize) {
        SmartUser.initSmartUserList(start, pageSize);
    },


    "search": function () {
        SmartUser.initSmartUserList(0, Page.size);
    },

    "batchSendNotify": function () {
        var ids = [];
        $("input[name='smartUser']").each(function () {
            if (true == $(this).is(':checked')) {
                ids.push($(this).val());
            }
        });
        if (ids.length === 0) {
            parent.showInfo("请选择发送的用户");
            return false;
        }
        var url = contextPath + "/notify/toSendNotify?smartUserIds=" + ids.join(",");
        top.showModal("发送通知", url, 500);
    },

    "AllSendNotify": function () {
        var ids = [-1];
        var url = contextPath + "/notify/toSendNotify?smartUserIds=" + ids.join(",");
        top.showModal("发送通知", url, 500);
    },

    "sendNotify": function (id) {
        var ids = [id];
        var url = contextPath + "/notify/toSendNotify?smartUserIds=" + ids.join(",");
        top.showModal("发送通知", url, 500);
    },

    "end": null
};