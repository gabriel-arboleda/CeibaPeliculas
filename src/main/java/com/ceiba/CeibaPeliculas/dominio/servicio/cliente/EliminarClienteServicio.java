package com.ceiba.CeibaPeliculas.dominio.servicio.cliente;

import com.ceiba.CeibaPeliculas.dominio.excepcion.ExistenciaPersonaExcepcion;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarClienteServicio {

    private final IRepositorioCliente repositorioCliente;
    public static final String ERROR_NO_EXISTE_CLIENTE = "No existe el cliente";

    public void eliminarCliente(Long docIdentidad) {
        existeCliente(docIdentidad);
        repositorioCliente.deleteById(docIdentidad);
    }

    public void existeCliente(Long docIdentidad) {
        boolean existeCliente = repositorioCliente.existsById(docIdentidad);
        if (!existeCliente)
            throw new ExistenciaPersonaExcepcion(ERROR_NO_EXISTE_CLIENTE);
    }

}
