package ejercicio3.modelo;

public class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
        this.nombre = "Círculo";
    }

    public double getRadio() {
        return radio;
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
