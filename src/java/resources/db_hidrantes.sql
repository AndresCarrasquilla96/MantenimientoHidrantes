CREATE DATABASE db_hidrantes;

\c db_hidrantes;

CREATE TABLE usuario (
    id_user SERIAL,
    username VARCHAR (50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (id_user)
);