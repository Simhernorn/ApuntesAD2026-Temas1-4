# UD01 · Cómo probar los ejemplos

Los ejemplos son programas Java independientes y usan el directorio de trabajo actual para
crear sus ficheros. Desde `ejemplos`, compila y ejecuta el programa que quieras:

```text
javac TextoPlano.java
java TextoPlano
```

| Programa | Concepto que practica |
| --- | --- |
| `InformacionFicheros` | Rutas, directorios y metadatos de `File`. |
| `TextoPlano` | Lectura y escritura de texto en UTF-8 con búfer. |
| `PropiedadesConfiguracion` | Cargar y guardar pares de configuración. |
| `DatosBinarios` | Escribir y leer tipos primitivos en el mismo orden. |
| `AccesoAleatorio` | Mover el cursor y actualizar un dato con `seek()`. |
| `SerializarProducto` | Guardar y recuperar un objeto `Serializable`. |

Cada programa crea o sobrescribe únicamente los ficheros de ejemplo con nombre explícito en
su código (`notas.txt`, `configuracion.properties`, etc.).
