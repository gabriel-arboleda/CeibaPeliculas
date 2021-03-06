package com.ceiba.peliculas.aplicacion.manejador;

import javax.transaction.Transactional;

public interface ManejadorComandoRespuesta<R, T> {

    @Transactional
    R ejecutar(T comando);
}
