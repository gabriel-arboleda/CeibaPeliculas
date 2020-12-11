package com.ceiba.peliculas.aplicacion.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComando<T> {

    @Transactional
    void ejecutar(T comando);
}
