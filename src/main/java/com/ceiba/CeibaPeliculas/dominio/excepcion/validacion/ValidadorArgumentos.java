package com.ceiba.CeibaPeliculas.dominio.excepcion.validacion;

import com.ceiba.CeibaPeliculas.dominio.excepcion.ValorObligatorioExcepcion;

public final class ValidadorArgumentos {

    private ValidadorArgumentos() { }

    public static void validarObligatorio(Object argumento, String mensajeError) {
        if (argumento == null || "".equals(argumento)) {
            throw new ValorObligatorioExcepcion(mensajeError);
        }
    }
}
