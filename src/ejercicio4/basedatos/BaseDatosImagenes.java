package ejercicio4.basedatos;

import java.util.HashSet;
import java.util.Set;

/**
 * Simula una base de datos o directorio de imágenes disponibles.
 */
public class BaseDatosImagenes {
    
    // Instancia única (Singleton)
    private static BaseDatosImagenes instance;
    
    // Conjunto de nombres de imágenes disponibles
    private Set<String> imagenesDisponibles;

    // Constructor privado (Singleton)
    private BaseDatosImagenes() {
        this.imagenesDisponibles = new HashSet<>();
        inicializarImagenes();
    }

    /**
     * Obtiene la instancia única (Singleton)
     */
    public static synchronized BaseDatosImagenes getInstance() {
        if (instance == null) {
            instance = new BaseDatosImagenes();
        }
        return instance;
    }

    /**
     * Inicializa las imágenes disponibles en la "base de datos"
     */
    private void inicializarImagenes() {
        imagenesDisponibles.add("foto_perfil.jpg");
        imagenesDisponibles.add("logo_empresa.png");
        imagenesDisponibles.add("banner_principal.jpg");
        imagenesDisponibles.add("icono_menu.png");
        imagenesDisponibles.add("fondo_pantalla.jpg");
        imagenesDisponibles.add("avatar_usuario.png");
        imagenesDisponibles.add("producto_001.jpg");
        imagenesDisponibles.add("producto_002.jpg");
        System.out.println("[BaseDatos] Base de datos de imágenes inicializada con " + 
                          imagenesDisponibles.size() + " imágenes.");
    }

    /**
     * Verifica si una imagen existe en la base de datos/directorio
     */
    public boolean existeImagen(String nombre) {
        boolean existe = imagenesDisponibles.contains(nombre);
        System.out.println("[BaseDatos] Buscando '" + nombre + "' en directorio... " + 
                          (existe ? "ENCONTRADA" : "NO ENCONTRADA"));
        return existe;
    }

    /**
     * Lista todas las imágenes disponibles
     */
    public void listarImagenesDisponibles() {
        System.out.println("\n[BaseDatos] Imágenes disponibles en el directorio:");
        System.out.println("--------------------------------------");
        for (String nombre : imagenesDisponibles) {
            System.out.println("  - " + nombre);
        }
        System.out.println("--------------------------------------");
    }
}
