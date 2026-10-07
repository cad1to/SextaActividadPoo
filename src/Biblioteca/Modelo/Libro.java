package Biblioteca.Modelo;

import java.util.HashSet;
import java.util.Set;

public class Libro {
    private String titulo;
    private String autor;
    public Set<Ejemplar> ejemplares = new HashSet<>();

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void agregarEjemplar(String codigo, EstadoEjemplar estado) {
        ejemplares.add(new Ejemplar(codigo, estado));
        System.out.println("Ejemplar agregado");
    }
    public void mostrarEjemplares() {
        System.out.println(titulo);
        for(Ejemplar ejemplar : ejemplares) {
            System.out.println("Codigo: "+ejemplar.getCodigo()+" Estado: " +ejemplar.getEstado());
        }
    }

    public Ejemplar buscarParaPrestamo(){
        for (Ejemplar ejemplarX : ejemplares){
            if(ejemplarX.getEstado() == EstadoEjemplar.DISPONIBLE){
                return ejemplarX;
            }
        }
        return null;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
