/**
 * Ejemplo de inyección de dependencias a través del constructor.
 */
public class InyeccionDependencias {

    private interface Salida {
        void mostrar(String mensaje);
    }

    private static class SalidaConsola implements Salida {
        @Override
        public void mostrar(String mensaje) {
            System.out.println(mensaje);
        }
    }

    private static class ServicioCatalogo {
        private final Salida salida;

        ServicioCatalogo(Salida salida) {
            this.salida = salida;
        }

        void informarArticulo(String nombre) {
            salida.mostrar("Artículo: " + nombre);
        }
    }

    /**
     * Crea la dependencia y la entrega al servicio desde el programa principal.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        Salida salida = new SalidaConsola();
        ServicioCatalogo servicio = new ServicioCatalogo(salida);
        servicio.informarArticulo("Regla");
    }
}
