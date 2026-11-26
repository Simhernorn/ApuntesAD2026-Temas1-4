import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Escribe y lee valores primitivos en un fichero binario.
 */
public class DatosBinarios {

    /**
     * Guarda un entero, un decimal y una cadena; luego los lee en el mismo orden.
     *
     * @param args no se utilizan
     * @throws IOException si ocurre un error de lectura o escritura
     */
    public static void main(String[] args) throws IOException {
        Path ruta = Paths.get("datos.bin");

        try (DataOutputStream salida = new DataOutputStream(Files.newOutputStream(ruta))) {
            salida.writeInt(7);
            salida.writeDouble(12.5);
            salida.writeUTF("Acceso a datos");
        }

        try (DataInputStream entrada = new DataInputStream(Files.newInputStream(ruta))) {
            int unidades = entrada.readInt();
            double precio = entrada.readDouble();
            String asignatura = entrada.readUTF();
            System.out.println(unidades + ", " + precio + ", " + asignatura);
        }
    }
}
