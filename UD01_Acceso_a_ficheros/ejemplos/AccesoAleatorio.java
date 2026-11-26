import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Actualiza un entero en una posición concreta de un fichero.
 */
public class AccesoAleatorio {

    /**
     * Escribe un valor, lo modifica desde el principio y vuelve a leerlo.
     *
     * @param args no se utilizan
     * @throws IOException si ocurre un error de lectura o escritura
     */
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile fichero = new RandomAccessFile("aleatorio.bin", "rw")) {
            fichero.setLength(0);
            fichero.writeInt(10);

            // El entero ocupa cuatro bytes; volvemos a la posición inicial para sustituirlo.
            fichero.seek(0);
            fichero.writeInt(25);
            fichero.seek(0);
            System.out.println("Valor actualizado: " + fichero.readInt());
        }
    }
}
