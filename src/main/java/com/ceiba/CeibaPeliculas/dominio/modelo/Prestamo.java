package com.ceiba.CeibaPeliculas.dominio.modelo;

import com.ceiba.CeibaPeliculas.dominio.excepcion.ValorObligatorioExcepcion;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static com.ceiba.CeibaPeliculas.dominio.excepcion.validacion.ValidadorArgumentos.validarObligatorio;

@Getter
@Setter
@Builder(setterPrefix = "con")
public class Prestamo {

    public static final String FECHA_DEVOLUCION_OBLIGATORIA = "Se debe ingresar la fecha de devolucion de la pelicula";

    public Prestamo(Long idPrestamo, Date fechaPrestamo, Date fechaDevolucion, long valorPrestamo, Cliente cliente, Pelicula pelicula) throws ValorObligatorioExcepcion {
        validarObligatorio(fechaDevolucion, FECHA_DEVOLUCION_OBLIGATORIA);

        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.valorPrestamo = valorPrestamo;
        this.cliente = cliente;
        this.pelicula = pelicula;
    }

    private Long idPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private long valorPrestamo;
    private Cliente cliente;
    private Pelicula pelicula;

}
