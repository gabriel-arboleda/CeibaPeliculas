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
import java.util.Date;
import java.util.List;

public class PrestamoFactory {
    private static final Long ID_PRESTAMO = 1L;
    private static final Date FECHA_PRESTAMO = new Date(1607729044846L);
    private static final Date FECHA_DEVOLUCION = new Date(1608181200000L);
    private static final long VALOR_PRESTAMO = 5000L;
    private static final Cliente CLIENTE = new ClienteFactory().buildCliente();
    private static final Pelicula PELICULA = new PeliculaFactory().buildPelicula();
    private static final ClienteEntidad CLIENTE_ENTIDAD = new ClienteFactory().buildClienteEntidad();
    private static final PeliculaEntidad PELICULA_ENTIDAD = new PeliculaFactory().buildPeliculaEntidad();
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

    public PrestamoEntidad buildPrestamoEntidad(){
        return PrestamoEntidad.builder()
                .conIdPrestamo(ID_PRESTAMO)
                .conFechaPrestamo(FECHA_PRESTAMO)
                .conFechaDevolucion(FECHA_DEVOLUCION)
                .conValorPrestamo(VALOR_PRESTAMO)
                .conClienteEntidad(CLIENTE_ENTIDAD)
                .conPeliculaEntidad(PELICULA_ENTIDAD)
                .build();
    }

    public List<Prestamo> buildListaPrestamoModelo(){
        List<Prestamo> listaPrestamos = new ArrayList<>();
        listaPrestamos.add(buildPrestamo());
        return listaPrestamos;
    }

    public List<Prestamo> buildListaPrestamoModelo(int numeroPrestamos){
        List<Prestamo> listaPrestamos = new ArrayList<>();
        int i = 0;
        while ( i < numeroPrestamos){
            listaPrestamos.add(buildPrestamo());
            i++;
        }
        return listaPrestamos;
    }

    public ComandoPrestamo buildComando() {
        return new ComandoPrestamo(FECHA_DEVOLUCION,COMANDO_CLIENTE,COMANDO_PELICULA);
    }

}
