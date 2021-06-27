DROP TABLE Forms;
DROP SEQUENCE forms_id_seq;
DROP TABLE Options;
DROP SEQUENCE options_id_seq;

CREATE SEQUENCE options_id_seq START 1;

CREATE TABLE Options (
    id integer NOT NULL DEFAULT nextval('options_id_seq'),
    option varchar(255) NOT NULL,
    CONSTRAINT PK_Options PRIMARY KEY (id)
);

CREATE SEQUENCE forms_id_seq START 1;

CREATE TABLE Forms (
    id integer NOT NULL DEFAULT nextval('forms_id_seq'),
	select_id integer,
    name varchar(255) NOT NULL,
	surname varchar(255) NOT NULL,
	number varchar(255) NOT NULL,
	request varchar(2000) NOT NULL,
    CONSTRAINT PK_Forms PRIMARY KEY (id),
    CONSTRAINT FK_Options FOREIGN KEY (select_id)
	REFERENCES Options(id)
);
