package ejercicio4.proxy;

import ejercicio4.modelo.Imagen;
import ejercicio4.modelo.ImagenReal;
import ejercicio4.cache.ImagenCache;
import ejercicio4.basedatos.BaseDatosImagenes;

/**
 * Proxy de Caché de Imágenes.
 * Implementa el patrón Proxy para controlar el acceso a las imágenes reales.
 * 
 * Comportamiento:
 * 1. Recibe el nombre de una imagen
 * 2. La imagen NO se carga hasta que es solicitada (lazy loading)
 * 3. Al solicitar la imagen:
 *    a. Busca en el caché de imágenes
 *    b. Si no está, busca en la base de datos/directorio
 *    c. Si la encuentra, la carga y la agrega al caché
 */
public class ImagenProxy implements Imagen {
    
    private String nombre;
    private ImagenReal imagenReal;
    private ImagenCache cache;
    private BaseDatosImagenes baseDatos;

    public ImagenProxy(String nombre) {
        this.nombre = nombre;
        this.imagenReal = null; // Lazy loading: no se carga hasta que se necesite
        this.cache = ImagenCache.getInstance();
        this.baseDatos = BaseDatosImagenes.getInstance();
        System.out.println("[Proxy] Proxy creado para imagen: '" + nombre + "' (no cargada aún)");
    }

    @Override
    public void mostrar() {
        System.out.println("\n[Proxy] Solicitando imagen: '" + nombre + "'");
        
        // Paso 1: Buscar en el caché
        System.out.println("[Proxy] Paso 1: Buscando en caché...");
        Imagen imagenEnCache = cache.buscarEnCache(nombre);
        
        if (imagenEnCache != null) {
            // Imagen encontrada en caché
            System.out.println("[Proxy] ¡Imagen encontrada en caché! (acceso rápido)");
            imagenEnCache.mostrar();
            return;
        }
        
        System.out.println("[Proxy] Imagen NO está en caché.");
        
        // Paso 2: Buscar en base de datos/directorio
        System.out.println("[Proxy] Paso 2: Buscando en base de datos/directorio...");
        
        if (baseDatos.existeImagen(nombre)) {
            // Paso 3: Cargar la imagen real
            System.out.println("[Proxy] Paso 3: Cargando imagen desde el directorio...");
            imagenReal = new ImagenReal(nombre);
            
            // Paso 4: Agregar al caché para futuras consultas
            System.out.println("[Proxy] Paso 4: Agregando imagen al caché...");
            cache.agregarAlCache(nombre, imagenReal);
            
            // Mostrar la imagen
            imagenReal.mostrar();
        } else {
            System.out.println("[Proxy] ERROR: La imagen '" + nombre + "' no existe en el sistema.");
        }
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Verifica si la imagen real ya fue cargada
     */
    public boolean estaImagenCargada() {
        return imagenReal != null || cache.existeEnCache(nombre);
    }

    @Override
    public String toString() {
        return "ImagenProxy{nombre='" + nombre + "', cargada=" + estaImagenCargada() + "}";
    }
}
