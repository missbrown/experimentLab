create table jc_t_pn
(
    id int unsigned not null auto_increment primary key,
    name varchar(100),
    business_code int,
    create_time timestamp default now()
);
create table jc_t_pn_place
(
    id int unsigned not null auto_increment primary key,
    name varchar(100),
    pn_id int unsigned,
    create_time timestamp default now()
);
create table jc_t_pn_transition
(
    id int unsigned not null auto_increment primary key,
    name varchar(100),
    pn_id int unsigned,
    create_time timestamp default now()
);
create table jc_t_pn_io
(
    id int unsigned not null auto_increment primary key,
    pn_id int unsigned,
    transition_id int unsigned,
    place_id int unsigned,
    input_flg int unsigned,
    output_flg int unsigned,
    create_time timestamp default now()
);
create table jc_t_pn_mark
(
    id int unsigned not null auto_increment primary key,
    pn_id int unsigned,
    place_id int unsigned,
    token_num int unsigned,
    create_time timestamp default now()
);
create table jc_t_pn_transition_event (
    id int unsigned not null auto_increment primary key,
    transition_id int unsigned,
    event_code int unsigned,
    create_time timestamp default now()
);
