package com.ceiba.CeibaPeliculas.infraestructura.controlador;

import com.ceiba.CeibaPeliculas.aplicacion.comando.ComandoPelicula;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.pelicula.ManejadorConsultaPelicula;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.pelicula.ManejadorEliminarPelicula;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.pelicula.ManejadorGuardarPelicula;
import com.ceiba.CeibaPeliculas.dominio.modelo.Pelicula;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "pelicula")
public class ControladorPelicula {

    private final ManejadorConsultaPelicula manejadorConsultaPelicula;
    private final ManejadorGuardarPelicula manejadorGuardarPelicula;
    private final ManejadorEliminarPelicula manejadorEliminarPelicula;

    @GetMapping
    public ResponseEntity<List<Pelicula>> consultar(){
        return ResponseEntity.ok( this.manejadorConsultaPelicula.ejecutar());
    }

    @PostMapping
    public ResponseEntity<Pelicula> guardar(@RequestBody ComandoPelicula comandoPelicula){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorGuardarPelicula.ejecutar(comandoPelicula));
    }

    @DeleteMapping(value = "/{idPelicula}")
    public void eliminar(@PathVariable("idPelicula") Long idPelicula) {
        this.manejadorEliminarPelicula.ejecutar(idPelicula);
    }

}
