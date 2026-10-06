package Biblioteca.App;
import Biblioteca.Modelo.Libro;
import Biblioteca.Modelo.Usuario;
import Biblioteca.Modelo.Ejemplar;
import Biblioteca.Modelo.Biblioteca;
import Biblioteca.Modelo.EstadoEjemplar;
import Biblioteca.Servicio.Prestamo;


public class BibliotecaApp {
    public static void main() {

        Libro libro1 = new Libro("Piensa en Java", "Antonio Vergará");
        Libro libro2 = new Libro("Troll face", "Digref");
        libro1.agregarEjemplar("001", EstadoEjemplar.DISPONIBLE);
        libro1.mostrarEjemplares();

    }
}
