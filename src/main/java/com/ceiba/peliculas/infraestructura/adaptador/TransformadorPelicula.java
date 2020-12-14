package com.ceiba.peliculas.infraestructura.adaptador;

import com.ceiba.peliculas.dominio.modelo.Pelicula;
import com.ceiba.peliculas.infraestructura.modelo.PeliculaEntidad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TransformadorPelicula {

    public static Pelicula mapToPeliculaModelo(PeliculaEntidad peliculaEntidad ) {
        return Pelicula.builder()
                .conIdPelicula(peliculaEntidad.getIdPelicula())
                .conNombrePelicula(peliculaEntidad.getNombrePelicula())
                .conGenero(peliculaEntidad.getGenero())
                .conListaPrestamo(new ArrayList<>())
                .build();
    }

    public static Pelicula mapToPeliculaModeloSinPrestamo(PeliculaEntidad peliculaEntidad ) {
        return Pelicula.builder()
                .conIdPelicula(peliculaEntidad.getIdPelicula())
                .conNombrePelicula(peliculaEntidad.getNombrePelicula())
                .conGenero(peliculaEntidad.getGenero())
                .conListaPrestamo(new ArrayList<>())
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
