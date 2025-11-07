CREATE TABLE IF NOT EXISTS libros (
  id BIGINT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(200) NOT NULL,
  anio_publicacion INT NOT NULL,
  PRIMARY KEY (id),
  KEY idx_libros_anio (anio_publicacion)
);

-- Tabla autores
CREATE TABLE IF NOT EXISTS autores (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(150) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uq_autores_nombre (nombre)
);

-- Asegurar columna autor_id en libros y FK (seguro para reruns en MySQL 8+)
ALTER TABLE libros
  ADD COLUMN IF NOT EXISTS autor_id BIGINT NULL,
  ADD KEY idx_libros_autor (autor_id);

ALTER TABLE libros
  ADD CONSTRAINT IF NOT EXISTS fk_libros_autor
  FOREIGN KEY (autor_id) REFERENCES autores(id)
  ON DELETE SET NULL ON UPDATE RESTRICT;
