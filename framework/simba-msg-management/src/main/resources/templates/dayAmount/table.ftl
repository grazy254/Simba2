<#list list as dayAmount>
	<tr>
		<td><input type="checkbox" name="dayAmount" value="${dayAmount.id}"></td>
		<td>${dayAmount.dayDate}</td>
		<td>${dayAmount.amount}</td>
		<td>${dayAmount.aliAmount}</td>
		<td>${dayAmount.jpushAmount}</td>
		<td>
			<button type="button" class="btn btn-default btn-sm" onclick="DayAmount.toUpdate(${dayAmount.id});"><i class="fa fa-pencil-square-o"></i>修改</button>
			<button type="button" class="btn btn-default btn-sm" onclick="DayAmount.deleteDayAmount(${dayAmount.id});"><i class="fa fa-remove"></i>删除</button>
		</td>
	</tr>
</#list>