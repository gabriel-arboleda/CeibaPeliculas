package com.ceiba.peliculas.aplicacion.manejador.prestamo;

import com.ceiba.peliculas.aplicacion.manejador.ManejadorComando;
import com.ceiba.peliculas.dominio.servicio.prestamo.EliminarPrestamoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorEliminarPrestamo implements ManejadorComando<Long>  {

    private final EliminarPrestamoServicio eliminarPrestamoServicio;

    @Override
    public void ejecutar(Long idPrestamo) {
        this.eliminarPrestamoServicio.eliminarPrestamo( idPrestamo );
    }
}
