import java.io.File;

/**
 * Consulta metadatos de una ruta y, si representa una carpeta, muestra su contenido.
 */
public class InformacionFicheros {

    /**
     * Muestra información de la ruta recibida o de la carpeta actual.
     *
     * @param args ruta opcional que se quiere consultar
     */
    public static void main(String[] args) {
        File ruta = new File(args.length == 0 ? "." : args[0]);

        System.out.println("Ruta: " + ruta.getAbsolutePath());
        System.out.println("Existe: " + ruta.exists());
        System.out.println("Es carpeta: " + ruta.isDirectory());
        System.out.println("Se puede leer: " + ruta.canRead());
        System.out.println("Tamaño: " + ruta.length() + " bytes");

        if (ruta.isDirectory()) {
            File[] contenido = ruta.listFiles();
            if (contenido != null) {
                for (File elemento : contenido) {
                    System.out.println((elemento.isDirectory() ? "[DIR] " : "[FILE] ")
                            + elemento.getName());
                }
            }
        }
    }
}
