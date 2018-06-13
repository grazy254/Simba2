<#if list??>
<#list list as tradeDetailVO>
	<tr>
		<td>${tradeDetailVO.tradeNO}</td>
		<td>${tradeDetailVO.tradeType}</td>
		<td>${tradeDetailVO.tradeStatus}</td>
		<td>${tradeDetailVO.orderNO}</td>
		<td>${tradeDetailVO.feeType}</td>
		<td>${tradeDetailVO.originalAmount}</td>
		<td>${tradeDetailVO.paymentAmount}</td>
		<td>${tradeDetailVO.tradePartyName}</td>
		<td>${tradeDetailVO.tradeCounterpartyName}</td>
		<td>${tradeDetailVO.channelName!}</td>
		<td>${tradeDetailVO.tradeCreateTime}</td>
		<td>${tradeDetailVO.tradePaymentTime}</td>
		<td>${tradeDetailVO.createTime}</td>
		<td>${tradeDetailVO.lastUpdateTime}</td>
	</tr>
</#list>
</#if>