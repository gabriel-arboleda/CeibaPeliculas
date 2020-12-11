package com.ceiba.CeibaPeliculas.dominio.excepcion;

public class ExistenciaPrestamoExcepcion extends RuntimeException {

    public ExistenciaPrestamoExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
