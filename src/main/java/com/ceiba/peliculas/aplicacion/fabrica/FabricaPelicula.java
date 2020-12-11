package com.ceiba.peliculas.aplicacion.fabrica;

import com.ceiba.peliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.peliculas.dominio.modelo.Pelicula;

public class FabricaPelicula {

    public FabricaPelicula() {
    }

    public static Pelicula crearPelicula(ComandoPelicula comandoPelicula) {
        return Pelicula.builder()
                .conIdPelicula(comandoPelicula.getIdPelicula())
                .conNombrePelicula(comandoPelicula.getNombrePelicula())
                .conGenero(comandoPelicula.getGenero())
                .build();
    }

}
