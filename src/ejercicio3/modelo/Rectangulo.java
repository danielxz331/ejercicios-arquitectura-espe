package ejercicio3.modelo;

/**
 * Clase que representa un Rectángulo.
 */
public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.nombre = "Rectángulo";
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
        return base * altura;
    }

    @Override
    public String toString() {
        return "Rectangulo{base=" + base + ", altura=" + altura + ", area=" + area() + "}";
    }
}
