package com.ceiba.peliculas.infraestructura.controlador;

import com.ceiba.peliculas.aplicacion.comando.ComandoCliente;
import com.ceiba.peliculas.aplicacion.manejador.cliente.ManejadorConsultaCliente;
import com.ceiba.peliculas.aplicacion.manejador.cliente.ManejadorEliminarCliente;
import com.ceiba.peliculas.aplicacion.manejador.cliente.ManejadorGuardarCliente;
import com.ceiba.peliculas.dominio.modelo.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/cliente")
public class ControladorCliente {

    private final ManejadorConsultaCliente manejadorConsultaCliente;
    private final ManejadorGuardarCliente manejadorGuardarCliente;
    private final ManejadorEliminarCliente manejadorEliminarCliente;

    @GetMapping
    public ResponseEntity<List<Cliente>> consultar(){
        return ResponseEntity.ok( this.manejadorConsultaCliente.ejecutar());
    }

    @PostMapping
    public ResponseEntity<Cliente> guardar(@RequestBody ComandoCliente comandoCliente){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.manejadorGuardarCliente.ejecutar(comandoCliente));
    }

    @DeleteMapping(value = "/{docIdentidad}")
    public void eliminar(@PathVariable("docIdentidad") Long docIdentidad) {
        this.manejadorEliminarCliente.ejecutar(docIdentidad);
    }
}
