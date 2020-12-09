package com.ceiba.CeibaPeliculas.aplicacion.fabrica;

import com.ceiba.CeibaPeliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;

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
