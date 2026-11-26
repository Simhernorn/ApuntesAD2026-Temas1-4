CREATE DATABASE IF NOT EXISTS acceso_datos;
USE acceso_datos;

CREATE TABLE IF NOT EXISTS articulos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    imagen LONGBLOB,
    descripcion VARCHAR(255)
);

DROP PROCEDURE IF EXISTS contar_articulos;
DELIMITER $$
CREATE PROCEDURE contar_articulos(OUT cantidad INT)
BEGIN
    SELECT COUNT(*) INTO cantidad FROM articulos;
END$$
DELIMITER ;

DROP FUNCTION IF EXISTS precio_mas_alto;
DELIMITER $$
CREATE FUNCTION precio_mas_alto()
RETURNS DECIMAL(10, 2)
READS SQL DATA
BEGIN
    DECLARE precio_maximo DECIMAL(10, 2);
    SELECT MAX(precio) INTO precio_maximo FROM articulos;
    RETURN precio_maximo;
END$$
DELIMITER ;
