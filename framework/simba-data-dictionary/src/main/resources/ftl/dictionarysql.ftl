<#list types as type>
insert into dictionaryType(id,code,description) values(${type.id},'${type.code}','${type.description}');
</#list>
<#list dictionaries as dictionary>
insert into dictionary(id,typeId,name,value) values(${dictionary.id},${dictionary.typeId},'${dictionary.name}','${dictionary.value}');
</#list>