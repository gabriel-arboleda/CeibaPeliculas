package com.ceiba.CeibaPeliculas.dominio.servicio.cliente;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio.RepositorioCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuardarClienteServicio {

    private final RepositorioCliente repositorioCliente;

    public Cliente guardarCliente(Cliente cliente) { return repositorioCliente.guardarCliente(cliente);}

}
