package ejercicio1.strategy;

import ejercicio1.modelo.VentaV3;

public interface IEstrategiaFijarPreciosVenta {
    double calcularPrecioFinal(VentaV3 venta);
    double calcularDescuento(VentaV3 venta);
}
