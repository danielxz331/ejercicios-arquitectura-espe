package ejercicio1.strategy;

import ejercicio1.modelo.VentaV3;

/**
 * Estrategia de descuento fijo (porcentaje).
 * Aplica un porcentaje fijo de descuento sobre el precio base.
 */
public class EstrategiaDescuentosFijos implements IEstrategiaFijarPreciosVenta {
    
    private double porcentajeDescuento; // Valor entre 0 y 100

    public EstrategiaDescuentosFijos(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double calcularDescuento(VentaV3 venta) {
        return venta.getPrecioBase() * (porcentajeDescuento / 100);
    }

    @Override
    public double calcularPrecioFinal(VentaV3 venta) {
        double descuento = calcularDescuento(venta);
        System.out.println("  - Descuento Fijo (" + porcentajeDescuento + "%): $" + String.format("%,.2f", descuento));
        return venta.getPrecioBase() - descuento;
    }
}
