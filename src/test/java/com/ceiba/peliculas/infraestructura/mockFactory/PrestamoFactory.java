package com.ceiba.peliculas.infraestructura.mockFactory;

import com.ceiba.peliculas.aplicacion.comando.ComandoCliente;
import com.ceiba.peliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.peliculas.aplicacion.comando.ComandoPrestamo;
import com.ceiba.peliculas.dominio.modelo.Cliente;
import com.ceiba.peliculas.dominio.modelo.Pelicula;
import com.ceiba.peliculas.dominio.modelo.Prestamo;
import com.ceiba.peliculas.infraestructura.modelo.ClienteEntidad;
import com.ceiba.peliculas.infraestructura.modelo.PeliculaEntidad;
import com.ceiba.peliculas.infraestructura.modelo.PrestamoEntidad;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PrestamoFactory {
    private static final Long ID_PRESTAMO = 1L;
    private static final Date FECHA_PRESTAMO = new Date();
    private static final Date FECHA_DEVOLUCION = new Date();
    private static final long VALOR_PRESTAMO = 5000L;
    private static final Cliente CLIENTE = new ClienteFactory().buildCliente();
    private static final Pelicula PELICULA = new PeliculaFactory().buildPelicula();
    private static final ComandoCliente COMANDO_CLIENTE = new ClienteFactory().buildComando();
    private static final ComandoPelicula COMANDO_PELICULA = new PeliculaFactory().buildComando();

    public Prestamo buildPrestamo(){
        return Prestamo.builder()
                .conIdPrestamo(ID_PRESTAMO)
                .conFechaPrestamo(FECHA_PRESTAMO)
                .conFechaDevolucion(FECHA_DEVOLUCION)
                .conValorPrestamo(VALOR_PRESTAMO)
                .conCliente(CLIENTE)
                .conPelicula(PELICULA)
                .build();
    }

    public Prestamo buildPrestamo(Date fechaPrestamo, Date fechaDevolucion){
        return Prestamo.builder()
                .conIdPrestamo(ID_PRESTAMO)
                .conFechaPrestamo(fechaPrestamo)
                .conFechaDevolucion(fechaDevolucion)
                .conValorPrestamo(VALOR_PRESTAMO)
                .conCliente(CLIENTE)
                .conPelicula(PELICULA)
                .build();
    }

    public List<Prestamo> buildListaPrestamoModelo(){
        List<Prestamo> listaPrestamos = new ArrayList<>();
        listaPrestamos.add(buildPrestamo(FECHA_PRESTAMO,FECHA_DEVOLUCION));
        return listaPrestamos;
    }

    public List<Prestamo> buildListaPrestamoModelo(int numeroPrestamos){
        List<Prestamo> listaPrestamos = new ArrayList<>();
        int i = 0;
        while ( i < numeroPrestamos){
            listaPrestamos.add(buildPrestamo(FECHA_PRESTAMO,FECHA_DEVOLUCION));
            i++;
        }
        return listaPrestamos;
    }

    public List<Prestamo> buildListaPrestamoModeloVigentes(int numeroPrestamos){
        List<Prestamo> listaPrestamos = new ArrayList<>();
        int i = 0;
        while ( i < numeroPrestamos){
            Prestamo prestamo = buildPrestamo(buildFecha(FECHA_PRESTAMO,-1),buildFecha(FECHA_DEVOLUCION,1));
            listaPrestamos.add(prestamo);
            i++;
        }
        return listaPrestamos;
    }

    public Date buildFecha( Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    public ComandoPrestamo buildComando() {
        return new ComandoPrestamo(FECHA_DEVOLUCION,COMANDO_CLIENTE,COMANDO_PELICULA);
    }

}
