# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table request (
  id                        bigint not null,
  requesting_student_id     bigint,
  requested_tutor_id        bigint,
  requested_start_time      bigint,
  requested_end_time        bigint,
  constraint pk_request primary key (id))
;

create table session (
  id                        bigint not null,
  student_id                bigint,
  tutor_id                  bigint,
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
  pwhash                    varchar(255),
  salt                      varchar(255),
  constraint pk_student primary key (id))
;

create table tmsession (
  id                        bigint not null,
  student_id                bigint,
  tutor_id                  bigint,
  start_time                bigint,
  end_time                  bigint,
  scribblar_id              varchar(255),
  constraint pk_tmsession primary key (id))
;

create table tutor (
  id                        bigint not null,
  username                  varchar(255),
  email                     varchar(255),
  name                      varchar(255),
  scribblar_id              varchar(255),
  pwhash                    varchar(255),
  salt                      varchar(255),
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

create sequence tmsession_seq;

create sequence tutor_seq;

alter table request add constraint fk_request_requestingStudent_1 foreign key (requesting_student_id) references student (id) on delete restrict on update restrict;
create index ix_request_requestingStudent_1 on request (requesting_student_id);
alter table request add constraint fk_request_requestedTutor_2 foreign key (requested_tutor_id) references tutor (id) on delete restrict on update restrict;
create index ix_request_requestedTutor_2 on request (requested_tutor_id);
alter table session add constraint fk_session_student_3 foreign key (student_id) references student (id) on delete restrict on update restrict;
create index ix_session_student_3 on session (student_id);
alter table session add constraint fk_session_tutor_4 foreign key (tutor_id) references tutor (id) on delete restrict on update restrict;
create index ix_session_tutor_4 on session (tutor_id);
alter table tmsession add constraint fk_tmsession_student_5 foreign key (student_id) references student (id) on delete restrict on update restrict;
create index ix_tmsession_student_5 on tmsession (student_id);
alter table tmsession add constraint fk_tmsession_tutor_6 foreign key (tutor_id) references tutor (id) on delete restrict on update restrict;
create index ix_tmsession_tutor_6 on tmsession (tutor_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists request;

drop table if exists session;

drop table if exists student;

drop table if exists tmsession;

drop table if exists tutor;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists request_seq;

drop sequence if exists session_seq;

drop sequence if exists student_seq;

drop sequence if exists tmsession_seq;

drop sequence if exists tutor_seq;

