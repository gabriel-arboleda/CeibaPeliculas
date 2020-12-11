package com.ceiba.CeibaPeliculas.infraestructura.adaptador;

import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.PeliculaEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TransformadorPelicula {

    public TransformadorPelicula() {
    }

    public static Pelicula mapToPeliculaModelo(PeliculaEntidad peliculaEntidad ) {
        return Pelicula.builder()
                .conIdPelicula(peliculaEntidad.getIdPelicula())
                .conNombrePelicula(peliculaEntidad.getNombrePelicula())
                .conGenero(peliculaEntidad.getGenero())
                .conListaPrestamo( TransformadorPrestamo.mapToListaPrestamo(peliculaEntidad.getListaPrestamos()))
                .build();
    }

    public static Pelicula mapToPeliculaModeloSinPrestamo(PeliculaEntidad peliculaEntidad ) {
        return Pelicula.builder()
                .conIdPelicula(peliculaEntidad.getIdPelicula())
                .conNombrePelicula(peliculaEntidad.getNombrePelicula())
                .conGenero(peliculaEntidad.getGenero())
                .build();
    }

    public static PeliculaEntidad mapToPeliculaEntidad(Pelicula pelicula) {
        return PeliculaEntidad.builder()
                .conIdPelicula(pelicula.getIdPelicula())
                .conNombrePelicula(pelicula.getNombrePelicula())
                .conGenero(pelicula.getGenero())
                .conListaPrestamos(new ArrayList<>())
                .build();
    }

    public static List<Pelicula> mapToListaPeliculaModelo( List<PeliculaEntidad> peliculas) {
        return peliculas.stream().map(TransformadorPelicula::mapToPeliculaModelo).collect(Collectors.toList());
    }

}
