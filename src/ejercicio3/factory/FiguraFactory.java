package ejercicio3.factory;

import ejercicio3.modelo.*;

/**
 * Fábrica Singleton para crear figuras geométricas.
 * Garantiza una única instancia de la fábrica.
 */
public class FiguraFactory {
    
    // Instancia única (Singleton)
    private static FiguraFactory instance;

    // Constructor privado (Singleton)
    private FiguraFactory() {
    }

    /**
     * Obtiene la instancia única de la fábrica (Singleton)
     */
    public static synchronized FiguraFactory getInstance() {
        if (instance == null) {
            instance = new FiguraFactory();
        }
        return instance;
    }

    /**
     * Crea un Rectángulo con las dimensiones especificadas
     */
    public Rectangulo crearRectangulo(double base, double altura) {
        return new Rectangulo(base, altura);
    }

    /**
     * Crea un Círculo con el radio especificado
     */
    public Circulo crearCirculo(double radio) {
        return new Circulo(radio);
    }

    /**
     * Crea un Triángulo con las dimensiones especificadas
     */
    public Triangulo crearTriangulo(double base, double altura) {
        return new Triangulo(base, altura);
    }
}
