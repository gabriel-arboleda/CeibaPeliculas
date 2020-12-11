package com.ceiba.peliculas.dominio.excepcion;

public class ExistenciaPersonaExcepcion extends RuntimeException {

    public ExistenciaPersonaExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
