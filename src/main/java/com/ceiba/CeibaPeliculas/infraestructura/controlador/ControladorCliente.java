package com.ceiba.CeibaPeliculas.infraestructura.controlador;

import com.ceiba.CeibaPeliculas.aplicacion.comando.ComandoCliente;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.cliente.ManejadorConsultaCliente;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.cliente.ManejadorEliminarCliente;
import com.ceiba.CeibaPeliculas.aplicacion.manejador.cliente.ManejadorGuardarCliente;
import com.ceiba.CeibaPeliculas.dominio.modelo.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "cliente")
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
