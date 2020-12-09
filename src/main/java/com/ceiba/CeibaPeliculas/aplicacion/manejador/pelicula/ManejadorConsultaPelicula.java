package com.ceiba.CeibaPeliculas.aplicacion.manejador.pelicula;

import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;
import com.ceiba.CeibaPeliculas.dominio.servicio.pelicula.ConsultarPeliculaServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultaPelicula {

    private final ConsultarPeliculaServicio consultarPeliculaServicio;

    public List<Pelicula> ejecutar() {
        return this.consultarPeliculaServicio.consultarPeliculas();
    }

}
