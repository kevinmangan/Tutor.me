# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table request (
  id                        bigint auto_increment not null,
  requested_start_time      bigint,
  requested_end_time        bigint,
  constraint pk_request primary key (id))
;

create table session (
  id                        bigint auto_increment not null,
  start_time                bigint,
  end_time                  bigint,
  scribblar_id              varchar(255),
  constraint pk_session primary key (id))
;

create table student (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  email                     varchar(255),
  name                      varchar(255),
  scribblar_id              varchar(255),
  constraint pk_student primary key (id))
;

create table tutor (
  id                        bigint auto_increment not null,
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




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table request;

drop table session;

drop table student;

drop table tutor;

SET FOREIGN_KEY_CHECKS=1;

