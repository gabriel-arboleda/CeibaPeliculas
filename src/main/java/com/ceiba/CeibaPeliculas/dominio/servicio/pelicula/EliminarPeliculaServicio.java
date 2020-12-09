package com.ceiba.CeibaPeliculas.dominio.servicio.pelicula;

import com.ceiba.CeibaPeliculas.dominio.excepcion.ExistenciaPeliculaExcepcion;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio.RepositorioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarPeliculaServicio {

    private final RepositorioPelicula repositorioPelicula;
    private static final String ERROR_NO_EXISTE_PELICULA = "No existe la pelicula";

    public void eliminarPelicula( Long idPelicula) {
        existePelicula(idPelicula);
        repositorioPelicula.eliminarPeliculaPorId(idPelicula);
    }

    public void existePelicula(Long idPelicula) {
        Boolean exitePelicula = repositorioPelicula.exitePelicula(idPelicula);
        if (!exitePelicula)
            throw new ExistenciaPeliculaExcepcion(ERROR_NO_EXISTE_PELICULA);
    }
}
