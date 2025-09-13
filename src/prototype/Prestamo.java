package prototype;

import builder.Usuario;
import factory.Libro;
import java.time.LocalDate;
import java.util.Objects;


public class Prestamo implements Cloneable{
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Prestamo(){ }

    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaInicio, LocalDate fechaFin) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public static class Builder{
        private Libro libro;
        private Usuario usuario;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;

        public Builder libro(Libro libro) { this.libro = libro; return this; }
        public Builder usuario(Usuario usuario) { this.usuario = usuario; return this; }
        public Builder fechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; return this; }
        public Builder fechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; return this; }

        public Prestamo build() { return new Prestamo(libro, usuario, fechaInicio, fechaFin); }
    }
    public static Builder builder() { return new Builder(); }

    // Getters y Setters
    public Libro getLibro() {
        return libro;
    }
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    // Evita duplicacion de prestamos
    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", usuario=" + usuario +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo)) return false;
        Prestamo that = (Prestamo) o;
        return Objects.equals(libro, that.libro) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(fechaInicio, that.fechaInicio) &&
                Objects.equals(fechaFin, that.fechaFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libro, usuario, fechaInicio, fechaFin);
    }

}
