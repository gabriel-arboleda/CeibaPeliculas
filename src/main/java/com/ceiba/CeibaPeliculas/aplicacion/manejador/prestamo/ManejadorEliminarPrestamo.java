package com.ceiba.CeibaPeliculas.aplicacion.manejador.prestamo;

import com.ceiba.CeibaPeliculas.aplicacion.manejador.ManejadorComando;
import com.ceiba.CeibaPeliculas.dominio.servicio.prestamo.EliminarPrestamoServicio;
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
