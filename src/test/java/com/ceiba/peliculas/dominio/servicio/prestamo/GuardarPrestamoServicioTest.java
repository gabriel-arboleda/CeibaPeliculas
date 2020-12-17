package com.ceiba.peliculas.dominio.servicio.prestamo;

import com.ceiba.peliculas.dominio.excepcion.ErrorFechaEntregaMaximaExcepcion;
import com.ceiba.peliculas.dominio.excepcion.ErrorMaximoPrestamoExcepcion;
import com.ceiba.peliculas.dominio.excepcion.ErrorPeliculaPrestadaExcepcion;
import com.ceiba.peliculas.dominio.modelo.Prestamo;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPrestamo;
import com.ceiba.peliculas.infraestructura.mockFactory.PrestamoFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo();

        Mockito.when(repositorioPrestamo.consultarPrestamosPorCliente(anyLong())).thenReturn(listaPrestamos);
        Mockito.doReturn(5000L).when(spyGuardarPrestamoServicio).calcularValorPrestamo(any(Prestamo.class));
        Mockito.doReturn(5000L).when(spyGuardarPrestamoServicio).aplicarDescuentos(anyListOf(Prestamo.class),any(Prestamo.class));
        Mockito.when(repositorioPrestamo.guardarPrestamo(any(Prestamo.class))).thenReturn(prestamo);

        Prestamo PrestamoCreado = spyGuardarPrestamoServicio.guardarPrestamo(prestamo);

        assertEquals(prestamo, PrestamoCreado);
        verify(repositorioPrestamo).consultarPrestamosPorCliente(anyLong());
        verify(spyGuardarPrestamoServicio).calcularValorPrestamo(any(Prestamo.class));
        verify(spyGuardarPrestamoServicio).aplicarDescuentos(anyListOf(Prestamo.class),any(Prestamo.class));
        verify(repositorioPrestamo).guardarPrestamo(any(Prestamo.class));
    }

    @Test
    public void peliculaPrestadaTest(){
        long idPelicula = 1L;

        Mockito.when(repositorioPrestamo.existePrestamoPorPelicula(anyLong())).thenReturn(true);

        try {
            spyGuardarPrestamoServicio.peliculaPrestada(idPelicula);
        } catch (Exception error){
            assertTrue(error instanceof ErrorPeliculaPrestadaExcepcion);
            assertEquals(GuardarPrestamoServicio.ERROR_PELICULA_PRESTADA, error.getMessage());
        }
        verify(repositorioPrestamo).existePrestamoPorPelicula(anyLong());

    }

    @Test
    public void maximoPrestamoTest(){
        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo();

        Mockito.doReturn(50L).when(spyGuardarPrestamoServicio).obtenerNumeroPrestamosVigentes(anyListOf(Prestamo.class));

        try {
            spyGuardarPrestamoServicio.maximoPrestamo(listaPrestamos);
        } catch (Exception error){
            assertTrue(error instanceof ErrorMaximoPrestamoExcepcion);
            assertEquals(GuardarPrestamoServicio.ERROR_MAXIMO_PRESTAMO, error.getMessage());
        }
        verify(spyGuardarPrestamoServicio).maximoPrestamo(anyListOf(Prestamo.class));
    }

    @Test
    public void validarFechaEntregaMaxima(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(prestamo.getFechaPrestamo());
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date fechaEntrega = calendar.getTime();

        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo(16);

        try {
            spyGuardarPrestamoServicio.validarFechaEntregaMaxima(listaPrestamos, prestamo);
        } catch (Exception error){
            assertTrue(error instanceof ErrorFechaEntregaMaximaExcepcion);
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
        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo(31);
        long valorPrestamoEsperado = 4000L;

        long valorPrestamo = spyGuardarPrestamoServicio.aplicarDescuentos(listaPrestamos,prestamo);

        assertEquals(valorPrestamo, valorPrestamoEsperado);
    }

    @Test
    public void aplicarDescuentos10porcientoTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo(16);
        long valorPrestamoEsperado = 4500L;

        long valorPrestamo = spyGuardarPrestamoServicio.aplicarDescuentos(listaPrestamos,prestamo);

        assertEquals(valorPrestamo, valorPrestamoEsperado);
    }

    @Test
    public void noAplicarDescuentosTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo();
        long valorPrestamoEsperado = 5000L;

        long valorPrestamo = spyGuardarPrestamoServicio.aplicarDescuentos(listaPrestamos,prestamo);

        assertEquals(valorPrestamo, valorPrestamoEsperado);
    }
}
