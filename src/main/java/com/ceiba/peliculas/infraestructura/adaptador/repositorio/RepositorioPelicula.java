package com.ceiba.peliculas.infraestructura.adaptador.repositorio;

import com.ceiba.peliculas.dominio.modelo.Pelicula;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPelicula;
import com.ceiba.peliculas.infraestructura.adaptador.transformador.TransformadorPelicula;
import com.ceiba.peliculas.infraestructura.modelo.PeliculaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPelicula extends JpaRepository<PeliculaEntidad, Long>, IRepositorioPelicula {

    @Override
    default boolean existePelicula(Long idPelicula) {
        return existsById(idPelicula);
    }

    @Override
    default List<Pelicula> consultarPelicula() {
        return TransformadorPelicula.mapToListaPeliculaModelo(findAll());
    }

    @Override
    default Pelicula guardarPelicula(Pelicula pelicula) {
        PeliculaEntidad peliculaEntidad = TransformadorPelicula.mapToPeliculaEntidad(pelicula);
        return TransformadorPelicula.mapToPeliculaModelo(saveAndFlush(peliculaEntidad));
    }

    @Override
    default void eliminarPelicula(Long idPelicula) {
        deleteById(idPelicula);
    }
}
