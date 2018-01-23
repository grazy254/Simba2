insert into registryType(id,text,parentID) values(1,'系统参数',-1);
insert into registryType(id,text,parentID) values(2,'异常邮件提醒',1);
insert into registryTable(id,code,value,typeID,description) values(2,'alarm.exception.email.enabled','true',2,'是否开启异常邮件提醒');
insert into registryTable(id,code,value,typeID,description) values(3,'alarm.email','caozhejun@ut.cn',2,'接收异常邮件的邮箱地址，多个使用英文逗号隔开');
insert into registryTable(id,code,value,typeID,description) values(4,'alarm.exception','all',2,'需要发送异常邮件提醒的异常类全路径，多个使用英文逗号隔开');
insert into registryTable(id,code,value,typeID,description) values(5,'alarm.exclude.exception','none',2,'不需要发送异常邮件提醒的异常类全路径，多个使用英文逗号隔开');
