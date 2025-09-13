package factory;

public class LogisticaLibro {
    //Define una interfaz para crear un objeto, pero deja que las subclases decidan qué clase instanciar.
    public static Libro crear(String tipo, String autor, String titulo, int paginas){ // Factory Method
        String t = tipo == null ? "" : tipo.trim().toUpperCase();
        switch (t) {
            case "FISICO":
                return LibroFisico.builder() //Creo la estructura del libro para crear otros
                    .titulo(titulo)
                    .autor(autor)
                    .paginas(paginas)
                    .build();
            case "DIGITAL":
                return LibroDigital.builder()
                    .titulo(titulo)
                    .autor(autor)
                    .paginas(paginas)
                    .build();
            default:throw new IllegalArgumentException("Tipo de Libro desconocido" + tipo);
        }
    }
}
