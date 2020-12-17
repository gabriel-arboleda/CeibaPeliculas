package com.ceiba.peliculas.dominio.excepcion;

public class ErrorFechaEntregaMaximaExcepcion extends RuntimeException {
    public ErrorFechaEntregaMaximaExcepcion(String message) {
        super(message);
    }
}
