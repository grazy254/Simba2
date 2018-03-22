/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/10/19 星期四 15:19:39                      */
/*==============================================================*/


drop table if exists commonFile;

drop table if exists fileType;

drop table if exists fileVersion;

drop table if exists iOSVersion;

/*==============================================================*/
/* Table: commonFile                                            */
/*==============================================================*/
create table commonFile
(
   id                   int not null auto_increment,
   name                 varchar(64) not null comment '名称',
   typeId               int not null comment '类型id',
   fileUrl              varchar(128) not null comment '文件地址',
   fileSize             double not null comment '文件大小',
   description          varchar(512) comment '描述',
   createTime           datetime not null comment '时间',
   extProps             varchar(512) comment '扩展属性',
   primary key (id),
   key AK_Key_Time (createTime),
   key AK_Key_Type (typeId)
);

alter table commonFile comment '通用文件';

/*==============================================================*/
/* Table: fileType                                              */
/*==============================================================*/
create table fileType
(
   id                   int not null auto_increment,
   name                 varchar(64) not null comment '名称',
   primary key (id)
);

alter table fileType comment '版本管理文件类型';

/*==============================================================*/
/* Table: fileVersion                                           */
/*==============================================================*/
create table fileVersion
(
   id                   int not null auto_increment,
   version              varchar(64) not null comment '版本号',
   typeId               int not null comment '类型id',
   fileUrl              varchar(128) not null comment '文件地址',
   fileSize             double not null comment '文件大小',
   description          varchar(512) comment '描述',
   createTime           datetime not null comment '时间',
   extProps             varchar(512) comment '扩展属性',
   primary key (id),
   key AK_Key_Time (createTime),
   key AK_Key_Type (typeId)
);

alter table fileVersion comment '文件版本';

/*==============================================================*/
/* Table: iOSVersion                                            */
/*==============================================================*/
create table iOSVersion
(
   id                   int not null auto_increment,
   version              varchar(64) not null comment '版本号',
   fileSize             double not null comment '文件大小',
   description          varchar(512) comment '描述',
   createTime           datetime not null comment '时间',
   identifer            varchar(64) not null comment 'ISO版本Identifer属性',
   title                varchar(128) not null comment '标题',
   ipaFileUrl           varchar(128) not null comment 'IPA文件地址',
   fullImageFileUrl     varchar(128) not null comment '大图片文件地址',
   logFileUrl           varchar(128) not null comment 'logo文件地址',
   primary key (id),
   key AK_Key_Time (createTime)
);

alter table iOSVersion comment 'IOS安装包版本管理';

