create sequence hibernate_sequence start 1 increment 1;
create table users
(
    id         int8 not null,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    primary key (id)
);
