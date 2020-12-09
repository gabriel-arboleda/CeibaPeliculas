package com.ceiba.CeibaPeliculas.dominio.modelo;

import static com.ceiba.CeibaPeliculas.dominio.excepcion.validacion.ValidadorArgumentos.validarObligatorio;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
@Builder(setterPrefix = "con")
public class Cliente {

    public static final String NOMBRES_OBLIGATIRIOS = "Se debe ingresar los nombres del cliente";
    public static final String APELLIDOS_OBLIGATIRIOS = "Se debe ingresar los apellidos del cliente";

    private Long docIdentidad;
    private String nombres;
    private String apellidos;
    private List<Prestamo> listaPrestamo;

    public Cliente(Long docIdentidad, String nombres, String apellidos, List<Prestamo> listaPrestamo) {
        validarObligatorio(nombres, NOMBRES_OBLIGATIRIOS);
        validarObligatorio(apellidos, APELLIDOS_OBLIGATIRIOS);

        this.docIdentidad = docIdentidad;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.listaPrestamo = listaPrestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(docIdentidad, cliente.docIdentidad) && Objects.equals(nombres, cliente.nombres) && Objects.equals(apellidos, cliente.apellidos) && Objects.equals(listaPrestamo, cliente.listaPrestamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docIdentidad, nombres, apellidos, listaPrestamo);
    }
}
