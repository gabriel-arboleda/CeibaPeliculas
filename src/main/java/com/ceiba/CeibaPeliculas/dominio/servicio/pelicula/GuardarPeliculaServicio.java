package com.ceiba.CeibaPeliculas.dominio.servicio.pelicula;

import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio.RepositorioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuardarPeliculaServicio {

    private final RepositorioPelicula repositorioPelicula;

    public Pelicula guardarPelicula(Pelicula pelicula) { return repositorioPelicula.GuardarPelicual(pelicula); }
}
