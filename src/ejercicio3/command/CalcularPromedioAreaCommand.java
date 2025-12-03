package ejercicio3.command;

import ejercicio3.modelo.FiguraGeometrica;
import java.util.ArrayList;

/**
 * Comando para calcular el valor promedio del área de las figuras geométricas.
 */
public class CalcularPromedioAreaCommand implements Command {
    
    private ArrayList<FiguraGeometrica> figuras;

    public CalcularPromedioAreaCommand(ArrayList<FiguraGeometrica> figuras) {
        this.figuras = figuras;
    }

    @Override
    public void execute() {
        System.out.println("========================================");
        System.out.println(" COMANDO: CALCULAR PROMEDIO DE ÁREAS");
        System.out.println("========================================");
        
        if (figuras.isEmpty()) {
            System.out.println("No hay figuras para calcular el promedio.");
            return;
        }

        double sumaAreas = 0;
        for (FiguraGeometrica figura : figuras) {
            sumaAreas += figura.area();
        }

        double promedio = sumaAreas / figuras.size();

        System.out.println("Total de figuras: " + figuras.size());
        System.out.println("Suma de áreas: " + String.format("%.2f", sumaAreas));
        System.out.println("Promedio de áreas: " + String.format("%.2f", promedio));
        System.out.println();
    }
}
