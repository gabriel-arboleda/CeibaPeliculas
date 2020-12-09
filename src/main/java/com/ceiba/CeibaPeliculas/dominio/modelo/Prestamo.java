package com.ceiba.CeibaPeliculas.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "con")
public class Prestamo {

    private Long idPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private long valorPrestamo;
    private Cliente cliente;
    private Pelicula pelicula;

}
