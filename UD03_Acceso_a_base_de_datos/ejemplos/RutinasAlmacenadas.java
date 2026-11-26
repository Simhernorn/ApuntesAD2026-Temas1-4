import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Invoca un procedimiento y una función almacenados en MySQL.
 */
public class RutinasAlmacenadas {

    /**
     * Obtiene el número de artículos mediante un parámetro OUT y el precio máximo.
     *
     * @param args no se utilizan
     * @throws SQLException si falla la llamada a una rutina o consulta
     */
    public static void main(String[] args) throws SQLException {
        try (Connection conexion = ConexionJdbc.abrir()) {
            try (CallableStatement procedimiento =
                         conexion.prepareCall("{call contar_articulos(?)}")) {
                procedimiento.registerOutParameter(1, Types.INTEGER);
                procedimiento.execute();
                System.out.println("Número de artículos: "
                        + procedimiento.getInt(1));
            }

            // Una función almacenada devuelve un valor que se lee como resultado de SELECT.
            try (PreparedStatement consulta =
                         conexion.prepareStatement("SELECT precio_mas_alto()");
                 ResultSet resultado = consulta.executeQuery()) {
                if (resultado.next()) {
                    System.out.println("Precio máximo: " + resultado.getBigDecimal(1));
                }
            }
        }
    }
}
