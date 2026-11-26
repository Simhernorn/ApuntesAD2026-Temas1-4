import java.io.IOException;
import java.nio.file.Path;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Operaciones comunes para analizar y guardar los XML de estos ejemplos.
 */
final class XmlSupport {

    private XmlSupport() {
    }

    /**
     * Analiza un fichero XML y devuelve su árbol DOM.
     *
     * @param ruta fichero que se va a analizar
     * @return documento DOM en memoria
     * @throws ParserConfigurationException si no se puede configurar el parser
     * @throws IOException si no se puede leer el fichero
     * @throws SAXException si el XML no es válido sintácticamente
     */
    static Document parse(Path ruta)
            throws ParserConfigurationException, IOException, SAXException {
        return crearBuilder().parse(ruta.toFile());
    }

    /**
     * Crea un documento DOM vacío.
     *
     * @return documento DOM nuevo
     * @throws ParserConfigurationException si no se puede configurar el parser
     */
    static Document newDocument() throws ParserConfigurationException {
        return crearBuilder().newDocument();
    }

    /**
     * Guarda un árbol DOM con formato legible.
     *
     * @param documento árbol que se va a guardar
     * @param ruta fichero de salida
     * @throws TransformerException si falla la transformación del árbol
     */
    static void save(Document documento, Path ruta) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.transform(new DOMSource(documento), new StreamResult(ruta.toFile()));
    }

    private static DocumentBuilder crearBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);
        return factory.newDocumentBuilder();
    }
}
