package ejercicio1.strategy;

import ejercicio1.modelo.VentaV3;

/**
 * Estrategia de descuento absoluto.
 * Aplica un monto fijo de descuento sin importar el precio base.
 */
public class EstrategiaDescuentosAbsoluto implements IEstrategiaFijarPreciosVenta {
    
    private double montoDescuento;

    public EstrategiaDescuentosAbsoluto(double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    @Override
    public double calcularDescuento(VentaV3 venta) {
        return montoDescuento;
    }

    @Override
    public double calcularPrecioFinal(VentaV3 venta) {
        double precioFinal = venta.getPrecioBase() - calcularDescuento(venta);
        System.out.println("  - Descuento Absoluto: $" + String.format("%,.2f", montoDescuento));
        return Math.max(precioFinal, 0);
    }
}
