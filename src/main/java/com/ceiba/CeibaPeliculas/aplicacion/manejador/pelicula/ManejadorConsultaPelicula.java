package com.ceiba.CeibaPeliculas.aplicacion.manejador.pelicula;

import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioPelicula;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.TransformadorPelicula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultaPelicula {

    private final IRepositorioPelicula repositorioPelicula;

    public List<Pelicula> ejecutar() {
        return TransformadorPelicula.mapToListaPeliculaModelo(repositorioPelicula.findAll());
    }

}
