<#list list as shortMessage>
	<tr>
        <td>${shortMessage.mobile}</td>
        <td>${shortMessage.projectName}</td>
        <td>${shortMessage.templateId}</td>
        <td>${shortMessage.status}</td>
        <td>${shortMessage.value}</td>
		<td>${shortMessage.platform}</td>
		<td>${shortMessage.messageId}</td>
        <td>${shortMessage.sendDate}</td>
        <td>
            <button type="button" class="btn btn-default btn-sm" onclick="ShortMessage.resend(${shortMessage.id});"><i class="fa fa-pencil-square-o"></i>重发</button>
        </td>
    </tr>
</#list>