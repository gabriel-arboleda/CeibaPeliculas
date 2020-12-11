package com.ceiba.CeibaPeliculas.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ComandoPrestamo {

    private Date fechaDevolucion;
    private ComandoCliente cliente;
    private ComandoPelicula pelicula;
}
