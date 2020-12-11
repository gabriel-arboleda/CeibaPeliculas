package com.ceiba.CeibaPeliculas.infraestructura.adaptador;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.ClienteEntidad;

import java.util.List;
import java.util.stream.Collectors;

public final class TransformadorCliente {

    public TransformadorCliente() {
    }

    public static Cliente mapToClienteModelo(ClienteEntidad clienteEntidad) {
        return Cliente.builder()
                .conDocIdentidad( clienteEntidad.getDocIdentidad() )
                .conNombres( clienteEntidad.getNombres() )
                .conApellidos( clienteEntidad.getApellidos() )
                .build();
    }

    public static Cliente mapToClienteModeloSinPrestamo(ClienteEntidad clienteEntidad) {
        return Cliente.builder()
                .conDocIdentidad( clienteEntidad.getDocIdentidad() )
                .conNombres( clienteEntidad.getNombres() )
                .conApellidos( clienteEntidad.getApellidos() )
                .build();
    }

    public static ClienteEntidad mapToClienteEntidad( Cliente cliente ){
        return ClienteEntidad.builder()
                .conDocIdentidad(cliente.getDocIdentidad())
                .conNombres(cliente.getNombres())
                .conApellidos(cliente.getApellidos())
                .build();
    }


    public static List<Cliente> mapToListaClienteModelo(List<ClienteEntidad> clientes) {
        return clientes.stream().map(TransformadorCliente::mapToClienteModelo).collect(Collectors.toList());
    }

}
