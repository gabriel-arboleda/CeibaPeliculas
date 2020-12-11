package com.ceiba.CeibaPeliculas.infraestructura.controlador;

import com.ceiba.CeibaPeliculas.aplicacion.comando.ComandoPrestamo;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.prestamo.ManejadorConsultaPrestamo;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.prestamo.ManejadorEliminarPrestamo;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.prestamo.ManejadorGuardarPrestamo;
import com.ceiba.CeibaPeliculas.dominio.modelo.Prestamo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "prestamo")
public class ControladorPrestamo {

    private final ManejadorConsultaPrestamo manejadorConsultaPrestamo;
    private final ManejadorGuardarPrestamo manejadorGuardarPrestamo;
    private final ManejadorEliminarPrestamo manejadorEliminarPrestamo;

    @GetMapping(value = "/{docIdentidad}")
    public ResponseEntity<List<Prestamo>> consultarPorCliente(@PathVariable("docIdentidad") Long docIdentidad){
        return ResponseEntity.ok( this.manejadorConsultaPrestamo.ejecutar(docIdentidad));
    }

    @PostMapping
    public ResponseEntity<Prestamo> guardar(@RequestBody ComandoPrestamo comandoPrestamo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorGuardarPrestamo.ejecutar(comandoPrestamo));
    }

    @DeleteMapping(value = "/{idPrestamo}")
    public void eliminar(@PathVariable("idPrestamo") Long idPrestamo) {
        this.manejadorEliminarPrestamo.ejecutar(idPrestamo);
    }

}
