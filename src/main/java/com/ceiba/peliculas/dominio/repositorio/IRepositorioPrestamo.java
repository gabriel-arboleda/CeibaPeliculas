package com.ceiba.peliculas.dominio.repositorio;

import com.ceiba.peliculas.dominio.modelo.Prestamo;
import com.ceiba.peliculas.infraestructura.modelo.PrestamoEntidad;

import java.util.List;

public interface IRepositorioPrestamo {

    boolean existePrestamo(Long idPrestamo);
    boolean existePrestamoPorPelicula(Long idPelicula);
    List<Prestamo> consultarPrestamosPorCliente(Long docIdentidad);
    Prestamo guardarPrestamo(Prestamo prestamo);
    void eliminarPrestamo(Long idPrestamo);
}
