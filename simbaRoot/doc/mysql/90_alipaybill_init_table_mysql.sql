/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 10                       */
/* Created on:     2018/5/24 星期四 15:55:52                       */
/*==============================================================*/


if exists(
   select 1 from sys.systable 
   where table_name='aliPayBill'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table aliPayBill
end if;

/*==============================================================*/
/* Table: aliPayBill                                            */
/*==============================================================*/
create table aliPayBill 
(
   id                   bigint                         not null,
   appid                varchar(32),
   body                 varchar(128),
   totalAmount          varchar(9),
   subject              varchar(256),
   outTradeNo           varchar(64),
   tradeNo              varchar(64),
   productCode          varchar(64),
   goodType             varchar(16),
   storeId              varchar(16),
   sellId               varchar(64),
   timeoutExpress       varchar(16),
   createTime           datetime,
   constraint PK_ALIPAYBILL primary key clustered (id)
);

comment on table aliPayBill is 
'阿里支付账单';

comment on column aliPayBill.appid is 
'应用ID';

comment on column aliPayBill.body is 
'描述';

comment on column aliPayBill.totalAmount is 
'订单总金额';

comment on column aliPayBill.subject is 
'标题';

comment on column aliPayBill.outTradeNo is 
'商户订单号';

comment on column aliPayBill.tradeNo is 
'支付宝交易流水号';

comment on column aliPayBill.productCode is 
'产品码';

comment on column aliPayBill.goodType is 
'商品主类型';

comment on column aliPayBill.storeId is 
'商户门店编号';

comment on column aliPayBill.sellId is 
'收款支付宝账号ID';

comment on column aliPayBill.timeoutExpress is 
'最晚付款时间';

comment on column aliPayBill.createTime is 
'订单时间';

