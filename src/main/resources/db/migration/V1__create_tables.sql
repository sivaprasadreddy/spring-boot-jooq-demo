CREATE TABLE user_preferences
(
    id         bigserial primary key,
    theme      varchar(255),
    language   varchar(255),
    created_at timestamp with time zone default CURRENT_TIMESTAMP,
    updated_at timestamp with time zone
);

CREATE TABLE users
(
    id             bigserial primary key,
    name           varchar(255) not null,
    email          varchar(255) not null,
    password       varchar(255) not null,
    preferences_id bigint REFERENCES user_preferences (id),
    created_at     timestamp with time zone default CURRENT_TIMESTAMP,
    updated_at     timestamp with time zone,
    CONSTRAINT user_email_unique UNIQUE (email)
);

CREATE TABLE bookmarks
(
    id         bigserial primary key,
    url        varchar(1024) not null,
    title      varchar(1024),
    created_by bigint        not null REFERENCES users (id),
    created_at timestamp with time zone default CURRENT_TIMESTAMP,
    updated_at timestamp with time zone
);

CREATE TABLE tags
(
    id         bigserial primary key,
    name       varchar(100) not null,
    created_at timestamp with time zone default CURRENT_TIMESTAMP,
    updated_at timestamp with time zone,
    CONSTRAINT tag_name_unique UNIQUE (name)
);

CREATE TABLE bookmark_tag
(
    bookmark_id bigint not null REFERENCES bookmarks (id),
    tag_id      bigint not null REFERENCES tags (id)
);

ALTER SEQUENCE user_preferences_id_seq RESTART WITH 101;
ALTER SEQUENCE users_id_seq RESTART WITH 101;
ALTER SEQUENCE bookmarks_id_seq RESTART WITH 101;
ALTER SEQUENCE tags_id_seq RESTART WITH 101;