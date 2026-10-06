package Biblioteca.Modelo;

public class Usuario {
    private String nombre;
    private String numUsuario;

    public Usuario(String nombre, String numUsuario) {
        this.nombre = nombre;
        this.numUsuario = numUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumUsuario() {
        return numUsuario;
    }
}
