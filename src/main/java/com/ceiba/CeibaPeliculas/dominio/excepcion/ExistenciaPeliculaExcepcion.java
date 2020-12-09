package com.ceiba.CeibaPeliculas.dominio.excepcion;

public class ExistenciaPeliculaExcepcion extends RuntimeException {

    public ExistenciaPeliculaExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
