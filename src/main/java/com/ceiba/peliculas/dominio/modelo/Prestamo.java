package com.ceiba.peliculas.dominio.modelo;

import com.ceiba.peliculas.dominio.excepcion.ValorObligatorioExcepcion;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

import static com.ceiba.peliculas.dominio.excepcion.validacion.ValidadorArgumentos.validarObligatorio;

@Getter
@Setter
@Builder(setterPrefix = "con")
public class Prestamo {

    public static final String FECHA_DEVOLUCION_OBLIGATORIA = "Se debe ingresar la fecha de devolucion de la pelicula";

    public Prestamo(Long idPrestamo, Date fechaPrestamo, Date fechaDevolucion, long valorPrestamo, Cliente cliente, Pelicula pelicula) throws ValorObligatorioExcepcion {
        validarObligatorio(fechaDevolucion, FECHA_DEVOLUCION_OBLIGATORIA);

        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = new Date(fechaPrestamo.getTime());
        this.fechaDevolucion = new Date(fechaDevolucion.getTime());;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return valorPrestamo == prestamo.valorPrestamo && Objects.equals(idPrestamo, prestamo.idPrestamo) && Objects.equals(fechaPrestamo, prestamo.fechaPrestamo) && Objects.equals(fechaDevolucion, prestamo.fechaDevolucion) && Objects.equals(cliente, prestamo.cliente) && Objects.equals(pelicula, prestamo.pelicula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrestamo, fechaPrestamo, fechaDevolucion, valorPrestamo, cliente, pelicula);
    }
}
