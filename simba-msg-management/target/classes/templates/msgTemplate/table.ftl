<#list list as template>
<tr>
    <td><input type="checkbox" name="template" value="${template.id}"></td>
    <td>${template.selfId}</td>
    <td>${template.name}</td>
    <td>${template.content}</td>
    <#if template.statusAli == 0 >
        <td>审核不过</td>
    <#elseif template.statusAli == 1 >
        <td>已审核</td>
    <#elseif template.statusAli == 2 >
        <td>审核中</td>
    <#elseif template.statusAli == 3 >
        <td>无</td>
    </#if>
    <#if template.statusJpush == 0 >
        <td>审核不过</td>
    <#elseif template.statusJpush == 1 >
        <td>已审核</td>
    <#elseif template.statusJpush == 2 >
        <td>审核中</td>
    <#elseif template.statusJpush == 3 >
        <td>无</td>
    </#if>
    <#if template.aliTemplateId == '' >
        <td>无</td>
    <#else >
        <td>${template.aliTemplateId}</td>
    </#if>
    <#if template.jpushTemplateId == '' >
        <td>无</td>
    <#else >
        <td>${template.jpushTemplateId}</td>
    </#if>
    <td>${template.createTime}</td>
    <td>
        <button type="button" class="btn btn-default btn-sm" onclick="Template.toUpdate(${template.id});"><i
                class="fa fa-pencil-square-o"></i>修改
        </button>
        <button type="button" class="btn btn-default btn-sm" onclick="Template.deleteTemplate(${template.id});"><i
                class="fa fa-remove"></i>删除
        </button>
    </td>
</tr>
</#list>