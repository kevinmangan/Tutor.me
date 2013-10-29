# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tutor (
  id                        bigint not null,
  username                  varchar(255),
  email                     varchar(255),
  name                      varchar(255),
  rating                    double,
  num_raters                integer,
  description               varchar(255),
  tagline                   varchar(255),
  cost_usd                  double,
  constraint pk_tutor primary key (id))
;

create sequence tutor_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists tutor;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists tutor_seq;

