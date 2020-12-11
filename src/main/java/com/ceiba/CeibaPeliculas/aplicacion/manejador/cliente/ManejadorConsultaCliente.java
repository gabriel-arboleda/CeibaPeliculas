package com.ceiba.CeibaPeliculas.aplicacion.manejador.cliente;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioCliente;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.TransformadorCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultaCliente {

    private final IRepositorioCliente repositorioCliente;

    public List<Cliente> ejecutar(){
        return TransformadorCliente.mapToListaClienteModelo(this.repositorioCliente.findAll());
    }
}
