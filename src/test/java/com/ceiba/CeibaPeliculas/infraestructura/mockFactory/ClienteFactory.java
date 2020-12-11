package com.ceiba.CeibaPeliculas.infraestructura.mockFactory;

import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.ClienteEntidad;

public class ClienteFactory {

    private static final Long DOC_IDENTIDAD = 2L;
    private static final String NOMBRES = "Cliente";
    private static final String APPELLIDOS = "Prueba";

    public Cliente buildCliente(){
        return Cliente.builder()
                .conDocIdentidad(DOC_IDENTIDAD)
                .conNombres(NOMBRES)
                .conApellidos(APPELLIDOS)
                .build();
    }

    public ClienteEntidad buildClienteEntidad(){
        return ClienteEntidad.builder()
                .conDocIdentidad(DOC_IDENTIDAD)
                .conNombres(NOMBRES)
                .conApellidos(APPELLIDOS)
                .build();
    }

}
