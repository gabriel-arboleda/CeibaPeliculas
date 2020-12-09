package com.ceiba.CeibaPeliculas.aplicacion.manejador.cliente;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.dominio.servicio.cliente.ConsultarClienteServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultaCliente {

    private final ConsultarClienteServicio consultarClienteServicio;

    public List<Cliente> ejecutar(){
        return this.consultarClienteServicio.consultarClientes();
    }
}
