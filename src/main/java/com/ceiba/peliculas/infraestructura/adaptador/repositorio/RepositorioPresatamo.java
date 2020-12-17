package com.ceiba.peliculas.infraestructura.adaptador.repositorio;

import com.ceiba.peliculas.dominio.modelo.Prestamo;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPrestamo;
import com.ceiba.peliculas.infraestructura.adaptador.transformador.TransformadorPrestamo;
import com.ceiba.peliculas.infraestructura.modelo.PrestamoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPresatamo extends JpaRepository<PrestamoEntidad, Long>, IRepositorioPrestamo {

    @Override
    default boolean existePrestamo(Long idPrestamo) {
        return existsById(idPrestamo);
    }

    @Override
    default boolean existePrestamoPorPelicula(Long idPelicula) {
        return existsByPeliculaEntidadIdPelicula(idPelicula);
    }

    @Override
    default List<Prestamo> consultarPrestamosPorCliente(Long docIdentidad) {
        return TransformadorPrestamo.mapToListaPrestamo(findAllByClienteEntidadDocIdentidad(docIdentidad));
    }

    @Override
    default Prestamo guardarPrestamo(Prestamo prestamo) {
        PrestamoEntidad prestamoEntidad = TransformadorPrestamo.mapToPrestamoEntidad(prestamo);
        return TransformadorPrestamo.mapToPrestamoModelo(saveAndFlush(prestamoEntidad));
    }

    @Override
    default void eliminarPrestamo(Long idPrestamo) {
        deleteById(idPrestamo);
    }

    boolean existsByPeliculaEntidadIdPelicula( Long idPelicula );
    List<PrestamoEntidad> findAllByClienteEntidadDocIdentidad(Long docIdentidad);
}
