package com.ceiba.peliculas.dominio.repositorio;

import com.ceiba.peliculas.dominio.modelo.Cliente;

import java.util.List;

public interface IRepositorioCliente {

    boolean existeCliente(Long docIdentidad);
    List<Cliente> consultarCliente();
    Cliente guardarCliente(Cliente cliente);
    void eliminarCliente(Long docIdentidad);

}
