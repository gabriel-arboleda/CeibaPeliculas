package com.ceiba.peliculas.dominio.excepcion;

public class ErrorMaximoPrestamoExcepcion extends RuntimeException{
    public ErrorMaximoPrestamoExcepcion(String message) {
        super(message);
    }
}
