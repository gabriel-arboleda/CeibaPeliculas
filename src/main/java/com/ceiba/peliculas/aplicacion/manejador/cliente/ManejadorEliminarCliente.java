package com.ceiba.peliculas.aplicacion.manejador.cliente;

import com.ceiba.peliculas.aplicacion.manejador.ManejadorComando;
import com.ceiba.peliculas.dominio.servicio.cliente.EliminarClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorEliminarCliente implements ManejadorComando<Long> {

    private final EliminarClienteServicio eliminarClienteServicio;

    @Override
    public void ejecutar(Long docIdentidad) {
        this.eliminarClienteServicio.eliminarCliente(docIdentidad);
    }
}
