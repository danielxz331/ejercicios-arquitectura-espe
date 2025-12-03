package ejercicio1.strategy;

import ejercicio1.modelo.VentaV3;

/**
 * Estrategia compuesta que selecciona el MAYOR descuento disponible.
 * Esto es lo mejor para el usuario/cliente.
 */
public class EstrategiaCompuestaLoMejorParaElUsuario extends EstrategiaCompuesta {

    @Override
    public double calcularDescuento(VentaV3 venta) {
        double maxDescuento = 0;

        for (IEstrategiaFijarPreciosVenta estrategia : estrategias) {
            double descuento = estrategia.calcularDescuento(venta);
            if (descuento > maxDescuento) {
                maxDescuento = descuento;
            }
        }

        return maxDescuento;
    }

    @Override
    public double calcularPrecioFinal(VentaV3 venta) {
        System.out.println("Evaluando descuentos disponibles:");
        
        double maxDescuento = 0;
        String mejorEstrategia = "";

        for (IEstrategiaFijarPreciosVenta estrategia : estrategias) {
            double descuento = estrategia.calcularDescuento(venta);
            System.out.println("  - " + estrategia.getClass().getSimpleName() + ": $" + String.format("%,.2f", descuento));
            
            if (descuento > maxDescuento) {
                maxDescuento = descuento;
                mejorEstrategia = estrategia.getClass().getSimpleName();
            }
        }

        System.out.println(">>> Mejor descuento (MAYOR): " + mejorEstrategia + " = $" + String.format("%,.2f", maxDescuento));
        return venta.getPrecioBase() - maxDescuento;
    }
}
