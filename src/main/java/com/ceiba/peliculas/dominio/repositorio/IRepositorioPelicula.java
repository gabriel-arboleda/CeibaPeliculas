package com.ceiba.peliculas.dominio.repositorio;

import com.ceiba.peliculas.dominio.modelo.Pelicula;

import java.util.List;

public interface IRepositorioPelicula {

    boolean existePelicula(Long idPelicula);
    List<Pelicula> consultarPelicula();
    Pelicula guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Long idPelicula);

}