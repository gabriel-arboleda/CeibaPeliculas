package com.ceiba.peliculas.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ComandoCliente {

    private Long docIdentidad;
    private String nombres;
    private String apellidos;

}
