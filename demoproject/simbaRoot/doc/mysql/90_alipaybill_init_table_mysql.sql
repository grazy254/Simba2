/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/23 ����һ 15:34:06                       */
/*==============================================================*/


drop table if exists aliPayBill;

drop table if exists aliPayEnterpriseBill;

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
   status               varchar(64) comment '״̬',
   createTime           datetime comment '����ʱ��',
   outBizNo             varchar(64) comment '�̻�ҵ��ID',
   buyerId              varchar(64) comment '���֧�����˺Ŷ�Ӧ��֧����Ψһ�û���',
   buyerLogonId         varchar(64) comment '���֧�����˺�',
   sellerEmail          varchar(128) comment '����֧�����˺�',
   receiptAmount        varchar(9) comment '�̼��ڽ�����ʵ���յ��Ŀ���',
   invoiceAmount        varchar(9) comment '�û��ڽ�����֧���Ŀɿ���Ʊ�Ľ��',
   buyerPayAmount       varchar(9) comment '�û��ڽ�����֧���Ľ��',
   refundFee            varchar(9) comment '�˿�֪ͨ�У��������˿���',
   payTime              varchar(32) comment '��Ҹ���ʱ��',
   refundTime           varchar(32) comment '�˿�ʱ��',
   closeTime            varchar(32) comment '����ʱ��',
   primary key (id)
);

alter table aliPayBill comment '����֧���˵�';

/*==============================================================*/
/* Table: aliPayEnterpriseBill                                  */
/*==============================================================*/
create table aliPayEnterpriseBill
(
   id                   bigint not null auto_increment,
   outBizNo             varchar(32) comment '�̻�������',
   payType              varchar(32) comment '�˻�����',
   account              varchar(128) comment '�տ�˻�',
   amount               varchar(16) comment 'ת�˽��',
   payerName            varchar(32) comment '�������',
   peyeeName            varchar(16) comment '�տ��ʵ����',
   remark               varchar(256) comment '��ע',
   orderId              varchar(64) comment '֧����ת�˵��ݺ�',
   payDate              varchar(32) comment '֧��ʱ��',
   createTime           datetime comment 'ʱ��',
   createUser           varchar(32) comment '������',
   status               varchar(32) comment '״̬',
   reason               varchar(256) comment '����',
   orderFee             varchar(16) comment 'Ԥ���շѽ��',
   primary key (id)
);

alter table aliPayEnterpriseBill comment '֧������ҵ֧���˵�';

