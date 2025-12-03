package ejercicio2.cadena;

import ejercicio2.modelo.Empleado;
import ejercicio2.modelo.Persona;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GenerarPagoSalarioHandler extends ManejadorPersona {
    private static int numeroPago = 5000;

    @Override
    public void manejar(Persona persona) {
        if (persona instanceof Empleado) {
            Empleado empleado = (Empleado) persona;
            generarPagoSalario(empleado);
        }
        // Pasar al siguiente manejador
        pasarAlSiguiente(persona);
    }

    private void generarPagoSalario(Empleado empleado) {
        numeroPago++;
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        double salario = calcularSalario(empleado);

        System.out.println("========================================");
        System.out.println("       COMPROBANTE DE PAGO DE SALARIO");
        System.out.println("========================================");
        System.out.println("Comprobante No: " + numeroPago);
        System.out.println("Fecha: " + fechaActual.format(formatter));
        System.out.println("----------------------------------------");
        System.out.println("Empleado: " + empleado.getNombres() + " " + empleado.getApellidos());
        System.out.println("Cargo: " + empleado.cargoAsignado());
        System.out.println("Salario: $" + String.format("%,.2f", salario));
        System.out.println("Estado: PAGADO");
        System.out.println("========================================");
        System.out.println();
    }

    private double calcularSalario(Empleado empleado) {
        // Lógica simulada para calcular salario según cargo
        double salarioBase = 1500000;
        String cargo = empleado.cargoAsignado();
        
        if (cargo != null) {
            if (cargo.toLowerCase().contains("gerente")) {
                salarioBase = 8000000;
            } else if (cargo.toLowerCase().contains("director")) {
                salarioBase = 6000000;
            } else if (cargo.toLowerCase().contains("coordinador")) {
                salarioBase = 4000000;
            } else if (cargo.toLowerCase().contains("analista")) {
                salarioBase = 2500000;
            } else if (cargo.toLowerCase().contains("asistente")) {
                salarioBase = 1800000;
            }
        }
        return salarioBase;
    }
}
