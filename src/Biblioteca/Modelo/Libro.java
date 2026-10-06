package Biblioteca.Modelo;

import java.util.HashSet;
import java.util.Set;

public class Libro {
    private String titulo;
    private String autor;
    Set<Ejemplar> libros = new HashSet<>();

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void agregarEjemplar(String codigo, EstadoEjemplar estado) {
        libros.add(new Ejemplar(codigo, estado));
        System.out.println("Ejemplar agregado");
    }
    public void mostrarEjemplares() {
        System.out.println(titulo);
        for(Ejemplar ejemplar : libros) {
            System.out.println("Codigo: "+ejemplar.getCodigo()+" Estado: " +ejemplar.getEstado());
        }
    }
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
