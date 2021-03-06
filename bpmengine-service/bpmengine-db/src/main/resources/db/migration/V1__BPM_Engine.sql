create table mdr.BPM_PROCESSDEF (
    ID VARCHAR2(36) NOT NULL,
    NAME VARCHAR(120) NOT NULL,
    DEFINITION VARCHAR(2000) NOT NULL
);
ALTER TABLE mdr.BPM_PROCESSDEF ADD CONSTRAINT PK1_PROCESSDEF PRIMARY KEY (ID);

create table mdr.BPM_PROCESSINST (
    ID VARCHAR2(36) NOT NULL,
    PROCESSDEF_ID VARCHAR2(36) NOT NULL,
    CREATEDON DATE NOT NULL
);
ALTER TABLE mdr.BPM_PROCESSINST ADD CONSTRAINT PK1_PROCESSINST PRIMARY KEY (ID);
ALTER TABLE mdr.BPM_PROCESSINST ADD CONSTRAINT FK1_PROCESSINST FOREIGN KEY (PROCESSDEF_ID) 
    REFERENCES mdr.BPM_PROCESSDEF (ID);

create table mdr.BPM_PARTICIPANT (
    ID VARCHAR2(36) NOT NULL,
    NAME VARCHAR(60) NOT NULL,
    PROCESSDEF_ID VARCHAR2(36) NOT NULL
);
ALTER TABLE mdr.BPM_PARTICIPANT ADD CONSTRAINT PK1_PARTICIPANT PRIMARY KEY (ID);
ALTER TABLE mdr.BPM_PARTICIPANT ADD CONSTRAINT FK1_PARTICIPANT FOREIGN KEY (PROCESSDEF_ID) 
    REFERENCES mdr.BPM_PROCESSDEF (ID);