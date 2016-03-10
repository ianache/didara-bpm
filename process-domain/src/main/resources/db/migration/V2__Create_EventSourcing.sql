create table STOREDEVENT (
    ID VARCHAR(36) NOT NULL,
    OCCURREDON timestamp NOT NULL,
    BODY VARCHAR(4000) NOT NULL,
    TYPENAME VARCHAR(120) NOT NULL
);
alter table STOREDEVENT
    add constraint STOREDEVENT_PK1 
    primary key(ID);

create sequence STOREDEVENT_ID_SEQ 
  start with 1 increment by 1;