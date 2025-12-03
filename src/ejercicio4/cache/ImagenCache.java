package ejercicio4.cache;

import ejercicio4.modelo.Imagen;
import ejercicio4.modelo.ImagenReal;
import java.util.HashMap;
import java.util.Map;

/**
 * Caché de imágenes que almacena las imágenes ya cargadas.
 * Implementa el patrón Singleton para tener una única instancia del caché.
 */
public class ImagenCache {
    
    // Instancia única (Singleton)
    private static ImagenCache instance;
    
    // Mapa para almacenar las imágenes en caché
    private Map<String, Imagen> cache;

    // Constructor privado (Singleton)
    private ImagenCache() {
        this.cache = new HashMap<>();
        System.out.println("[Cache] Caché de imágenes inicializado.");
    }

    /**
     * Obtiene la instancia única del caché (Singleton)
     */
    public static synchronized ImagenCache getInstance() {
        if (instance == null) {
            instance = new ImagenCache();
        }
        return instance;
    }

    /**
     * Busca una imagen en el caché por su nombre
     */
    public Imagen buscarEnCache(String nombre) {
        return cache.get(nombre);
    }

    /**
     * Agrega una imagen al caché
     */
    public void agregarAlCache(String nombre, Imagen imagen) {
        cache.put(nombre, imagen);
        System.out.println("[Cache] Imagen '" + nombre + "' agregada al caché.");
    }

    /**
     * Verifica si una imagen está en el caché
     */
    public boolean existeEnCache(String nombre) {
        return cache.containsKey(nombre);
    }

    /**
     * Obtiene el número de imágenes en caché
     */
    public int getTamanioCache() {
        return cache.size();
    }

    /**
     * Muestra el contenido del caché
     */
    public void mostrarContenidoCache() {
        System.out.println("\n[Cache] Contenido actual del caché:");
        System.out.println("--------------------------------------");
        if (cache.isEmpty()) {
            System.out.println("  (Caché vacío)");
        } else {
            for (String nombre : cache.keySet()) {
                System.out.println("  - " + nombre);
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("Total de imágenes en caché: " + cache.size());
    }

    /**
     * Limpia el caché
     */
    public void limpiarCache() {
        cache.clear();
        System.out.println("[Cache] Caché limpiado.");
    }
}
