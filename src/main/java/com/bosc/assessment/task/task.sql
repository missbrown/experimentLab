create table jc_t_task_group (
    id int unsigned not null auto_increment primary key,
    name varchar,
    creator int unsigned,
    update_user int unsigned,
    update_time timestamp,
    create_time timestamp default now()
);

create table jc_t_task (
    id int unsigned not null auto_increment primary key,
    group_id int unsigned,
    code varchar,
    name varchar,
    frequency int unsigned,
    status int unsigned,
    timeout int unsigned,
    creator int unsigned,
    update_user int unsigned,
    update_time timestamp,
    create_time timestamp default now()
);

create table jc_t_task_dependency (
    id int unsigned not null auto_increment primary key,
    task_id int unsigned,
    parent_id int unsigned,
    create_time timestamp default now()
);

create table jc_t_task_instance (
    id bigint unsigned not null auto_increment primary key,
    task_id int unsigned,
    task_date date,
    start_time timestamp,
    end_time timestamp,
    trigger_type int unsigned,
    state int unsigned,
    creator int unsigned,
    create_time timestamp default now()
);

create table jc_t_task_log (
    id bigint unsigned not null auto_increment primary key,
    op_user_id int unsigned,
    op_type int unsigned,
    op_task_id int unsigned,
    op_time timestamp,
    create_time timestamp default now()
);

create table jc_report_task (
    id bigInt unsigned not null auto_increment primary key,
    data_time date,
    count_month bigint unsigned,
    count_year bigint unsigned,
    count_success bigint unsigned,
    count_fail bigint unsigned,
    time_usage_alter_threshold bigint,
    time_usage_alter_count bigint,
    time_usage_avg bigint unsigned,
    time_usage_max bigint unsigned,
    create_time timestamp default now()
);