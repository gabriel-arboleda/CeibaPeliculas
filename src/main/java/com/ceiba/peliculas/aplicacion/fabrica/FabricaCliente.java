package com.ceiba.peliculas.aplicacion.fabrica;

import com.ceiba.peliculas.aplicacion.comando.ComandoCliente;
import com.ceiba.peliculas.dominio.modelo.Cliente;

import java.util.ArrayList;

public final class FabricaCliente {

    public FabricaCliente() {
    }

    public static Cliente crearCliente(ComandoCliente comandoCliente) {
        return Cliente.builder()
                .conDocIdentidad(comandoCliente.getDocIdentidad())
                .conNombres(comandoCliente.getNombres())
                .conApellidos(comandoCliente.getApellidos())
                .conListaPrestamo(new ArrayList<>())
                .build();
    }

}
