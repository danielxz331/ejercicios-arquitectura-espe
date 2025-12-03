package ejercicio4.proxy;

import ejercicio4.modelo.Imagen;
import ejercicio4.modelo.ImagenReal;
import ejercicio4.cache.ImagenCache;
import ejercicio4.basedatos.BaseDatosImagenes;

public class ImagenProxy implements Imagen {
    
    private String nombre;
    private ImagenReal imagenReal;
    private ImagenCache cache;
    private BaseDatosImagenes baseDatos;

    public ImagenProxy(String nombre) {
        this.nombre = nombre;
        this.imagenReal = null;
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

        System.out.println("[Proxy] Paso 2: Buscando en base de datos/directorio...");
        
        if (baseDatos.existeImagen(nombre)) {
            System.out.println("[Proxy] Paso 3: Cargando imagen desde el directorio...");
            imagenReal = new ImagenReal(nombre);

            System.out.println("[Proxy] Paso 4: Agregando imagen al caché...");
            cache.agregarAlCache(nombre, imagenReal);

            imagenReal.mostrar();
        } else {
            System.out.println("[Proxy] ERROR: La imagen '" + nombre + "' no existe en el sistema.");
        }
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public boolean estaImagenCargada() {
        return imagenReal != null || cache.existeEnCache(nombre);
    }

    @Override
    public String toString() {
        return "ImagenProxy{nombre='" + nombre + "', cargada=" + estaImagenCargada() + "}";
    }
}
