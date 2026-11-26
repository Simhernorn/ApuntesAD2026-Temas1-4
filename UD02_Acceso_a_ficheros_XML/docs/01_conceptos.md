# UD02 · Acceso a ficheros XML

## XML y analizadores

XML organiza datos con etiquetas anidadas, atributos y texto. Un documento bien formado
respeta la sintaxis XML; además, puede validarse contra una estructura como un DTD.
Un parser interpreta el documento y permite acceder a sus datos.

DOM carga el documento completo en memoria como un árbol de nodos. Así se puede recorrer,
consultar, crear y modificar el árbol, pero el tamaño del documento afecta a la memoria usada.
SAX, en cambio, procesa el documento secuencialmente mediante eventos y es apropiado cuando
solo se necesita leerlo de principio a fin.

## DOM en Java

`DocumentBuilderFactory` crea un `DocumentBuilder`, que analiza el XML y devuelve un
`Document`. Cada elemento, atributo o fragmento de texto aparece como un nodo. Los métodos
como `getElementsByTagName()`, `getChildNodes()` y `getTextContent()` permiten recorrer los
datos.

Para consultar un árbol con una expresión, Java ofrece XPath:

```text
//libro[@categoria='programacion']/titulo
```

La expresión busca los títulos de los libros cuya categoría es `programacion`. XPath resulta
útil cuando se quiere seleccionar nodos sin recorrer a mano todas las ramas del árbol.

## Crear, modificar y guardar

Los métodos de `Document` permiten construir nodos y enlazarlos con `appendChild()`. Para
guardar el árbol se usa JAXP: `TransformerFactory` crea un `Transformer` que copia el `Document`
a un `StreamResult` asociado a un fichero. Tras modificar un documento, hay que volver a
serializarlo para conservar los cambios.
