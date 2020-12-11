package com.ceiba.CeibaPeliculas.dominio.servicio.prestamo;

import com.ceiba.CeibaPeliculas.dominio.excepcion.ErrorNegocioExcepcion;
import com.ceiba.CeibaPeliculas.dominio.modelo.Prestamo;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioPrestamo;
import com.ceiba.CeibaPeliculas.infraestructura.mockFactory.PrestamoFactory;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.PrestamoEntidad;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class GuardarPrestamoServicioTest {

    private GuardarPrestamoServicio spyGuardarPrestamoServicio;
    private IRepositorioPrestamo repositorioPrestamo;

    @Before
    public void before(){
        repositorioPrestamo = Mockito.mock(IRepositorioPrestamo.class);
        spyGuardarPrestamoServicio = Mockito.spy(new GuardarPrestamoServicio(repositorioPrestamo));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void guardarPrestamoTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        PrestamoEntidad prestamoEntidad = new PrestamoFactory().buildPrestamoEntidad();
        List<PrestamoEntidad> listaPrestamos = new PrestamoFactory().buildListaPrestamoEntidad();

        Mockito.when(repositorioPrestamo.findAllByClienteEntidadDocIdentidad(anyLong())).thenReturn(listaPrestamos);
        Mockito.doReturn(5000L).when(spyGuardarPrestamoServicio).calcularValorPrestamo(any(Prestamo.class));
        Mockito.doReturn(5000L).when(spyGuardarPrestamoServicio).aplicarDescuentos(anyListOf(PrestamoEntidad.class),any(Prestamo.class));
        Mockito.when(repositorioPrestamo.saveAndFlush(any(PrestamoEntidad.class))).thenReturn(prestamoEntidad);

        Prestamo PrestamoCreado = spyGuardarPrestamoServicio.guardarPrestamo(prestamo);

        assertEquals(prestamo, PrestamoCreado);
        verify(repositorioPrestamo).findAllByClienteEntidadDocIdentidad(anyLong());
        verify(spyGuardarPrestamoServicio).calcularValorPrestamo(any(Prestamo.class));
        verify(spyGuardarPrestamoServicio).aplicarDescuentos(anyListOf(PrestamoEntidad.class),any(Prestamo.class));
        verify(repositorioPrestamo).saveAndFlush(any(PrestamoEntidad.class));
    }

    @Test
    public void peliculaPrestadaTest(){
        long idPelicula = 1L;

        Mockito.when(repositorioPrestamo.existsByPeliculaEntidadIdPelicula(anyLong())).thenReturn(true);

        try {
            spyGuardarPrestamoServicio.peliculaPrestada(idPelicula);
        } catch (Exception error){
            assertTrue(error instanceof ErrorNegocioExcepcion);
            assertEquals(GuardarPrestamoServicio.ERROR_PELICULA_PRESTADA, error.getMessage());
        }
        verify(repositorioPrestamo).existsByPeliculaEntidadIdPelicula(anyLong());

    }

    @Test
    public void maximoPrestamoTest(){
        List<PrestamoEntidad> listaPrestamos = new PrestamoFactory().buildListaPrestamoEntidad();

        Mockito.doReturn(50L).when(spyGuardarPrestamoServicio).obtenerNumeroPrestamosVigentes(anyListOf(PrestamoEntidad.class));

        try {
            spyGuardarPrestamoServicio.maximoPrestamo(listaPrestamos);
        } catch (Exception error){
            assertTrue(error instanceof ErrorNegocioExcepcion);
            assertEquals(GuardarPrestamoServicio.ERROR_MAXIMO_PRESTAMO, error.getMessage());
        }
        verify(spyGuardarPrestamoServicio).maximoPrestamo(anyListOf(PrestamoEntidad.class));
    }

    @Test
    public void validarFechaEntregaMaxima(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(prestamo.getFechaPrestamo());
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date fechaEntrega = calendar.getTime();

        List<PrestamoEntidad> listaPrestamos = new PrestamoFactory().buildListaPrestamoEntidad(16);

        try {
            spyGuardarPrestamoServicio.validarFechaEntregaMaxima(listaPrestamos, prestamo);
        } catch (Exception error){
            assertTrue(error instanceof ErrorNegocioExcepcion);
            assertEquals(GuardarPrestamoServicio.ERROR_FECHA_MAXIMA_ENTREGA+fechaEntrega, error.getMessage());
        }

    }

    @Test
    public void calcularValorPrestamoTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        long valorPrestamoEsperado = 9000L;

        long valorPrestamo = spyGuardarPrestamoServicio.calcularValorPrestamo(prestamo);

        assertEquals(valorPrestamo, valorPrestamoEsperado);

    }

    @Test
    public void aplicarDescuentos20porcientoTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        List<PrestamoEntidad> listaPrestamos = new PrestamoFactory().buildListaPrestamoEntidad(31);
        long valorPrestamoEsperado = 4000L;

        long valorPrestamo = spyGuardarPrestamoServicio.aplicarDescuentos(listaPrestamos,prestamo);

        assertEquals(valorPrestamo, valorPrestamoEsperado);
    }

    @Test
    public void aplicarDescuentos10porcientoTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        List<PrestamoEntidad> listaPrestamos = new PrestamoFactory().buildListaPrestamoEntidad(16);
        long valorPrestamoEsperado = 4500L;

        long valorPrestamo = spyGuardarPrestamoServicio.aplicarDescuentos(listaPrestamos,prestamo);

        assertEquals(valorPrestamo, valorPrestamoEsperado);
    }

    @Test
    public void noAplicarDescuentosTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        List<PrestamoEntidad> listaPrestamos = new PrestamoFactory().buildListaPrestamoEntidad();
        long valorPrestamoEsperado = 5000L;

        long valorPrestamo = spyGuardarPrestamoServicio.aplicarDescuentos(listaPrestamos,prestamo);

        assertEquals(valorPrestamo, valorPrestamoEsperado);
    }
}
