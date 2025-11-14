-- script_productos.sql

-- Crear base de datos (si no existe)
CREATE DATABASE IF NOT EXISTS gestion_productos
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE gestion_productos;

-- Eliminar tabla si existe (para poder recrearla limpia)
DROP TABLE IF EXISTS productos;

-- Crear tabla productos
CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    detalle VARCHAR(255),
    cantidad INT NOT NULL,
    precio DOUBLE NOT NULL
);

-- Datos de prueba
INSERT INTO productos (nombre, detalle, cantidad, precio) VALUES
('Café molido', '500g tostado medio', 20, 4500),
('Té verde', 'Caja 20 bolsas', 35, 2500),
('Azúcar rubia', 'Bolsa 1kg', 15, 1800);
