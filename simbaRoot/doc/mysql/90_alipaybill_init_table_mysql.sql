/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/5/25 ������ 8:12:01                        */
/*==============================================================*/


drop table if exists aliPayBill;

/*==============================================================*/
/* Table: aliPayBill                                            */
/*==============================================================*/
create table aliPayBill
(
   id                   bigint not null auto_increment,
   appid                varchar(32) comment 'Ӧ��ID',
   body                 varchar(128) comment '����',
   totalAmount          varchar(9) comment '�����ܽ��',
   subject              varchar(256) comment '����',
   outTradeNo           varchar(64) comment '�̻�������',
   tradeNo              varchar(64) comment '֧����������ˮ��',
   productCode          varchar(64) comment '��Ʒ��',
   goodType             varchar(16) comment '��Ʒ������',
   storeId              varchar(16) comment '�̻��ŵ���',
   sellId               varchar(64) comment '�տ�֧�����˺�ID',
   timeoutExpress       varchar(16) comment '������ʱ��',
   createTime           datetime comment '����ʱ��',
   primary key (id)
);

alter table aliPayBill comment '����֧���˵�';

