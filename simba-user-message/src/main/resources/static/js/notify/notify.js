var Notify = {

    "toAdd": function () {
        window.self.location.href = contextPath + "/notify/toAdd";
    },

    "batchDelete": function () {
        var ids = new Array();
        $("input[name='notify']").each(function () {
            if (true == $(this).is(':checked')) {
                ids.push($(this).val());
            }
        });
        if (ids.length == 0) {
            parent.showInfo("请选择要删除的记录");
            return false;
        }
        $.ajax({
            type: "post",
            url: contextPath + "/notify/batchDelete",
            data: {
                "id": ids.join(",")
            },
            async: true,
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    Notify.initNotifyList(0, Page.size);
                } else {
                    parent.showInfo(data.msg);
                }
            }
        });
    },
    "initNotifyList": function (start, pageSize, method) {
        var data = {};
        var data2 = {};
        method = method || "getList";
        $.extend(data2, data);
        data["pageStart"] = start;
        data["pageSize"] = pageSize;
        $.ajax({
            type: "get",
            url: contextPath + "/notify/" + method,
            data: data,
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
            url: contextPath + "/notify/count",
            async: true,
            data: data2,
            dataType: "json",
            success: function (data) {
                var total = data.data;
                var pageHtml = Page.init(total, start, pageSize, "Notify.clickPager");
                $("#page").html(pageHtml);
            }
        });
    },
    "clickPager": function (start, pageSize) {
        Notify.initNotifyList(start, pageSize);
    },

    "toUpdate": function (id) {
        window.self.location.href = contextPath + "/notify/toUpdate?id=" + id;
    },

    "deleteNotify": function (id) {
        $.ajax({
            type: "post",
            url: contextPath + "/notify/batchDelete",
            data: {
                "id": id
            },
            async: true,
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    Notify.initNotifyList(0, Page.size);
                } else {
                    parent.showInfo(data.msg);
                }
            }
        });
    },

    "checkForm": function () {
        return true;
    },

    "toList": function () {
        window.self.location.href = contextPath + "/notify/list";
    },


    "mysubmit": function () {
        $("#sendBtn").attr("disabled","disabled");
        var $form = $("#form");
        var action = $form.attr("action");
        $.post(action, $form.serialize(), function (res) {
            if (res.code === 200) {
                parent.showSuccessInfo("发送成功!");
            }
            else {
                parent.showInfo(res.msg);
            }
            top.hideModal();
        }, 'json');
    },

    "end": null
};