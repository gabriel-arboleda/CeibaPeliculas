package com.ceiba.CeibaPeliculas.dominio.excepcion;

public class ErrorNegocioExcepcion extends RuntimeException{

    public ErrorNegocioExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
