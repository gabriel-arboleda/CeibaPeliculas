package com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio;

import com.ceiba.CeibaPeliculas.dominio.modelo.Prestamo;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioPrestamo;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.transformador.TransformadorPrestamo;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.PrestamoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPrestamo extends JpaRepository<PrestamoEntidad, Long>, IRepositorioPrestamo {

    @Override
    default boolean exitePrestamoPelicula(Long idPelicula) {
        //consultar si la pelicula ya esta prestada
        return false;
    }

    @Override
    default List<Prestamo> consultarPrestamoPorCliente(Long idCliente) {
        return null;
    }

    @Override
    default List<Prestamo> consultarPrestamoPorId(Long idPrestamo) {
        return TransformadorPrestamo.mapToListaPrestamo(findAll());
    }

    @Override
    default Prestamo guardarPrestamo(Prestamo prestamo) {
        PrestamoEntidad prestamoEntidad = TransformadorPrestamo.mapToPrestamoEntidad(prestamo);
        return TransformadorPrestamo.mapToPrestamoModelo(saveAndFlush(prestamoEntidad));
    }

    @Override
    default void eliminarPrestamos(Long idPrestamo) {
        deleteById(idPrestamo);
    }
}
