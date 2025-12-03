package ejercicio1.factory;

import ejercicio1.strategy.*;

public class EstrategiaFactory {

    private static EstrategiaFactory instance;

    private EstrategiaCompuestaLoMejorParaElUsuario estrategiaUsuario;
    private EstrategiaCompuestaLoMejorParaLaEmpresa estrategiaEmpresa;

    private EstrategiaFactory() {
        inicializarEstrategias();
    }

    public static synchronized EstrategiaFactory getInstance() {
        if (instance == null) {
            instance = new EstrategiaFactory();
        }
        return instance;
    }

    private void inicializarEstrategias() {
        IEstrategiaFijarPreciosVenta descuentoAbsoluto = new EstrategiaDescuentosAbsoluto(50000);
        IEstrategiaFijarPreciosVenta descuentoFijo = new EstrategiaDescuentosFijos(10);
        IEstrategiaFijarPreciosVenta descuentoEdad = new EstrategiaDescuentosEdadClientes();

        estrategiaUsuario = new EstrategiaCompuestaLoMejorParaElUsuario();
        estrategiaUsuario.agregarEstrategia(descuentoAbsoluto);
        estrategiaUsuario.agregarEstrategia(descuentoFijo);
        estrategiaUsuario.agregarEstrategia(descuentoEdad);

        estrategiaEmpresa = new EstrategiaCompuestaLoMejorParaLaEmpresa();
        estrategiaEmpresa.agregarEstrategia(descuentoAbsoluto);
        estrategiaEmpresa.agregarEstrategia(descuentoFijo);
        estrategiaEmpresa.agregarEstrategia(descuentoEdad);
    }

    public IEstrategiaFijarPreciosVenta getEstrategiaLoMejorParaElUsuario() {
        return estrategiaUsuario;
    }

    public IEstrategiaFijarPreciosVenta getEstrategiaLoMejorParaLaEmpresa() {
        return estrategiaEmpresa;
    }
}
