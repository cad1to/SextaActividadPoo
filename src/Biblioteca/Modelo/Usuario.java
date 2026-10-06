package Biblioteca.Modelo;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
    private String nombre;
    private String numUsuario;
    public Set<Ejemplar> ejemplaresEnPosesion = new HashSet<>();

    public Usuario(String nombre, String numUsuario) {
        this.nombre = nombre;
        this.numUsuario = numUsuario;
    }

    public void mostrarLibrosPrestados () {
        for (Ejemplar ejemplar : ejemplaresEnPosesion) {
            System.out.println("Codigo: "+ ejemplar.getCodigo() + "Codigo ");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumUsuario() {
        return numUsuario;
    }
}
