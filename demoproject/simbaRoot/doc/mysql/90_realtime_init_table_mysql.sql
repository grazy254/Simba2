drop table if exists realTimeMessage;

/*==============================================================*/
/* Table: realTimeMessage                                       */
/*==============================================================*/
create table realTimeMessage
(
   id                   bigint not null auto_increment,
   appid                varchar(64) comment '应用id',
   userId               int not null comment '用户ID',
   message              text not null comment '内容',
   createTime           datetime not null comment '时间',
   primary key (id)
);

alter table realTimeMessage comment '实时推送记录';
