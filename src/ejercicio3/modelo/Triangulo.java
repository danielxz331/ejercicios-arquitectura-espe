package ejercicio3.modelo;

public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.nombre = "Triángulo";
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
