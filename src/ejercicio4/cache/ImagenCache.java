package ejercicio4.cache;

import ejercicio4.modelo.Imagen;
import ejercicio4.modelo.ImagenReal;
import java.util.HashMap;
import java.util.Map;

public class ImagenCache {

    private static ImagenCache instance;

    private Map<String, Imagen> cache;

    private ImagenCache() {
        this.cache = new HashMap<>();
        System.out.println("[Cache] Caché de imágenes inicializado.");
    }

    public static synchronized ImagenCache getInstance() {
        if (instance == null) {
            instance = new ImagenCache();
        }
        return instance;
    }

    public Imagen buscarEnCache(String nombre) {
        return cache.get(nombre);
    }

    public void agregarAlCache(String nombre, Imagen imagen) {
        cache.put(nombre, imagen);
        System.out.println("[Cache] Imagen '" + nombre + "' agregada al caché.");
    }

    public boolean existeEnCache(String nombre) {
        return cache.containsKey(nombre);
    }

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

    public void limpiarCache() {
        cache.clear();
        System.out.println("[Cache] Caché limpiado.");
    }
}
