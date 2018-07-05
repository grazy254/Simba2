<#list list as receiveEvent>
	<tr>
		<td>${receiveEvent.openid}</td>
		<td>${receiveEvent.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${receiveEvent.type}</td>
		<td>${receiveEvent.event}</td>
		<td>${receiveEvent.eventKey}</td>
		<td>${receiveEvent.menuId}</td>
		<td>${receiveEvent.scanType}</td>
		<td>${receiveEvent.scanResult}</td>
		<td>${receiveEvent.ticket}</td>
		<td>${receiveEvent.latitude}</td>
		<td>${receiveEvent.longitude}</td>
		<td>${receiveEvent.eventPrecision}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="ReceiveEvent.showXML(${receiveEvent.id});"><i class="fa fa-eye"></i>查看完整XML</button>
		</td>
	</tr>
</#list>