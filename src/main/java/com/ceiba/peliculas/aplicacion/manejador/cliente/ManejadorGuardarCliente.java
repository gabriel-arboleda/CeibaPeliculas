package com.ceiba.peliculas.aplicacion.manejador.cliente;

import com.ceiba.peliculas.aplicacion.comando.ComandoCliente;
import com.ceiba.peliculas.aplicacion.fabrica.FabricaCliente;
import com.ceiba.peliculas.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.peliculas.dominio.modelo.Cliente;
import com.ceiba.peliculas.dominio.servicio.cliente.GuardarClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorGuardarCliente implements ManejadorComandoRespuesta<Cliente, ComandoCliente> {

    private final GuardarClienteServicio guardarClienteServicio;

    @Override
    public Cliente ejecutar(ComandoCliente comando) {
        Cliente cliente = FabricaCliente.crearCliente(comando);
        return this.guardarClienteServicio.guardarCliente(cliente);
    }
}
