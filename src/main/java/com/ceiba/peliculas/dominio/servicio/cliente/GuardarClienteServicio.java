package com.ceiba.peliculas.dominio.servicio.cliente;

import com.ceiba.peliculas.dominio.modelo.Cliente;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GuardarClienteServicio {

    private final IRepositorioCliente repositorioCliente;

    public Cliente guardarCliente(Cliente cliente) {
        return repositorioCliente.guardarCliente(cliente);
    }

}
