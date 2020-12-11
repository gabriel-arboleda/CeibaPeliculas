package com.ceiba.peliculas.aplicacion.manejador.pelicula;

import com.ceiba.peliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.peliculas.aplicacion.fabrica.FabricaPelicula;
import com.ceiba.peliculas.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.peliculas.dominio.modelo.Pelicula;
import com.ceiba.peliculas.dominio.servicio.pelicula.GuardarPeliculaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManejadorGuardarPelicula implements ManejadorComandoRespuesta<Pelicula, ComandoPelicula> {

    private final GuardarPeliculaServicio guardarPeliculaServicio;

    @Override
    public Pelicula ejecutar(ComandoPelicula comando) {
        Pelicula pelicula = FabricaPelicula.crearPelicula(comando);
        return this.guardarPeliculaServicio.guardarPelicula(pelicula);
    }
}
