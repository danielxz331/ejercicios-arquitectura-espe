package ejercicio3.modelo;

/**
 * Clase abstracta que representa una figura geométrica.
 */
public abstract class FiguraGeometrica {
    protected String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract double area();
}
