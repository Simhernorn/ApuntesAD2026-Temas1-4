import java.nio.file.Paths;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Recorre los elementos {@code libro} del árbol DOM y muestra sus datos.
 */
public class RecorrerLibrosDom {

    /**
     * Lee el catálogo y presenta el título, la categoría y el precio de cada libro.
     *
     * @param args no se utilizan
     * @throws Exception si falla el análisis del documento
     */
    public static void main(String[] args) throws Exception {
        Document documento = XmlSupport.parse(Paths.get("bookstore.xml"));
        NodeList libros = documento.getElementsByTagName("libro");

        for (int i = 0; i < libros.getLength(); i++) {
            Element libro = (Element) libros.item(i);
            String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
            String precio = libro.getElementsByTagName("precio").item(0).getTextContent();
            System.out.println(titulo + " (" + libro.getAttribute("categoria")
                    + "): " + precio);
        }
    }
}
