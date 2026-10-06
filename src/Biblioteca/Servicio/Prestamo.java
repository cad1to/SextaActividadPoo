package Biblioteca.Servicio;

import Biblioteca.Modelo.Ejemplar;
import Biblioteca.Modelo.EstadoEjemplar;
import Biblioteca.Modelo.Libro;
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

    public String realizarPrestamo(Usuario usuario, Libro libro) {
        for (Ejemplar ejemplar : libro.ejemplares){
            if (ejemplar.getEstado() == EstadoEjemplar.DISPONIBLE) {
                ejemplar.setEstado(EstadoEjemplar.PRESTADO);
                usuario.ejemplaresEnPosesion.add(ejemplar);
                return "Libro prestado con exito a" + usuario.getNombre() + "Codigo del ejemplar prestado: " + ejemplar.getCodigo();
            }
        }
        return "No hay libros disponibles";
    }

    public void devolver (Libro libro, Usuario usuario,String codigo) {
        for (Ejemplar ejemplar : libro.ejemplares) {
            if (codigo.equals(ejemplar.getCodigo())){
                Scanner leer = new Scanner(System.in);
                System.out.println("¿El ejemplar esta dañado?");
                String dañado = leer.next();
                if (dañado.equals("Si")){
                    System.out.println("Cuota extra por: Ejemplar dañado");
                    ejemplar.setEstado(EstadoEjemplar.DANADO);
                } else if (dañado.equals("No")) {
                    ejemplar.setEstado(EstadoEjemplar.DISPONIBLE);
                } else {
                    System.out.println("Opcion no valida");
                }
                usuario.ejemplaresEnPosesion.removeIf(e -> codigo.equals(e.getCodigo()));
            } else {
                System.out.println("Ejemplar no encontrado");
            }
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
