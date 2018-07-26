/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/7/10 ����һ 14:14:54                       */
/*==============================================================*/


drop table if exists receiveDealType;

drop table if exists receiveMsg;



/*==============================================================*/
/* Table: receiveDealType                                       */
/*==============================================================*/
create table receiveDealType
(
   id                   int not null auto_increment,
   beanId               varchar(128) not null comment '����������͵�Bean��Id��������ʵ��ͬһ���ӿڣ���ע���Spring Bean',
   sync                 tinyint not null comment '�Ƿ�ͬ������(0:�첽��1��ͬ��)',
   name                 varchar(128) comment '����',
   description          varchar(128) comment '����',
   ext                  varchar(512) comment '��չ����',
   primary key (id),
   unique key AK_Key_Name (name)
);

alter table receiveDealType comment '���������Ϣ����';

/*==============================================================*/
/* Table: receiveMsg                                            */
/*==============================================================*/
create table receiveMsg
(
   id                   bigint not null auto_increment,
   type                 varchar(128) not null comment '����',
   source               varchar(128) not null comment 'Դ',
   message              text not null comment '����',
   createTime           datetime not null comment 'ʱ��',
   primary key (id)
);

alter table receiveMsg comment '���յ�����Ϣ';


