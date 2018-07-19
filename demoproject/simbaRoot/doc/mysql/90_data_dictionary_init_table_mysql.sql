/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/19 星期四 15:53:18                       */
/*==============================================================*/


drop table if exists dictionary;

drop table if exists dictionaryType;

/*==============================================================*/
/* Table: dictionary                                            */
/*==============================================================*/
create table dictionary
(
   id                   bigint not null auto_increment,
   typeId               bigint not null comment '类型id',
   name                 varchar(128) comment '名称',
   value                varchar(128) comment '值',
   orderNo              int comment '排序',
   primary key (id),
   key AK_Key_typeId (typeId)
);

alter table dictionary comment '字典';

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

