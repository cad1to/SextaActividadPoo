package Biblioteca.Modelo;
import Biblioteca.Servicio.Prestamo;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
    private String nombre;
    private String numUsuario;
    private Set<Prestamo> PrestamosUsuario = new HashSet<>();

    public Usuario(String nombre, String numUsuario) {
        this.nombre = nombre;
        this.numUsuario = numUsuario;
    }

    public void agregarPrestamo(Prestamo prestamo){
        PrestamosUsuario.add(prestamo);
    }

    public void mostrarEjemplares() {
        System.out.println("Libros en posicion de "+getNombre()+".");
        for(Prestamo prestamoX : PrestamosUsuario) {
            prestamoX.mostrarEjemplares();
        }
    }

    public Set<Prestamo> getPrestamosUsuario() {
        return PrestamosUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumUsuario() {
        return numUsuario;
    }
}
