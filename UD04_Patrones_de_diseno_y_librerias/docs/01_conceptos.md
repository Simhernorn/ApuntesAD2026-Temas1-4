# UD04 · Patrones de diseño y librerías

## Arquitectura por capas

Una arquitectura organiza los componentes y sus relaciones. En una aplicación de tres capas,
la presentación recibe las acciones de la persona usuaria, la capa de negocio coordina el
trabajo y la capa de datos se ocupa de la persistencia. Mantener responsabilidades separadas
hace que un cambio en una capa afecte menos a las demás.

## Patrones vistos en la unidad

- **Singleton:** limita una clase a una instancia accesible mediante un método estático, como
  `getInstance()`.
- **POJO / Value Object / DTO:** objeto sencillo que agrupa los campos de una entidad y los
  transporta entre partes del programa.
- **DAO:** concentra las operaciones de acceso a datos detrás de una interfaz. El resto del
  programa depende de la interfaz, no de los detalles de persistencia.
- **MVC:** separa el modelo (datos y lógica), la vista (presentación) y el controlador (coordina
  las acciones entre ambos).
- **Inyección de dependencias:** entrega a una clase las dependencias que necesita, por ejemplo
  a través de su constructor, en vez de crearlas dentro de ella.

Estos patrones son formas de organizar el código. No sustituyen las clases de Java ni obligan a
usar un framework.

## Lombok

Lombok es una librería que genera código repetitivo durante la compilación. Sus anotaciones,
como `@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor` y `@Data`, pueden
generar accesores, constructores y métodos comunes. `@Builder` facilita construir objetos paso
a paso. Para que funcione, el proyecto debe incluir la dependencia y el entorno de compilación
debe reconocer el procesamiento de anotaciones.
