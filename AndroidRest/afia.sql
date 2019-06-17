
    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)

    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        hpass varchar(255),
        latitude bigint,
        longtuide bigint,
        phone_numbe varchar(255),
        relative_adress varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        hospital_picture varchar(255),
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)
