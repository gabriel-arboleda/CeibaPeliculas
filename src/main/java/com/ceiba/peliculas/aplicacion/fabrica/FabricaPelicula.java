package com.ceiba.peliculas.aplicacion.fabrica;

import com.ceiba.peliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.peliculas.dominio.modelo.Pelicula;

import java.util.ArrayList;

public class FabricaPelicula {

    public static Pelicula crearPelicula(ComandoPelicula comandoPelicula) {
        return Pelicula.builder()
                .conIdPelicula(comandoPelicula.getIdPelicula())
                .conNombrePelicula(comandoPelicula.getNombrePelicula())
                .conGenero(comandoPelicula.getGenero())
                .conListaPrestamo(new ArrayList<>())
                .build();
    }

}
