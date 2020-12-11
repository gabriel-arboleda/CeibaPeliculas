package com.ceiba.peliculas.aplicacion.manejador.pelicula;

import com.ceiba.peliculas.aplicacion.manejador.ManejadorComando;
import com.ceiba.peliculas.dominio.servicio.pelicula.EliminarPeliculaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorEliminarPelicula implements ManejadorComando<Long> {

    private final EliminarPeliculaServicio eliminarPeliculaServicio;

    @Override
    public void ejecutar(Long idPelicula) {
        this.eliminarPeliculaServicio.eliminarPelicula(idPelicula);
    }

}
