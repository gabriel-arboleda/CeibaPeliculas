package com.ceiba.CeibaPeliculas.aplicacion.manejador.prestamo;

import com.ceiba.CeibaPeliculas.aplicacion.comando.ComandoPrestamo;
import com.ceiba.CeibaPeliculas.aplicacion.fabrica.FabricaPrestamo;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.CeibaPeliculas.dominio.modelo.Prestamo;
import com.ceiba.CeibaPeliculas.dominio.servicio.prestamo.GuardarPrestamoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorGuardarPrestamo implements ManejadorComandoRespuesta<Prestamo, ComandoPrestamo> {

    private final GuardarPrestamoServicio guardarPrestamoServicio;

    @Override
    public Prestamo ejecutar(ComandoPrestamo comando) {
        Prestamo prestamo = FabricaPrestamo.crearPrestamo(comando);
        return this.guardarPrestamoServicio.guardarPrestamo(prestamo);
    }
}
