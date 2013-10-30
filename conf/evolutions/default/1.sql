# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tutor (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  email                     varchar(255),
  name                      varchar(255),
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

drop table tutor;

SET FOREIGN_KEY_CHECKS=1;

