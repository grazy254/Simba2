/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 10                       */
/* Created on:     2018/5/24 ������ 15:55:52                       */
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
'����֧���˵�';

comment on column aliPayBill.appid is 
'Ӧ��ID';

comment on column aliPayBill.body is 
'����';

comment on column aliPayBill.totalAmount is 
'�����ܽ��';

comment on column aliPayBill.subject is 
'����';

comment on column aliPayBill.outTradeNo is 
'�̻�������';

comment on column aliPayBill.tradeNo is 
'֧����������ˮ��';

comment on column aliPayBill.productCode is 
'��Ʒ��';

comment on column aliPayBill.goodType is 
'��Ʒ������';

comment on column aliPayBill.storeId is 
'�̻��ŵ���';

comment on column aliPayBill.sellId is 
'�տ�֧�����˺�ID';

comment on column aliPayBill.timeoutExpress is 
'������ʱ��';

comment on column aliPayBill.createTime is 
'����ʱ��';

