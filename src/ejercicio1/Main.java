package ejercicio1;

import ejercicio1.factory.EstrategiaFactory;
import ejercicio1.modelo.VentaV3;
import ejercicio1.strategy.IEstrategiaFijarPreciosVenta;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   EJERCICIO 1: PATRÓN STRATEGY + COMPOSITE");
        System.out.println("        DESCUENTOS COMBINADOS EN VENTAS");
        System.out.println("==============================================\n");

        // Crear una venta de ejemplo
        VentaV3 venta = new VentaV3();
        venta.setPrecioBase(1000000);  // Precio base de 1,000,000
        venta.setEdadCliente(65);       // Cliente de 65 años (adulto mayor)

        System.out.println(">>> Datos de la Venta:");
        System.out.println("    Precio Base: $" + String.format("%,.2f", venta.getPrecioBase()));
        System.out.println("    Edad del Cliente: " + venta.getEdadCliente() + " años");
        System.out.println();

        // Obtener estrategias desde la factoría (Singleton)
        EstrategiaFactory factory = EstrategiaFactory.getInstance();

        // Estrategia: Lo mejor para el Usuario (descuento MAYOR)
        System.out.println("========================================");
        System.out.println("ESTRATEGIA: LO MEJOR PARA EL USUARIO");
        System.out.println("(Se aplica el descuento MAYOR)");
        System.out.println("========================================");
        IEstrategiaFijarPreciosVenta estrategiaUsuario = factory.getEstrategiaLoMejorParaElUsuario();
        double precioUsuario = estrategiaUsuario.calcularPrecioFinal(venta);
        System.out.println("Precio Final: $" + String.format("%,.2f", precioUsuario));
        System.out.println();

        // Estrategia: Lo mejor para la Empresa (descuento MENOR)
        System.out.println("========================================");
        System.out.println("ESTRATEGIA: LO MEJOR PARA LA EMPRESA");
        System.out.println("(Se aplica el descuento MENOR)");
        System.out.println("========================================");
        IEstrategiaFijarPreciosVenta estrategiaEmpresa = factory.getEstrategiaLoMejorParaLaEmpresa();
        double precioEmpresa = estrategiaEmpresa.calcularPrecioFinal(venta);
        System.out.println("Precio Final: $" + String.format("%,.2f", precioEmpresa));
        System.out.println();

        // Resumen
        System.out.println("==============================================");
        System.out.println("                 RESUMEN");
        System.out.println("==============================================");
        System.out.println("Precio Base:              $" + String.format("%,.2f", venta.getPrecioBase()));
        System.out.println("Precio (Mejor Usuario):   $" + String.format("%,.2f", precioUsuario));
        System.out.println("Precio (Mejor Empresa):   $" + String.format("%,.2f", precioEmpresa));
        System.out.println("Ahorro Usuario:           $" + String.format("%,.2f", (venta.getPrecioBase() - precioUsuario)));
        System.out.println("Ahorro Empresa:           $" + String.format("%,.2f", (precioUsuario - precioEmpresa)));
        System.out.println("==============================================");

        // Prueba con otro cliente (joven)
        System.out.println("\n>>> Segunda Venta (Cliente Joven):");
        VentaV3 venta2 = new VentaV3();
        venta2.setPrecioBase(500000);
        venta2.setEdadCliente(25);
        
        System.out.println("    Precio Base: $" + String.format("%,.2f", venta2.getPrecioBase()));
        System.out.println("    Edad del Cliente: " + venta2.getEdadCliente() + " años");
        System.out.println();
        
        double precioUsuario2 = estrategiaUsuario.calcularPrecioFinal(venta2);
        double precioEmpresa2 = estrategiaEmpresa.calcularPrecioFinal(venta2);
        
        System.out.println("Precio (Mejor Usuario):   $" + String.format("%,.2f", precioUsuario2));
        System.out.println("Precio (Mejor Empresa):   $" + String.format("%,.2f", precioEmpresa2));
    }
}
