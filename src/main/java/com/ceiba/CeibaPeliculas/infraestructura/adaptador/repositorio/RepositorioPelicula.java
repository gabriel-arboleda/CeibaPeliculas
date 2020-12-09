package com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio;

import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioPelicula;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.transformador.TransformadorPelicula;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.PeliculaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPelicula extends JpaRepository<PeliculaEntidad, Long>, IRepositorioPelicula {

    @Override
    default boolean exitePelicula(Long idPelicula) { return existsById(idPelicula); }

    @Override
    default List<Pelicula> consultarPelicula() { return TransformadorPelicula.mapToListaPeliculaModelo(findAll()); }

    @Override
    default Pelicula GuardarPelicual(Pelicula pelicula) {
        PeliculaEntidad peliculaEntidad = TransformadorPelicula.mapToPeliculaEntidad(pelicula);
        return TransformadorPelicula.mapToPeliculaModelo(saveAndFlush(peliculaEntidad));
    }

    @Override
    default void eliminarPeliculaPorId(Long idPelicula) { deleteById(idPelicula); }
}
