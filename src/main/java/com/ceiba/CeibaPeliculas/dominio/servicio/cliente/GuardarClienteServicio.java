package com.ceiba.CeibaPeliculas.dominio.servicio.cliente;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioCliente;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.TransformadorCliente;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.ClienteEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuardarClienteServicio {

    private final IRepositorioCliente repositorioCliente;

    public Cliente guardarCliente(Cliente cliente) {
        ClienteEntidad clienteEntidad = TransformadorCliente.mapToClienteEntidad(cliente);
        return TransformadorCliente.mapToClienteModelo(repositorioCliente.saveAndFlush(clienteEntidad));
    }

}
