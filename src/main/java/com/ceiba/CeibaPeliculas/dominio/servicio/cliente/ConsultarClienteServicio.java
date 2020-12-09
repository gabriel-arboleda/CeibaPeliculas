package com.ceiba.CeibaPeliculas.dominio.servicio.cliente;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio.RepositorioCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultarClienteServicio {

    private final RepositorioCliente repositorioCliente;

    public List<Cliente> consultarClientes() {
        return this.repositorioCliente.consultarCliente();
    }
}
