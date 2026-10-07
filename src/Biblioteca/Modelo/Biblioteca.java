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

    public void mostrarUsuarios() {
        System.out.println("======"+getNombre()+"======");
        for(Usuario usuario : usuarios) {
            System.out.println("Nombre: "+usuario.getNombre()+".");
        }
        System.out.println();
    }

    public String getNombre() {
        return nombre;
    }
}
