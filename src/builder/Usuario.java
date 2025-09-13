package builder;

import java.time.LocalDate; // Se utiliza para manejar fechas sin horas
import java.util.Objects;

// Declaro las atrubutos de la clase usuario
public class Usuario {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;

    private Usuario(){ } // Permite crear un objeto Usuario sin pasar parámetros.

    // Creo el constructor que inicializa todos los atributos en el momento de crear el objeto
    public Usuario(String nombre, String email, String direccion, String telefono, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Con el patrón Builder: construimos objetos paso a paso de forma legible.
    public static class Builder {
        private String nombre;
        private String email;
        private String direccion;
        private String telefono;
        private LocalDate fechaNacimiento;

        // Cada metodo asigna un atributo al builder y devuelve this para permitir encadenamiento fluido.
        public Builder nombre(String nombre) { this.nombre = nombre; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder direccion(String direccion) { this.direccion = direccion; return this; }
        public Builder telefono(String telefono) { this.telefono = telefono; return this; }
        public Builder fechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; return this; }

        // Construye un objeto Usuario usando los valores almacenados en el builder.
        public Usuario build(){
            return new Usuario(nombre, email, direccion, telefono, fechaNacimiento);
        }
    }
    public static Builder builder() { return new Builder(); }

        // equals & hashCode (basados en email)
        @Override
        public boolean equals(Object o) {     //equals: compara dos objetos Usuario basándose en el campo email.
            if (this == o) return true;
            if (!(o instanceof Usuario)) return false;
            Usuario usuario = (Usuario) o;
            return Objects.equals(email, usuario.email);
        }

        @Override
        public int hashCode() { return Objects.hash(email); }     //hashCode: devuelve un entero consistente con equals

        @Override
        public String toString() { // Sirve para dar una representación en texto legible de la clase
            return "Usuario{" +
                    "nombre='" + nombre + '\'' +
                    ", email='" + email + '\'' +
                    ", direccion='" + direccion + '\'' +
                    ", telefono='" + telefono + '\'' +
                    ", fechaNacimiento=" + fechaNacimiento +
                    '}';
        }
}

