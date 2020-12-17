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
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.never;
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
    public void guardarPrestamoExitoTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo();

        Mockito.when(repositorioPrestamo.consultarPrestamosPorCliente(anyLong())).thenReturn(listaPrestamos);
        Mockito.when(repositorioPrestamo.guardarPrestamo(any(Prestamo.class))).thenReturn(prestamo);
        Mockito.when(repositorioPrestamo.existePrestamoPorPelicula(anyLong())).thenReturn(false);

        Prestamo PrestamoCreado = spyGuardarPrestamoServicio.guardarPrestamo(prestamo);

        assertEquals(prestamo, PrestamoCreado);
        verify(repositorioPrestamo).consultarPrestamosPorCliente(anyLong());
        verify(repositorioPrestamo).guardarPrestamo(any(Prestamo.class));
        verify(repositorioPrestamo).existePrestamoPorPelicula(anyLong());
    }

    @Test
    public void guardarPrestamoErrorPeliculaPrestadaTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo();

        Mockito.when(repositorioPrestamo.consultarPrestamosPorCliente(anyLong())).thenReturn(listaPrestamos);
        Mockito.when(repositorioPrestamo.guardarPrestamo(any(Prestamo.class))).thenReturn(prestamo);
        Mockito.when(repositorioPrestamo.existePrestamoPorPelicula(anyLong())).thenReturn(true);

        try {
            spyGuardarPrestamoServicio.guardarPrestamo(prestamo);
        } catch (Exception error){
            assertTrue(error instanceof ErrorPeliculaPrestadaExcepcion);
            assertEquals(GuardarPrestamoServicio.ERROR_PELICULA_PRESTADA, error.getMessage());
        }

        verify(repositorioPrestamo).consultarPrestamosPorCliente(anyLong());
        verify(repositorioPrestamo, never()).guardarPrestamo(any(Prestamo.class));
        verify(repositorioPrestamo).existePrestamoPorPelicula(anyLong());
    }

    @Test
    public void guardarPrestamoErrorFechaMaximoEntregaTest(){
        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo(40);

        Mockito.when(repositorioPrestamo.consultarPrestamosPorCliente(anyLong())).thenReturn(listaPrestamos);
        Mockito.when(repositorioPrestamo.guardarPrestamo(any(Prestamo.class))).thenReturn(prestamo);
        Mockito.when(repositorioPrestamo.existePrestamoPorPelicula(anyLong())).thenReturn(false);

        try {
            spyGuardarPrestamoServicio.guardarPrestamo(prestamo);
        } catch (Exception error){
            assertTrue(error instanceof ErrorFechaEntregaMaximaExcepcion);
        }

        verify(repositorioPrestamo).consultarPrestamosPorCliente(anyLong());
        verify(repositorioPrestamo, never()).guardarPrestamo(any(Prestamo.class));
        verify(repositorioPrestamo).existePrestamoPorPelicula(anyLong());
    }

//    @Test
//    public void guardarPrestamoErrorMaximoPrestamosTest(){
//        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
//        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo(40);
//
//        Mockito.when(repositorioPrestamo.consultarPrestamosPorCliente(anyLong())).thenReturn(listaPrestamos);
//        Mockito.when(repositorioPrestamo.guardarPrestamo(any(Prestamo.class))).thenReturn(prestamo);
//        Mockito.when(repositorioPrestamo.existePrestamoPorPelicula(anyLong())).thenReturn(false);
//
//        try {
//            spyGuardarPrestamoServicio.guardarPrestamo(prestamo);
//        } catch (Exception error){
//            assertTrue(error instanceof ErrorFechaEntregaMaximaExcepcion);
//            assertEquals(GuardarPrestamoServicio.ERROR_FECHA_MAXIMA_ENTREGA, error.getMessage());
//        }
//
//        verify(repositorioPrestamo).consultarPrestamosPorCliente(anyLong());
//        verify(repositorioPrestamo, never()).guardarPrestamo(any(Prestamo.class));
//        verify(repositorioPrestamo).existePrestamoPorPelicula(anyLong());
//    }

//
//    @Test
//    public void maximoPrestamoTest(){
//        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo();
//
//        Mockito.doReturn(50L).when(spyGuardarPrestamoServicio).obtenerNumeroPrestamosVigentes(anyListOf(Prestamo.class));
//
//        try {
//            spyGuardarPrestamoServicio.maximoPrestamo(listaPrestamos);
//        } catch (Exception error){
//            assertTrue(error instanceof ErrorMaximoPrestamoExcepcion);
//            assertEquals(GuardarPrestamoServicio.ERROR_MAXIMO_PRESTAMO, error.getMessage());
//        }
//        verify(spyGuardarPrestamoServicio).maximoPrestamo(anyListOf(Prestamo.class));
//    }
//
//
//
//    @Test
//    public void aplicarDescuentos20porcientoTest(){
//        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
//        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo(31);
//        long valorPrestamoEsperado = 4000L;
//
//        long valorPrestamo = spyGuardarPrestamoServicio.aplicarDescuentos(listaPrestamos,prestamo);
//
//        assertEquals(valorPrestamo, valorPrestamoEsperado);
//    }
//
//    @Test
//    public void aplicarDescuentos10porcientoTest(){
//        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
//        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo(16);
//        long valorPrestamoEsperado = 4500L;
//
//        long valorPrestamo = spyGuardarPrestamoServicio.aplicarDescuentos(listaPrestamos,prestamo);
//
//        assertEquals(valorPrestamo, valorPrestamoEsperado);
//    }
//
//    @Test
//    public void noAplicarDescuentosTest(){
//        Prestamo prestamo = new PrestamoFactory().buildPrestamo();
//        List<Prestamo> listaPrestamos = new PrestamoFactory().buildListaPrestamoModelo();
//        long valorPrestamoEsperado = 5000L;
//
//        long valorPrestamo = spyGuardarPrestamoServicio.aplicarDescuentos(listaPrestamos,prestamo);
//
//        assertEquals(valorPrestamo, valorPrestamoEsperado);
//    }
}
