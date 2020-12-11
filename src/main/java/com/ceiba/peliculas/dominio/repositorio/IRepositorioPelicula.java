package com.ceiba.peliculas.dominio.repositorio;

import com.ceiba.peliculas.infraestructura.modelo.PeliculaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioPelicula extends JpaRepository<PeliculaEntidad, Long>{}