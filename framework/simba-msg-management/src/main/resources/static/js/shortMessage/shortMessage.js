var ShortMessage = {

    "toAdd": function () {
        window.self.location.href = contextPath + "/shortMessage/toAdd";
    },

    "batchDelete": function () {
        var ids = new Array();
        $("input[name='shortMessage']").each(function () {
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
            url: contextPath + "/shortMessage/batchDelete",
            data: {
                "id": ids.join(",")
            },
            async: true,
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    ShortMessage.initShortMessageList(0, Page.size);
                } else {
                    parent.showInfo(data.msg);
                }
            }
        });
    },

    "initShortMessageList": function (start, pageSize) {
        $.ajax({
            type: "get",
            url: contextPath + "/shortMessage/getListVo",
            data: {
                "pageStart": start,
                "pageSize": pageSize
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
            url: contextPath + "/shortMessage/count",
            async: true,
            data: {},
            async: true,
            dataType: "json",
            success: function (data) {
                var total = data.data;
                var pageHtml = Page.init(total, start, pageSize, "ShortMessage.clickPager");
                $("#page").html(pageHtml);
            }
        });
    },

    "clickPager": function (start, pageSize) {
        ShortMessage.search(start, pageSize);
    },

    "toUpdate": function (id) {
        window.self.location.href = contextPath + "/shortMessage/toUpdate?id=" + id;
    },

    "deleteShortMessage": function (id) {
        $.ajax({
            type: "post",
            url: contextPath + "/shortMessage/batchDelete",
            data: {
                "id": id
            },
            async: true,
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    ShortMessage.initShortMessageList(0, Page.size);
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
        window.self.location.href = contextPath + "/shortMessage/list";
    },

    "search": function (start, pageSize) {
        $.ajax({
            type: "get",
            url: contextPath + "/shortMessage/getListSearch",
            data: {
                "pageStart": start,
                "pageSize": pageSize,
                "mobile": $("#mobile").val(),
                "templateId": $("#templateId").val(),
                "projectId": $("#projectId").val(),
                "platform": $("#platform").val(),
                "status": $("#status").val(),
                "startTime": $("#startTime").val(),
                "endTime": $("#endTime").val()
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
            url: contextPath + "/shortMessage/countSearch",
            async: true,
            data: {
                "mobile": $("#mobile").val(),
                "templateId": $("#templateId").val(),
                "projectId": $("#projectId").val(),
                "platform": $("#platform").val(),
                "status": $("#status").val(),
                "startTime": $("#startTime").val(),
                "endTime": $("#endTime").val()
            },
            dataType: "json",
            success: function (data) {
                var total = data.data;
                var pageHtml = Page.init(total, start, pageSize, "ShortMessage.clickPager");
                $("#page").html(pageHtml);
            }
        });
    },

    "getProjectList": function () {
        $.ajax({
            type: "get",
            url: contextPath + "/msgProject/listJson",
            data: {},
            async: true,
            dataType: "json",
            success: function (data) {
                var projectList = JSON.parse(data.data);
                $("#projectId").empty();
                $("#projectId").append("<option value=''>全部项目</option>");
                for (var i = 0; i < projectList.length; i++) {
                    var newOption = "<option value='" + projectList[i].id + "'>" + projectList[i].name + "</option>";
                    $("#projectId").append(newOption);
                }
            }
        });
    },

    "resend": function (id) {
        $.ajax({
            type: "get",
            url: contextPath + "/shortMessage/resend",
            async: true,
            data: { id:id},
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    parent.showSuccessInfo("重发成功!");
                    ShortMessage.search(0,Page.size);
                } else {
                    parent.showInfo('发送失败!'+data.msg);
                }
            }
        });
    },

    "end": null
};