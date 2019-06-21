
    create table hospital (
       id bigint not null auto_increment,
        hname varchar(255) not null,
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

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
        image varchar(255),
        latitude bigint,
        longtuide bigint,
        owendby varchar(255),
        phone_numbe varchar(255),
        relative_adress varchar(255),
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        email varchar(255),
        enabled integer,
        lname varchar(255),
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table hospital 
       add constraint UK_955jevpk91outckcwno5w98ip unique (hname)

    alter table user 
       add constraint UK_sb8bbouer5wak8vyiiy4pf2bx unique (username)

    create table role (
       id bigint not null,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table role 
       add constraint UK_bjxn5ii7v7ygwx39et0wawu0q unique (role)

    create table card (
       id bigint not null,
        approved bit,
        card_no varchar(255),
        date date,
        description varchar(255),
        fx_hospital bigint,
        fx_user bigint,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table report (
       id bigint not null,
        blood_test varchar(255),
        other_test varchar(255),
        report_date datetime,
        reportno varchar(255),
        urin_test varchar(255),
        hospital_id bigint,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table card 
       add constraint UK_2gifx4rwq94tfkasgtoaxpdah unique (card_no)

    alter table report 
       add constraint UK_jxifx2jha7ytulah689axg4v7 unique (reportno)

    alter table hospital 
       add constraint FKg0et105phnwcq7vbj9rccsnqk 
       foreign key (fx_user) 
       references user (id)

    alter table card 
       add constraint FK3hamt386m9rxt3yffro9x4r2n 
       foreign key (fx_hospital) 
       references hospital (id)

    alter table card 
       add constraint FKjal5w9n3x8bvwloiudkndtkv1 
       foreign key (fx_user) 
       references user (id)

    alter table report 
       add constraint FKfjoqg8f32ffbmfwgiap62k7a4 
       foreign key (hospital_id) 
       references hospital (id)

    alter table report 
       add constraint FKj62onw73yx1qnmd57tcaa9q3a 
       foreign key (user_id) 
       references user (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)
