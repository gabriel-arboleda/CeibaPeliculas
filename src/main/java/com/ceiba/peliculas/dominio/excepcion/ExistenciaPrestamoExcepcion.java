package com.ceiba.peliculas.dominio.excepcion;

public class ExistenciaPrestamoExcepcion extends RuntimeException {

    public ExistenciaPrestamoExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
