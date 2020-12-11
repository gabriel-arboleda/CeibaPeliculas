package com.ceiba.peliculas.infraestructura.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CLIENTE", schema = "DB_CEIBA_RENTA_PELICULA")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "con")
public class ClienteEntidad implements Serializable {

    private static final long serialVersionUID = 8434850033473170469L;

    @Id
    private Long docIdentidad;

    private String nombres;
    private String apellidos;

    @JsonManagedReference
    @OneToMany(mappedBy = "clienteEntidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrestamoEntidad> listaPrestamos;
}
