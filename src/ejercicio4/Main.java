package ejercicio4;

import ejercicio4.modelo.Imagen;
import ejercicio4.proxy.ImagenProxy;
import ejercicio4.cache.ImagenCache;
import ejercicio4.basedatos.BaseDatosImagenes;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   EJERCICIO 4: PATRÓN PROXY");
        System.out.println("      CACHÉ DE IMÁGENES");
        System.out.println("==============================================\n");

        BaseDatosImagenes.getInstance().listarImagenesDisponibles();
        System.out.println();

        System.out.println(">>> Creando proxies para imágenes (lazy loading)...\n");
        
        Imagen imagen1 = new ImagenProxy("foto_perfil.jpg");
        Imagen imagen2 = new ImagenProxy("logo_empresa.png");
        Imagen imagen3 = new ImagenProxy("banner_principal.jpg");
        Imagen imagen4 = new ImagenProxy("imagen_inexistente.jpg");
        
        System.out.println("\n>>> Las imágenes NO han sido cargadas aún (lazy loading)");

        ImagenCache.getInstance().mostrarContenidoCache();

        System.out.println("\n==============================================");
        System.out.println("PRIMERA SOLICITUD DE IMÁGENES");
        System.out.println("(Se cargarán desde el directorio y se agregarán al caché)");
        System.out.println("==============================================");

        System.out.println("\n--- Solicitando imagen 1 ---");
        imagen1.mostrar();

        System.out.println("\n--- Solicitando imagen 2 ---");
        imagen2.mostrar();

        ImagenCache.getInstance().mostrarContenidoCache();

        System.out.println("\n==============================================");
        System.out.println("SEGUNDA SOLICITUD DE LAS MISMAS IMÁGENES");
        System.out.println("(Se obtendrán del caché - acceso rápido)");
        System.out.println("==============================================");

        System.out.println("\n--- Solicitando imagen 1 de nuevo ---");
        imagen1.mostrar();

        System.out.println("\n--- Solicitando imagen 2 de nuevo ---");
        imagen2.mostrar();

        System.out.println("\n==============================================");
        System.out.println("SOLICITUD DE IMAGEN INEXISTENTE");
        System.out.println("==============================================");

        System.out.println("\n--- Solicitando imagen inexistente ---");
        imagen4.mostrar();

        System.out.println("\n==============================================");
        System.out.println("SOLICITUD DE NUEVA IMAGEN");
        System.out.println("==============================================");

        System.out.println("\n--- Solicitando imagen 3 (primera vez) ---");
        imagen3.mostrar();

        System.out.println("\n--- Solicitando imagen 3 (segunda vez - desde caché) ---");
        imagen3.mostrar();

        System.out.println("\n==============================================");
        System.out.println("ESTADO FINAL DEL CACHÉ");
        System.out.println("==============================================");
        ImagenCache.getInstance().mostrarContenidoCache();

    }
}
