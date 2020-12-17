package com.ceiba.peliculas.aplicacion.manejador.pelicula;

import com.ceiba.peliculas.dominio.modelo.Pelicula;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPelicula;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultaPelicula {

    private final IRepositorioPelicula repositorioPelicula;

    public List<Pelicula> ejecutar() {
        return repositorioPelicula.consultarPelicula();
    }

}
