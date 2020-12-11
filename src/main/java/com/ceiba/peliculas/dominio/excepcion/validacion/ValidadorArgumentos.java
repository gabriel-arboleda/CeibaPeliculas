package com.ceiba.peliculas.dominio.excepcion.validacion;

import com.ceiba.peliculas.dominio.excepcion.ValorObligatorioExcepcion;

public final class ValidadorArgumentos {

    private ValidadorArgumentos() { }

    public static void validarObligatorio(Object argumento, String mensajeError) {
        if (argumento == null || "".equals(argumento)) {
            throw new ValorObligatorioExcepcion(mensajeError);
        }
    }
}
