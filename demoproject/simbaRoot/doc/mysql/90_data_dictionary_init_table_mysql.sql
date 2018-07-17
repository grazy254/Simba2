/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/17 ���ڶ� 16:48:24                       */
/*==============================================================*/


drop table if exists dictionaryType;

drop table if exists directionary;

/*==============================================================*/
/* Table: dictionaryType                                        */
/*==============================================================*/
create table dictionaryType
(
   id                   bigint not null auto_increment,
   code                 varchar(64) not null comment '����',
   description          varchar(128) comment '����',
   primary key (id),
   unique key AK_Key_code (code)
);

alter table dictionaryType comment '�ֵ�����';

/*==============================================================*/
/* Table: directionary                                          */
/*==============================================================*/
create table directionary
(
   id                   bigint not null auto_increment,
   typeId               bigint not null comment '����id',
   name                 varchar(128) comment '����',
   value                varchar(128) comment 'ֵ',
   primary key (id),
   key AK_Key_typeId (typeId)
);

alter table directionary comment '�ֵ�';

