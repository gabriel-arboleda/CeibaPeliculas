package com.ceiba.CeibaPeliculas.aplicacion.manejador.cliente;

import com.ceiba.CeibaPeliculas.aplicacion.manejador.ManejadorComando;
import com.ceiba.CeibaPeliculas.dominio.servicio.cliente.EliminarClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorEliminarCliente implements ManejadorComando<Long> {

    private final EliminarClienteServicio clienteServicio;

    @Override
    public void ejecutar(Long docIdentidad) {
        this.clienteServicio.eliminarCliente(docIdentidad);
    }
}
