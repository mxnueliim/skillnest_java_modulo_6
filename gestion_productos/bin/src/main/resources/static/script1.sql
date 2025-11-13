use gestion_productos;
select * from personas;

INSERT INTO `gestion_productos`.`departamentos` (`nombre`) VALUES ('contabilidad');
INSERT INTO `gestion_productos`.`departamentos` (`nombre`) VALUES ('informatica');

INSERT INTO `gestion_productos`.`empleados` (`departamento_id`, `nombre`, `puesto`) VALUES ('1', 'Juan', 'Tecnico');
INSERT INTO `gestion_productos`.`empleados` (`departamento_id`, `nombre`, `puesto`) VALUES ('1', 'Ricardo', 'Ingeniero');
INSERT INTO `gestion_productos`.`empleados` (`departamento_id`, `nombre`, `puesto`) VALUES ('2', 'Guido', 'Informatico');

INSERT INTO `gestion_productos`.`cuenta_usuarios` (`empleado_id`, `contrasena`, `nombre_usuario`) VALUES ('1', 'qwerty', 'Juanito');
INSERT INTO `gestion_productos`.`cuenta_usuarios` (`empleado_id`, `contrasena`, `nombre_usuario`) VALUES ('2', 'asdfgh', 'Pipo');
INSERT INTO `gestion_productos`.`cuenta_usuarios` (`empleado_id`, `contrasena`, `nombre_usuario`) VALUES ('3', 'zxcvbn', 'Guido');
