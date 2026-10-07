package Biblioteca.Modelo;
import Biblioteca.Servicio.Prestamo;

import java.util.*;

public class Biblioteca {
    private String nombre;
    public Set<Usuario> usuarios = new HashSet<>();
    public Set<Libro> librosSet = new HashSet<>();
    public Set<Prestamo> prestamoSet = new HashSet<>();

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado con exito");
    }

    public void agregarLibro(Libro libro) {
        librosSet.add(libro);
        System.out.println("Libro agregado con exito");
    }

    public void mostrarUsuarios() {
        System.out.println("======"+getNombre()+"======");
        for(Usuario usuario : usuarios) {
            System.out.println("Nombre: "+usuario.getNombre()+".");
        }
        System.out.println();
    }

    public void mostrarLibros() {
        System.out.println("======"+getNombre()+"======");
        for(Libro libro : librosSet) {
            System.out.println("Nombre: "+libro.getTitulo()+"." + "  Autor: "+libro.getAutor()+".");
        }
        System.out.println();
    }

    public String getNombre() {
        return nombre;
    }
}
