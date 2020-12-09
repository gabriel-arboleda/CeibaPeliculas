package com.ceiba.CeibaPeliculas.aplicacion.fabrica;

import com.ceiba.CeibaPeliculas.aplicacion.comando.ComandoCliente;
import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;

public final class FabricaCliente {

    public FabricaCliente() {
    }

    public static Cliente crearCliente(ComandoCliente comandoCliente) {
        return Cliente.builder()
                .conDocIdentidad(comandoCliente.getDocIdentidad())
                .conNombres(comandoCliente.getNombres())
                .conApellidos(comandoCliente.getApellidos())
                .build();
    }

}
