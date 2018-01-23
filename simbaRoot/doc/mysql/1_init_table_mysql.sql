/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/12/1 ������ 17:39:05                       */
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
   ip                   varchar(32) not null comment 'ip��ַ',
   ipInfo               varchar(64) not null comment 'ip��ַ��Ϣ',
   exceptionInfo        text not null comment '�쳣��Ϣ',
   createTime           datetime not null comment 'ʱ��',
   primary key (id)
);

alter table exceptionInfo comment '�쳣��Ϣ';

/*==============================================================*/
/* Table: job                                                   */
/*==============================================================*/
create table job
(
   id                   int not null auto_increment,
   name                 varchar(64) not null comment '����',
   description          varchar(256) comment '����',
   cronExpression       varchar(128) comment 'cron���ʽ',
   startTime            varchar(64) comment '��ʼִ��ʱ��',
   endTime              varchar(64) comment '����ִ��ʱ��',
   exeCount             int comment 'ִ�д���',
   maxExeCount          int comment '���ִ�д���',
   status               varchar(16) comment '״̬',
   className            varchar(256) not null comment '������·��',
   methodName           varchar(128) not null comment 'ִ���෽����',
   delayTime            int comment '�ӳ�ʱ��',
   intervalTime         int comment '���ʱ��',
   primary key (id)
);

alter table job comment '����';

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

alter table menu comment '�˵�';

/*==============================================================*/
/* Table: operLog                                               */
/*==============================================================*/
create table operLog
(
   id                   bigint not null auto_increment,
   account              varchar(64) not null comment '�˺�',
   ip                   varchar(32) not null comment 'IP',
   address              varchar(64) not null comment '��ַ',
   content              varchar(512) not null comment '����',
   createTime           datetime not null comment 'ʱ��',
   primary key (id),
   key AK_Key_Time (createTime),
   key AK_Key_Account (account)
);

alter table operLog comment '������־';

/*==============================================================*/
/* Table: org                                                   */
/*==============================================================*/
create table org
(
   id                   int not null auto_increment comment '����ID',
   text                 varchar(128) not null comment '����',
   parentID             int not null comment '������ID',
   orderNo              int comment '����',
   primary key (id)
);

alter table org comment '����';

/*==============================================================*/
/* Table: orgExt                                                */
/*==============================================================*/
create table orgExt
(
   id                   int not null comment '����ID',
   primary key (id)
);

alter table orgExt comment '������չ';

/*==============================================================*/
/* Table: orgRole                                               */
/*==============================================================*/
create table orgRole
(
   id                   int not null auto_increment comment '����ID',
   orgID                int not null comment '����',
   roleName             varchar(64) not null comment '������ID',
   primary key (id)
);

alter table orgRole comment '������ɫ������';

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
   versionNo            varchar(128) not null comment '�汾��',
   filePath             varchar(256) not null comment '�ļ���ַ',
   createTime           datetime not null comment '����ʱ��',
   primary key (id),
   unique key AK_Key_VersionNo (versionNo)
);

alter table projectVersion comment '��Ŀ�汾';

/*==============================================================*/
/* Table: registryTable                                         */
/*==============================================================*/
create table registryTable
(
   id                   int not null auto_increment,
   code                 varchar(64) not null comment '����',
   value                varchar(128) not null comment 'ֵ',
   typeID               int not null comment '����ID',
   description          varchar(128) comment '����',
   primary key (id)
);

alter table registryTable comment 'ע���';

/*==============================================================*/
/* Table: registryType                                          */
/*==============================================================*/
create table registryType
(
   id                   int not null auto_increment,
   text                 varchar(128) not null comment '����',
   parentID             int not null comment '��ID',
   primary key (id)
);

alter table registryType comment 'ע������';

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
   userAccount          varchar(64) not null comment '�û��˺�',
   primary key (userAccount)
);

alter table userExt comment '�û���չ';

/*==============================================================*/
/* Table: userOrg                                               */
/*==============================================================*/
create table userOrg
(
   id                   int not null auto_increment,
   userAccount          varchar(64) not null comment '�û��˺�',
   orgID                int not null comment '����ID',
   primary key (id)
);

alter table userOrg comment '�û�����';

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

