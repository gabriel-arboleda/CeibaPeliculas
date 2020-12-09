package com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioCliente;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.transformador.TransformadorCliente;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCliente extends JpaRepository<ClienteEntidad, Long>, IRepositorioCliente {

    @Override
    default boolean existeCliente(Long docIdentidad) {
        return existsById( docIdentidad );
    }

    @Override
    default List<Cliente> consultarCliente() {
        return TransformadorCliente.mapToListaClienteModelo(findAll());
    }

    @Override
    default Cliente guardarCliente(Cliente cliente) {
        ClienteEntidad clienteEntidad = TransformadorCliente.mapToClienteEntidad(cliente);
        return TransformadorCliente.mapToClienteModelo(saveAndFlush(clienteEntidad));
    }

    @Override
    default void eliminarClientePorId(Long docIdentidad) {
        deleteById(docIdentidad);
    }
}
