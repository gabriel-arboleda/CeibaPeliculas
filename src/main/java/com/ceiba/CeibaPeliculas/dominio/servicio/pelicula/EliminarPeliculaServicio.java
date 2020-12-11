package com.ceiba.CeibaPeliculas.dominio.servicio.pelicula;

import com.ceiba.CeibaPeliculas.dominio.excepcion.ExistenciaPeliculaExcepcion;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarPeliculaServicio {

    private final IRepositorioPelicula repositorioPelicula;
    private static final String ERROR_NO_EXISTE_PELICULA = "No existe la pelicula";

    public void eliminarPelicula( Long idPelicula) {
        existePelicula(idPelicula);
        repositorioPelicula.deleteById(idPelicula);
    }

    public void existePelicula(Long idPelicula) {
        boolean exitePelicula = repositorioPelicula.existsById(idPelicula);
        if (!exitePelicula)
            throw new ExistenciaPeliculaExcepcion(ERROR_NO_EXISTE_PELICULA);
    }
}
