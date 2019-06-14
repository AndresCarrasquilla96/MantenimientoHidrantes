CREATE DATABASE db_hidrantes;

\c db_hidrantes

CREATE TABLE role (
    id_role SERIAL,
    descripcion VARCHAR(30),
    CONSTRAINT pk_role PRIMARY KEY (id_role)
);

CREATE TABLE usuario (
    id_user SERIAL,
    username VARCHAR (50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    id_role INT NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id_user),
    CONSTRAINT fk_role FOREIGN KEY(id_role) REFERENCES role(id_role)
);

CREATE TABLE hidrante (
    id_hidrante SERIAL,
    ubicacion POINT NOT NULL,
    caudal_esperado VARCHAR (50) NOT NULL,
    tamanio_salidas VARCHAR (50) NOT NULL,
    buen_estado BOOLEAN DEFAULT true, 
    CONSTRAINT pk_hidrante PRIMARY KEY (id_hidrante)
);

INSERT INTO role (descripcion) VALUES ('bombero'), ('municipalidad');
INSERT INTO usuario (username, password, id_role) VALUES ('bombero','bombero123', 1);