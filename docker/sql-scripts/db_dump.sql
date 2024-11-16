create table users
(
    id  bigint not null primary key,
    username varchar(255),
    email varchar(255) UNIQUE
);
create table roles
(
    id_user bigint not null,
    role varchar(255) not null
);

alter table users
    owner to postgres;

alter table roles
    owner to postgres;

alter table roles
    add constraint fkmfk0sutpaln74rrn4jfy7i58i
        foreign key (id_user) references users;