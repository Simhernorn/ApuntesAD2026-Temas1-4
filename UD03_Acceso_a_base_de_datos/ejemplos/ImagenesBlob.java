import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Guarda una imagen en un BLOB y recupera sus bytes a un fichero.
 */
public class ImagenesBlob {

    /**
     * Guarda y vuelve a descargar una imagen asociada a un artículo existente.
     *
     * @param args identificador del artículo y ruta de la imagen de entrada
     * @throws Exception si faltan argumentos o falla la operación de fichero o JDBC
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Uso: java ImagenesBlob <id-articulo> <ruta-imagen>");
        }

        int id = Integer.parseInt(args[0]);
        Path imagen = Paths.get(args[1]);
        Path copia = Paths.get("imagen-recuperada" + obtenerExtension(imagen));

        try (Connection conexion = ConexionJdbc.abrir()) {
            guardar(conexion, id, imagen);
            recuperar(conexion, id, copia);
        }
        System.out.println("Imagen recuperada en: " + copia.toAbsolutePath());
    }

    private static void guardar(Connection conexion, int id, Path imagen) throws Exception {
        String sql = "UPDATE articulos SET imagen = ? WHERE id = ?";
        try (InputStream entrada = Files.newInputStream(imagen);
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setBinaryStream(1, entrada, Files.size(imagen));
            sentencia.setInt(2, id);
            if (sentencia.executeUpdate() != 1) {
                throw new SQLException("No existe el artículo con id " + id + ".");
            }
        }
    }

    private static void recuperar(Connection conexion, int id, Path destino) throws Exception {
        try (PreparedStatement sentencia =
                     conexion.prepareStatement("SELECT imagen FROM articulos WHERE id = ?")) {
            sentencia.setInt(1, id);
            try (ResultSet resultado = sentencia.executeQuery()) {
                if (!resultado.next()) {
                    throw new SQLException("No existe el artículo con id " + id + ".");
                }
                try (InputStream imagen = resultado.getBinaryStream("imagen")) {
                    if (imagen == null) {
                        throw new SQLException("El artículo no tiene una imagen guardada.");
                    }
                    Files.copy(imagen, destino, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    private static String obtenerExtension(Path ruta) {
        String nombre = ruta.getFileName().toString();
        int punto = nombre.lastIndexOf('.');
        return punto >= 0 ? nombre.substring(punto) : ".bin";
    }
}
