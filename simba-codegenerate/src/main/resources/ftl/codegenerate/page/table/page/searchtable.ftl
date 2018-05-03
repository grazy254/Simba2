<#assign dollar = '$'>
<#assign pound = '#'>
<${pound}if list?exists>
<${pound}list list as ${firstLower}>
	<tr>
		<#list filedsWithPage as field> 
		<td>${dollar}{${firstLower}.${field.key}}</td>
		</#list>
	</tr>
</${pound}list>
</${pound}if>