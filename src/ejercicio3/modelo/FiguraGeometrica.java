package ejercicio3.modelo;

public abstract class FiguraGeometrica {
    protected String nombre;

    public String getNombre() {
        return nombre;
    }

    public abstract double area();
}
