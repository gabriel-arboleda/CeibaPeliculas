DELETE FROM DB_CEIBA_RENTA_PELICULA.PRESTAMO;
DELETE FROM DB_CEIBA_RENTA_PELICULA.CLIENTE;
DELETE FROM DB_CEIBA_RENTA_PELICULA.PELICULA;

INSERT INTO DB_CEIBA_RENTA_PELICULA.CLIENTE(DOC_IDENTIDAD,NOMBRES,APELLIDOS) VALUES ( 123, 'gabriel', 'arboleda' );
INSERT INTO DB_CEIBA_RENTA_PELICULA.CLIENTE(DOC_IDENTIDAD,NOMBRES,APELLIDOS) VALUES ( 321, 'andres', 'tolosa' );

INSERT INTO DB_CEIBA_RENTA_PELICULA.PELICULA(ID_PELICULA,NOMBRE_PELICULA,GENERO) VALUES ( 1, 'matrix', 'accion' );
INSERT INTO DB_CEIBA_RENTA_PELICULA.PELICULA(ID_PELICULA,NOMBRE_PELICULA,GENERO) VALUES ( 2, 'avengers', 'accion' );

INSERT INTO DB_CEIBA_RENTA_PELICULA.PRESTAMO(ID_PRESTAMO,FECHA_PRESTAMO,FECHA_DEVOLUCION,VALOR_PRESTAMO,DOC_IDENTIDAD,ID_PELICULA) VALUES ( 1, PARSEDATETIME('14/12/2020', 'dd/MM/yyyy'), PARSEDATETIME('14/08/2021', 'dd/MM/yyyy'), 15000, 123, 1 );