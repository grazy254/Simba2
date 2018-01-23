/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/12/1 星期五 17:39:05                       */
/*==============================================================*/


drop table if exists buss;

drop table if exists exceptionInfo;

drop table if exists job;

drop table if exists menu;

drop table if exists operLog;

drop table if exists org;

drop table if exists orgExt;

drop table if exists orgRole;

drop table if exists permission;

drop table if exists projectVersion;

drop table if exists registryTable;

drop table if exists registryType;

drop table if exists role;

drop table if exists rolePermission;

drop table if exists systemUser;

drop table if exists template;

drop table if exists userExt;

drop table if exists userOrg;

drop table if exists userRole;

/*==============================================================*/
/* Table: buss                                                  */
/*==============================================================*/
create table buss
(
   name                 varchar(64) not null,
   description          varchar(128),
   script               text not null,
   primary key (name)
);

/*==============================================================*/
/* Table: exceptionInfo                                         */
/*==============================================================*/
create table exceptionInfo
(
   id                   bigint not null auto_increment,
   ip                   varchar(32) not null comment 'ip地址',
   ipInfo               varchar(64) not null comment 'ip地址信息',
   exceptionInfo        text not null comment '异常信息',
   createTime           datetime not null comment '时间',
   primary key (id)
);

alter table exceptionInfo comment '异常信息';

/*==============================================================*/
/* Table: job                                                   */
/*==============================================================*/
create table job
(
   id                   int not null auto_increment,
   name                 varchar(64) not null comment '名称',
   description          varchar(256) comment '描述',
   cronExpression       varchar(128) comment 'cron表达式',
   startTime            varchar(64) comment '开始执行时间',
   endTime              varchar(64) comment '结束执行时间',
   exeCount             int comment '执行次数',
   maxExeCount          int comment '最大执行次数',
   status               varchar(16) comment '状态',
   className            varchar(256) not null comment '完整类路径',
   methodName           varchar(128) not null comment '执行类方法名',
   delayTime            int comment '延迟时间',
   intervalTime         int comment '间隔时间',
   primary key (id)
);

alter table job comment '任务';

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   id                   int not null auto_increment,
   text                 varchar(64) not null,
   parentID             int not null,
   url                  varchar(256),
   orderNo              int,
   primary key (id)
);

alter table menu comment '菜单';

/*==============================================================*/
/* Table: operLog                                               */
/*==============================================================*/
create table operLog
(
   id                   bigint not null auto_increment,
   account              varchar(64) not null comment '账号',
   ip                   varchar(32) not null comment 'IP',
   address              varchar(64) not null comment '地址',
   content              varchar(512) not null comment '内容',
   createTime           datetime not null comment '时间',
   primary key (id),
   key AK_Key_Time (createTime),
   key AK_Key_Account (account)
);

alter table operLog comment '操作日志';

/*==============================================================*/
/* Table: org                                                   */
/*==============================================================*/
create table org
(
   id                   int not null auto_increment comment '机构ID',
   text                 varchar(128) not null comment '名称',
   parentID             int not null comment '父机构ID',
   orderNo              int comment '排序',
   primary key (id)
);

alter table org comment '机构';

/*==============================================================*/
/* Table: orgExt                                                */
/*==============================================================*/
create table orgExt
(
   id                   int not null comment '机构ID',
   primary key (id)
);

alter table orgExt comment '机构扩展';

/*==============================================================*/
/* Table: orgRole                                               */
/*==============================================================*/
create table orgRole
(
   id                   int not null auto_increment comment '机构ID',
   orgID                int not null comment '名称',
   roleName             varchar(64) not null comment '父机构ID',
   primary key (id)
);

alter table orgRole comment '机构角色关联表';

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   id                   int not null auto_increment,
   text                 varchar(64) not null,
   url                  varchar(512),
   parentID             int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: projectVersion                                        */
/*==============================================================*/
create table projectVersion
(
   id                   int not null auto_increment,
   versionNo            varchar(128) not null comment '版本号',
   filePath             varchar(256) not null comment '文件地址',
   createTime           datetime not null comment '发布时间',
   primary key (id),
   unique key AK_Key_VersionNo (versionNo)
);

alter table projectVersion comment '项目版本';

/*==============================================================*/
/* Table: registryTable                                         */
/*==============================================================*/
create table registryTable
(
   id                   int not null auto_increment,
   code                 varchar(64) not null comment '编码',
   value                varchar(128) not null comment '值',
   typeID               int not null comment '类型ID',
   description          varchar(128) comment '描述',
   primary key (id)
);

alter table registryTable comment '注册表';

/*==============================================================*/
/* Table: registryType                                          */
/*==============================================================*/
create table registryType
(
   id                   int not null auto_increment,
   text                 varchar(128) not null comment '名称',
   parentID             int not null comment '父ID',
   primary key (id)
);

alter table registryType comment '注册类型';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   name                 varchar(64) not null,
   description          varchar(64),
   primary key (name)
);

/*==============================================================*/
/* Table: rolePermission                                        */
/*==============================================================*/
create table rolePermission
(
   id                   int not null auto_increment,
   roleName             varchar(64) not null,
   permissionID         int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: systemUser                                            */
/*==============================================================*/
create table systemUser
(
   account              varchar(64) not null,
   name                 varchar(64) not null,
   pwd                  varchar(256) not null,
   primary key (account)
);

/*==============================================================*/
/* Table: userExt                                               */
/*==============================================================*/
create table userExt
(
   userAccount          varchar(64) not null comment '用户账号',
   primary key (userAccount)
);

alter table userExt comment '用户扩展';

/*==============================================================*/
/* Table: userOrg                                               */
/*==============================================================*/
create table userOrg
(
   id                   int not null auto_increment,
   userAccount          varchar(64) not null comment '用户账号',
   orgID                int not null comment '机构ID',
   primary key (id)
);

alter table userOrg comment '用户机构';

/*==============================================================*/
/* Table: userRole                                              */
/*==============================================================*/
create table userRole
(
   userAccount          varchar(64) not null,
   roleName             varchar(64) not null,
   primary key (userAccount, roleName)
);

/*==============================================================*/
/* Table: template                                              */
/*==============================================================*/
create table template
(
   id                   int not null auto_increment,
   name                 varchar(64) not null,
   description          varchar(128),
   template             text,
   createtime           datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: applicationUser                                       */
/*==============================================================*/
create table applicationUser
(
   id                   int not null auto_increment,
   userId               int not null,
   appliactionId        int not null,
   userType             tinyint,
   primary key (id)
);

drop table if exists applicationproperty;

/*==============================================================*/
/* Table: applicationproperty                                   */
/*==============================================================*/
create table applicationproperty
(
   id                   int not null auto_increment,
   name                 varchar(128),
   templateId           int not null,
   dev                  text,
   prod                 text,
   test                 text,
   createtime           datetime not null,
   primary key (id)
);

