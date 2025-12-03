package ejercicio1.strategy;

import ejercicio1.modelo.VentaV3;
import java.util.ArrayList;
import java.util.List;

/**
 * Estrategia compuesta que combina múltiples estrategias de descuento.
 * Clase base para las estrategias compuestas.
 */
public abstract class EstrategiaCompuesta implements IEstrategiaFijarPreciosVenta {
    
    protected List<IEstrategiaFijarPreciosVenta> estrategias;

    public EstrategiaCompuesta() {
        this.estrategias = new ArrayList<>();
    }

    public void agregarEstrategia(IEstrategiaFijarPreciosVenta estrategia) {
        estrategias.add(estrategia);
    }

    public void removerEstrategia(IEstrategiaFijarPreciosVenta estrategia) {
        estrategias.remove(estrategia);
    }

    public List<IEstrategiaFijarPreciosVenta> getEstrategias() {
        return estrategias;
    }

    @Override
    public abstract double calcularDescuento(VentaV3 venta);

    @Override
    public abstract double calcularPrecioFinal(VentaV3 venta);
}
