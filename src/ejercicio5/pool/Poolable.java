package ejercicio5.pool;

public interface Poolable {

    void reset();

    boolean isDisponible();

    void setDisponible(boolean disponible);
}
