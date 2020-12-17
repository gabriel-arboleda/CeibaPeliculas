package com.ceiba.peliculas.dominio.excepcion;

public class ErrorPeliculaPrestadaExcepcion extends RuntimeException {

    public ErrorPeliculaPrestadaExcepcion(String message) {
        super(message);
    }
}
