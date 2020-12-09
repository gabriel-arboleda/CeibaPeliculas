package com.ceiba.CeibaPeliculas.dominio.repositorio;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;

import java.util.List;

public interface IRepositorioCliente {

    boolean existeCliente( Long docIdentidad );
    List<Cliente> consultarCliente();
    Cliente guardarCliente(Cliente cliente);
    void eliminarClientePorId( Long docIdentidad );

}
