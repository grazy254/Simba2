<#if list??>
<#list list as tradeChannelDetail>
	<tr>
		<td><input type="checkbox" name="tradeChannelDetail" value="${tradeChannelDetail.id}"></td>
		<td>${tradeChannelDetail.tradeAccountID}</td>
		<td>${tradeChannelDetail.channelID}</td>
		<td>${tradeChannelDetail.orderCreateTime}</td>
		<td>${tradeChannelDetail.paymentTime}</td>
		<td>${tradeChannelDetail.orderNO}</td>
		<td>${tradeChannelDetail.openID}</td>
		<td>${tradeChannelDetail.errorMsg}</td>
		<td>${tradeChannelDetail.errorCode}</td>
		<td>${tradeChannelDetail.createTime}</td>
		<td>${tradeChannelDetail.lastUpdateTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeChannelDetail.toUpdate(${tradeChannelDetail.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeChannelDetail.deleteTradeChannelDetail(${tradeChannelDetail.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>
</#if>