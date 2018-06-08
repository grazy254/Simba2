<#if list??>
<#list list as tradeDetail>
	<tr>
		<td><input type="checkbox" name="tradeDetail" value="${tradeDetail.id}"></td>
		<td>${tradeDetail.tradeNO}</td>
		<td>${tradeDetail.tradeType}</td>
		<td>${tradeDetail.tradeStatus}</td>
		<td>${tradeDetail.orderNO}</td>
		<td>${tradeDetail.orderName}</td>
		<td>${tradeDetail.orderDesc}</td>
		<td>${tradeDetail.orderAddress}</td>
		<td>${tradeDetail.feeType}</td>
		<td>${tradeDetail.originalAmount}</td>
		<td>${tradeDetail.paymentAmount}</td>
		<td>${tradeDetail.tradePartyID}</td>
		<td>${tradeDetail.tradeCounterpartyID}</td>
		<td>${tradeDetail.tradeChannelID}</td>
		<td>${tradeDetail.tradeCreateTime}</td>
		<td>${tradeDetail.tradePaymentTime}</td>
		<td>${tradeDetail.createTime}</td>
		<td>${tradeDetail.lastUpdateTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeDetail.toUpdate(${tradeDetail.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeDetail.deleteTradeDetail(${tradeDetail.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>
</#if>