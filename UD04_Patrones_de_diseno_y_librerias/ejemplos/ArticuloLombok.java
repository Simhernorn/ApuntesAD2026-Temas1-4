import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO cuyos métodos y constructores se generan con anotaciones de Lombok.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloLombok {

    private int id;
    private String nombre;
    private double precio;

    /**
     * Construye un DTO con el patrón Builder y usa los métodos generados por Lombok.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        ArticuloLombok articulo = ArticuloLombok.builder()
                .id(3)
                .nombre("Goma")
                .precio(0.5)
                .build();
        System.out.println(articulo.getNombre() + ": " + articulo.getPrecio());
    }
}
