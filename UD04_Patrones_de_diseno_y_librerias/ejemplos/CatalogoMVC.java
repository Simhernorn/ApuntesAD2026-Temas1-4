import java.util.ArrayList;
import java.util.List;

/**
 * Ejemplo de separación entre modelo, vista y controlador (MVC).
 */
public class CatalogoMVC {

    private static class Modelo {
        private final List<String> articulos = new ArrayList<String>();

        void agregar(String articulo) {
            articulos.add(articulo);
        }

        List<String> obtenerArticulos() {
            return new ArrayList<String>(articulos);
        }
    }

    private static class Vista {
        void mostrarArticulos(List<String> articulos) {
            System.out.println("Artículos del catálogo:");
            for (String articulo : articulos) {
                System.out.println("- " + articulo);
            }
        }
    }

    private static class Controlador {
        private final Modelo modelo;
        private final Vista vista;

        Controlador(Modelo modelo, Vista vista) {
            this.modelo = modelo;
            this.vista = vista;
        }

        void agregarYMostrar(String articulo) {
            modelo.agregar(articulo);
            vista.mostrarArticulos(modelo.obtenerArticulos());
        }
    }

    /**
     * Construye las tres partes y pide al controlador que coordine la acción.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);
        controlador.agregarYMostrar("Carpeta");
        controlador.agregarYMostrar("Bolígrafo");
    }
}
