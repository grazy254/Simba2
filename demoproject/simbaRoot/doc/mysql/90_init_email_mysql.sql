/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/9/20 ������ 15:58:48                       */
/*==============================================================*/


drop table if exists email;

/*==============================================================*/
/* Table: email                                                 */
/*==============================================================*/
create table email
(
   id                   bigint not null auto_increment,
   appid                varchar(64) comment 'Ӧ��ID',
   toEmail              varchar(128) comment '���շ�����',
   title                varchar(128) comment '����',
   content              text comment '����',
   type                 varchar(16) comment '����',
   createTime           datetime comment 'ʱ��',
   primary key (id),
   key AK_Key_Appid (appid),
   key AK_Key_toEmail (toEmail),
   key AK_Key_time (createTime)
);

alter table email comment '�ʼ���¼';

