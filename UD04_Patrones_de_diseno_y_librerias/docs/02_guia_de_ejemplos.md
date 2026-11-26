# UD04 · Cómo probar los ejemplos

Los primeros cinco programas usan únicamente Java estándar. Desde `ejemplos`, compila cada
clase que quieras probar:

```text
javac SingletonConfiguracion.java
java SingletonConfiguracion
```

| Programa | Concepto que practica |
| --- | --- |
| `SingletonConfiguracion` | Una instancia compartida con `getInstance()`. |
| `ArticuloDTO` | Agrupar y transportar campos en un POJO/DTO. |
| `ArticuloDAO` | Separar operaciones de datos tras una interfaz DAO. |
| `CatalogoMVC` | Separar modelo, vista y controlador. |
| `InyeccionDependencias` | Entregar una dependencia al servicio por constructor. |
| `ArticuloLombok` | Generar métodos de un DTO con anotaciones Lombok. |

`ArticuloLombok` requiere Lombok y un procesador de anotaciones. Su `pom.xml` declara la
dependencia y compila todos los ejemplos con `mvn compile`. Sin Lombok, los otros cinco
programas se pueden compilar y ejecutar directamente con `javac` y `java`.
