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

        FiguraFactory factory = FiguraFactory.getInstance();
        System.out.println(">>> Fábrica Singleton obtenida: " + factory.getClass().getSimpleName());
        System.out.println();

        ArrayList<FiguraGeometrica> figuras = new ArrayList<>();

        System.out.println(">>> Creando figuras desde la fábrica...\n");
        
        figuras.add(factory.crearRectangulo(10, 5));
        figuras.add(factory.crearRectangulo(8, 4));

        figuras.add(factory.crearCirculo(5));
        figuras.add(factory.crearCirculo(3));
        figuras.add(factory.crearCirculo(7));

        figuras.add(factory.crearTriangulo(6, 8));
        figuras.add(factory.crearTriangulo(10, 5));
        figuras.add(factory.crearTriangulo(12, 6));

        System.out.println(">>> Figuras creadas en el ArrayList:");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println((i + 1) + ". " + figuras.get(i));
        }
        System.out.println();

        Command calcularArea = new CalcularAreaCommand(figuras);
        Command imprimirNombres = new ImprimirNombresCommand(figuras);
        Command calcularPromedio = new CalcularPromedioAreaCommand(figuras);

        CommandInvoker invoker = new CommandInvoker();

        invoker.agregarComando(imprimirNombres);
        invoker.agregarComando(calcularArea);
        invoker.agregarComando(calcularPromedio);

        System.out.println("==============================================");
        System.out.println("        EJECUTANDO COMANDOS");
        System.out.println("==============================================\n");
        
        invoker.ejecutarTodosLosComandos();

        System.out.println("==============================================");
        System.out.println("    EJECUTANDO COMANDO INDIVIDUAL");
        System.out.println("==============================================\n");
        invoker.ejecutarComando(calcularPromedio);

        System.out.println(">>> Proceso completado exitosamente!");
    }
}
