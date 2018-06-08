<#if list??>
<#list list as tradeSmartUserVO>
	<tr>
		<td>${tradeSmartUserVO.name}</td>
		<td>${tradeSmartUserVO.account}</td>
		<td>${tradeSmartUserVO.userStatus}</td>
		<td>${tradeSmartUserVO.accountStatus}</td>
		<td>${tradeSmartUserVO.isAllowPay}</td>
		<td>${tradeSmartUserVO.createTime}</td>
		<td>${tradeSmartUserVO.lastUpdateTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeSmartUser.frozeSmartUserPayment('${tradeSmartUserVO.account}');"><i class="fa fa-user"></i>冻结支付</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeSmartUser.activateSmartUserPayment('${tradeSmartUserVO.account}');"><i class="fa fa-user"></i>激活支付</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeSmartUser.frozeSmartUserAccount('${tradeSmartUserVO.account}');"><i class="fa fa-user"></i>冻结账户</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeSmartUser.activateSmartUserAccount('${tradeSmartUserVO.account}');"><i class="fa fa-user"></i>激活账户</button>
		</td>
	</tr>
</#list>
</#if>