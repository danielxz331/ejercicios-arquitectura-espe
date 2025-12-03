package ejercicio5.pool;

/**
 * Interface que deben implementar los objetos que serán gestionados por el pool.
 */
public interface Poolable {
    /**
     * Reinicia el estado del objeto para ser reutilizado
     */
    void reset();
    
    /**
     * Verifica si el objeto está disponible para ser usado
     */
    boolean isDisponible();
    
    /**
     * Marca el objeto como en uso o disponible
     */
    void setDisponible(boolean disponible);
}
