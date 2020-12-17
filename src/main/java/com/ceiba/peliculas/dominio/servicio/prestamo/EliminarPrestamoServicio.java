package com.ceiba.peliculas.dominio.servicio.prestamo;

import com.ceiba.peliculas.dominio.excepcion.ExistenciaPrestamoExcepcion;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPrestamo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarPrestamoServicio {

    private final IRepositorioPrestamo repositorioPrestamo;
    public static final String ERROR_NO_EXISTE_PRESTAMO = "No existe el prestamo";

    public void eliminarPrestamo( Long idPrestamo ) {
        existePrestamo(idPrestamo);
        repositorioPrestamo.eliminarPrestamo(idPrestamo);
    }

    public void existePrestamo( Long idPrestamo ) {
        boolean existePrestamo = repositorioPrestamo.existePrestamo( idPrestamo );
        if ( !existePrestamo )
            throw new ExistenciaPrestamoExcepcion(ERROR_NO_EXISTE_PRESTAMO);
    }

}
