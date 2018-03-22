/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/3/13 ���ڶ� 8:57:03                        */
/*==============================================================*/


drop table if exists cardMoneyBill;

drop table if exists looseMoneyBill;

drop table if exists payBill;

drop table if exists redPackBill;

/*==============================================================*/
/* Table: cardMoneyBill                                         */
/*==============================================================*/
create table cardMoneyBill
(
   id                   bigint not null auto_increment,
   mchId                varchar(32) comment '�̻���',
   partnerTradeNo       varchar(32) comment '�̻���ҵ�����',
   bankNo               varchar(64) comment '�տ���п���',
   trueName             varchar(16) comment '�տ�û���',
   bankCode             varchar(64) comment '�տ������',
   amount               int comment '������',
   description          varchar(128) comment '����˵��',
   status               varchar(32) comment '״̬',
   errMsg               varchar(32) comment '������Ϣ',
   paymentNo            varchar(64) comment '΢����ҵ�����',
   cmmsAmt              int comment '�����ѽ��',
   createTime           datetime comment 'ʱ��',
   createUser           varchar(64) comment '������',
   primary key (id),
   key AK_Key_Time (createTime)
);

alter table cardMoneyBill comment '���п��˵�';

/*==============================================================*/
/* Table: looseMoneyBill                                        */
/*==============================================================*/
create table looseMoneyBill
(
   id                   bigint not null auto_increment,
   appid                varchar(64) comment '�̻��˺�appid',
   mchid                varchar(32) comment '�̻���',
   deviceInfo           varchar(32) comment '�豸��',
   partnerTradeNo       varchar(64) comment '�̻�������',
   openid               varchar(64) comment '�û�openid',
   reUserName           varchar(32) comment '�տ��û�����',
   amount               int comment '���',
   description          varchar(128) comment '��ҵ����������Ϣ',
   clientIp             varchar(64) comment 'Ip��ַ',
   status               varchar(64) comment '״̬',
   errMsg               varchar(64) comment '������Ϣ',
   paymentNo            varchar(64) comment '΢�Ŷ�����',
   paymentTime          varchar(64) comment '΢��֧���ɹ�ʱ��',
   createTime           datetime comment '����ʱ��',
   createUser           varchar(64) comment '������',
   primary key (id),
   key AK_Key_Time (createTime)
);

alter table looseMoneyBill comment '��Ǯ�˵�';

/*==============================================================*/
/* Table: payBill                                               */
/*==============================================================*/
create table payBill
(
   id                   bigint not null auto_increment,
   appid                varchar(32) comment 'AppID',
   mchId                varchar(32) comment '�̻���',
   deviceInfo           varchar(32) comment '�豸��',
   productDesc          varchar(128) comment '��Ʒ����',
   detail               varchar(6000) comment '��Ʒ����',
   attach               varchar(127) comment '��������',
   outTradeNo           varchar(32) comment '�̻�������',
   fee                  int comment '��۽��',
   clientIp             varchar(16) comment '�ն�IP',
   startTime            varchar(16) comment '������ʼʱ��',
   endTime              varchar(16) comment '���׽���ʱ��',
   goodsTag             varchar(32) comment '�����Żݱ��',
   notifyUrl            varchar(256) comment '֪ͨ��ַ',
   tradeType            varchar(16) comment '��������',
   productId            varchar(32) comment '��ƷID',
   openid               varchar(128) comment '�û���ʶ',
   status               varchar(32) comment '״̬',
   errMsg               varchar(32) comment '������Ϣ',
   prepayId             varchar(64) comment 'Ԥ֧�����׻Ự��ʶ',
   codeUrl              varchar(64) comment '��ά������',
   mwebUrl              varchar(128) comment 'H5֧������',
   createTime           datetime comment 'ʱ��',
   primary key (id),
   key AK_Key_Time (createTime)
);

alter table payBill comment '֧���˵�';

/*==============================================================*/
/* Table: redPackBill                                           */
/*==============================================================*/
create table redPackBill
(
   id                   bigint not null auto_increment,
   type                 varchar(32) comment '�������',
   billNo               varchar(32) comment '�̻�������',
   mchId                varchar(32) comment '�̻���',
   appid                varchar(32) comment '�����˺�appid',
   sendName             varchar(32) comment '�̻�����',
   openid               varchar(32) comment '�û�openid',
   amount               int comment '������',
   num                  int comment '�������������',
   wishing              varchar(128) comment '���ף����',
   clientIp             varchar(16) comment 'Ip��ַ',
   actName              varchar(32) comment '�����',
   remark               varchar(256) comment '��ע',
   sceneId              varchar(32) comment '����id',
   riskInfo             varchar(128) comment '���Ϣ',
   consumeMchId         varchar(32) comment '�ʽ���Ȩ�̻���',
   status               varchar(32) comment '״̬',
   errMsg               varchar(32) comment '������Ϣ',
   sendListId           varchar(32) comment '΢�ŵ���',
   createTime           datetime comment 'ʱ��',
   createUser           varchar(32) comment '������',
   primary key (id),
   key AK_Key_Type (type),
   key AK_Key_Time (createTime)
);

alter table redPackBill comment '����˵�';

