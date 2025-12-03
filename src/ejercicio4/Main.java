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

        // Mostrar imágenes disponibles en el sistema
        BaseDatosImagenes.getInstance().listarImagenesDisponibles();
        System.out.println();

        // Crear proxies para las imágenes (NO se cargan aún - lazy loading)
        System.out.println(">>> Creando proxies para imágenes (lazy loading)...\n");
        
        Imagen imagen1 = new ImagenProxy("foto_perfil.jpg");
        Imagen imagen2 = new ImagenProxy("logo_empresa.png");
        Imagen imagen3 = new ImagenProxy("banner_principal.jpg");
        Imagen imagen4 = new ImagenProxy("imagen_inexistente.jpg"); // No existe
        
        System.out.println("\n>>> Las imágenes NO han sido cargadas aún (lazy loading)");
        
        // Mostrar estado del caché (debe estar vacío)
        ImagenCache.getInstance().mostrarContenidoCache();

        // ============================================
        // PRIMERA SOLICITUD: Cargar desde directorio
        // ============================================
        System.out.println("\n==============================================");
        System.out.println("PRIMERA SOLICITUD DE IMÁGENES");
        System.out.println("(Se cargarán desde el directorio y se agregarán al caché)");
        System.out.println("==============================================");

        System.out.println("\n--- Solicitando imagen 1 ---");
        imagen1.mostrar();

        System.out.println("\n--- Solicitando imagen 2 ---");
        imagen2.mostrar();

        // Mostrar estado del caché (debe tener 2 imágenes)
        ImagenCache.getInstance().mostrarContenidoCache();

        // ============================================
        // SEGUNDA SOLICITUD: Obtener desde caché
        // ============================================
        System.out.println("\n==============================================");
        System.out.println("SEGUNDA SOLICITUD DE LAS MISMAS IMÁGENES");
        System.out.println("(Se obtendrán del caché - acceso rápido)");
        System.out.println("==============================================");

        System.out.println("\n--- Solicitando imagen 1 de nuevo ---");
        imagen1.mostrar();

        System.out.println("\n--- Solicitando imagen 2 de nuevo ---");
        imagen2.mostrar();

        // ============================================
        // SOLICITUD DE IMAGEN INEXISTENTE
        // ============================================
        System.out.println("\n==============================================");
        System.out.println("SOLICITUD DE IMAGEN INEXISTENTE");
        System.out.println("==============================================");

        System.out.println("\n--- Solicitando imagen inexistente ---");
        imagen4.mostrar();

        // ============================================
        // NUEVA IMAGEN (no solicitada antes)
        // ============================================
        System.out.println("\n==============================================");
        System.out.println("SOLICITUD DE NUEVA IMAGEN");
        System.out.println("==============================================");

        System.out.println("\n--- Solicitando imagen 3 (primera vez) ---");
        imagen3.mostrar();

        System.out.println("\n--- Solicitando imagen 3 (segunda vez - desde caché) ---");
        imagen3.mostrar();

        // Estado final del caché
        System.out.println("\n==============================================");
        System.out.println("ESTADO FINAL DEL CACHÉ");
        System.out.println("==============================================");
        ImagenCache.getInstance().mostrarContenidoCache();

        System.out.println("\n>>> Proceso completado exitosamente!");
        System.out.println("\nRESUMEN:");
        System.out.println("- El proxy controla el acceso a las imágenes reales");
        System.out.println("- Las imágenes se cargan solo cuando son solicitadas (lazy loading)");
        System.out.println("- Las imágenes cargadas se almacenan en caché");
        System.out.println("- Las siguientes solicitudes se obtienen del caché (rápido)");
    }
}
