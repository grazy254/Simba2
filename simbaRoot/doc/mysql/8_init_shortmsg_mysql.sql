/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/1/16 11:31:39                           */
/*==============================================================*/


drop table if exists msgBlacklist;

drop table if exists dayAmount;

drop table if exists msgProject;

drop table if exists shortMessage;

drop table if exists msgTemplate;

/*==============================================================*/
/* Table: msgBlacklist*/
/*==============================================================*/
create table msgBlacklist
(
   id                   int not null auto_increment,
   mobile               varchar(32) not null comment '�ֻ���',
   createTime           datetime not null,
   primary key (id),
   unique key AK_key_mobile (mobile)
);

alter table msgBlacklist comment '�쳣��������ʱ�������ڷ��������ŵ�';

/*==============================================================*/
/* Table: dayAmount                                             */
/*==============================================================*/
create table dayAmount
(
   id                   bigint not null auto_increment,
   dayDate              date,
   amount               int not null,
   projectId            int,
   primary key (id)
);

alter table dayAmount comment 'ÿ��ķ�����';

/*==============================================================*/
/* Table: msgProject*/
/*==============================================================*/
create table msgProject
(
   id                   int not null auto_increment,
   name                 varchar(64) comment '��Ŀ����',
   projectKey           varchar(128) not null,
   ip                   text,
   threshold            float comment '������ֵ',
   limitNum             int comment 'ÿ�������������',
   email                varchar(1024) comment '��������',
   mobile               varchar(1024) comment '��������',
   primary key (id)
);

alter table msgProject comment '��Ŀ';

/*==============================================================*/
/* Table: shortMessage                                          */
/*==============================================================*/
create table shortMessage
(
   id                   bigint not null auto_increment comment 'ID',
   templateId           varchar(64) not null comment 'ģ��Id',
   value                varchar(512) comment 'ģ���е�ֵ',
   mobile               varchar(32) not null comment '�ֻ�����',
   sendDate             datetime not null comment '����ʱ��',
   projectId            int not null comment '������Ŀ',
   status               tinyint comment '����״̬',
   platform             varchar(32) comment '���͵�ƽ̨',
   messageId            varchar(64) comment '����SMS���ͽӿڷ��صĶ���ID',
   primary key (id)
);

alter table shortMessage comment '����';

/*==============================================================*/
/* Table: msgTemplate;*/
/*==============================================================*/
create table msgTemplate
(
   id                   int not null auto_increment,
   name                 varchar(64) comment 'ģ������',
   content              varchar(1024) comment 'ģ������',
   createTime           datetime not null comment 'ģ�崴��ʱ��',
   statusAli            tinyint,
   statusJpush          tinyint comment '���״̬',
   aliTemplateId        varchar(64),
   jpushTemplateId      varchar(64),
   selfId               varchar(64),
   primary key (id)
);

alter table msgTemplate comment 'ģ��';

