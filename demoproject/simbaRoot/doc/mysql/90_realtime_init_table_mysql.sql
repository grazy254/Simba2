drop table if exists realTimeMessage;

/*==============================================================*/
/* Table: realTimeMessage                                       */
/*==============================================================*/
create table realTimeMessage
(
   id                   bigint not null auto_increment,
   appid                varchar(64) comment 'Ӧ��id',
   userId               int not null comment '�û�ID',
   message              text not null comment '����',
   createTime           datetime not null comment 'ʱ��',
   primary key (id)
);

alter table realTimeMessage comment 'ʵʱ���ͼ�¼';
