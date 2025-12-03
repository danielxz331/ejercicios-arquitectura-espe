package ejercicio2;

import ejercicio2.factory.PersonaFactory;
import ejercicio2.modelo.Persona;
import ejercicio2.cadena.ManejadorPersona;
import ejercicio2.cadena.CalcularValorMatriculaHandler;
import ejercicio2.cadena.GenerarReciboMatriculaHandler;
import ejercicio2.cadena.GenerarPagoSalarioHandler;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   EJERCICIO: PATRONES BUILDER, FACTORY Y");
        System.out.println("         CHAIN OF RESPONSIBILITY");
        System.out.println("==============================================\n");

        ArrayList<Persona> personas = new ArrayList<>();

        System.out.println(">>> Creando objetos desde la fábrica...\n");
        
        Persona estudiante1 = PersonaFactory.crearEstudiante(
                "Juan Carlos", 
                "García López", 
                "Ingeniería de Sistemas"
        );
        personas.add(estudiante1);

        Persona estudiante2 = PersonaFactory.crearEstudiante(
                "María Fernanda", 
                "Rodríguez Pérez", 
                "Medicina"
        );
        personas.add(estudiante2);

        Persona empleado1 = PersonaFactory.crearEmpleado(
                "Carlos Alberto", 
                "Martínez Ruiz", 
                "Gerente de Proyectos"
        );
        personas.add(empleado1);

        Persona empleado2 = PersonaFactory.crearEmpleado(
                "Ana María", 
                "López Sánchez", 
                "Coordinador Académico"
        );
        personas.add(empleado2);

        Persona empleado3 = PersonaFactory.crearEmpleado(
                "Pedro José", 
                "Hernández Castro", 
                "Analista de Sistemas"
        );
        personas.add(empleado3);

        System.out.println(">>> Objetos creados en el ArrayList:");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < personas.size(); i++) {
            System.out.println((i + 1) + ". " + personas.get(i));
        }
        System.out.println();

        System.out.println(">>> Configurando Cadena de Responsabilidad...\n");
        
        ManejadorPersona calcularMatricula = new CalcularValorMatriculaHandler();
        ManejadorPersona generarRecibo = new GenerarReciboMatriculaHandler();
        ManejadorPersona generarPagoSalario = new GenerarPagoSalarioHandler();

        calcularMatricula.setSiguiente(generarRecibo);
        generarRecibo.setSiguiente(generarPagoSalario);

        // Procesar cada persona a través de la cadena
        System.out.println(">>> Procesando personas a través de la cadena...\n");
        
        for (Persona persona : personas) {
            System.out.println("**********************************************");
            System.out.println("Procesando: " + persona.getNombres() + " " + persona.getApellidos());
            System.out.println("**********************************************\n");
            calcularMatricula.manejar(persona);
        }

        System.out.println(">>> Proceso completado exitosamente!");
    }
}
