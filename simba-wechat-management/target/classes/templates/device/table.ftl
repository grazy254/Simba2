<#list list as device>
	<tr>
		<td>
			<#if device.status==1><input type="checkbox" name="device" value="${device.id}"></#if>
		</td>
		<td>${device.wxDeviceId}</td>
		<td>${device.qrcode}</td>
		<td>${device.wxProductId}</td>
		<td>
			<#if device.status==0>空闲</#if>
			<#if device.status==1>已用</#if>
		</td>
	</tr>
</#list>