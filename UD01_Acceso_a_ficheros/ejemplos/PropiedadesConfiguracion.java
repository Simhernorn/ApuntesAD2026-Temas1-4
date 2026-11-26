import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Guarda y carga una configuración sencilla con la clase {@link Properties}.
 */
public class PropiedadesConfiguracion {

    /**
     * Escribe la configuración y lee sus valores desde el fichero creado.
     *
     * @param args no se utilizan
     * @throws IOException si ocurre un error de lectura o escritura
     */
    public static void main(String[] args) throws IOException {
        Path ruta = Paths.get("configuracion.properties");
        Properties propiedades = new Properties();
        propiedades.setProperty("idioma", "es");
        propiedades.setProperty("tema", "claro");

        try (Writer salida = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8)) {
            propiedades.store(salida, "Configuración del ejemplo");
        }

        Properties cargadas = new Properties();
        try (Reader entrada = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
            cargadas.load(entrada);
        }

        System.out.println("Idioma: " + cargadas.getProperty("idioma"));
        System.out.println("Tema: " + cargadas.getProperty("tema"));
    }
}
