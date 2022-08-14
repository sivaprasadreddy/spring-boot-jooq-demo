create sequence user_id_seq start with 1 increment by 1;
create sequence address_id_seq start with 1 increment by 1;
create sequence bookmark_id_seq start with 1 increment by 1;
create sequence tag_id_seq start with 1 increment by 1;

create table addresses
(
    id      bigint DEFAULT nextval('address_id_seq') not null,
    street  varchar(255),
    city    varchar(255),
    state   varchar(255),
    zip     varchar(255),
    country varchar(20),
    primary key (id)
);

create table users
(
    id         bigint DEFAULT nextval('user_id_seq') not null,
    name       varchar(255)                          not null,
    email      varchar(255)                          not null,
    password   varchar(255)                          not null,
    addr_id    bigint REFERENCES addresses (id),
    created_at timestamp,
    updated_at timestamp,
    primary key (id),
    CONSTRAINT user_email_unique UNIQUE (email)
);

create table bookmarks
(
    id         bigint DEFAULT nextval('bookmark_id_seq') not null,
    url        varchar(1024)                             not null,
    title      varchar(1024),
    created_by bigint                                    not null REFERENCES users (id),
    created_at timestamp,
    updated_at timestamp,
    primary key (id)
);

create table tags
(
    id   bigint DEFAULT nextval('tag_id_seq') not null,
    name varchar(100)                         not null,
    primary key (id),
    CONSTRAINT tag_name_unique UNIQUE (name)
);

create table bookmark_tag
(
    bookmark_id bigint not null REFERENCES bookmarks (id),
    tag_id      bigint not null REFERENCES tags (id)
);
