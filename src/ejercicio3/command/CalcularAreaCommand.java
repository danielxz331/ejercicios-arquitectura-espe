package ejercicio3.command;

import ejercicio3.modelo.FiguraGeometrica;
import java.util.ArrayList;

public class CalcularAreaCommand implements Command {
    
    private ArrayList<FiguraGeometrica> figuras;

    public CalcularAreaCommand(ArrayList<FiguraGeometrica> figuras) {
        this.figuras = figuras;
    }

    @Override
    public void execute() {
        System.out.println("========================================");
        System.out.println("    COMANDO: CALCULAR ÁREA DE FIGURAS");
        System.out.println("========================================");
        
        for (int i = 0; i < figuras.size(); i++) {
            FiguraGeometrica figura = figuras.get(i);
            System.out.println((i + 1) + ". " + figura.getNombre() + 
                             " -> Área: " + String.format("%.2f", figura.area()));
        }
        System.out.println();
    }
}
