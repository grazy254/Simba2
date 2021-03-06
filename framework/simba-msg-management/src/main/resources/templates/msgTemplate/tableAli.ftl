<#list list as template>
<#if template.aliTemplateId != '' >
<tr>
    <td>${template.aliTemplateId}</td>
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
    <td>${template.createTime}</td>
    <td style="display: none">
        <button type="button" class="btn btn-default btn-sm" onclick="Template.toUpdate(${template.id}); " style="display: none"><i
                class="fa fa-pencil-square-o"></i>修改
        </button>
        <button type="button" class="btn btn-default btn-sm" onclick="Template.deleteTemplate(${template.id});" style="display: none"><i
                class="fa fa-remove"></i>删除
        </button>
    </td>
</tr>
</#if>
</#list>