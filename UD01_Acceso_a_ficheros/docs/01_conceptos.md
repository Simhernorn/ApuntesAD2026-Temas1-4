# UD01 · Acceso a ficheros

## Ficheros y rutas

Un fichero guarda información de forma persistente. Los directorios permiten organizar los
ficheros en una estructura jerárquica y una ruta identifica dónde está cada uno. Una ruta puede
ser absoluta (`C:/datos/notas.txt`) o relativa al directorio desde el que se ejecuta el programa
(`datos/notas.txt`).

La clase `File` representa un fichero o directorio y permite consultar sus propiedades y
gestionar la estructura del sistema de ficheros. **No** lee ni escribe el contenido: para eso se
usan flujos (`streams`).

## Texto y configuración

Los ficheros de texto guardan caracteres que una persona puede leer. `FileReader` y
`FileWriter` trabajan con caracteres; `BufferedReader` y `BufferedWriter` añaden un búfer y
permiten leer o escribir líneas cómodamente. Al elegir una codificación, por ejemplo UTF-8, el
contenido se interpreta de la misma manera al guardar y al leer.

Un fichero de propiedades es texto con pares `clave=valor`. La clase `Properties` permite
cargarlo y guardarlo; es práctico para separar datos de configuración del código.

```properties
idioma=es
tema=claro
```

## Datos binarios y acceso aleatorio

Un fichero binario almacena bytes, no texto pensado para leer directamente. `DataOutputStream`
y `DataInputStream` escriben y leen tipos primitivos en el mismo orden. El orden y el tipo de
cada lectura deben coincidir con los de la escritura.

`RandomAccessFile` permite desplazarse a una posición con `seek()` y leer o modificar datos sin
recorrer el fichero desde el principio. Es útil cuando la posición de los datos es conocida.

## Serialización de objetos

La serialización transforma un objeto en una secuencia de bytes que puede guardarse y
recuperarse con `ObjectOutputStream` y `ObjectInputStream`. La clase debe implementar
`Serializable`. `serialVersionUID` identifica la versión serializada de la clase; cambiar la
estructura de una clase puede impedir leer ficheros antiguos, por lo que la serialización no es
un formato de intercambio estable.
