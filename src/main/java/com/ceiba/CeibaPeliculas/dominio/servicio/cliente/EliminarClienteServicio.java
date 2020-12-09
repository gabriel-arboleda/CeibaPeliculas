package com.ceiba.CeibaPeliculas.dominio.servicio.cliente;

import com.ceiba.CeibaPeliculas.dominio.excepcion.ExistenciaPersonaExcepcion;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio.RepositorioCliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EliminarClienteServicio {

    private final RepositorioCliente repositorioCliente;
    public static final String ERROR_NO_EXISTE_CLIENTE = "No existe el cliente";

    public void eliminarCliente(Long idCliente) {
        existeCliente(idCliente);
        repositorioCliente.eliminarClientePorId(idCliente);
    }

    public void existeCliente(Long idCliente) {
        Boolean existeCliente = repositorioCliente.existeCliente(idCliente);
        if (!existeCliente)
            throw new ExistenciaPersonaExcepcion(ERROR_NO_EXISTE_CLIENTE);
    }

}
