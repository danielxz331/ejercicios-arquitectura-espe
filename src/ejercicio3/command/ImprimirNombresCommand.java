package ejercicio3.command;

import ejercicio3.modelo.FiguraGeometrica;
import java.util.ArrayList;

public class ImprimirNombresCommand implements Command {
    
    private ArrayList<FiguraGeometrica> figuras;

    public ImprimirNombresCommand(ArrayList<FiguraGeometrica> figuras) {
        this.figuras = figuras;
    }

    @Override
    public void execute() {
        System.out.println("========================================");
        System.out.println("  COMANDO: IMPRIMIR NOMBRES DE FIGURAS");
        System.out.println("========================================");
        
        for (int i = 0; i < figuras.size(); i++) {
            FiguraGeometrica figura = figuras.get(i);
            System.out.println((i + 1) + ". " + figura.getNombre());
        }
        System.out.println();
    }
}
