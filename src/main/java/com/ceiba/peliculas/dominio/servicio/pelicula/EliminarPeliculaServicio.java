package com.ceiba.peliculas.dominio.servicio.pelicula;

import com.ceiba.peliculas.dominio.excepcion.ExistenciaPeliculaExcepcion;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarPeliculaServicio {

    private final IRepositorioPelicula repositorioPelicula;
    public static final String ERROR_NO_EXISTE_PELICULA = "No existe la pelicula";

    public void eliminarPelicula( Long idPelicula) {
        existePelicula(idPelicula);
        repositorioPelicula.eliminarPelicula(idPelicula);
    }

    public void existePelicula(Long idPelicula) {
        boolean exitePelicula = repositorioPelicula.existePelicula(idPelicula);
        if (!exitePelicula)
            throw new ExistenciaPeliculaExcepcion(ERROR_NO_EXISTE_PELICULA);
    }
}
