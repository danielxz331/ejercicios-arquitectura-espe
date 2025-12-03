package ejercicio1.strategy;

import ejercicio1.modelo.VentaV3;

public class EstrategiaDescuentosEdadClientes implements IEstrategiaFijarPreciosVenta {

    @Override
    public double calcularDescuento(VentaV3 venta) {
        int edad = venta.getEdadCliente();
        double porcentaje = 0;

        if (edad < 18) {
            porcentaje = 10;
        } else if (edad >= 60) {
            porcentaje = 15;
        }

        return venta.getPrecioBase() * (porcentaje / 100);
    }

    @Override
    public double calcularPrecioFinal(VentaV3 venta) {
        int edad = venta.getEdadCliente();
        double descuento = calcularDescuento(venta);
        
        String tipoCliente = "";
        if (edad < 18) {
            tipoCliente = "Menor de edad - 10%";
        } else if (edad >= 60) {
            tipoCliente = "Adulto mayor - 15%";
        } else {
            tipoCliente = "Sin descuento por edad";
        }
        
        System.out.println("  - Descuento por Edad (" + tipoCliente + "): $" + String.format("%,.2f", descuento));
        return venta.getPrecioBase() - descuento;
    }
}
