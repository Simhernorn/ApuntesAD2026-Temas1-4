import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Guarda un objeto en binario y crea otro objeto a partir de ese fichero.
 */
public class SerializarProducto {

    /**
     * Escribe y recupera un producto serializable.
     *
     * @param args no se utilizan
     * @throws IOException si falla el acceso al fichero
     * @throws ClassNotFoundException si no se encuentra la clase serializada
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Producto producto = new Producto("Cuaderno", 3.5);
        try (ObjectOutputStream salida =
                     new ObjectOutputStream(new FileOutputStream("producto.obj"))) {
            salida.writeObject(producto);
        }

        try (ObjectInputStream entrada =
                     new ObjectInputStream(new FileInputStream("producto.obj"))) {
            Producto recuperado = (Producto) entrada.readObject();
            System.out.println(recuperado.getNombre() + ": " + recuperado.getPrecio());
        }
    }

    /**
     * Objeto sencillo cuyos datos se pueden serializar.
     */
    private static class Producto implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String nombre;
        private final double precio;

        private Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        private String getNombre() {
            return nombre;
        }

        private double getPrecio() {
            return precio;
        }
    }
}
