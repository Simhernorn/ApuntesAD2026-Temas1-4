import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Demuestra las cuatro operaciones CRUD con sentencias parametrizadas.
 */
public class CrudArticulos {

    /**
     * Crea una fila de prueba, la consulta, la actualiza y finalmente la borra.
     *
     * @param args no se utilizan
     * @throws SQLException si falla alguna operación JDBC
     */
    public static void main(String[] args) throws SQLException {
        try (Connection conexion = ConexionJdbc.abrir()) {
            int id = insertar(conexion);
            consultar(conexion, id);
            actualizar(conexion, id);
            borrar(conexion, id);
        }
    }

    private static int insertar(Connection conexion) throws SQLException {
        String sql = "INSERT INTO articulos (nombre, precio, stock, descripcion) "
                + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement sentencia =
                     conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            sentencia.setString(1, "Artículo de prueba JDBC");
            sentencia.setBigDecimal(2, new BigDecimal("4.50"));
            sentencia.setInt(3, 3);
            sentencia.setString(4, "Fila temporal para mostrar CRUD");
            sentencia.executeUpdate();

            try (ResultSet claves = sentencia.getGeneratedKeys()) {
                if (!claves.next()) {
                    throw new SQLException("MySQL no devolvió el identificador generado.");
                }
                return claves.getInt(1);
            }
        }
    }

    private static void consultar(Connection conexion, int id) throws SQLException {
        String sql = "SELECT nombre, precio FROM articulos WHERE id = ?";
        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setInt(1, id);
            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    System.out.println("Leído: " + resultado.getString("nombre")
                            + " (" + resultado.getBigDecimal("precio") + ")");
                }
            }
        }
    }

    private static void actualizar(Connection conexion, int id) throws SQLException {
        String sql = "UPDATE articulos SET precio = ?, stock = ? WHERE id = ?";
        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setBigDecimal(1, new BigDecimal("5.00"));
            sentencia.setInt(2, 4);
            sentencia.setInt(3, id);
            sentencia.executeUpdate();
        }
    }

    private static void borrar(Connection conexion, int id) throws SQLException {
        try (PreparedStatement sentencia =
                     conexion.prepareStatement("DELETE FROM articulos WHERE id = ?")) {
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        }
    }
}
