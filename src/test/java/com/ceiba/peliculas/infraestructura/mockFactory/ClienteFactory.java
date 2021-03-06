package com.ceiba.peliculas.infraestructura.mockFactory;

import com.ceiba.peliculas.aplicacion.comando.ComandoCliente;
import com.ceiba.peliculas.dominio.modelo.Cliente;
import com.ceiba.peliculas.infraestructura.modelo.ClienteEntidad;

import java.util.ArrayList;

public class ClienteFactory {

    private static final Long DOC_IDENTIDAD = 321L;
    private static final String NOMBRES = "Cliente";
    private static final String APPELLIDOS = "Prueba";

    public Cliente buildCliente(){
        return Cliente.builder()
                .conDocIdentidad(DOC_IDENTIDAD)
                .conNombres(NOMBRES)
                .conApellidos(APPELLIDOS)
                .conListaPrestamo(new ArrayList<>())
                .build();
    }

    public ClienteEntidad buildClienteEntidad(){
        return ClienteEntidad.builder()
                .conDocIdentidad(DOC_IDENTIDAD)
                .conNombres(NOMBRES)
                .conApellidos(APPELLIDOS)
                .conListaPrestamos(new ArrayList<>())
                .build();
    }

    public ComandoCliente buildComando() {
        return new ComandoCliente(DOC_IDENTIDAD,NOMBRES,APPELLIDOS);
    }

}
