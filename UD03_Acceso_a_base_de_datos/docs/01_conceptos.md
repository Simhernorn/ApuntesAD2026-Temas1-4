# UD03 · Acceso a bases de datos

## Persistencia y JDBC

Una base de datos relacional organiza la información en tablas relacionadas mediante claves.
SQL permite definir las tablas y consultar o modificar sus filas. JDBC es la API de Java que
permite conectarse a un SGBD y ejecutar esas sentencias.

El flujo básico es:

1. Abrir una conexión con `DriverManager` y obtener un `Connection`.
2. Ejecutar SQL con `Statement`, `PreparedStatement` o `CallableStatement`.
3. Leer un `ResultSet` cuando se ejecuta una consulta.
4. Cerrar los recursos; `try-with-resources` lo hace automáticamente.

Para valores que vienen de la aplicación, `PreparedStatement` separa la sentencia de sus
parámetros. `executeUpdate()` se usa para inserciones, cambios y borrados; `executeQuery()`
devuelve el `ResultSet` de una consulta `SELECT`.

## CRUD y rutinas almacenadas

CRUD reúne las cuatro operaciones habituales: crear (`INSERT`), leer (`SELECT`), actualizar
(`UPDATE`) y borrar (`DELETE`). En un `UPDATE` o `DELETE`, la condición `WHERE` limita las
filas afectadas.

Un procedimiento almacenado se invoca desde JDBC con `CallableStatement`; sus parámetros
`OUT` se registran con `registerOutParameter()`. Una función almacenada devuelve un valor y
puede consultarse con `SELECT`, recogiendo el resultado en un `ResultSet`.

## Imágenes y datos binarios

Una imagen es un bloque de bytes. En una tabla se puede guardar en una columna BLOB; JDBC
permite enviar o recuperar el contenido mediante flujos (`setBinaryStream()` y
`getBinaryStream()`). Si el fichero es grande, los flujos evitan tener que cargarlo entero en
memoria.

## Esquema usado

`ejemplos/articulos.sql` crea una base de datos de prácticas con la tabla `articulos` y dos
rutinas: un procedimiento que cuenta artículos y una función que devuelve el precio mayor.
La tabla tiene `id`, `nombre`, `precio`, `stock`, `imagen` y `descripcion`, como en los ejemplos
de los apuntes.
