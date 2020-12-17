package com.ceiba.peliculas.dominio.servicio.cliente;

import com.ceiba.peliculas.dominio.excepcion.ExistenciaPersonaExcepcion;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioCliente;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class EliminarClienteServicioTest {

    private EliminarClienteServicio spyEliminarClienteServicio;
    private IRepositorioCliente repositorioCliente;

    @Before
    public void before(){
        repositorioCliente = Mockito.mock(IRepositorioCliente.class);
        spyEliminarClienteServicio = Mockito.spy(new EliminarClienteServicio(repositorioCliente));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noExiteClienteTest(){
        long docIdentidad = 1L;

        Mockito.when(repositorioCliente.existeCliente(anyLong())).thenReturn(false);

        try {
            spyEliminarClienteServicio.eliminarCliente(docIdentidad);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPersonaExcepcion);
            assertEquals(EliminarClienteServicio.ERROR_NO_EXISTE_CLIENTE, error.getMessage());
        }

        verify(repositorioCliente).existeCliente(anyLong());
        verify(repositorioCliente, never()).eliminarCliente(anyLong());
    }

    @Test
    public void siExiteClienteTest(){
        long docIdentidad = 1L;

        Mockito.when(repositorioCliente.existeCliente(anyLong())).thenReturn(true);

        try {
            spyEliminarClienteServicio.eliminarCliente(docIdentidad);
        } catch (Exception ignored) {}

        verify(repositorioCliente).existeCliente(anyLong());
        verify(repositorioCliente).eliminarCliente(anyLong());
    }

}
