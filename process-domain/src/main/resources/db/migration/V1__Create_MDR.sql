create table PARTICIPANT (
    ID VARCHAR(36) NOT NULL,
    TITLE VARCHAR(80) NOT NULL,
    DESCRIPTION VARCHAR(2000) NULL
);
alter table PARTICIPANT add constraint PARTICIPANT_PK1
    primary key (ID);

create table TASKDEFINITION (
    ID VARCHAR(36) NOT NULL,
    TITLE VARCHAR(120) NOT NULL,
    INSTTITLE VARCHAR(200) NULL,
    PARTICIPANT_ID VARCHAR(36) NOT NULL
);
alter table TASKDEFINITION add constraint TASKDEFINITION_PK1
    primary key (ID);
alter table TASKDEFINITION add constraint TASKDEFINITION_FK1
    foreign key (PARTICIPANT_ID) references PARTICIPANT(ID);

create table TASKINSTANCE (
    ID VARCHAR(36) NOT NULL,
    TASKDEFINITION_ID VARCHAR(36) NOT NULL,
    OUTCOME VARCHAR(60) NULL,   -- valor del outcome cuando finaliza la tarea
    DATAOBJECT VARCHAR(400) NULL   -- Contenido del objeto de dato serializado (JSON)
);
alter table TASKINSTANCE add constraint TASKINSTANCE_PK1
    primary key (ID);
alter table TASKINSTANCE add constraint TASKINSTANCE_FK1
    foreign key (TASKDEFINITION_ID) references TASKDEFINITION(ID);

create table TASKSTATE (
    ID INT NOT NULL,
    TITLE VARCHAR(30) NOT NULL,
    ACTIONSALLOWED VARCHAR(1000) NULL
);
alter table TASKSTATE add constraint TASKSTATE_PK1
    primary key (ID);

create table TASKSTATUS (
    TASKINSTANCE_ID VARCHAR(36) NOT NULL,
    TASKSTATE_ID INT NOT NULL,
    FROMDATE TIMESTAMP NOT NULL,
    THRUDATE TIMESTAMP NULL,
    USERNAME VARCHAR(30) NOT NULL
);
alter table TASKSTATUS add constraint TASKSTATUS_PK1
    primary key (TASKINSTANCE_ID,TASKSTATE_ID,FROMDATE);
alter table TASKSTATUS add constraint TASKSTATUS_FK1
    foreign key (TASKINSTANCE_ID) references TASKINSTANCE(ID);
alter table TASKSTATUS add constraint TASKSTATUS_FK2
    foreign key (TASKSTATE_ID) references TASKSTATE(ID);
