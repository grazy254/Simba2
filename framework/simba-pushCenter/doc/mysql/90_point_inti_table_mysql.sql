drop table if exists activity;

drop table if exists pointDetail;

drop table if exists pointSummary;

/*==============================================================*/
/* Table: activity                                              */
/*==============================================================*/
create table activity
(
   id                   bigint not null auto_increment,
   activityID           varchar(100) not null,
   name                 varchar(100),
   description          varchar(500),
   ownerID              varchar(64),
   point                int,
   startTime            datetime,
   endTime              datetime,
   createTime           datetime,
   updateTime           datetime,
   primary key (id),
   unique key uk_activityID (activityID)
);

/*==============================================================*/
/* Table: pointDetail                                           */
/*==============================================================*/
create table pointDetail
(
   id                   bigint not null auto_increment,
   userID               varchar(64),
   activityID           varchar(64),
   point                int,
   createTime           datetime,
   expireTime           datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: pointSummary                                          */
/*==============================================================*/
create table pointSummary
(
   id                   bigint not null auto_increment,
   userID               varchar(64),
   point                int,
   createTime           datetime,
   updateTime           datetime,
   primary key (id),
   unique key uk_userID (userID)
);
