create table jc_t_pn
(
    id integer not null,
    name varchar2(100),
    business_code integer,
    create_time date default sysdate
);
alter table jc_t_pn add constraint jc_t_pn_pk primary key (id);
create sequence jc_t_pn_seq
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1;

create table jc_t_pn_place
(
    id integer not null,
    name varchar2(100),
    pn_id integer,
    create_time date default sysdate
);
alter table jc_t_pn_place add constraint jc_t_pn_place_pk primary key (id);
create sequence jc_t_pn_place_seq
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1;

create table jc_t_pn_transition
(
    id integer not null,
    name varchar2(100),
    pn_id integer,
    create_time date default sysdate
);
alter table jc_t_pn_transition add constraint jc_t_pn_transition_pk primary key (id);
create sequence jc_t_pn_transition_seq
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1;

create table jc_t_pn_io
(
    id integer not null,
    pn_id integer,
    transition_id integer,
    place_id integer,
    input_flg integer,
    output_flg integer,
    create_time date default sysdate
);
alter table jc_t_pn_io add constraint jc_t_pn_io_pk primary key (id);
create sequence jc_t_pn_io_seq
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1;

create table jc_t_pn_mark
(
    id integer not null,
    pn_id integer,
    place_id integer,
    token_num integer,
    create_time date default sysdate
);
alter table jc_t_pn_mark add constraint jc_t_pn_mark_pk primary key (id);
create sequence jc_t_pn_mark_seq
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1;

create table jc_t_pn_transition_event (
    id integer not null,
    transition_id integer,
    event_code integer,
    create_time date default sysdate
);
alter table jc_t_pn_transition_event add constraint jc_t_pn_transition_event_pk primary key (id);
create sequence jc_t_pn_transition_event_seq
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1;

