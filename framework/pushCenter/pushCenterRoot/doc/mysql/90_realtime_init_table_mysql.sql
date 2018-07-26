/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/2/5 ����һ 10:35:03                        */
/*==============================================================*/


drop table if exists realTimeMessage;

/*==============================================================*/
/* Table: realTimeMessage                                       */
/*==============================================================*/
create table realTimeMessage
(
   id                   bigint not null auto_increment,
   fromUserId               int not null comment '�û�ID',
   message              text not null comment '����',
   createTime           datetime not null comment 'ʱ��',
   primary key (id)
);

alter table realTimeMessage comment 'ʵʱ���ͼ�¼';

