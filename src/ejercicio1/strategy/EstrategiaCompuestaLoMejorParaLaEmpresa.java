package ejercicio1.strategy;

import ejercicio1.modelo.VentaV3;

/**
 * Estrategia compuesta que selecciona el MENOR descuento disponible.
 * Esto es lo mejor para la empresa.
 */
public class EstrategiaCompuestaLoMejorParaLaEmpresa extends EstrategiaCompuesta {

    @Override
    public double calcularDescuento(VentaV3 venta) {
        double minDescuento = Double.MAX_VALUE;

        for (IEstrategiaFijarPreciosVenta estrategia : estrategias) {
            double descuento = estrategia.calcularDescuento(venta);
            if (descuento < minDescuento) {
                minDescuento = descuento;
            }
        }

        return minDescuento == Double.MAX_VALUE ? 0 : minDescuento;
    }

    @Override
    public double calcularPrecioFinal(VentaV3 venta) {
        System.out.println("Evaluando descuentos disponibles:");
        
        double minDescuento = Double.MAX_VALUE;
        String mejorEstrategia = "";

        for (IEstrategiaFijarPreciosVenta estrategia : estrategias) {
            double descuento = estrategia.calcularDescuento(venta);
            System.out.println("  - " + estrategia.getClass().getSimpleName() + ": $" + String.format("%,.2f", descuento));
            
            if (descuento < minDescuento) {
                minDescuento = descuento;
                mejorEstrategia = estrategia.getClass().getSimpleName();
            }
        }

        if (minDescuento == Double.MAX_VALUE) {
            minDescuento = 0;
        }

        System.out.println(">>> Mejor descuento (MENOR): " + mejorEstrategia + " = $" + String.format("%,.2f", minDescuento));
        return venta.getPrecioBase() - minDescuento;
    }
}
