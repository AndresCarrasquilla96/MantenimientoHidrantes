CREATE DATABASE db_hidrantes;

\c db_hidrantes;

CREATE EXTENSION postgis SCHEMA public VERSION "2.5.2";

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

CREATE TABLE historial_instalaciones(
    id_hidrante INT,
    fecha  TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT historialInstalaciones_fk FOREIGN KEY (id_hidrante) REFERENCES hidrante(id_hidrante)
);

CREATE TABLE historial_mantenimientos(
    id_hidrante INT,
    fecha  TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT historialInstalaciones_fk FOREIGN KEY (id_hidrante) REFERENCES hidrante(id_hidrante)
);

-- Funciones
CREATE OR REPLACE FUNCTION insertarHidrante(lat DOUBLE PRECISION, lng DOUBLE PRECISION, caudal_esperado VARCHAR, tamanio_salidas VARCHAR) RETURNS void AS
$$
    INSERT INTO hidrante(ubicacion, caudal_esperado, tamanio_salidas) VALUES (POINT(lat, lng), caudal_esperado, tamanio_salidas);
$$
LANGUAGE 'sql';
--
CREATE OR REPLACE FUNCTION obtenerHidrantes() RETURNS TABLE (id_hidrante INTEGER, ubicacion POINT, caudal_esperado VARCHAR, tamanio_salidas VARCHAR, buen_estado BOOLEAN) AS
$$
    SELECT id_hidrante, ubicacion, caudal_esperado, tamanio_salidas, buen_estado FROM hidrante
$$
LANGUAGE 'sql';
--
CREATE OR REPLACE FUNCTION actualizarHidrante(id_hidra INT) RETURNS void AS
$$
    UPDATE hidrante SET buen_estado=true WHERE id_hidrante=id_hidra
$$
LANGUAGE  'sql';
--
CREATE OR REPLACE FUNCTION historial_instalacion() RETURNS TRIGGER AS 
$BODY$
BEGIN
    INSERT INTO historial_instalaciones VALUES (NEW.id_hidrante);
    RETURN NEW;
END
$BODY$
LANGUAGE 'plpgsql';
--
CREATE OR REPLACE FUNCTION historial_matenimiento() RETURNS TRIGGER AS 
$BODY$
BEGIN
    INSERT INTO historial_mantenimientos VALUES (NEW.id_hidrante);
    RETURN NEW;
END
$BODY$
LANGUAGE 'plpgsql';
--
-- Triggers
CREATE TRIGGER tr_instalacion AFTER INSERT ON hidrante 
FOR EACH row EXECUTE PROCEDURE historial_instalacion();
--
CREATE TRIGGER tr_mantenimiento AFTER UPDATE ON hidrante 
FOR EACH row EXECUTE PROCEDURE historial_matenimiento();
--
-- INSERTS
INSERT INTO role (descripcion) VALUES ('bombero'), ('municipalidad');
INSERT INTO usuario (username, password, id_role) VALUES ('bombero','bombero123', 1);

INSERT INTO hidrante(ubicacion, caudal_esperado, tamanio_salidas,buen_estado) VALUES (POINT(10.0162099508656,-84.2115569114685), 111, 111, false);
INSERT INTO hidrante(ubicacion, caudal_esperado, tamanio_salidas,buen_estado) VALUES (POINT(10.0170338005087,-84.2180800437927), 222, 222, false);
INSERT INTO hidrante(ubicacion, caudal_esperado, tamanio_salidas,buen_estado) VALUES (POINT(10.0137806384557,-84.2120718955994), 333, 333, false);
INSERT INTO hidrante(ubicacion, caudal_esperado, tamanio_salidas,buen_estado) VALUES (POINT(10.0121540451978,-84.2157626152039), 444, 444, false);

INSERT INTO hidrante(ubicacion, caudal_esperado, tamanio_salidas,buen_estado) VALUES (POINT(10.0195149676941,-84.2124474048615), 555, 555, true);
INSERT INTO hidrante(ubicacion, caudal_esperado, tamanio_salidas,buen_estado) VALUES (POINT(10.0130836310259,-84.2133459448815), 666, 666, true);
INSERT INTO hidrante(ubicacion, caudal_esperado, tamanio_salidas,buen_estado) VALUES (POINT(10.013595825907,-84.2095237970352), 777, 777, true);
INSERT INTO hidrante(ubicacion, caudal_esperado, tamanio_salidas,buen_estado) VALUES (POINT(10.0154578654137,-84.2176146805287), 888, 888, true);