<#list allType as type>
insert into registryType(id,text,parentID) values(${type.id},'${type.text}',${type.parentID});
</#list>
<#list allTable as table>
insert into registryTable(id,code,value,typeID,description) values(${table.id},'${table.code}','${table.value}',${table.typeID},'${table.description}');
</#list>