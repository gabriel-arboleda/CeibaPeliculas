package com.ceiba.peliculas.dominio.modelo;

import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.ceiba.peliculas.dominio.excepcion.validacion.ValidadorArgumentos.validarObligatorio;

@Getter
@Builder(setterPrefix = "con")
public class Pelicula {

    public static final String NOMBRE_OBLIGATIRIOS = "Se debe ingresar el nombre de la pelicula";
    public static final String GENERO_OBLIGATIRIOS = "Se debe ingresar el genero de la pelicula";

    private Long idPelicula;
    private String nombrePelicula;
    private String genero;
    private List<Prestamo> listaPrestamo;

    public Pelicula(Long idPelicula, String nombrePelicula, String genero, List<Prestamo> listaPrestamo) {
        validarObligatorio(nombrePelicula, NOMBRE_OBLIGATIRIOS);
        validarObligatorio(genero, GENERO_OBLIGATIRIOS);

        this.idPelicula = idPelicula;
        this.nombrePelicula = nombrePelicula;
        this.genero = genero;
        this.listaPrestamo = Collections.unmodifiableList(listaPrestamo);
    }

    @Override
    public boolean equals(Object objPelicula) {
        if (this == objPelicula) return true;
        if (objPelicula == null || getClass() != objPelicula.getClass()) return false;
        Pelicula pelicula = (Pelicula) objPelicula;
        return Objects.equals(idPelicula, pelicula.idPelicula) && Objects.equals(nombrePelicula, pelicula.nombrePelicula) && Objects.equals(genero, pelicula.genero) && Objects.equals(listaPrestamo, pelicula.listaPrestamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, nombrePelicula, genero, listaPrestamo);
    }
}
