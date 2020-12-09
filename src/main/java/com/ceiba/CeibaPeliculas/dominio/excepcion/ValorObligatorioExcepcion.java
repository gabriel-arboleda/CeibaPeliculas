package com.ceiba.CeibaPeliculas.dominio.excepcion;

public class ValorObligatorioExcepcion extends RuntimeException {

    public ValorObligatorioExcepcion(String mensajeError) {
        super(mensajeError);
    }
}
