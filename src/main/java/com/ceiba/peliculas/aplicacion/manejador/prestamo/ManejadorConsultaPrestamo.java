package com.ceiba.peliculas.aplicacion.manejador.prestamo;

import com.ceiba.peliculas.dominio.modelo.Prestamo;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPrestamo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultaPrestamo {

    private final IRepositorioPrestamo repositorioPrestamo;

    public List<Prestamo> ejecutar(Long docIdentidad){
        return this.repositorioPrestamo.consultarPrestamosPorCliente(docIdentidad);
    }
}
