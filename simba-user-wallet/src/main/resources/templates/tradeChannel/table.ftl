<#list list as tradeChannelVO>
	<tr>
		<td>${tradeChannelVO.name}</td>
		<td>${tradeChannelVO.type}</td>
		<td>${tradeChannelVO.accountStatus}</td>
		<td>${tradeChannelVO.createTime}</td>
		<td>${tradeChannelVO.lastUpdateTime}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeChannel.toUpdate(${tradeChannelVO.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeChannel.deleteTradeChannel('${tradeChannelVO.type}');"><i class="fa fa-remove"></i>删除</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeChannel.openChannelAccount('${tradeChannelVO.type}', '${tradeChannelVO.name}', '18676459182');"><i class="fa fa-user"></i>开通账户</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeChannel.frozeChannelAccount('${tradeChannelVO.type}');"><i class="fa fa-user"></i>冻结账户</button>
			<button type="button" class="btn btn-default btn-sm" onclick="TradeChannel.activateChannelAccount('${tradeChannelVO.type}');"><i class="fa fa-user"></i>激活账户</button>

		</td>
	</tr>
</#list>