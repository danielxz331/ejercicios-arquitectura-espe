package ejercicio4.basedatos;

import java.util.HashSet;
import java.util.Set;

public class BaseDatosImagenes {

    private static BaseDatosImagenes instance;

    private Set<String> imagenesDisponibles;

    private BaseDatosImagenes() {
        this.imagenesDisponibles = new HashSet<>();
        inicializarImagenes();
    }

    public static synchronized BaseDatosImagenes getInstance() {
        if (instance == null) {
            instance = new BaseDatosImagenes();
        }
        return instance;
    }

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

    public boolean existeImagen(String nombre) {
        boolean existe = imagenesDisponibles.contains(nombre);
        System.out.println("[BaseDatos] Buscando '" + nombre + "' en directorio... " + 
                          (existe ? "ENCONTRADA" : "NO ENCONTRADA"));
        return existe;
    }

    public void listarImagenesDisponibles() {
        System.out.println("\n[BaseDatos] Imágenes disponibles en el directorio:");
        System.out.println("--------------------------------------");
        for (String nombre : imagenesDisponibles) {
            System.out.println("  - " + nombre);
        }
        System.out.println("--------------------------------------");
    }
}
