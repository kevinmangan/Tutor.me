# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table request (
  id                        bigint not null,
  requested_start_time      bigint,
  requested_end_time        bigint,
  constraint pk_request primary key (id))
;

create table session (
  id                        bigint not null,
  start_time                bigint,
  end_time                  bigint,
  scribblar_id              varchar(255),
  constraint pk_session primary key (id))
;

create table student (
  id                        bigint not null,
  username                  varchar(255),
  email                     varchar(255),
  name                      varchar(255),
  scribblar_id              varchar(255),
  constraint pk_student primary key (id))
;

create table tutor (
  id                        bigint not null,
  username                  varchar(255),
  email                     varchar(255),
  name                      varchar(255),
  scribblar_id              varchar(255),
  picture                   varchar(255),
  rating                    double,
  num_raters                integer,
  description               varchar(255),
  tagline                   varchar(255),
  subjects_csv              varchar(255),
  cost_usd                  double,
  constraint pk_tutor primary key (id))
;

create sequence request_seq;

create sequence session_seq;

create sequence student_seq;

create sequence tutor_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists request;

drop table if exists session;

drop table if exists student;

drop table if exists tutor;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists request_seq;

drop sequence if exists session_seq;

drop sequence if exists student_seq;

drop sequence if exists tutor_seq;

