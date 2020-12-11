package com.ceiba.CeibaPeliculas.aplicacion.manejador.prestamo;

import com.ceiba.CeibaPeliculas.dominio.modelo.Prestamo;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioPrestamo;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.TransformadorPrestamo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultaPrestamo {

    private final IRepositorioPrestamo repositorioPrestamo;

    public List<Prestamo> ejecutar(Long docIdentidad){
        return TransformadorPrestamo.mapToListaPrestamo(this.repositorioPrestamo.findAllByClienteEntidadDocIdentidad(docIdentidad));
    }
}
