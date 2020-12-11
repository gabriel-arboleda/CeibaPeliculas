package com.ceiba.peliculas.aplicacion.manejador.cliente;

import com.ceiba.peliculas.dominio.modelo.Cliente;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioCliente;
import com.ceiba.peliculas.infraestructura.adaptador.TransformadorCliente;
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
