package com.ceiba.peliculas.dominio.servicio.pelicula;

import com.ceiba.peliculas.dominio.excepcion.ExistenciaPeliculaExcepcion;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPelicula;
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
public class EliminarPeliculaServicioTest {

    private EliminarPeliculaServicio spyEliminarPeliculaServicio;
    private IRepositorioPelicula repositorioPelicula;

    @Before
    public void before(){
        repositorioPelicula = Mockito.mock(IRepositorioPelicula.class);
        spyEliminarPeliculaServicio = Mockito.spy(new EliminarPeliculaServicio(repositorioPelicula));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noExitePeliculaTest(){
        long idPelicula = 1L;

        Mockito.when(repositorioPelicula.existePelicula(anyLong())).thenReturn(false);

        try {
            spyEliminarPeliculaServicio.existePelicula(idPelicula);
        } catch (Exception error) {
            assertTrue(error instanceof ExistenciaPeliculaExcepcion);
            assertEquals(EliminarPeliculaServicio.ERROR_NO_EXISTE_PELICULA, error.getMessage());
        }

        verify(repositorioPelicula).existePelicula(anyLong());
    }
}
