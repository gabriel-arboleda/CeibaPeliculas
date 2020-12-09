package com.ceiba.CeibaPeliculas.dominio.servicio.pelicula;

import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio.RepositorioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultarPeliculaServicio {

    private final RepositorioPelicula repositorioPelicula;

    public List<Pelicula> consultarPeliculas() {
        return this.repositorioPelicula.consultarPelicula();
    }
}
