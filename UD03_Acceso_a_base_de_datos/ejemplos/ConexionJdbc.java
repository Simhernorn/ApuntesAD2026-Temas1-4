import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Abre conexiones JDBC usando la configuración del entorno.
 */
final class ConexionJdbc {

    private static final String URL_PREDETERMINADA =
            "jdbc:mysql://localhost:3306/acceso_datos?serverTimezone=UTC";

    private ConexionJdbc() {
    }

    /**
     * Abre una conexión a la base de datos de prácticas.
     *
     * @return conexión abierta
     * @throws SQLException si faltan credenciales o no se puede conectar
     */
    static Connection abrir() throws SQLException {
        String url = System.getenv("AD_JDBC_URL");
        String usuario = System.getenv("AD_DB_USER");
        String contrasena = System.getenv("AD_DB_PASSWORD");

        if (url == null || url.trim().isEmpty()) {
            url = URL_PREDETERMINADA;
        }
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new SQLException("Define la variable de entorno AD_DB_USER.");
        }

        return DriverManager.getConnection(url, usuario, contrasena == null ? "" : contrasena);
    }
}
