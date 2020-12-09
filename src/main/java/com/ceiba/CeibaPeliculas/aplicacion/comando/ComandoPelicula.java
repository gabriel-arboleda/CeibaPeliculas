package com.ceiba.CeibaPeliculas.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComandoPelicula {

    private Long idPelicula;
    private String nombrePelicula;
    private String genero;
}
