package com.ceiba.peliculas.dominio.excepcion;

public class ErrorNegocioExcepcion extends RuntimeException{

    public ErrorNegocioExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
