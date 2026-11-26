/**
 * Ejemplo mínimo del patrón Singleton para compartir una configuración.
 */
public final class SingletonConfiguracion {

    private static final SingletonConfiguracion INSTANCIA = new SingletonConfiguracion();
    private String idioma = "es";

    private SingletonConfiguracion() {
    }

    /**
     * Devuelve la única instancia disponible.
     *
     * @return instancia compartida
     */
    public static SingletonConfiguracion getInstance() {
        return INSTANCIA;
    }

    /**
     * Devuelve el idioma configurado.
     *
     * @return idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Actualiza el idioma configurado.
     *
     * @param idioma nuevo idioma
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Comprueba que dos llamadas devuelven el mismo objeto.
     *
     * @param args no se utilizan
     */
    public static void main(String[] args) {
        SingletonConfiguracion primera = getInstance();
        SingletonConfiguracion segunda = getInstance();
        primera.setIdioma("es");
        System.out.println("Misma instancia: " + (primera == segunda));
        System.out.println("Idioma: " + segunda.getIdioma());
    }
}
