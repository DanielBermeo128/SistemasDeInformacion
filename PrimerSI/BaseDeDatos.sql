CREATE DATABASE  IF NOT EXISTS nombres;
USE nombres;

CREATE TABLE datos(
	id_nombre	 	INTEGER NOT NULL AUTO_INCREMENT,
	nombre 	 	VARCHAR(30) NOT NULL,
	incidencias 	INTEGER NOT NULL,
	
PRIMARY KEY(id_nombre)
);