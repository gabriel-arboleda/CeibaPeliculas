package com.ceiba.CeibaPeliculas.aplicacion.manejador.pelicula;

import com.ceiba.CeibaPeliculas.aplicacion.manejador.ManejadorComando;
import com.ceiba.CeibaPeliculas.dominio.servicio.pelicula.EliminarPeliculaServicio;
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
