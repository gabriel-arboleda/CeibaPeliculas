package com.ceiba.CeibaPeliculas.dominio.repositorio;

import com.ceiba.CeibaPeliculas.dominio.modelo.Prestamo;

import java.util.List;

public interface IRepositorioPrestamo {

    boolean exitePrestamoPelicula( Long idPelicula );
    List<Prestamo> consultarPrestamoPorCliente( Long idCliente );
    List<Prestamo> consultarPrestamoPorId( Long idPrestamo );
    Prestamo guardarPrestamo( Prestamo prestamo );
    void eliminarPrestamos( Long idPrestamo );

}
