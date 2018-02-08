/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/1/31 ������ 14:30:29                       */
/*==============================================================*/


drop table if exists buss;

drop table if exists deployLog;

drop table if exists devProject;

drop table if exists exceptionInfo;

drop table if exists job;

drop table if exists menu;

drop table if exists operLog;

drop table if exists org;

drop table if exists orgExt;

drop table if exists orgRole;

drop table if exists permission;

drop table if exists project;

drop table if exists projectPackageResult;

drop table if exists projectServer;

drop table if exists projectServerRel;

drop table if exists projectUser;

drop table if exists projectVersion;

drop table if exists registryTable;

drop table if exists registryType;

drop table if exists role;

drop table if exists rolePermission;

drop table if exists systemUser;

drop table if exists urlData;

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
/* Table: deployLog                                             */
/*==============================================================*/
create table deployLog
(
   id                   bigint not null auto_increment,
   projectId            int comment '��Ŀid',
   name                 varchar(64) comment '��Ŀ����',
   createTime           datetime comment 'ʱ��',
   primary key (id)
);

alter table deployLog comment '������־';

/*==============================================================*/
/* Table: devProject                                            */
/*==============================================================*/
create table devProject
(
   id                   int not null auto_increment,
   code                 varchar(64) comment '���',
   name                 varchar(64) comment '����',
   versionType          varchar(64) comment '�汾��������(svn/git)',
   account              varchar(128) comment '�˺�',
   pwd                  varchar(128) comment '����',
   versionUrl           varchar(256) comment '�汾�����ַ',
   packageCommandFile   varchar(512) comment '��������ļ�·��',
   startParams          varchar(512) comment '������������',
   createTime           datetime comment 'ʱ��',
   notifyEmails         varchar(1024) comment '֪ͨ�ʼ���ַ',
   primary key (id),
   unique key AK_Key_Code (code)
);

alter table devProject comment '��Ŀ';

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
/* Table: project                                               */
/*==============================================================*/
create table project
(
   id                   int not null auto_increment,
   code                 varchar(128) not null,
   name                 varchar(128) not null,
   primary key (id),
   unique key AK_Key_Code (code)
);

alter table project comment '��Ŀ';

/*==============================================================*/
/* Table: projectPackageResult                                  */
/*==============================================================*/
create table projectPackageResult
(
   id                   int not null auto_increment,
   projectId            int comment '��Ŀid',
   filePath             varchar(512) comment '�������ļ�·��',
   primary key (id),
   key AK_Key_projectId (projectId)
);

alter table projectPackageResult comment '��Ŀ������';

/*==============================================================*/
/* Table: projectServer                                         */
/*==============================================================*/
create table projectServer
(
   id                   int not null auto_increment,
   name                 varchar(64) comment '����',
   ip                   varchar(64) comment 'IP',
   port                 int comment '�˿ں�',
   primary key (id)
);

alter table projectServer comment '������';

/*==============================================================*/
/* Table: projectServerRel                                      */
/*==============================================================*/
create table projectServerRel
(
   id                   int not null auto_increment,
   projectId            int comment '��Ŀid',
   serverId             int comment '������id',
   primary key (id)
);

alter table projectServerRel comment '��Ŀ�󶨲���ķ�����';

/*==============================================================*/
/* Table: projectUser                                           */
/*==============================================================*/
create table projectUser
(
   id                   int not null auto_increment,
   account              varchar(128) not null,
   projectId            int not null,
   type                 tinyint not null,
   primary key (id)
);

alter table projectUser comment '��Ŀ�û���ϵ��';

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
/* Table: urlData                                               */
/*==============================================================*/
create table urlData
(
   id                   int not null auto_increment,
   projectId            int not null,
   url                  varchar(128) not null,
   data                 text not null,
   description          varchar(128),
   primary key (id)
);

alter table urlData comment 'url��ַ��Ӧ�����ݱ�';

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

