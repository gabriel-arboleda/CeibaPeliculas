package com.ceiba.peliculas.dominio.excepcion.validacion;

import com.ceiba.peliculas.dominio.excepcion.ValorObligatorioExcepcion;
import com.ceiba.peliculas.dominio.modelo.Cliente;
import org.junit.Assert;
import org.junit.Test;

public class ValidarArgumentosTest {

    @Test
    public void validarObligatorioNombreVacio() {
        String nombresPrueba = "";
        try {
            ValidadorArgumentos.validarObligatorio(nombresPrueba, Cliente.NOMBRES_OBLIGATIRIOS);
        } catch (Exception error) {
            Assert.assertTrue(error instanceof ValorObligatorioExcepcion);
            Assert.assertEquals(Cliente.NOMBRES_OBLIGATIRIOS, error.getMessage());
        }
    }

    @Test
    public void validarObligatorioNombreNoExiste() {
        try {
            ValidadorArgumentos.validarObligatorio(null, Cliente.NOMBRES_OBLIGATIRIOS);
        } catch (Exception error) {
            Assert.assertTrue(error instanceof ValorObligatorioExcepcion);
            Assert.assertEquals(Cliente.NOMBRES_OBLIGATIRIOS, error.getMessage());
        }
    }

}
