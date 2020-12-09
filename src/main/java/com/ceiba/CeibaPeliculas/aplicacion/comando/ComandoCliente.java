package com.ceiba.CeibaPeliculas.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComandoCliente {

    private Long docIdentidad;
    private String nombres;
    private String apellidos;

}
