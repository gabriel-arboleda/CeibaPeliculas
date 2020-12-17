package com.ceiba.peliculas.dominio.servicio.prestamo;

import com.ceiba.peliculas.dominio.excepcion.ErrorFechaEntregaMaximaExcepcion;
import com.ceiba.peliculas.dominio.excepcion.ErrorMaximoPrestamoExcepcion;
import com.ceiba.peliculas.dominio.excepcion.ErrorPeliculaPrestadaExcepcion;
import com.ceiba.peliculas.dominio.modelo.Prestamo;
import com.ceiba.peliculas.dominio.repositorio.IRepositorioPrestamo;
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
    public static final String ERROR_FECHA_MAXIMA_ENTREGA = "La fecha maxima de entrega es el ";

    public Prestamo guardarPrestamo(Prestamo prestamo) {
        List<Prestamo> prestamos = repositorioPrestamo.consultarPrestamosPorCliente(prestamo.getCliente().getDocIdentidad());
        maximoPrestamo(prestamos);
        peliculaPrestada(prestamo.getPelicula().getIdPelicula());
        validarFechaEntregaMaxima(prestamos, prestamo);
        prestamo.setValorPrestamo(calcularValorPrestamo(prestamo));
        prestamo.setValorPrestamo(aplicarDescuentos(prestamos, prestamo));
        return repositorioPrestamo.guardarPrestamo(prestamo);
    }

    private void peliculaPrestada(Long idPelicula) {
        boolean peliculaPrestada = repositorioPrestamo.existePrestamoPorPelicula( idPelicula );
        if ( peliculaPrestada )
            throw new ErrorPeliculaPrestadaExcepcion(ERROR_PELICULA_PRESTADA);
    }

    private void maximoPrestamo( List<Prestamo> prestamos ) {
        long numeroPrestamos = obtenerNumeroPrestamosVigentes(prestamos);
        if (numeroPrestamos > MAXIMOS_PRESTAMO){
            throw new ErrorMaximoPrestamoExcepcion(ERROR_MAXIMO_PRESTAMO);
        }
    }

    private Long obtenerNumeroPrestamosVigentes(List<Prestamo> prestamos){
        Date fechaHoy = new Date();
        return prestamos.stream()
                .filter( prestamoEntidad ->
                prestamoEntidad.getFechaPrestamo().after(fechaHoy) && prestamoEntidad.getFechaDevolucion().before(fechaHoy)
        ).count();
    }

    private void validarFechaEntregaMaxima(List<Prestamo> prestamos, Prestamo prestamo) {
        int numeroPrestamos = prestamos.size();
        if (numeroPrestamos > 15 ) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(prestamo.getFechaPrestamo());
            calendar.add(Calendar.DAY_OF_YEAR, 5);
            Date fechaEntrega = calendar.getTime();
            if (prestamo.getFechaDevolucion().after(fechaEntrega)) {
                throw new ErrorFechaEntregaMaximaExcepcion(ERROR_FECHA_MAXIMA_ENTREGA +fechaEntrega );
            }
        }
    }

    private Long calcularValorPrestamo(Prestamo prestamo) {
        long valorPrestamo = VALOR_PRESTAMOS_INICIAL;
        Date fechaPrestamo = prestamo.getFechaPrestamo();
        Date fechaDevolucion = prestamo.getFechaDevolucion();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(prestamo.getFechaPrestamo());
        while (fechaPrestamo.before(fechaDevolucion)) {
            int dia = calendar.get(Calendar.DAY_OF_WEEK);
            if (dia == Calendar.SUNDAY || dia == Calendar.SATURDAY) {
                valorPrestamo += 500;
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            fechaPrestamo = calendar.getTime();
            valorPrestamo += 500;
        }
        return valorPrestamo;
    }

    private Long aplicarDescuentos( List<Prestamo> prestamos, Prestamo prestamo ){
        int numeroPrestamos = prestamos.size();
        long valorPrestamo = prestamo.getValorPrestamo();
        if ( numeroPrestamos > 30){
            valorPrestamo -= valorPrestamo * 0.2;
        } else if( numeroPrestamos > 15 ) {
            valorPrestamo -= valorPrestamo * 0.1;
        }
        return valorPrestamo;
    }

}
