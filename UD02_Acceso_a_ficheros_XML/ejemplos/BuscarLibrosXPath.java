import java.nio.file.Paths;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Busca con XPath los títulos de los libros de programación.
 */
public class BuscarLibrosXPath {

    /**
     * Analiza {@code bookstore.xml} y muestra los títulos seleccionados.
     *
     * @param args no se utilizan
     * @throws Exception si falla el análisis o la consulta XPath
     */
    public static void main(String[] args) throws Exception {
        Document documento = XmlSupport.parse(Paths.get("bookstore.xml"));
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList titulos = (NodeList) xpath.evaluate(
                "//libro[@categoria='programacion']/titulo",
                documento,
                XPathConstants.NODESET);

        for (int i = 0; i < titulos.getLength(); i++) {
            Node titulo = titulos.item(i);
            System.out.println(titulo.getTextContent());
        }
    }
}
