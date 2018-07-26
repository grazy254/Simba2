drop table if exists project;

drop table if exists smartGroup;

drop table if exists smartUser;

drop table if exists thirdSystemUser;

drop table if exists userGroup;

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project
(
   id                   int not null auto_increment,
   code                 varchar(64) not null comment '����',
   name                 varchar(64) not null comment '����',
   projectKey           varchar(128) not null comment '������Կ',
   loginSuccessUrl      varchar(256) comment '��¼�ɹ���Ļص���ַ',
   forgetBackUrl        varchar(256) comment '���������Ļص�url��ַ',
   createTime           datetime not null comment '����ʱ��',
   createUserAccount    varchar(64) not null comment '�������˺�',
   primary key (id),
   unique key AK_Key_Code (code)
);

alter table project comment '��Ŀ';

/*==============================================================*/
/* Table: smartGroup                                            */
/*==============================================================*/
create table smartGroup
(
   id                   bigint not null auto_increment,
   name                 varchar(64) comment '��������',
   description          varchar(256) comment '��������',
   status               int comment '����״̬',
   type                 int comment '��������',
   creater              varchar(64) comment '���鴴����',
   createTime           datetime,
   primary key (id)
);

alter table smartGroup comment '�����';

/*==============================================================*/
/* Table: smartUser                                             */
/*==============================================================*/
create table smartUser
(
   id                   bigint not null auto_increment,
   account              varchar(128) not null comment '�˺�',
   name                 varchar(128) not null comment '����',
   email                varchar(128) comment '����',
   telNo                varchar(32) comment '�ֻ���',
   password             varchar(128) comment '����',
   createTime           datetime not null comment 'ע��ʱ��',
   status               tinyint comment '״̬',
   sex                  int comment '�Ա�',
   groupId              bigint comment '����id',
   headPic              varchar(256) comment 'ͷ��',
   primary key (id),
   unique key AK_Key_Account (account)
);

alter table smartUser comment '�û�';

/*==============================================================*/
/* Table: thirdSystemUser                                       */
/*==============================================================*/
create table thirdSystemUser
(
   id                   bigint not null auto_increment,
   fromUserId               bigint not null comment '�û�ID',
   thirdSystem          varchar(64) not null comment '������ϵͳ',
   thirdSystemUserId    varchar(128) not null comment '������ϵͳ�û�ID��ʶ',
   primary key (id),
   key AK_Key_UserId (fromUserId),
   key AK_Key_ThirdUserId (thirdSystemUserId, thirdSystem)
);

alter table thirdSystemUser comment '������ϵͳ�û�';

/*==============================================================*/
/* Table: userGroup                                             */
/*==============================================================*/
create table userGroup
(
   id                   bigint not null auto_increment,
   fromUserId               bigint,
   groupId              bigint,
   createTime           datetime,
   primary key (id)
);

alter table userGroup comment '�û����������';
