<#list list as tradeAccount>
	<tr>
		<td><input type="checkbox" name="tradeAccount" value="${tradeAccount.id}"></td>
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
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeAccount.toUpdate(${tradeAccount.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeAccount.deleteTradeAccount(${tradeAccount.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>