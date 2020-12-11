package com.ceiba.CeibaPeliculas.dominio.servicio.prestamo;

import com.ceiba.CeibaPeliculas.dominio.excepcion.ErrorNegocioExcepcion;
import com.ceiba.CeibaPeliculas.dominio.modelo.Prestamo;
import com.ceiba.CeibaPeliculas.dominio.repositorio.IRepositorioPrestamo;
import com.ceiba.CeibaPeliculas.infraestructura.adaptador.TransformadorPrestamo;
import com.ceiba.CeibaPeliculas.infraestructura.modelo.PrestamoEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class GuardarPrestamoServicio {

    private final IRepositorioPrestamo repositorioPrestamo;
    public static final String ERROR_PELICULA_PRESTADA = "La pelicula ya ha sido prestada";
    public static final String ERROR_MAXIMO_PRESTAMO = "El cliente no puede prestar mas peliculas";
    public static final int MAXIMOS_PRESTAMO = 35;
    public static final int VALOR_PRESTAMOS_INICIAL = 5000;
    public static final String FECHA_MAXIMA_ENTREGA = "La fecha maxima de entrega es el ";

    public Prestamo guardarPrestamo(Prestamo prestamo) {
        long idCliente = prestamo.getPelicula().getIdPelicula();
        List<PrestamoEntidad> prestamos = repositorioPrestamo.findAllByClienteEntidadDocIdentidad(idCliente);
        maximoPrestamo(prestamos);
        peliculaPrestada(idCliente);
        calcularFechaEntregaMaxima(prestamos, prestamo);
        prestamo.setValorPrestamo(calcularValorPrestamo(prestamo));
        prestamo.setValorPrestamo(aplicarDescuentos(prestamos, prestamo));
        PrestamoEntidad prestamoEntidad = TransformadorPrestamo.mapToPrestamoEntidad(prestamo);
        return TransformadorPrestamo.mapToPrestamoModelo(repositorioPrestamo.saveAndFlush(prestamoEntidad));
    }

    public void peliculaPrestada( Long idPelicula ) {
        boolean peliculaPrestada = repositorioPrestamo.existsByPeliculaEntidadIdPelicula( idPelicula );
        if ( peliculaPrestada )
            throw new ErrorNegocioExcepcion(ERROR_PELICULA_PRESTADA);
    }

    public void maximoPrestamo( List<PrestamoEntidad> prestamos ) throws ErrorNegocioExcepcion {
        Date fechaHoy = new Date();
        long prestamosMaximo = prestamos.stream().filter( prestamoEntidad -> prestamoEntidad.getFechaPrestamo().after(fechaHoy) && prestamoEntidad.getFechaDevolucion().before(fechaHoy) ).count();
        if (prestamosMaximo > MAXIMOS_PRESTAMO){
            throw new ErrorNegocioExcepcion(ERROR_MAXIMO_PRESTAMO);
        }
    }

    public void calcularFechaEntregaMaxima(List<PrestamoEntidad> prestamos, Prestamo prestamo) {
        int numeroPrestamos = prestamos.size();
        if (numeroPrestamos > 15 ) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(prestamo.getFechaPrestamo());
            calendar.add(Calendar.DAY_OF_YEAR, 5);
            Date fechaEntrega = calendar.getTime();
            if (prestamo.getFechaDevolucion().after(fechaEntrega)) {
                throw new ErrorNegocioExcepcion(FECHA_MAXIMA_ENTREGA+fechaEntrega );
            }
        }
    }

    public Long aplicarDescuentos( List<PrestamoEntidad> prestamos, Prestamo prestamo ){
        int numeroPrestamos = prestamos.size();
        long valorPrestamo = prestamo.getValorPrestamo();
        if ( numeroPrestamos > 30){
            valorPrestamo -= valorPrestamo * 0.2;
        } else if( numeroPrestamos > 15 ) {
            valorPrestamo *= valorPrestamo * 0.1;
        }
        return valorPrestamo;
    }

    public Long calcularValorPrestamo(Prestamo prestamo) {
        long valorPrestamo = VALOR_PRESTAMOS_INICIAL;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(prestamo.getFechaPrestamo());
        while (calendar.after(prestamo.getFechaDevolucion())) {
            int dia = calendar.get(Calendar.DAY_OF_WEEK);
            if (dia == Calendar.SUNDAY || dia == Calendar.SATURDAY) {
                valorPrestamo += 500;
            }
            valorPrestamo += 500;
        }
        return valorPrestamo;
    }

}
