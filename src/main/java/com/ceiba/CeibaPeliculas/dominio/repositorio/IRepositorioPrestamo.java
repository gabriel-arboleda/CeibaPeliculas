package com.ceiba.CeibaPeliculas.dominio.repositorio;

import com.ceiba.CeibaPeliculas.infraestructura.modelo.PrestamoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioPrestamo extends JpaRepository<PrestamoEntidad, Long> {

    boolean existsByPeliculaEntidadIdPelicula( Long idPelicula );
    List<PrestamoEntidad> findAllByClienteEntidadDocIdentidad( Long docIdentidad );
}
