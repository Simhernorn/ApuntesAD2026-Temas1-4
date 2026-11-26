# UD02 · Cómo probar los ejemplos

Los programas utilizan exclusivamente APIs estándar de Java (DOM, XPath y JAXP). Desde
`ejemplos`, compila la clase y ejecuta el nombre que quieras:

```text
javac XmlSupport.java BuscarLibrosXPath.java
java BuscarLibrosXPath
```

| Programa | Concepto que practica |
| --- | --- |
| `BuscarLibrosXPath` | Analizar un XML y seleccionar nodos con XPath. |
| `RecorrerLibrosDom` | Recorrer elementos y leer atributos y texto. |
| `CrearCatalogoDom` | Crear nodos DOM y guardar un documento nuevo. |
| `ActualizarCatalogoDom` | Modificar un nodo y guardar el árbol actualizado. |

`XmlSupport` es una ayuda compartida para analizar y guardar los ficheros de ejemplo.
`bookstore.xml` es el documento de entrada de los dos primeros ejemplos y del programa de
modificación; los programas de escritura generan otros ficheros, sin cambiar el original.
