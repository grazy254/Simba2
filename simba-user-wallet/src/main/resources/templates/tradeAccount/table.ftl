<#list list as tradeAccount>
	<tr>
		<td>${tradeAccount.tradeUserID}</td>
		<td>${tradeAccount.accountID}</td>
		<td>${tradeAccount.accountType}</td>
		<td>${tradeAccount.feeType}</td>
		<td>${tradeAccount.isAllowRecharge}</td>
		<td>${tradeAccount.isAllowPay}</td>
		<td>${tradeAccount.isActive}</td>
		<td>${tradeAccount.isFrozen}</td>
		<td>${tradeAccount.accountBalance}</td>
		<td>${tradeAccount.availableBalance}</td>
		<td>${tradeAccount.frozenBalance}</td>
		<td>${tradeAccount.createTime}</td>
		<td>${tradeAccount.lastUpdateTime}</td>
	</tr>
</#list>