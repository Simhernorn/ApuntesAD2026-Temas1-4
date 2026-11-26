import java.nio.file.Paths;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * Modifica un título del catálogo y guarda el resultado en otro fichero.
 */
public class ActualizarCatalogoDom {

    /**
     * Cambia el primer título y serializa el árbol DOM modificado.
     *
     * @param args no se utilizan
     * @throws Exception si falla el análisis, modificación o guardado
     */
    public static void main(String[] args) throws Exception {
        Document documento = XmlSupport.parse(Paths.get("bookstore.xml"));
        NodeList titulos = documento.getElementsByTagName("titulo");

        if (titulos.getLength() == 0) {
            throw new IllegalStateException("El catálogo no contiene títulos.");
        }

        // Se modifica el árbol en memoria; el fichero original queda intacto.
        titulos.item(0).setTextContent("Java y documentos XML");
        XmlSupport.save(documento, Paths.get("bookstore-actualizado.xml"));
        System.out.println("Catálogo actualizado.");
    }
}
