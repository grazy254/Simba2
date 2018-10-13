<#list list as redPackBill>
	<tr>
		<td>
			<#if redPackBill.type == "NORMAL">
			普通红包
			<#elseif redPackBill.type == "GROUP">
			裂变红包
			</#if>
		</td>
		<td>${redPackBill.billNo}</td>
		<td>${redPackBill.sendName!}</td>
		<td>${redPackBill.openid}</td>
		<td>${redPackBill.amount}</td>
		<td>${redPackBill.num!}</td>
		<td>${redPackBill.wishing!}</td>
		<td>${redPackBill.actName!}</td>
		<td>${redPackBill.remark!}</td>
		<td>
			<#if redPackBill.sceneId == "PRODUCT_1">
				商品促销
			<#elseif redPackBill.sceneId == "PRODUCT_2">
				抽奖
			<#elseif redPackBill.sceneId == "PRODUCT_3">
				虚拟物品兑奖
			<#elseif redPackBill.sceneId == "PRODUCT_4">
				企业内部福利
			<#elseif redPackBill.sceneId == "PRODUCT_5">
				渠道分润
			<#elseif redPackBill.sceneId == "PRODUCT_6">
				保险回馈
			<#elseif redPackBill.sceneId == "PRODUCT_7">
				彩票派奖
			<#elseif redPackBill.sceneId == "PRODUCT_8">
				税务刮奖
			</#if>
		</td>
		<td>
			<#if redPackBill.status == "SENDING">
				发放中
			<#elseif redPackBill.status == "SENT">
				已发放待领取
			<#elseif redPackBill.status == "FAILED">
				发放失败
			<#elseif redPackBill.status == "RECEIVED">
				已领取
			<#elseif redPackBill.status == "RFUND_ING">
				退款中
			<#elseif redPackBill.status == "REFUND">
				已退款
			</#if>
		</td>
		<td>${redPackBill.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
		<td>${redPackBill.createUser!}</td>
		<td>${redPackBill.errMsg!}</td>
		<td>${redPackBill.sendListId!}</td>
	</tr>
</#list>