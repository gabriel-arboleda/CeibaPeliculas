package com.ceiba.peliculas.infraestructura.mockFactory;

import com.ceiba.peliculas.dominio.modelo.Pelicula;
import com.ceiba.peliculas.infraestructura.modelo.PeliculaEntidad;

public class PeliculaFactory {

    private static final Long ID_PELICULA = 1L;
    private static final String NOMBRE_PELICULA = "Matrix";
    private static final String GENERO = "Accion";

    public Pelicula buildPelicula(){
        return Pelicula.builder()
                .conIdPelicula(ID_PELICULA)
                .conNombrePelicula(NOMBRE_PELICULA)
                .conGenero(GENERO)
                .build();
    }

    public PeliculaEntidad buildPeliculaEntidad(){
        return PeliculaEntidad.builder()
                .conIdPelicula(ID_PELICULA)
                .conNombrePelicula(NOMBRE_PELICULA)
                .conGenero(GENERO)
                .build();
    }


}
