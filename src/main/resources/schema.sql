-- schema.sql
DROP TABLE IF EXISTS empleados;
CREATE TABLE empleados (
                           emp_id SERIAL PRIMARY KEY NOT NULL,
                           email varchar(255) NOT NULL,
                           nombre varchar(255) NOT NULL,
                           puesto varchar(255) NOT NULL
);
