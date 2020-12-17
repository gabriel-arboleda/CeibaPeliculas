package com.ceiba.peliculas.dominio.servicio.prestamo;

import com.ceiba.peliculas.dominio.excepcion.ExistenciaPrestamoExcepcion;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPrestamo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class EliminarPrestamoServicioTest {

    private EliminarPrestamoServicio spyEliminarPrestamoServicio;
    private IRepositorioPrestamo repositorioPrestamo;

    @Before
    public void before(){
        repositorioPrestamo = Mockito.mock(IRepositorioPrestamo.class);
        spyEliminarPrestamoServicio = Mockito.spy(new EliminarPrestamoServicio(repositorioPrestamo));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noExitePrestamoTest(){
        long idPrestamo = 1L;

        Mockito.when(repositorioPrestamo.existePrestamo(anyLong())).thenReturn(false);

        try {
            spyEliminarPrestamoServicio.existePrestamo(idPrestamo);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPrestamoExcepcion);
            assertEquals(EliminarPrestamoServicio.ERROR_NO_EXISTE_PRESTAMO, error.getMessage());
        }

        verify(repositorioPrestamo).existePrestamo(anyLong());
    }

}
