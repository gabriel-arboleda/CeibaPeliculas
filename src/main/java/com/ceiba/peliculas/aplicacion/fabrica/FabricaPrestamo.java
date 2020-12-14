package com.ceiba.peliculas.aplicacion.fabrica;

import com.ceiba.peliculas.aplicacion.comando.ComandoPrestamo;
import com.ceiba.peliculas.dominio.modelo.Prestamo;

import java.util.Date;

public class FabricaPrestamo {

    public static Prestamo crearPrestamo(ComandoPrestamo comandoPrestamo ) {
        return Prestamo.builder()
                .conFechaPrestamo(new Date())
                .conFechaDevolucion(comandoPrestamo.getFechaDevolucion())
                .conCliente(FabricaCliente.crearCliente(comandoPrestamo.getCliente()))
                .conPelicula(FabricaPelicula.crearPelicula(comandoPrestamo.getPelicula()))
                .build();
    }
}
