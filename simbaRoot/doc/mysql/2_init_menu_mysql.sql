﻿insert into menu(id,text,parentID,url,orderNo) values(1000,'权限管理',-1,'',1);
insert into menu(id,text,parentID,url,orderNo) values(10000,'机构管理',1000,'/org/list',1);
insert into menu(id,text,parentID,url,orderNo) values(10021,'项目版本管理',10029,'/projectVersion/list',1);
insert into menu(id,text,parentID,url,orderNo) values(10024,'部署项目管理',10023,'/devProject/list',1);
insert into menu(id,text,parentID,url,orderNo) values(10028,'模拟项目管理',10027,'/project/list',1);
insert into menu(id,text,parentID,url,orderNo) values(1001,'系统管理',-1,'',2);
insert into menu(id,text,parentID,url,orderNo) values(10001,'用户管理',1000,'/user/list',2);
insert into menu(id,text,parentID,url,orderNo) values(10022,'创建项目',10029,'/projectPackage/create',2);
insert into menu(id,text,parentID,url,orderNo) values(10025,'服务器管理',10023,'/projectServer/list',2);
insert into menu(id,text,parentID,url,orderNo) values(10002,'角色管理',1000,'/role/list',3);
insert into menu(id,text,parentID,url,orderNo) values(10023,'自动化部署',-1,'',3);
insert into menu(id,text,parentID,url,orderNo) values(10026,'部署日志管理',10023,'/deployLog/list',3);
insert into menu(id,text,parentID,url,orderNo) values(10003,'权限管理',1000,'/permission/list',4);
insert into menu(id,text,parentID,url,orderNo) values(10027,'模拟管理',-1,'',4);
insert into menu(id,text,parentID,url,orderNo) values(10004,'菜单管理',1001,'/menu/list',5);
insert into menu(id,text,parentID,url,orderNo) values(10029,'框架版本管理',-1,'',5);
insert into menu(id,text,parentID,url,orderNo) values(10005,'业务管理',1001,'/buss/list',6);
insert into menu(id,text,parentID,url,orderNo) values(10007,'注册类型管理',1001,'/registryType/list',8);
insert into menu(id,text,parentID,url,orderNo) values(10008,'注册表管理',1001,'/registryTable/list',9);
insert into menu(id,text,parentID,url,orderNo) values(10019,'异常信息管理',1001,'/exceptionInfo/list',11);
insert into menu(id,text,parentID,url,orderNo) values(10020,'日志管理',1001,'/operLog/list',13);
insert into menu(id,text,parentID,url,orderNo) values(10017,'任务管理',1001,'/job/list',19);
insert into menu(id,text,parentID,url,orderNo) values(10018,'数据库监控',1001,'/druid/index.html',20);
