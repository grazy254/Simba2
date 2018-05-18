<#list list as tradeChannel>
	<tr>
		<td><input type="checkbox" name="tradeChannel" value="${tradeChannel.id}"></td>
		<td>${tradeChannel.name}</td>
		<td>${tradeChannel.type}</td>
		<td>${tradeChannel.createTime}</td>
		<td>${tradeChannel.lastUpdateTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeChannel.toUpdate(${tradeChannel.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeChannel.deleteTradeChannel(${tradeChannel.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>