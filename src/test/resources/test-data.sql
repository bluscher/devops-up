-- schema.sql
DROP TABLE IF EXISTS empleados;
CREATE TABLE empleados (
                           emp_id SERIAL PRIMARY KEY NOT NULL,
                           email varchar(255) NOT NULL,
                           nombre varchar(255) NOT NULL,
                           puesto varchar(255) NOT NULL
);

-- data.sql
INSERT INTO empleados (nombre, email, puesto) VALUES('test1', '@test1.com', 'puesto1');
INSERT INTO empleados (nombre, email, puesto) VALUES('test2', '@test2.com', 'puesto2');
INSERT INTO empleados (nombre, email, puesto) VALUES('test3', '@test3.com', 'puesto3');
INSERT INTO empleados (nombre, email, puesto) VALUES('test4', '@test4.com', 'puesto4');