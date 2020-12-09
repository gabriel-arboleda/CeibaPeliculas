package com.ceiba.CeibaPeliculas.aplicacion.manejador.pelicula;

import com.ceiba.CeibaPeliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.CeibaPeliculas.aplicacion.fabrica.FabricaPelicula;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;
import com.ceiba.CeibaPeliculas.dominio.servicio.pelicula.GuardarPeliculaServicio;
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
