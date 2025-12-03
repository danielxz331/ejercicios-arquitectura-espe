package ejercicio2.cadena;

import ejercicio2.modelo.Estudiante;
import ejercicio2.modelo.Persona;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GenerarReciboMatriculaHandler extends ManejadorPersona {
    private static int numeroRecibo = 1000;

    @Override
    public void manejar(Persona persona) {
        if (persona instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) persona;
            generarRecibo(estudiante);
        }
        // Pasar al siguiente manejador
        pasarAlSiguiente(persona);
    }

    private void generarRecibo(Estudiante estudiante) {
        numeroRecibo++;
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("========================================");
        System.out.println("       RECIBO DE MATRÍCULA");
        System.out.println("========================================");
        System.out.println("Recibo No: " + numeroRecibo);
        System.out.println("Fecha: " + fechaActual.format(formatter));
        System.out.println("----------------------------------------");
        System.out.println("Estudiante: " + estudiante.getNombres() + " " + estudiante.getApellidos());
        System.out.println("Programa: " + estudiante.programaAcademico());
        System.out.println("Estado: MATRICULADO");
        System.out.println("========================================");
        System.out.println();
    }
}
