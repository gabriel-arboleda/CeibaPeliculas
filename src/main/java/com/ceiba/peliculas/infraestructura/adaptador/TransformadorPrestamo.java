package com.ceiba.peliculas.infraestructura.adaptador;

import com.ceiba.peliculas.dominio.modelo.Prestamo;
import com.ceiba.peliculas.infraestructura.modelo.PrestamoEntidad;

import java.util.List;
import java.util.stream.Collectors;

public final class TransformadorPrestamo {

    public TransformadorPrestamo() {
    }

    public static Prestamo mapToPrestamoModelo(PrestamoEntidad prestamoEntidad ) {
        return Prestamo.builder()
                .conIdPrestamo(prestamoEntidad.getIdPrestamo())
                .conFechaPrestamo(prestamoEntidad.getFechaPrestamo())
                .conFechaDevolucion(prestamoEntidad.getFechaDevolucion())
                .conValorPrestamo(prestamoEntidad.getValorPrestamo())
                .conCliente(TransformadorCliente.mapToClienteModeloSinPrestamo(prestamoEntidad.getClienteEntidad()))
                .conPelicula(TransformadorPelicula.mapToPeliculaModeloSinPrestamo(prestamoEntidad.getPeliculaEntidad()))
                .build();
    }

    public static PrestamoEntidad mapToPrestamoEntidad( Prestamo prestamo ) {
        return PrestamoEntidad.builder()
                .conIdPrestamo(prestamo.getIdPrestamo())
                .conFechaPrestamo(prestamo.getFechaPrestamo())
                .conFechaDevolucion(prestamo.getFechaDevolucion())
                .conValorPrestamo(prestamo.getValorPrestamo())
                .conClienteEntidad(TransformadorCliente.mapToClienteEntidad(prestamo.getCliente()))
                .conPeliculaEntidad(TransformadorPelicula.mapToPeliculaEntidad(prestamo.getPelicula()))
                .build();
    }

    public static List<Prestamo> mapToListaPrestamo(List<PrestamoEntidad> prestamos) {
        return prestamos.stream().map(TransformadorPrestamo::mapToPrestamoModelo).collect(Collectors.toList());
    }
}
