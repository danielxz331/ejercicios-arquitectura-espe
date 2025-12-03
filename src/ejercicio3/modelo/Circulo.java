package ejercicio3.modelo;

/**
 * Clase que representa un Círculo.
 */
public class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
        this.nombre = "Círculo";
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }

    @Override
    public String toString() {
        return "Circulo{radio=" + radio + ", area=" + String.format("%.2f", area()) + "}";
    }
}
