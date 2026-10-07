package Biblioteca.App;
import Biblioteca.Modelo.Libro;
import Biblioteca.Modelo.Usuario;
import Biblioteca.Modelo.Ejemplar;
import Biblioteca.Modelo.Biblioteca;
import Biblioteca.Modelo.EstadoEjemplar;
import Biblioteca.Servicio.Prestamo;

import java.time.LocalDate;


public class BibliotecaApp {
    public static void main() {

        Biblioteca biblioteca1 = new Biblioteca("USBI");

        Libro libro1 = new Libro("Piensa en Java", "Antonio Vergará");
        Libro libro2 = new Libro("Troll face", "Digref");

        //El codigo lo creo agrandole las iniciales de cada palabra del libro para saber de quien pertenece
        libro1.agregarEjemplar("PEJ001", EstadoEjemplar.DISPONIBLE);
        libro1.agregarEjemplar("PEJ002", EstadoEjemplar.DISPONIBLE);
        libro2.agregarEjemplar("TF001", EstadoEjemplar.DISPONIBLE);
        libro2.agregarEjemplar("TF002", EstadoEjemplar.DISPONIBLE);

        //libro1.mostrarEjemplares();
        //libro2.mostrarEjemplares();

        Usuario rafa = new Usuario("Rafa","011rafa");
        Usuario diego = new Usuario("Diego","012diego");

    /*
        //agregar usuarios a la biblioteca
        biblioteca1.agregarUsuario(rafa);
        biblioteca1.agregarUsuario(diego);
        biblioteca1.mostrarUsuarios();
    */

        //creo prestamos
        Prestamo prestamo1 = new Prestamo(LocalDate.now(),LocalDate.of(2026,11,20));

        //primero registro los libros del prestamo
        System.out.println(prestamo1.registrarPrestamo(rafa,libro1));
        System.out.println(prestamo1.registrarPrestamo(rafa,libro2));
        //luego agrego el prestamo al usuario
        rafa.agregarPrestamo(prestamo1);


        Prestamo prestamo2 = new Prestamo(LocalDate.now(),LocalDate.of(2026,11,20));
        //primero agrego los libros al prestamo
        System.out.println(prestamo2.registrarPrestamo(diego,libro1));
        System.out.println(prestamo2.registrarPrestamo(diego,libro1)); //error: ya no hay mas ejemplares
        //el paso el prestamo al usuario
        diego.agregarPrestamo(prestamo2);

        //muestra los ejemplares de un solo prestamo
        prestamo1.mostrarEjemplares();
        prestamo2.mostrarEjemplares();

        prestamo1.devolverLibros();

        libro1.mostrarEjemplares();
    }
}
