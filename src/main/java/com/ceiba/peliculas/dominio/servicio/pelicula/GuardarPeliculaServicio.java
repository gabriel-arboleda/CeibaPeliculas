package com.ceiba.peliculas.dominio.servicio.pelicula;

import com.ceiba.peliculas.dominio.modelo.Pelicula;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuardarPeliculaServicio {

    private final IRepositorioPelicula repositorioPelicula;

    public Pelicula guardarPelicula(Pelicula pelicula) {
        return repositorioPelicula.guardarPelicula(pelicula);
    }
}
