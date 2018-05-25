/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/5/23 17:52:27                           */
/*==============================================================*/


drop table if exists tradeAccount;

drop table if exists tradeChannel;

drop table if exists tradeChannelDetail;

drop table if exists tradeDepartment;

drop table if exists tradeDetail;

drop table if exists tradePartyDetail;

drop table if exists tradeUser;

/*==============================================================*/
/* Table: tradeAccount                                          */
/*==============================================================*/
create table tradeAccount
(
   id                   bigint not null auto_increment,
   tradeUserID          bigint not null comment '֧���û�ID',
   accountID            varchar(100) not null comment '�˺�ID',
   accountType          varchar(20) not null comment '�˻����ͣ������ʲ��˻�/�����˻�/�����˺�',
   feeType              varchar(10) not null default 'CNY' comment '�������ͣ������ΪCNY',
   isAllowRecharge      tinyint not null default 0 comment '�Ƿ������ֵ��0������1����',
   isAllowPay           tinyint not null default 0 comment '�Ƿ�����֧����0������1����',
   isActive             tinyint not null default 0 comment '�Ƿ񼤻0δ���1���-1ע��',
   isFrozen             tinyint not null default 1 comment '�Ƿ񶳽᣺0���ᣬ1δ����',
   accountBalance       bigint not null default 0 comment '�˻���ǰ���',
   availableBalance     bigint not null default 0 comment '�˻���ǰ�������',
   frozenBalance        bigint not null default 0 comment '�˻���ǰ�������',
   createTime           datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   lastUpdateTime       datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '����޸�ʱ��',
   primary key (id),
   unique key uk_accountID (accountID, accountType)
);

alter table tradeAccount comment '֧���˺�';

/*==============================================================*/
/* Table: tradeChannel                                          */
/*==============================================================*/
create table tradeChannel
(
   id                   bigint not null auto_increment,
   name                 varchar(100) comment '�������ƣ�΢��֧��/֧����֧��',
   type                 varchar(20) comment '�������ͣ�WXPAY/ALIPAY',
   createTime           datetime comment '����ʱ��',
   lastUpdateTime       datetime comment '������ʱ��',
   primary key (id),
   unique key uk_type (type)
);

alter table tradeChannel comment '������Ϣ';

/*==============================================================*/
/* Table: tradeChannelDetail                                    */
/*==============================================================*/
create table tradeChannelDetail
(
   id                   bigint not null auto_increment,
   tradeAccountID       varchar(100) not null comment '�ʺ�ID',
   channelID            bigint not null comment '����ID',
   orderCreateTime      datetime not null comment '�����ύʱ��',
   paymentTime          datetime not null comment '����֧��ʱ��',
   orderNO              varchar(100) not null comment '����������',
   openID               varchar(100) not null comment '�û���openID',
   errorMsg             varchar(200) default '' comment '������Ϣ',
   errorCode            varchar(20) default '' comment '�������',
   createTime           datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   lastUpdateTime       datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '������ʱ��',
   primary key (id)
);

alter table tradeChannelDetail comment '���׵�������Ϣ';

/*==============================================================*/
/* Table: tradeDepartment                                       */
/*==============================================================*/
create table tradeDepartment
(
   id                   bigint not null auto_increment comment '�տ��',
   deptNO               varchar(50) comment '���ű��',
   deptName             varchar(50) comment '��������',
   createTime           datetime default CURRENT_TIMESTAMP,
   lastUpdateTime       datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   primary key (id),
   unique key uk_deptNO (deptNO)
);

alter table tradeDepartment comment '�տ��';

/*==============================================================*/
/* Table: tradeDetail                                           */
/*==============================================================*/
create table tradeDetail
(
   id                   bigint not null auto_increment,
   tradeNO              varchar(100) not null comment '������ˮ��',
   tradeType            varchar(10) not null comment '��¼�������ͣ���ֵ/����',
   tradeStatus          varchar(10) not null comment '��¼֧��״̬ SUCCESS/FAILED/FROZON',
   orderNO              varchar(100) not null comment '������',
   orderName            varchar(100) not null comment '��������',
   orderDesc            varchar(200) default '' comment '��������',
   orderAddress         varchar(200) default '' comment '������ַ',
   feeType              varchar(10) not null default 'CNY' comment '��������',
   originalAmount       bigint not null default 0 comment 'ԭʼ����',
   paymentAmount        bigint not null default 0 comment 'ʵ�ʷ���',
   tradePartyID         bigint not null comment '��������ID',
   tradeCounterpartyID  bigint not null comment '���׶���ID',
   tradeChannelID       bigint not null comment '��������ID',
   tradeCreateTime      datetime not null comment '����֧��ʱ��',
   tradePaymentTime     datetime not null comment '֧������ʱ��',
   createTime           datetime not null default CURRENT_TIMESTAMP comment '����ʱ��',
   lastUpdateTime       datetime not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '������ʱ��',
   primary key (id)
);

alter table tradeDetail comment '����������Ϣ';

/*==============================================================*/
/* Table: tradePartyDetail                                      */
/*==============================================================*/
create table tradePartyDetail
(
   id                   bigint not null auto_increment,
   tradeUserID          bigint not null comment '֧���û�ID',
   partyName            varchar(100) not null comment '�������ƣ��������/��������',
   partyType            varchar(20) not null comment '�������ͣ�����/��˾����',
   tradeAccountID       varchar(100) not null comment '�˻�ID',
   ip                   varchar(16) default '' comment '���׵��豸IP��Ϣ�����������ѡ�',
   mobileNumber         varchar(11) default '' comment '�û��ĵ绰��Ϣ�����������ѡ�',
   device               varchar(10) default '' comment '�ֻ���ƽ̨�� IOS/Android�� ���������ѡ�',
   noticeMail           varchar(255) not null comment '֪ͨ������',
   location             varchar(200) default '' comment '��ʱ��λ����Ϣ�����������ѡ�',
   createTime           datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   createDate           date comment '��������',
   primary key (id)
);

alter table tradePartyDetail comment '��������';

/*==============================================================*/
/* Table: tradeUser                                             */
/*==============================================================*/
create table tradeUser
(
   id                   bigint not null auto_increment,
   userID               varchar(100) not null comment '�û�ID/����ID',
   name                 varchar(100) not null comment '�û�/��������',
   type                 varchar(20) comment '�û����ͣ�PERSON/CHANNEL/DEPARTMENT',
   isAllowPay           tinyint not null comment '�Ƿ�����֧����0������1����',
   isActive             tinyint comment '�Ƿ񼤻� 0��δ���� 1������ -1:ע��',
   payPassword          varchar(128) not null comment '֧������ ',
   payPhone             varchar(11) not null comment '֧���ֻ�',
   payEmail             varchar(200) not null comment '֧������',
   createTime           datetime default CURRENT_TIMESTAMP comment '����ʱ��',
   lastUpdateTime       datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '������ʱ��',
   primary key (id),
   unique key uk_userID (userID)
);

alter table tradeUser comment 'Ǯ���û���Ϣ';

