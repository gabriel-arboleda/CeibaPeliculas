package com.ceiba.CeibaPeliculas.dominio.servicio.prestamo;

import com.ceiba.CeibaPeliculas.dominio.excepcion.ExistenciaPrestamoExcepcion;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioPrestamo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarPrestamoServicio {

    private final IRepositorioPrestamo repositorioPrestamo;
    public static final String ERROR_NO_EXISTE_PRESTAMO = "No existe el prestamo";

    public void eliminarPrestamo( Long idPrestamo ) {
        existePrestamo(idPrestamo);
        repositorioPrestamo.deleteById(idPrestamo);
    }

    public void existePrestamo( Long idPrestamo ) {
        boolean existePrestamo = repositorioPrestamo.existsById( idPrestamo );
        if ( !existePrestamo )
            throw new ExistenciaPrestamoExcepcion(ERROR_NO_EXISTE_PRESTAMO);
    }

}
