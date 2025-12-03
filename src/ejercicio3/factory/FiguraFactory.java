package ejercicio3.factory;

import ejercicio3.modelo.*;

public class FiguraFactory {

    private static FiguraFactory instance;

    private FiguraFactory() {
    }

    public static synchronized FiguraFactory getInstance() {
        if (instance == null) {
            instance = new FiguraFactory();
        }
        return instance;
    }

    public Rectangulo crearRectangulo(double base, double altura) {
        return new Rectangulo(base, altura);
    }

    public Circulo crearCirculo(double radio) {
        return new Circulo(radio);
    }

    public Triangulo crearTriangulo(double base, double altura) {
        return new Triangulo(base, altura);
    }
}
