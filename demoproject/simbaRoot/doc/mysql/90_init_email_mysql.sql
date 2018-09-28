/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/9/20 星期四 15:58:48                       */
/*==============================================================*/


drop table if exists email;

/*==============================================================*/
/* Table: email                                                 */
/*==============================================================*/
create table email
(
   id                   bigint not null auto_increment,
   appid                varchar(64) comment '应用ID',
   toEmail              varchar(128) comment '接收方邮箱',
   title                varchar(128) comment '标题',
   content              text comment '内容',
   type                 varchar(16) comment '类型',
   createTime           datetime comment '时间',
   primary key (id),
   key AK_Key_Appid (appid),
   key AK_Key_toEmail (toEmail),
   key AK_Key_time (createTime)
);

alter table email comment '邮件记录';

