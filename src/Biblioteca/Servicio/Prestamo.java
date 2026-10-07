package Biblioteca.Servicio;

import Biblioteca.Modelo.Ejemplar;
import Biblioteca.Modelo.EstadoEjemplar;
import Biblioteca.Modelo.Libro;
import Biblioteca.Modelo.Usuario;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private String nombreUsuario;
    Set<Ejemplar> ejemplaresDelPrestamo = new HashSet<>();

    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion, String nombreUsuario) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.nombreUsuario = nombreUsuario;
    }

    public String registrarPrestamo(Usuario usuario, Libro libro) {
        nombreUsuario = usuario.getNombre();
        Ejemplar libroAgregar = libro.buscarParaPrestamo();

        if(libroAgregar == null){
            return "No hay ejemplares disponibles de " + libro.getTitulo()+".\n";
        }else{
            ejemplaresDelPrestamo.add(libroAgregar);
            libroAgregar.setEstado(EstadoEjemplar.PRESTADO);
            return "El ejemplar "+libroAgregar.getCodigo()+" de "+libro.getTitulo()+ " fue prestado a " + nombreUsuario+".\n";
        }
    }

    public void mostrarEjemplares() {
        System.out.println("Libros del prestamo");
        for(Ejemplar ejemplar : ejemplaresDelPrestamo) {
            System.out.println("Codigo: "+ejemplar.getCodigo()+".");
        }
        System.out.println();
    }

    public void devolverLibros() {
        if(ejemplaresDelPrestamo.isEmpty()){
            System.out.println("No hay libros en este prestamo.\n");
        }else{
            if(estaVencido()){
                System.out.println("Cuota adicional por entrega tardia: $2000");
            }
            for (Ejemplar ejemplar : ejemplaresDelPrestamo) {
                System.out.println("Codigo:"+ejemplar.getCodigo());
                Scanner leer = new Scanner(System.in);
                System.out.println("¿El ejemplar esta dañado?");
                String danado = leer.next();
                if (danado.equals("Si")){
                    System.out.println("Cuota extra de $20000 por: Ejemplar dañado");
                    ejemplar.setEstado(EstadoEjemplar.DANADO);
                    //elimina del set los libros que ya no estan ocupados
                    ejemplaresDelPrestamo.remove(ejemplar);
                } else if (danado.equals("No")) {
                    ejemplar.setEstado(EstadoEjemplar.DISPONIBLE);
                    //elimina del set los libros que ya no estan ocupados
                    ejemplaresDelPrestamo.remove(ejemplar);

                } else {
                    System.out.println("Opcion no valida");
                }
                //borre tu condicional pq ya no habia razon de evaluar si esta o no, el for each recorrera todos los ejemplares del prestamo
            }
            System.out.println("Proceso de devolucion terminado");
        }
    }

    public boolean estaVencido(){
        LocalDate fechaActual = LocalDate.now();
        return !fechaActual.isBefore(fechaDevolucion);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
