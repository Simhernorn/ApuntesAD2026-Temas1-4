import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Escribe y después lee un fichero de texto usando UTF-8 y flujos con búfer.
 */
public class TextoPlano {

    /**
     * Crea {@code notas.txt} y muestra sus líneas por consola.
     *
     * @param args no se utilizan
     * @throws IOException si ocurre un error de lectura o escritura
     */
    public static void main(String[] args) throws IOException {
        Path ruta = Paths.get("notas.txt");

        // El try-with-resources cierra el flujo incluso si ocurre un error.
        try (BufferedWriter salida = Files.newBufferedWriter(ruta, StandardCharsets.UTF_8)) {
            salida.write("Primera línea");
            salida.newLine();
            salida.write("Texto guardado en UTF-8");
            salida.newLine();
        }

        try (BufferedReader entrada = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}
