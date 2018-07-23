<#list list as aliPayBill>
	<tr>
		<td><input type="checkbox" name="aliPayBill" value="${aliPayBill.id}"></td>
		<!-- 
		<td>${aliPayBill.appid}</td>
		-->
		<td>${aliPayBill.buyerLogonId!}</td>
		<td>${aliPayBill.payTime!}</td>
		<td>${aliPayBill.refundTime!}</td>
		<td>${aliPayBill.buyerPayAmount!}</td>
		<td>${aliPayBill.body!}</td>
		<td>${aliPayBill.totalAmount}</td>
		<td>${aliPayBill.subject}</td>
		<td>
			<#if aliPayBill.status=='WAIT_BUYER_PAY'>
				交易创建，等待买家付款
			<#elseif aliPayBill.status=='TRADE_CLOSED'>
				未付款交易超时关闭，或支付完成后全额退款
			<#elseif aliPayBill.status=='TRADE_SUCCESS'>
				交易支付成功
			<#elseif aliPayBill.status=='TRADE_FINISHED'>
				交易结束，不可退款
			<#elseif aliPayBill.status=='REFUND'>
				退款中
			<#elseif aliPayBill.status=='REFUNDSUCCESS'>
				退款成功
			</#if>
		</td>
		<td>${aliPayBill.outTradeNo!}</td>
		<td>${aliPayBill.tradeNo!}</td>
		<td>${aliPayBill.productCode!}</td>
		<!--
		<td>${aliPayBill.goodType!}</td>
		<td>${aliPayBill.storeId!}</td>
		-->
		<!--
		<td>${aliPayBill.sellId!}</td>
		-->
		<td>${aliPayBill.timeoutExpress!}</td>
		<td>${aliPayBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>
			<#if aliPayBill.status=='WAIT_BUYER_PAY'>
				<button type="button" class="btn btn-default btn-sm" onclick="AliPayBill.close(${aliPayBill.id});"><i class="fa fa-close"></i>关闭</button>
			<#elseif aliPayBill.status=='TRADE_CLOSED'>

			<#elseif aliPayBill.status=='TRADE_SUCCESS'>
					<button type="button" class="btn btn-default btn-sm" onclick="AliPayBill.refund(${aliPayBill.id});"><i class="fa fa-close"></i>退款</button>
			<#elseif aliPayBill.status=='TRADE_FINISHED'>

			<#elseif aliPayBill.status=='REFUND'>

			<#elseif aliPayBill.status=='REFUNDSUCCESS'>

			</#if>
		</td>
	</tr>
</#list>