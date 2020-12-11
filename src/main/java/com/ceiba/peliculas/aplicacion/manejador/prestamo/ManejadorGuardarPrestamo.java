package com.ceiba.peliculas.aplicacion.manejador.prestamo;

import com.ceiba.peliculas.aplicacion.comando.ComandoPrestamo;
import com.ceiba.peliculas.aplicacion.fabrica.FabricaPrestamo;
import com.ceiba.peliculas.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.peliculas.dominio.modelo.Prestamo;
import com.ceiba.peliculas.dominio.servicio.prestamo.GuardarPrestamoServicio;
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
