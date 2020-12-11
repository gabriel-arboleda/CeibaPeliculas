package com.ceiba.peliculas.dominio.servicio.pelicula;

import com.ceiba.peliculas.dominio.modelo.Pelicula;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPelicula;
import com.ceiba.peliculas.infraestructura.mockFactory.PeliculaFactory;
import com.ceiba.peliculas.infraestructura.modelo.PeliculaEntidad;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class GuardarPeliculaServicioTest {

    private GuardarPeliculaServicio spyGuardarPeliculaServicio;
    private IRepositorioPelicula repositorioPelicula;

    @Before
    public void before(){
        repositorioPelicula = Mockito.mock(IRepositorioPelicula.class);
        spyGuardarPeliculaServicio = Mockito.spy(new GuardarPeliculaServicio(repositorioPelicula));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void guardarPeliculaTest(){
        Pelicula pelicula = new PeliculaFactory().buildPelicula();
        PeliculaEntidad peliculaEntidad = new PeliculaFactory().buildPeliculaEntidad();

        Mockito.when(repositorioPelicula.saveAndFlush(any(PeliculaEntidad.class))).thenReturn(peliculaEntidad);

        Pelicula peliculaCreada = spyGuardarPeliculaServicio.guardarPelicula(pelicula);

        assertEquals(pelicula,peliculaCreada);
        verify(repositorioPelicula).saveAndFlush(any(PeliculaEntidad.class));
    }

}
