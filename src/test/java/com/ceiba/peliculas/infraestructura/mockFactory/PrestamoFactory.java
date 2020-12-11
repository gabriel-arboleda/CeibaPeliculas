package com.ceiba.peliculas.infraestructura.mockFactory;

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

    public List<PrestamoEntidad> buildListaPrestamoEntidad(){
        List<PrestamoEntidad> listaPrestamos = new ArrayList<>();
        listaPrestamos.add(buildPrestamoEntidad());
        return listaPrestamos;
    }

    public List<PrestamoEntidad> buildListaPrestamoEntidad(int numeroPrestamos){
        List<PrestamoEntidad> listaPrestamos = new ArrayList<>();
        int i = 0;
        while ( i < numeroPrestamos){
            listaPrestamos.add(buildPrestamoEntidad());
            i++;
        }
        return listaPrestamos;
    }

}
