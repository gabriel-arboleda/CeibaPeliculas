package com.ceiba.CeibaPeliculas.dominio.repositorio;

import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;

import java.util.List;

public interface IRepositorioPelicula {

    boolean exitePelicula( Long idPelicula );
    List<Pelicula> consultarPelicula();
    Pelicula GuardarPelicual(Pelicula pelicula);
    void eliminarPeliculaPorId(Long idPelicula );
}
