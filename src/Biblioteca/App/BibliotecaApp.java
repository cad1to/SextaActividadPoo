package Biblioteca.App;
import Biblioteca.Modelo.Libro;
import Biblioteca.Modelo.Usuario;
import Biblioteca.Modelo.Ejemplar;
import Biblioteca.Modelo.Biblioteca;
import Biblioteca.Modelo.EstadoEjemplar;
import Biblioteca.Servicio.Prestamo;

import javax.print.attribute.PrintRequestAttribute;
import java.time.LocalDate;
import java.util.Scanner;



public class BibliotecaApp {

    public static void main() {
        Biblioteca biblioteca1 = new Biblioteca("USBI");
        Scanner leer = new Scanner(System.in);
        int op;
        do {
            System.out.println("-------------- Biblioteca --------------" +
                    "\n 1. Menu Libro" +
                    "\n 2. Menu Usuarios" +
                    "\n 3. Menu Prestamos" +
                    "\n 0. Salir");

            op = leer.nextInt();
            switch (op) {
                case 1:
                    menuLibro(biblioteca1);
                    break;
                case 2:
                    menuUsuario(biblioteca1);
                    break;
                case 3:
                    menuPrestamo(biblioteca1);
                    break;
                case 0:
                    System.out.println("Saliendoo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (op != 0);

    }

    public static void menuLibro(Biblioteca biblioteca1) {
        Scanner leer = new Scanner(System.in);
        int op;
        boolean encontrado = false;
        do {
            System.out.println("-------------- Biblioteca --------------" +
                    "\n 1. Registrar Libro" +
                    "\n 2. Mostrar Libros" +
                    "\n 3. Registrar Ejemplar" +
                    "\n 4. Mostrar ejemplares del libro" +
                    "\n 0. Regresar");
            op = leer.nextInt();
            leer.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Ingresa el titulo del libro");
                    String titulo = leer.nextLine();
                    System.out.println("Ahora ingrese el autor del libro");
                    String autor = leer.nextLine();
                    Libro libroDefault = new Libro(titulo,autor);
                    biblioteca1.agregarLibro(libroDefault);
                    break;
                case 2:
                    biblioteca1.mostrarLibros();
                    break;
                case 3:
                    System.out.println("Ingrese el titulo del libro y asi registrar el ejemplar");
                    String libroBusqueda = leer.nextLine();
                    System.out.println("Ingrese el codigo del ejemplar");
                    String codigo = leer.nextLine();
                    encontrado = false;
                    for (Libro libro : biblioteca1.librosSet) {
                        if (libroBusqueda.equals(libro.getTitulo())) {
                            libro.agregarEjemplar(codigo, EstadoEjemplar.DISPONIBLE);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado)System.out.println("Libro no encontrado");
                    break;
                case 4:
                    System.out.println("Ingrese el titulo del libro y asi mostrar los ejemplares");
                    String tituloBusqueda = leer.nextLine();
                    encontrado = false;
                    for (Libro libro : biblioteca1.librosSet) {
                        if (tituloBusqueda.equals(libro.getTitulo())) {
                            libro.mostrarEjemplares();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado)System.out.println("Libro no encontrado");
                    break;
                case 0:
                    System.out.println("Regresandoo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (op != 0);
    }

    public static void menuUsuario(Biblioteca biblioteca1) {
        Scanner leer = new Scanner(System.in);
        int op;
        do {
            System.out.println("-------------- Biblioteca --------------" +
                    "\n 1. Registrar Usuario" +
                    "\n 2. Mostrar Ejemplares del usuario" +
                    "\n 3. Mostrar Usuarios" +
                    "\n 0. Regresar");
            op = leer.nextInt();
            leer.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Ingresa el nombre del Usuario a registrar");
                    String nombreUsuario = leer.nextLine();
                    System.out.println("Ahora ingrese el numero de usuario");
                    String numUsuario = leer.nextLine();
                    Usuario usurioDefault = new Usuario(nombreUsuario,numUsuario);
                    biblioteca1.agregarUsuario(usurioDefault);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del usuario y asi mostrar sus ejemplares en posesion");
                    String nombreBusqueda = leer.nextLine();
                    boolean encontrado = false;
                    for (Usuario usuario : biblioteca1.usuarios) {
                        if (nombreBusqueda.equals(usuario.getNombre())) {
                            usuario.mostrarEjemplares();
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado)System.out.println("Usuario no encontrado");
                    break;
                case 3:
                    biblioteca1.mostrarUsuarios();
                    break;
                case 0:
                    System.out.println("Regresandooo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (op != 0);
    }

    public static void menuPrestamo(Biblioteca biblioteca1) {

        int op;
        boolean encontrado= false;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("-------------- Biblioteca --------------" +
                    "\n 1. Registrar prestamo" +
                    "\n 2. Mostrar ejemplares del prestamo" +
                    "\n 3. Devovler libros" +
                    "\n 0. Regresar");
            op = leer.nextInt();
            leer.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Ingrese el nombre del usuario y asi registrar su prestamo");
                    String nombreBusqueda = leer.nextLine();
                    System.out.println("Ingresa la fecha de devolucion");
                    String textoFecha = leer.nextLine();
                    LocalDate fechaDevolucion = LocalDate.parse(textoFecha);
                    Prestamo prestamoDefault = new Prestamo(LocalDate.now(),fechaDevolucion,nombreBusqueda);
                    System.out.println("Ingresa el titulo del libro");
                    String titulo = leer.nextLine();
                    biblioteca1.prestamoSet.add(prestamoDefault);
                    encontrado = false;
                    for (Libro libro : biblioteca1.librosSet) {
                        if (titulo.equals(libro.getTitulo())) {
                            for (Usuario usuario : biblioteca1.usuarios) {
                                if (nombreBusqueda.equals(usuario.getNombre())) {
                                    prestamoDefault.registrarPrestamo(usuario, libro);
                                    usuario.agregarPrestamo(prestamoDefault);
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del usuario y asi registrar su prestamo");
                    String nombreBusquedaprestamo = leer.nextLine();
                    encontrado = false;
                    for (Prestamo prestamo : biblioteca1.prestamoSet) {
                        if (nombreBusquedaprestamo.equals(prestamo.getNombreUsuario())) {
                            prestamo.mostrarEjemplares();
                            encontrado = true;
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del usuario y asi devolver su prestamo");
                    String nombreBusquedadevolver = leer.nextLine();
                    encontrado = false;
                    for (Prestamo prestamo : biblioteca1.prestamoSet) {
                        if (nombreBusquedadevolver.equals(prestamo.getNombreUsuario())) {
                            prestamo.devolverLibros();
                            encontrado = true;
                            break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Regresandoo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (op != 0);
    }
}