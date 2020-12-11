package com.ceiba.peliculas.dominio.excepcion;

public class ExistenciaPeliculaExcepcion extends RuntimeException {

    public ExistenciaPeliculaExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
