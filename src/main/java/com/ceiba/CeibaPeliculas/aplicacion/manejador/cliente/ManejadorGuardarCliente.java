package com.ceiba.CeibaPeliculas.aplicacion.manejador.cliente;

import com.ceiba.CeibaPeliculas.aplicacion.comando.ComandoCliente;
import com.ceiba.CeibaPeliculas.aplicacion.fabrica.FabricaCliente;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.dominio.servicio.cliente.GuardarClienteServicio;
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
