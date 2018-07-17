/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/17 星期二 16:48:24                       */
/*==============================================================*/


drop table if exists dictionaryType;

drop table if exists directionary;

/*==============================================================*/
/* Table: dictionaryType                                        */
/*==============================================================*/
create table dictionaryType
(
   id                   bigint not null auto_increment,
   code                 varchar(64) not null comment '编码',
   description          varchar(128) comment '描述',
   primary key (id),
   unique key AK_Key_code (code)
);

alter table dictionaryType comment '字典类型';

/*==============================================================*/
/* Table: directionary                                          */
/*==============================================================*/
create table directionary
(
   id                   bigint not null auto_increment,
   typeId               bigint not null comment '类型id',
   name                 varchar(128) comment '名称',
   value                varchar(128) comment '值',
   primary key (id),
   key AK_Key_typeId (typeId)
);

alter table directionary comment '字典';

