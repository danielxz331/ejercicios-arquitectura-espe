package ejercicio3.modelo;

public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.nombre = "Rectángulo";
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
