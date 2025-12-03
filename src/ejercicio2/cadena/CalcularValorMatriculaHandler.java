package ejercicio2.cadena;

import ejercicio2.modelo.Estudiante;
import ejercicio2.modelo.Persona;

public class CalcularValorMatriculaHandler extends ManejadorPersona {

    @Override
    public void manejar(Persona persona) {
        if (persona instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) persona;
            // Simulación del cálculo de matrícula
            double valorMatricula = calcularMatricula(estudiante);
            System.out.println("========================================");
            System.out.println("CÁLCULO DE VALOR DE MATRÍCULA");
            System.out.println("========================================");
            System.out.println("Estudiante: " + estudiante.getNombres() + " " + estudiante.getApellidos());
            System.out.println("Programa Académico: " + estudiante.programaAcademico());
            System.out.println("Valor de Matrícula: $" + String.format("%,.2f", valorMatricula));
            System.out.println();
        }
        // Pasar al siguiente manejador
        pasarAlSiguiente(persona);
    }

    private double calcularMatricula(Estudiante estudiante) {
        // Lógica simulada para calcular matrícula según programa
        double valorBase = 2500000;
        String programa = estudiante.programaAcademico();
        
        if (programa != null) {
            if (programa.toLowerCase().contains("ingeniería")) {
                valorBase = 3500000;
            } else if (programa.toLowerCase().contains("medicina")) {
                valorBase = 5000000;
            } else if (programa.toLowerCase().contains("derecho")) {
                valorBase = 3000000;
            }
        }
        return valorBase;
    }
}
