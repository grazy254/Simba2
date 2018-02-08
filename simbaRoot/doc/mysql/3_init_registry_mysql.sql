insert into registryType(id,text,parentID) values(1,'系统参数',-1);
insert into registryType(id,text,parentID) values(2,'异常邮件提醒',1);
insert into registryType(id,text,parentID) values(3,'自动化部署',1);
insert into registryType(id,text,parentID) values(4,'超级管理员',1);
insert into registryTable(id,code,value,typeID,description) values(2,'alarm.exception.email.enabled','true',2,'是否开启异常邮件提醒');
insert into registryTable(id,code,value,typeID,description) values(3,'alarm.email','caozhejun@ut.cn',2,'接收异常邮件的邮箱地址，多个使用英文逗号隔开');
insert into registryTable(id,code,value,typeID,description) values(4,'alarm.exception','all',2,'需要发送异常邮件提醒的异常类全路径，多个使用英文逗号隔开');
insert into registryTable(id,code,value,typeID,description) values(5,'alarm.exclude.exception','none',2,'不需要发送异常邮件提醒的异常类全路径，多个使用英文逗号隔开');
insert into registryTable(id,code,value,typeID,description) values(6,'autoDeployKey','simbaAutoDeploy',3,'自动化部署提交部署文件时的秘钥');
insert into registryTable(id,code,value,typeID,description) values(7,'autoDeployIps',' ',3,'接收提交部署文件的服务器ip地址列表');
insert into registryTable(id,code,value,typeID,description) values(8,'autoDeployServerDir','/home/smarthome/servers',3,'自动化部署时，服务器存放服务文件的目录');
insert into registryTable(id,code,value,typeID,description) values(9,'administrator.username','66d4aaa5ea177ac32c69946de3731ec0',4,'超级管理员账号');
insert into registryTable(id,code,value,typeID,description) values(10,'administrator.password','91d4b760bf3bf963b775955e12d0a3c2',4,'超级管理员密码');
