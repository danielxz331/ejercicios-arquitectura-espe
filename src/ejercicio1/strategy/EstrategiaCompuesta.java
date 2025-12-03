package ejercicio1.strategy;

import ejercicio1.modelo.VentaV3;
import java.util.ArrayList;
import java.util.List;

public abstract class EstrategiaCompuesta implements IEstrategiaFijarPreciosVenta {
    
    protected List<IEstrategiaFijarPreciosVenta> estrategias;

    public EstrategiaCompuesta() {
        this.estrategias = new ArrayList<>();
    }

    public void agregarEstrategia(IEstrategiaFijarPreciosVenta estrategia) {
        estrategias.add(estrategia);
    }

    @Override
    public abstract double calcularDescuento(VentaV3 venta);

    @Override
    public abstract double calcularPrecioFinal(VentaV3 venta);
}
