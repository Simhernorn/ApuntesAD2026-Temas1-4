import java.nio.file.Paths;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Construye un documento XML nuevo mediante operaciones DOM.
 */
public class CrearCatalogoDom {

    /**
     * Crea un catálogo pequeño y lo serializa en {@code catalogo-nuevo.xml}.
     *
     * @param args no se utilizan
     * @throws Exception si falla la creación o serialización del documento
     */
    public static void main(String[] args) throws Exception {
        Document documento = XmlSupport.newDocument();
        Element raiz = documento.createElement("bookstore");
        documento.appendChild(raiz);

        Element libro = documento.createElement("libro");
        libro.setAttribute("categoria", "programacion");
        raiz.appendChild(libro);

        agregarTexto(documento, libro, "titulo", "DOM en Java");
        agregarTexto(documento, libro, "autor", "Marta Gil");
        agregarTexto(documento, libro, "precio", "19.95");

        XmlSupport.save(documento, Paths.get("catalogo-nuevo.xml"));
        System.out.println("Catálogo guardado.");
    }

    private static void agregarTexto(Document documento, Element padre,
                                     String etiqueta, String valor) {
        Element elemento = documento.createElement(etiqueta);
        elemento.setTextContent(valor);
        padre.appendChild(elemento);
    }
}
