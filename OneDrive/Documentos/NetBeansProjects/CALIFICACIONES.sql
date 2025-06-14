CREATE DATABASE IF NOT EXISTS calificaciones;
USE calificaciones;

-- Eliminar la base de datos si existe (para empezar desde cero)
DROP DATABASE IF EXISTS calificaciones;

-- Crear la base de datos y usarla
CREATE DATABASE calificaciones;
USE calificaciones;

-- Crear la tabla maestro
CREATE TABLE maestro (
    id_maestro INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50)
);

-- Crear la tabla materias
CREATE TABLE materias (
    id_materia INT AUTO_INCREMENT PRIMARY KEY,
    nombre_materia VARCHAR(100),
    horario VARCHAR(50),
    aula VARCHAR(50),
    semestre VARCHAR(20),
    fecha_inicio DATE,
    fecha_fin DATE
);

-- Crear la tabla grupo
CREATE TABLE grupo (
    id_grupo INT AUTO_INCREMENT PRIMARY KEY,
    nombre_grupo VARCHAR(50) NOT NULL
);

-- Crear la tabla tutor
CREATE TABLE tutor (
    id_tutor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    telefono VARCHAR(20),
    email VARCHAR(50)
);

-- Crear la tabla alumno
CREATE TABLE alumno (
    matricula_alumno INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    id_materia INT,
    parcial1 DOUBLE,
    parcial2 DOUBLE,
    parcial3 DOUBLE,
    promedio DOUBLE,
    email VARCHAR(50),
    direccion VARCHAR(50),
    telefono VARCHAR(20),
    localidad VARCHAR(50),
    id_tutor INT,
    FOREIGN KEY (id_materia) REFERENCES materias(id_materia),
    FOREIGN KEY (id_tutor) REFERENCES tutor(id_tutor)
);

-- Crear la tabla usuarios para el sistema de login
CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL
);

-- Insertar un usuario con una contraseña hasheada
INSERT INTO usuarios (nombre_usuario, contraseña)
VALUES ('RYSANGY2', 'sama1505');

-- Crear la tabla alumno_materia
CREATE TABLE alumno_materia (
    matricula_alumno INT,
    id_materia INT,
    PRIMARY KEY (matricula_alumno, id_materia),
    FOREIGN KEY (matricula_alumno) REFERENCES alumno(matricula_alumno),
    FOREIGN KEY (id_materia) REFERENCES materias(id_materia)
);

-- Consultar las tablas
SELECT * FROM grupo;
SELECT * FROM alumno;
SELECT * FROM materias;
SELECT * FROM usuarios;
SELECT * FROM tutor;
SELECT * FROM alumno_materia;

-- Relaciones entre las tablas materias y grupo
ALTER TABLE materias ADD id_grupo INT;
ALTER TABLE materias ADD FOREIGN KEY (id_grupo) REFERENCES grupo(id_grupo);

-- Relaciones entre las tablas alumno y materias, tutor
ALTER TABLE alumno ADD id_materia INT;
ALTER TABLE alumno ADD FOREIGN KEY (id_materia) REFERENCES materias(id_materia);
