/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/7/23 星期一 15:34:06                       */
/*==============================================================*/


drop table if exists aliPayBill;

drop table if exists aliPayEnterpriseBill;

/*==============================================================*/
/* Table: aliPayBill                                            */
/*==============================================================*/
create table aliPayBill
(
   id                   bigint not null auto_increment,
   appid                varchar(32) comment '应用ID',
   body                 varchar(128) comment '描述',
   totalAmount          varchar(9) comment '订单总金额',
   subject              varchar(256) comment '标题',
   outTradeNo           varchar(64) comment '商户订单号',
   tradeNo              varchar(64) comment '支付宝交易流水号',
   productCode          varchar(64) comment '产品码',
   goodType             varchar(16) comment '商品主类型',
   storeId              varchar(16) comment '商户门店编号',
   sellId               varchar(64) comment '收款支付宝账号ID',
   timeoutExpress       varchar(16) comment '最晚付款时间',
   status               varchar(64) comment '状态',
   createTime           datetime comment '订单时间',
   outBizNo             varchar(64) comment '商户业务ID',
   buyerId              varchar(64) comment '买家支付宝账号对应的支付宝唯一用户号',
   buyerLogonId         varchar(64) comment '买家支付宝账号',
   sellerEmail          varchar(128) comment '卖家支付宝账号',
   receiptAmount        varchar(9) comment '商家在交易中实际收到的款项',
   invoiceAmount        varchar(9) comment '用户在交易中支付的可开发票的金额',
   buyerPayAmount       varchar(9) comment '用户在交易中支付的金额',
   refundFee            varchar(9) comment '退款通知中，返回总退款金额',
   payTime              varchar(32) comment '买家付款时间',
   refundTime           varchar(32) comment '退款时间',
   closeTime            varchar(32) comment '结束时间',
   primary key (id)
);

alter table aliPayBill comment '阿里支付账单';

/*==============================================================*/
/* Table: aliPayEnterpriseBill                                  */
/*==============================================================*/
create table aliPayEnterpriseBill
(
   id                   bigint not null auto_increment,
   outBizNo             varchar(32) comment '商户订单号',
   payType              varchar(32) comment '账户类型',
   account              varchar(128) comment '收款方账户',
   amount               varchar(16) comment '转账金额',
   payerName            varchar(32) comment '付款方姓名',
   peyeeName            varchar(16) comment '收款方真实姓名',
   remark               varchar(256) comment '备注',
   orderId              varchar(64) comment '支付宝转账单据号',
   payDate              varchar(32) comment '支付时间',
   createTime           datetime comment '时间',
   createUser           varchar(32) comment '创建者',
   status               varchar(32) comment '状态',
   reason               varchar(256) comment '理由',
   orderFee             varchar(16) comment '预计收费金额',
   primary key (id)
);

alter table aliPayEnterpriseBill comment '支付宝企业支付账单';

