/**
 * POJO/DTO que agrupa datos de un artículo para transportarlos como un objeto.
 */
public class ArticuloDTO {

    private int id;
    private String nombre;
    private double precio;

    /**
     * Crea un DTO vacío.
     */
    public ArticuloDTO() {
    }

    /**
     * Crea un DTO con los campos del artículo.
     *
     * @param id identificador del artículo
     * @param nombre nombre del artículo
     * @param precio precio del artículo
     */
    public ArticuloDTO(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Devuelve el identificador.
     *
     * @return identificador del artículo
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el nombre.
     *
     * @return nombre del artículo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el precio.
     *
     * @return precio del artículo
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Cambia el identificador.
     *
     * @param id nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Cambia el nombre.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Cambia el precio.
     *
     * @param precio nuevo precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Muestra cómo se pasa un objeto completo a un método.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        ArticuloDTO articulo = new ArticuloDTO(1, "Cuaderno", 3.5);
        imprimirArticulo(articulo);
    }

    private static void imprimirArticulo(ArticuloDTO articulo) {
        System.out.println(articulo.getId() + " - " + articulo.getNombre()
                + " - " + articulo.getPrecio());
    }
}
