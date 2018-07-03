<#list list as payBill>
	<tr>
		<td><input type="checkbox" name="payBill" value="${payBill.id}"></td>
		<td>${payBill.productDesc}</td>
		<td>${payBill.detail}</td>
		<td>${payBill.outTradeNo}</td>
		<td>${payBill.fee}</td>
		<td>${payBill.startTime}</td>
		<td>${payBill.endTime}</td>
		<td>${payBill.goodsTag}</td>
		<td>${payBill.tradeType}</td>
		<td>${payBill.productId}</td>
		<td>${payBill.openid}</td>
		<td>
			<#if payBill.status=='SUCCESS'>
				支付成功
			<#elseif payBill.status=='REFUND'>
				转入退款
			<#elseif payBill.status=='NOTPAY'>
				未支付
			<#elseif payBill.status=='CLOSED'>
				已关闭
			<#elseif payBill.status=='REVOKED'>
				已撤销（刷卡支付）
			<#elseif payBill.status=='USERPAYING'>
				用户支付中
			<#elseif payBill.status=='PAYERROR'>
				支付失败
			</#if>
			
		</td>
		<td>${payBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<#if payBill.status=='SUCCESS'>
				<button type="button" class="btn btn-default btn-sm" onclick="PayBill.refund(${payBill.id});"><i class="fa fa-close"></i>退款</button>
			<#elseif payBill.status=='REFUND'>
			<#elseif payBill.status=='NOTPAY'>
			<#elseif payBill.status=='CLOSED'>
			<#elseif payBill.status=='REVOKED'>
			<#elseif payBill.status=='USERPAYING'>
			<#elseif payBill.status=='PAYERROR'>
				<button type="button" class="btn btn-default btn-sm" onclick="PayBill.close(${payBill.id});"><i class="fa fa-close"></i>关闭</button>
			</#if>
		</td>
	</tr>
</#list>