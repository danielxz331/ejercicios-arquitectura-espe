package ejercicio3.modelo;

/**
 * Clase que representa un Triángulo.
 */
public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.nombre = "Triángulo";
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public String toString() {
        return "Triangulo{base=" + base + ", altura=" + altura + ", area=" + area() + "}";
    }
}
