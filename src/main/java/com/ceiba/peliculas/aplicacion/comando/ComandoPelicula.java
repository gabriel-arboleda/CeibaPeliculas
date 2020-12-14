package com.ceiba.peliculas.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ComandoPelicula {

    private Long idPelicula;
    private String nombrePelicula;
    private String genero;
}
