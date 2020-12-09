package com.ceiba.CeibaPeliculas.dominio.servicio.prestamo;

import com.ceiba.CeibaPeliculas.dominio.modelo.Prestamo;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.repositorio.RepositorioPrestamo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class guardarPrestamoServicio {

    private final RepositorioPrestamo repositorioPrestamo;

    public Prestamo guardarPrestamo(Prestamo prestamo){ return repositorioPrestamo.guardarPrestamo(prestamo);}

}
