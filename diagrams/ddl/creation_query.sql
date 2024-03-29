create table _user (
                       id bigint generated by default as identity,
                       email varchar(255),
                       password varchar(255),
                       role varchar(255),
                       primary key (id)
);


create table administrator (
                               id bigint not null,
                               primary key (id)
);


create table guide (
                       organization_name varchar(255),
                       id bigint not null,
                       city_id bigint,
                       primary key (id)
);


create table platform_user (
                               first_name varchar(255),
                               last_name varchar(255),
                               id bigint not null,
                               primary key (id)
);

create table tourist (
                         id bigint not null,
                         primary key (id)
);


alter table if exists administrator
    add constraint FKi2p2fkkrblbu5ol5y2qqk71kv
        foreign key (id)
            references _user;


alter table if exists guide
    add constraint FK9mnedftd1vtjyhp7ltbbmnfj
        foreign key (id)
            references platform_user;


alter table if exists platform_user
    add constraint FK2d67ep7gr73imsf4el5onlyi9
        foreign key (id)
            references _user;


alter table if exists tourist
    add constraint FKsm5405ea22exwwwsaw960gqcb
        foreign key (id)
            references platform_user;

