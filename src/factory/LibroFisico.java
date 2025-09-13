package factory;

import java.util.Objects;

public class LibroFisico implements Libro{
    private String titulo;
    private String autor;
    private int paginas;

    public LibroFisico(String titulo, String autor, int paginas) {
        this.titulo = Objects.requireNonNull(titulo);
        this.autor = Objects.requireNonNull(autor);
        this.paginas = paginas;
    }

    public static class Builder {
        private String titulo;
        private String autor;
        private int paginas;

        public Builder titulo(String titulo) { this.titulo = titulo; return this; }
        public Builder autor(String autor) { this.autor = autor; return this; }
        public Builder paginas(int paginas) { this.paginas = paginas; return this; }

        public LibroFisico build() { return new LibroFisico(titulo, autor, paginas); }
    }
    public static Builder builder() { return new Builder(); }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    // Métodos de la interzaf
    @Override
    public String getTitulo() {
        return titulo;
    }
    @Override
    public String getAutor() {
        return autor;
    }
    @Override
    public String getTipo() {
        return "FISICO";
    }
    @Override
    public int getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return "LibroFisico{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}
