package com.ceiba.peliculas.dominio.excepcion;

public class ValorObligatorioExcepcion extends RuntimeException {

    public ValorObligatorioExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
