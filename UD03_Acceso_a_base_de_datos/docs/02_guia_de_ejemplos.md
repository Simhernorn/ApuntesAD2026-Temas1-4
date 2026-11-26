# UD03 · Preparar y probar los ejemplos

Se necesita un servidor MySQL, la base de datos del fichero `ejemplos/articulos.sql` y el
conector JDBC de MySQL. Desde `ejemplos`, ejecuta el script en MySQL y configura estas
variables de entorno antes de lanzar los programas:

```text
AD_JDBC_URL=jdbc:mysql://localhost:3306/acceso_datos?serverTimezone=UTC
AD_DB_USER=usuario_mysql
AD_DB_PASSWORD=contraseña_mysql
```

El proyecto `pom.xml` descarga Connector/J y permite compilar los ejemplos con `mvn compile`.
Cada clase `main` es independiente; ejecuta una a la vez con la clase compilada y las
dependencias en el classpath.

| Programa | Concepto que practica |
| --- | --- |
| `ConsultaArticulos` | Abrir una conexión y recorrer un `ResultSet`. |
| `CrudArticulos` | Insertar, consultar, actualizar y borrar con parámetros. |
| `RutinasAlmacenadas` | Llamar a un procedimiento y consultar una función. |
| `ImagenesBlob` | Guardar y recuperar bytes de una imagen en una columna BLOB. |

`ImagenesBlob` recibe el identificador de un artículo existente y la ruta de una imagen:

```text
java ImagenesBlob 1 foto.jpg
```

Los programas no contienen credenciales; léenlas del entorno. Usa una base de datos de
prácticas, porque el ejemplo CRUD crea y borra una fila de prueba.
