<#if list??>
<#list list as tradeAccountVO>
	<tr>
		<td>${tradeAccountVO.userID}</td>
		<td>${tradeAccountVO.accountID}</td>
		<td>${tradeAccountVO.accountStatus}</td>
		<td>${tradeAccountVO.accountBalance}</td>
		<td>${tradeAccountVO.availableBalance}</td>
		<td>${tradeAccountVO.frozenBalance}</td>
		<td>${tradeAccountVO.createTime}</td>
		<td>${tradeAccountVO.lastUpdateTime} </td>
	</tr>
</#list>
</#if>
<#if showSummery>
<tr>
	<td></td>
	<td></td> 
	<td></td> 
	<td></td> 
	<td></td>
	
	<td>总余额：${accountBalance!}</td> 
	<td>总可用余额：${availableBalance!} </td>
	<td>总冻结余额：${frozenBalance!}</td>
</tr>
</#if>
	