/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/7/19 ������ 13:56:03                       */
/*==============================================================*/


drop table if exists project;

drop table if exists smartUser;

drop table if exists thirdSystemUser;

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project
(
   id                   int not null auto_increment,
   code                 varchar(64) not null comment '����',
   name                 varchar(64) not null comment '����',
   projectKey           varchar(128) not null comment '������Կ',
   loginSuccessUrl      varchar(256) comment '��¼�ɹ���Ļص���ַ',
   forgetBackUrl        varchar(256) comment '���������Ļص�url��ַ',
   createTime           datetime not null comment '����ʱ��',
   createUserAccount    varchar(64) not null comment '�������˺�',
   primary key (id),
   unique key AK_Key_Code (code)
);

alter table project comment '��Ŀ';

/*==============================================================*/
/* Table: smartUser                                             */
/*==============================================================*/
create table smartUser
(
   id                   bigint not null auto_increment,
   account              varchar(128) not null comment '�˺�',
   name                 varchar(128) not null comment '����',
   email                varchar(128) comment '����',
   telNo                varchar(32) comment '�ֻ���',
   password             varchar(128) comment '����',
   createTime           datetime not null comment 'ע��ʱ��',
   status               tinyint comment '״̬',
   primary key (id),
   unique key AK_Key_Account (account)
);

alter table smartUser comment '�û�';

/*==============================================================*/
/* Table: thirdSystemUser                                       */
/*==============================================================*/
create table thirdSystemUser
(
   id                   bigint not null auto_increment,
   userId               bigint not null comment '�û�ID',
   thirdSystem          varchar(64) not null comment '������ϵͳ',
   thirdSystemUserId    varchar(128) not null comment '������ϵͳ�û�ID��ʶ',
   primary key (id),
   key AK_Key_UserId (userId),
   key AK_Key_ThirdUserId (thirdSystemUserId, thirdSystem)
);

alter table thirdSystemUser comment '������ϵͳ�û�';
