package Biblioteca.Servicio;

import Biblioteca.Modelo.Ejemplar;
import Biblioteca.Modelo.EstadoEjemplar;
import Biblioteca.Modelo.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String realizarPrestamo(Usuario usuario, Ejemplar ejemplar ) {
        if (ejemplar.getEstado() == EstadoEjemplar.DANADO || ejemplar.getEstado() == EstadoEjemplar.PRESTADO) {
            return "Este prestamo no puede ser realizado";
        } else {
            ejemplar.setEstado(EstadoEjemplar.PRESTADO);
            return "Se presto " + ejemplar.getCodigo() + " a " + usuario.getNombre();
        }
    }

    public void devolver (Ejemplar ejemplar) {

        if (ejemplar.getEstado() == EstadoEjemplar.PRESTADO) {
            if (estaVencido()) System.out.println("Entrega tardia, cuota adicional");
            System.out.println("¿El libro esta dañado? 1: SI 2: NO");
            Scanner leer = new Scanner(System.in);
            int dañado = leer.nextInt();
            if (dañado == 1) {
                ejemplar.setEstado(EstadoEjemplar.DANADO);
                System.out.println("Ya no te te presto nada bye :v");
            } else if (dañado == 2) {
                ejemplar.setEstado(EstadoEjemplar.DISPONIBLE);
                System.out.println("Devoluciendo prestamo");
            } else {
                System.out.println("Opcion no valida");
            }
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public boolean estaVencido(){
        LocalDate fechaActual = LocalDate.now();
        if (fechaActual.isBefore(fechaDevolucion)) {
            return false;
        } else {
            return true;
        }
    }
}
