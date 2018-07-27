drop table if exists pushMessage;

/*==============================================================*/
/* Table: pushMessage                                           */
/*==============================================================*/
create table pushMessage
(
   id                   bigint not null auto_increment,
   toUserId             bigint comment '接收方Id',
   fromUserId           bigint comment '发送方Id',
   pushType             varchar(32) comment '推送类型',
   content              text comment '内容',
   createTime           datetime comment '创建时间',
   primary key (id)
);

alter table pushMessage comment '消息记录';
