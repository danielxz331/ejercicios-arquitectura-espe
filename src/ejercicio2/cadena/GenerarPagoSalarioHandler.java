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
        String cargo = empleado.cargoAsignado();
        
        if (cargo == null) {
            return 1500000;
        }
        
        String cargoLower = cargo.toLowerCase();
        
        switch (cargoLower) {
            case "gerente":
                return 8000000;
            case "director":
                return 6000000;
            case "coordinador":
                return 4000000;
            case "analista":
                return 2500000;
            case "asistente":
                return 1800000;
            default:
                return 1500000;
        }
    }
}
