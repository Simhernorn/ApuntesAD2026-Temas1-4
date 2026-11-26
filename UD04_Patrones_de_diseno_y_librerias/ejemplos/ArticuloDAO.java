import java.util.LinkedHashMap;
import java.util.Map;

/**
 * DAO de ejemplo que centraliza las operaciones sobre artículos.
 */
public class ArticuloDAO {

    /**
     * Operaciones que cualquier implementación del DAO debe ofrecer.
     */
    interface RepositorioArticulos {
        void guardar(ArticuloDTO articulo);
        ArticuloDTO buscar(int id);
        void borrar(int id);
    }

    private static class RepositorioEnMemoria implements RepositorioArticulos {
        private final Map<Integer, ArticuloDTO> articulos =
                new LinkedHashMap<Integer, ArticuloDTO>();

        @Override
        public void guardar(ArticuloDTO articulo) {
            articulos.put(articulo.getId(), articulo);
        }

        @Override
        public ArticuloDTO buscar(int id) {
            return articulos.get(id);
        }

        @Override
        public void borrar(int id) {
            articulos.remove(id);
        }
    }

    /**
     * Demuestra que el cliente usa la interfaz DAO para guardar y recuperar datos.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        RepositorioArticulos dao = new RepositorioEnMemoria();
        dao.guardar(new ArticuloDTO(7, "Lápiz", 0.75));

        ArticuloDTO encontrado = dao.buscar(7);
        System.out.println(encontrado.getNombre() + ": " + encontrado.getPrecio());
        dao.borrar(7);
        System.out.println("Después de borrar: " + dao.buscar(7));
    }
}
