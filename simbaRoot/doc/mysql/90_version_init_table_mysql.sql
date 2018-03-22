/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/10/19 ������ 15:19:39                      */
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
   name                 varchar(64) not null comment '����',
   typeId               int not null comment '����id',
   fileUrl              varchar(128) not null comment '�ļ���ַ',
   fileSize             double not null comment '�ļ���С',
   description          varchar(512) comment '����',
   createTime           datetime not null comment 'ʱ��',
   extProps             varchar(512) comment '��չ����',
   primary key (id),
   key AK_Key_Time (createTime),
   key AK_Key_Type (typeId)
);

alter table commonFile comment 'ͨ���ļ�';

/*==============================================================*/
/* Table: fileType                                              */
/*==============================================================*/
create table fileType
(
   id                   int not null auto_increment,
   name                 varchar(64) not null comment '����',
   primary key (id)
);

alter table fileType comment '�汾�����ļ�����';

/*==============================================================*/
/* Table: fileVersion                                           */
/*==============================================================*/
create table fileVersion
(
   id                   int not null auto_increment,
   version              varchar(64) not null comment '�汾��',
   typeId               int not null comment '����id',
   fileUrl              varchar(128) not null comment '�ļ���ַ',
   fileSize             double not null comment '�ļ���С',
   description          varchar(512) comment '����',
   createTime           datetime not null comment 'ʱ��',
   extProps             varchar(512) comment '��չ����',
   primary key (id),
   key AK_Key_Time (createTime),
   key AK_Key_Type (typeId)
);

alter table fileVersion comment '�ļ��汾';

/*==============================================================*/
/* Table: iOSVersion                                            */
/*==============================================================*/
create table iOSVersion
(
   id                   int not null auto_increment,
   version              varchar(64) not null comment '�汾��',
   fileSize             double not null comment '�ļ���С',
   description          varchar(512) comment '����',
   createTime           datetime not null comment 'ʱ��',
   identifer            varchar(64) not null comment 'ISO�汾Identifer����',
   title                varchar(128) not null comment '����',
   ipaFileUrl           varchar(128) not null comment 'IPA�ļ���ַ',
   fullImageFileUrl     varchar(128) not null comment '��ͼƬ�ļ���ַ',
   logFileUrl           varchar(128) not null comment 'logo�ļ���ַ',
   primary key (id),
   key AK_Key_Time (createTime)
);

alter table iOSVersion comment 'IOS��װ���汾����';

