package ejercicio5.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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

    public synchronized T obtenerObjeto() {
        System.out.println("\n[" + nombrePool + "] Solicitando objeto...");
        
        for (T objeto : pool) {
            if (objeto.isDisponible()) {
                objeto.setDisponible(false);
                System.out.println("[" + nombrePool + "] Objeto reutilizado del pool.");
                mostrarEstado();
                return objeto;
            }
        }
        
        if (objetosCreados < tamanioMaximo) {
            T nuevoObjeto = creadorObjetos.get();
            nuevoObjeto.setDisponible(false);
            pool.add(nuevoObjeto);
            objetosCreados++;
            System.out.println("[" + nombrePool + "] Nuevo objeto creado (total: " + objetosCreados + "/" + tamanioMaximo + ")");
            mostrarEstado();
            return nuevoObjeto;
        }
        
        System.out.println("[" + nombrePool + "] ERROR: Pool agotado. No hay objetos disponibles.");
        System.out.println("[" + nombrePool + "] Todos los " + tamanioMaximo + " objetos están en uso.");
        mostrarEstado();
        return null;
    }

    public synchronized void liberarObjeto(T objeto) {
        if (objeto != null && pool.contains(objeto)) {
            objeto.reset();
            objeto.setDisponible(true);
            System.out.println("[" + nombrePool + "] Objeto liberado y devuelto al pool.");
            mostrarEstado();
        }
    }

    public int getObjetosDisponibles() {
        int disponibles = 0;
        for (T objeto : pool) {
            if (objeto.isDisponible()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public int getObjetosEnUso() {
        return objetosCreados - getObjetosDisponibles();
    }

    public void mostrarEstado() {
        System.out.println("[" + nombrePool + "] Estado: " + 
                          getObjetosEnUso() + " en uso, " + 
                          getObjetosDisponibles() + " disponibles, " +
                          objetosCreados + "/" + tamanioMaximo + " creados");
    }

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
}
