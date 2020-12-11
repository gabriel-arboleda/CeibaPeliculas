package com.ceiba.CeibaPeliculas.aplicacion.fabrica;

import com.ceiba.CeibaPeliculas.aplicacion.comando.ComandoPrestamo;
import com.ceiba.CeibaPeliculas.dominio.modelo.Prestamo;

import java.util.Date;

public class FabricaPrestamo {

    public FabricaPrestamo() {
    }

    public static Prestamo crearPrestamo(ComandoPrestamo comandoPrestamo ) {
        return Prestamo.builder()
                .conFechaPrestamo(new Date())
                .conFechaDevolucion(comandoPrestamo.getFechaDevolucion())
                .conCliente(FabricaCliente.crearCliente(comandoPrestamo.getCliente()))
                .conPelicula(FabricaPelicula.crearPelicula(comandoPrestamo.getPelicula()))
                .build();
    }
}
