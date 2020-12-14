package com.ceiba.peliculas.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ComandoPrestamo {

    private Date fechaDevolucion;
    private ComandoCliente cliente;
    private ComandoPelicula pelicula;
}
