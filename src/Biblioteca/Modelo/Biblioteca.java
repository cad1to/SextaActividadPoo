package Biblioteca.Modelo;
import java.util.*;

public class Biblioteca {
    private String nombre;
    Set<Usuario> usuarios = new HashSet<>();

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado con exito");
    }
}
