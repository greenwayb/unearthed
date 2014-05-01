# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table audit (
  id                        varchar(255) not null,
  event                     varchar(2),
  username                  varchar(255),
  event_date_time           timestamp,
  info                      varchar(255),
  constraint ck_audit_event check (event in ('LO','PA','MS')),
  constraint pk_audit primary key (id))
;

create table bar (
  id                        varchar(255) not null,
  name                      varchar(255),
  constraint pk_bar primary key (id))
;

create table match_user (
  person_type               varchar(31) not null,
  id                        bigint not null,
  username                  varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  created_on                timestamp,
  last_logged_on            timestamp,
  first_name                varchar(255),
  last_name                 varchar(255),
  gender                    varchar(1),
  description               varchar(255),
  constraint ck_match_user_gender check (gender in ('X','M','F')),
  constraint pk_match_user primary key (id))
;

create sequence audit_seq;

create sequence bar_seq;

create sequence match_user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists audit;

drop table if exists bar;

drop table if exists match_user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists audit_seq;

drop sequence if exists bar_seq;

drop sequence if exists match_user_seq;

