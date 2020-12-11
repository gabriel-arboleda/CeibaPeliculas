package com.ceiba.CeibaPeliculas.dominio.servicio.pelicula;

import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioPelicula;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.TransformadorPelicula;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.PeliculaEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuardarPeliculaServicio {

    private final IRepositorioPelicula repositorioPelicula;

    public Pelicula guardarPelicula(Pelicula pelicula) {
        PeliculaEntidad peliculaEntidad = TransformadorPelicula.mapToPeliculaEntidad(pelicula);
        return TransformadorPelicula.mapToPeliculaModelo(repositorioPelicula.saveAndFlush(peliculaEntidad));
    }
}
