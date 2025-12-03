package ejercicio5.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Object Pool genérico que gestiona un conjunto de objetos reutilizables.
 * Evita la creación y destrucción constante de objetos costosos.
 * 
 * @param <T> Tipo de objeto que gestiona el pool (debe implementar Poolable)
 */
public class ObjectPool<T extends Poolable> {
    
    private List<T> pool;
    private int tamanioMaximo;
    private int objetosCreados;
    private Supplier<T> creadorObjetos;
    private String nombrePool;

    /**
     * Constructor del Object Pool
     * @param tamanioMaximo Número máximo de objetos en el pool
     * @param creadorObjetos Función para crear nuevos objetos
     * @param nombrePool Nombre identificador del pool
     */
    public ObjectPool(int tamanioMaximo, Supplier<T> creadorObjetos, String nombrePool) {
        this.pool = new ArrayList<>();
        this.tamanioMaximo = tamanioMaximo;
        this.objetosCreados = 0;
        this.creadorObjetos = creadorObjetos;
        this.nombrePool = nombrePool;
        
        System.out.println("[" + nombrePool + "] Pool inicializado con capacidad máxima de " + tamanioMaximo + " objetos.");
    }

    /**
     * Obtiene un objeto del pool.
     * Si hay objetos disponibles, retorna uno.
     * Si no hay disponibles pero no se ha alcanzado el máximo, crea uno nuevo.
     * Si se alcanzó el máximo, retorna null.
     */
    public synchronized T obtenerObjeto() {
        System.out.println("\n[" + nombrePool + "] Solicitando objeto...");
        
        // Buscar un objeto disponible en el pool
        for (T objeto : pool) {
            if (objeto.isDisponible()) {
                objeto.setDisponible(false);
                System.out.println("[" + nombrePool + "] Objeto reutilizado del pool.");
                mostrarEstado();
                return objeto;
            }
        }
        
        // Si no hay disponibles, intentar crear uno nuevo
        if (objetosCreados < tamanioMaximo) {
            T nuevoObjeto = creadorObjetos.get();
            nuevoObjeto.setDisponible(false);
            pool.add(nuevoObjeto);
            objetosCreados++;
            System.out.println("[" + nombrePool + "] Nuevo objeto creado (total: " + objetosCreados + "/" + tamanioMaximo + ")");
            mostrarEstado();
            return nuevoObjeto;
        }
        
        // Si se alcanzó el límite máximo
        System.out.println("[" + nombrePool + "] ERROR: Pool agotado. No hay objetos disponibles.");
        System.out.println("[" + nombrePool + "] Todos los " + tamanioMaximo + " objetos están en uso.");
        mostrarEstado();
        return null;
    }

    /**
     * Libera un objeto y lo devuelve al pool para ser reutilizado.
     */
    public synchronized void liberarObjeto(T objeto) {
        if (objeto != null && pool.contains(objeto)) {
            objeto.reset();
            objeto.setDisponible(true);
            System.out.println("[" + nombrePool + "] Objeto liberado y devuelto al pool.");
            mostrarEstado();
        }
    }

    /**
     * Obtiene el número de objetos disponibles en el pool
     */
    public int getObjetosDisponibles() {
        int disponibles = 0;
        for (T objeto : pool) {
            if (objeto.isDisponible()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    /**
     * Obtiene el número de objetos en uso
     */
    public int getObjetosEnUso() {
        return objetosCreados - getObjetosDisponibles();
    }

    /**
     * Muestra el estado actual del pool
     */
    public void mostrarEstado() {
        System.out.println("[" + nombrePool + "] Estado: " + 
                          getObjetosEnUso() + " en uso, " + 
                          getObjetosDisponibles() + " disponibles, " +
                          objetosCreados + "/" + tamanioMaximo + " creados");
    }

    /**
     * Muestra información detallada del pool
     */
    public void mostrarInfoDetallada() {
        System.out.println("\n========================================");
        System.out.println("  INFORMACIÓN DEL POOL: " + nombrePool);
        System.out.println("========================================");
        System.out.println("  Tamaño máximo: " + tamanioMaximo);
        System.out.println("  Objetos creados: " + objetosCreados);
        System.out.println("  Objetos en uso: " + getObjetosEnUso());
        System.out.println("  Objetos disponibles: " + getObjetosDisponibles());
        System.out.println("========================================\n");
    }

    public int getTamanioMaximo() {
        return tamanioMaximo;
    }

    public int getObjetosCreados() {
        return objetosCreados;
    }

    public String getNombrePool() {
        return nombrePool;
    }
}
