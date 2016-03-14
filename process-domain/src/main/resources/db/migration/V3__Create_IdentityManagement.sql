create table ORGENTITY (
    ID VARCHAR(36) NOT NULL,
    SNAME VARCHAR(60) NOT NULL
);
alter table ORGENTITY 
    add constraint ORGENTITY_PK1
    primary key(ID);

create table USERENTITY (
    ID VARCHAR(36) NOT NULL,
    FULLNAME VARCHAR(120) NOT NULL,
    EMAIL VARCHAR(120) NULL,
    PASSWORD VARCHAR(60) NOT NULL,
    LOCKED INT NOT NULL
);
alter table USERENTITY
    add constraint USERENTITY_PK1
    primary key(ID);
alter table USERENTITY
    add constraint USERENTITY_FK1
    foreign key (ID)
    references ORGENTITY(ID);

create table GROUPENTITY (
    ID VARCHAR(36) NOT NULL,
    DESCRIPTION VARCHAR(200) NULL,
    PARENT_ID VARCHAR(36) NULL
);
alter table GROUPENTITY
    add constraint GROUPENTITY_PK1
    primary key(ID);
alter table GROUPENTITY
    add constraint GROUPENTITY_FK1
    foreign key (ID)
    references ORGENTITY(ID);
alter table GROUPENTITY
    add constraint GROUPENTITY_FK2
    foreign key (PARENT_ID)
    references GROUPENTITY(ID);

create table ORGENTITYMEMBERSHIP (
    GROUP_ID VARCHAR(36) NOT NULL,
    USER_ID VARCHAR(36) NOT NULL,
    ACTIVE INT NOT NULL
);
alter table ORGENTITYMEMBERSHIP
    add constraint ORGENTITYMEMBERSHIP_PK1
    primary key(GROUP_ID,USER_ID);
alter table ORGENTITYMEMBERSHIP
    add constraint ORGENTITYMEMBERSHIP_FK1
    foreign key (GROUP_ID)
    references GROUPENTITY(ID);
alter table ORGENTITYMEMBERSHIP
    add constraint ORGENTITYMEMBERSHIP_FK2
    foreign key (USER_ID)
    references USERENTITY(ID);