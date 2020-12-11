package com.ceiba.peliculas.infraestructura.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PRESTAMO", schema = "DB_CEIBA_RENTA_PELICULA")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "con")
public class PrestamoEntidad implements Serializable {

    private static final long serialVersionUID = 7617811362219595918L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private long valorPrestamo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOC_IDENTIDAD")
    private ClienteEntidad clienteEntidad;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PELICULA")
    private PeliculaEntidad peliculaEntidad;
}
