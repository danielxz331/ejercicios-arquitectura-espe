package ejercicio1.factory;

import ejercicio1.strategy.*;

/**
 * Factoría Singleton para crear estrategias de descuento compuestas.
 * Garantiza una única instancia de la factoría en toda la aplicación.
 */
public class EstrategiaFactory {
    
    // Instancia única (Singleton)
    private static EstrategiaFactory instance;
    
    // Estrategias compuestas pre-configuradas
    private EstrategiaCompuestaLoMejorParaElUsuario estrategiaUsuario;
    private EstrategiaCompuestaLoMejorParaLaEmpresa estrategiaEmpresa;

    // Constructor privado (Singleton)
    private EstrategiaFactory() {
        inicializarEstrategias();
    }

    /**
     * Obtiene la instancia única de la factoría (Singleton)
     */
    public static synchronized EstrategiaFactory getInstance() {
        if (instance == null) {
            instance = new EstrategiaFactory();
        }
        return instance;
    }

    /**
     * Inicializa las estrategias compuestas con los descuentos disponibles
     */
    private void inicializarEstrategias() {
        // Crear las estrategias individuales
        IEstrategiaFijarPreciosVenta descuentoAbsoluto = new EstrategiaDescuentosAbsoluto(50000); // $50,000 de descuento
        IEstrategiaFijarPreciosVenta descuentoFijo = new EstrategiaDescuentosFijos(10); // 10% de descuento
        IEstrategiaFijarPreciosVenta descuentoEdad = new EstrategiaDescuentosEdadClientes(); // Descuento por edad

        // Configurar estrategia para el Usuario (descuento MAYOR)
        estrategiaUsuario = new EstrategiaCompuestaLoMejorParaElUsuario();
        estrategiaUsuario.agregarEstrategia(descuentoAbsoluto);
        estrategiaUsuario.agregarEstrategia(descuentoFijo);
        estrategiaUsuario.agregarEstrategia(descuentoEdad);

        // Configurar estrategia para la Empresa (descuento MENOR)
        estrategiaEmpresa = new EstrategiaCompuestaLoMejorParaLaEmpresa();
        estrategiaEmpresa.agregarEstrategia(descuentoAbsoluto);
        estrategiaEmpresa.agregarEstrategia(descuentoFijo);
        estrategiaEmpresa.agregarEstrategia(descuentoEdad);
    }

    /**
     * Obtiene la estrategia que beneficia al usuario (descuento mayor)
     */
    public IEstrategiaFijarPreciosVenta getEstrategiaLoMejorParaElUsuario() {
        return estrategiaUsuario;
    }

    /**
     * Obtiene la estrategia que beneficia a la empresa (descuento menor)
     */
    public IEstrategiaFijarPreciosVenta getEstrategiaLoMejorParaLaEmpresa() {
        return estrategiaEmpresa;
    }

    /**
     * Crea una estrategia de descuento absoluto
     */
    public IEstrategiaFijarPreciosVenta crearDescuentoAbsoluto(double monto) {
        return new EstrategiaDescuentosAbsoluto(monto);
    }

    /**
     * Crea una estrategia de descuento fijo (porcentaje)
     */
    public IEstrategiaFijarPreciosVenta crearDescuentoFijo(double porcentaje) {
        return new EstrategiaDescuentosFijos(porcentaje);
    }

    /**
     * Crea una estrategia de descuento por edad
     */
    public IEstrategiaFijarPreciosVenta crearDescuentoEdad() {
        return new EstrategiaDescuentosEdadClientes();
    }
}
