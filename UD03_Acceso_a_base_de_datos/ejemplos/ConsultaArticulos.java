import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Consulta y muestra los artículos guardados en la base de datos.
 */
public class ConsultaArticulos {

    /**
     * Ejecuta un SELECT y recorre las filas obtenidas.
     *
     * @param args no se utilizan
     * @throws SQLException si falla la conexión o la consulta
     */
    public static void main(String[] args) throws SQLException {
        String sql = "SELECT id, nombre, precio, stock FROM articulos ORDER BY id";
        try (Connection conexion = ConexionJdbc.abrir();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                System.out.printf("%d | %s | %.2f | stock: %d%n",
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getBigDecimal("precio"),
                        resultado.getInt("stock"));
            }
        }
    }
}
