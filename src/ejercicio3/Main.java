package ejercicio3;

import ejercicio3.factory.FiguraFactory;
import ejercicio3.modelo.FiguraGeometrica;
import ejercicio3.command.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   EJERCICIO 3: PATRÓN COMMAND + FACTORY");
        System.out.println("           + SINGLETON");
        System.out.println("==============================================\n");

        // Obtener la fábrica Singleton
        FiguraFactory factory = FiguraFactory.getInstance();
        System.out.println(">>> Fábrica Singleton obtenida: " + factory.getClass().getSimpleName());
        System.out.println();

        // Crear ArrayList de tipo FiguraGeometrica
        ArrayList<FiguraGeometrica> figuras = new ArrayList<>();

        // Crear 2 Rectángulos usando la fábrica
        System.out.println(">>> Creando figuras desde la fábrica...\n");
        
        figuras.add(factory.crearRectangulo(10, 5));    // Área: 50
        figuras.add(factory.crearRectangulo(8, 4));     // Área: 32

        // Crear 3 Círculos usando la fábrica
        figuras.add(factory.crearCirculo(5));           // Área: 78.54
        figuras.add(factory.crearCirculo(3));           // Área: 28.27
        figuras.add(factory.crearCirculo(7));           // Área: 153.94

        // Crear 3 Triángulos usando la fábrica
        figuras.add(factory.crearTriangulo(6, 8));      // Área: 24
        figuras.add(factory.crearTriangulo(10, 5));     // Área: 25
        figuras.add(factory.crearTriangulo(12, 6));     // Área: 36

        // Mostrar las figuras creadas
        System.out.println(">>> Figuras creadas en el ArrayList:");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println((i + 1) + ". " + figuras.get(i));
        }
        System.out.println();

        // Crear los comandos
        Command calcularArea = new CalcularAreaCommand(figuras);
        Command imprimirNombres = new ImprimirNombresCommand(figuras);
        Command calcularPromedio = new CalcularPromedioAreaCommand(figuras);

        // Crear el Invoker
        CommandInvoker invoker = new CommandInvoker();

        // Agregar los comandos al invoker
        invoker.agregarComando(imprimirNombres);
        invoker.agregarComando(calcularArea);
        invoker.agregarComando(calcularPromedio);

        // Ejecutar todos los comandos
        System.out.println("==============================================");
        System.out.println("        EJECUTANDO COMANDOS");
        System.out.println("==============================================\n");
        
        invoker.ejecutarTodosLosComandos();

        // También se pueden ejecutar comandos individuales
        System.out.println("==============================================");
        System.out.println("    EJECUTANDO COMANDO INDIVIDUAL");
        System.out.println("==============================================\n");
        invoker.ejecutarComando(calcularPromedio);

        System.out.println(">>> Proceso completado exitosamente!");
    }
}
