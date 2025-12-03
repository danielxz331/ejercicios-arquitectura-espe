package ejercicio5;

import ejercicio5.pool.ObjectPool;
import ejercicio5.recursos.ArchivoGrande;
import ejercicio5.recursos.PeticionServidor;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   EJERCICIO 5: PATRÓN OBJECT POOL");
        System.out.println("         (Implementación Genérica)");
        System.out.println("==============================================\n");

        // ============================================
        // POOL DE ARCHIVOS GRANDES
        // ============================================
        demostrarPoolArchivos();

        // ============================================
        // POOL DE PETICIONES AL SERVIDOR
        // ============================================
        demostrarPoolPeticiones();

        System.out.println("\n>>> Proceso completado exitosamente!");
        System.out.println("\nRESUMEN DEL PATRÓN OBJECT POOL:");
        System.out.println("- Reutiliza objetos costosos en lugar de crearlos/destruirlos");
        System.out.println("- Limita el número máximo de recursos en uso");
        System.out.println("- Mejora el rendimiento evitando creación repetida");
        System.out.println("- Implementación genérica aplicable a cualquier tipo de recurso");
    }

    private static void demostrarPoolArchivos() {
        System.out.println("##############################################");
        System.out.println("  DEMOSTRACIÓN: POOL DE ARCHIVOS GRANDES");
        System.out.println("##############################################\n");

        // Crear pool de archivos con máximo 3 instancias
        ObjectPool<ArchivoGrande> poolArchivos = new ObjectPool<>(
            3, 
            ArchivoGrande::new, 
            "PoolArchivos"
        );

        System.out.println("\n--- Fase 1: Obtener archivos del pool ---");
        
        // Obtener 3 archivos
        ArchivoGrande archivo1 = poolArchivos.obtenerObjeto();
        archivo1.cargarArchivo("documento_grande.pdf", 15 * 1024 * 1024); // 15 MB
        archivo1.procesar();

        ArchivoGrande archivo2 = poolArchivos.obtenerObjeto();
        archivo2.cargarArchivo("imagen_alta_resolucion.tiff", 50 * 1024 * 1024); // 50 MB
        archivo2.procesar();

        ArchivoGrande archivo3 = poolArchivos.obtenerObjeto();
        archivo3.cargarArchivo("video_clip.mp4", 100 * 1024 * 1024); // 100 MB
        archivo3.procesar();

        // Intentar obtener un cuarto archivo (pool agotado)
        System.out.println("\n--- Fase 2: Intentar obtener más archivos (pool agotado) ---");
        ArchivoGrande archivo4 = poolArchivos.obtenerObjeto();
        if (archivo4 == null) {
            System.out.println(">>> No se pudo obtener el archivo. Todos los recursos están en uso.");
        }

        // Liberar un archivo
        System.out.println("\n--- Fase 3: Liberar un archivo y reutilizar ---");
        poolArchivos.liberarObjeto(archivo1);

        // Ahora sí podemos obtener otro archivo (reutiliza el liberado)
        ArchivoGrande archivo5 = poolArchivos.obtenerObjeto();
        archivo5.cargarArchivo("backup_datos.zip", 200 * 1024 * 1024); // 200 MB
        archivo5.procesar();

        // Mostrar estado final
        poolArchivos.mostrarInfoDetallada();

        // Limpiar
        poolArchivos.liberarObjeto(archivo2);
        poolArchivos.liberarObjeto(archivo3);
        poolArchivos.liberarObjeto(archivo5);

        System.out.println("\n--- Todos los archivos liberados ---");
        poolArchivos.mostrarInfoDetallada();
    }

    private static void demostrarPoolPeticiones() {
        System.out.println("\n##############################################");
        System.out.println("  DEMOSTRACIÓN: POOL DE PETICIONES SERVIDOR");
        System.out.println("##############################################\n");

        // Crear pool de peticiones con máximo 5 conexiones permitidas
        final int MAX_PETICIONES_PERMITIDAS = 5;
        
        ObjectPool<PeticionServidor> poolPeticiones = new ObjectPool<>(
            MAX_PETICIONES_PERMITIDAS, 
            PeticionServidor::new, 
            "PoolPeticiones"
        );

        System.out.println("Número máximo de peticiones permitidas: " + MAX_PETICIONES_PERMITIDAS);

        System.out.println("\n--- Fase 1: Realizar múltiples peticiones ---");

        // Simular múltiples peticiones
        PeticionServidor[] peticiones = new PeticionServidor[MAX_PETICIONES_PERMITIDAS];
        
        String[][] datosAPIs = {
            {"https://api.ejemplo.com/usuarios", "GET", ""},
            {"https://api.ejemplo.com/productos", "GET", ""},
            {"https://api.ejemplo.com/pedidos", "POST", "{\"producto\": \"123\"}"},
            {"https://api.ejemplo.com/inventario", "PUT", "{\"cantidad\": 50}"},
            {"https://api.ejemplo.com/reportes", "GET", ""}
        };

        for (int i = 0; i < MAX_PETICIONES_PERMITIDAS; i++) {
            peticiones[i] = poolPeticiones.obtenerObjeto();
            if (peticiones[i] != null) {
                peticiones[i].configurarPeticion(datosAPIs[i][0], datosAPIs[i][1], datosAPIs[i][2]);
                peticiones[i].ejecutar();
                System.out.println("    Respuesta: " + peticiones[i].obtenerRespuesta());
            }
        }

        // Intentar una petición adicional (excede el límite)
        System.out.println("\n--- Fase 2: Intentar exceder el límite de peticiones ---");
        PeticionServidor peticionExtra = poolPeticiones.obtenerObjeto();
        if (peticionExtra == null) {
            System.out.println(">>> Límite de peticiones alcanzado. Espere a que se liberen conexiones.");
        }

        // Liberar algunas peticiones
        System.out.println("\n--- Fase 3: Liberar y reutilizar conexiones ---");
        poolPeticiones.liberarObjeto(peticiones[0]);
        poolPeticiones.liberarObjeto(peticiones[1]);

        // Ahora podemos hacer nuevas peticiones
        PeticionServidor nuevaPeticion1 = poolPeticiones.obtenerObjeto();
        nuevaPeticion1.configurarPeticion("https://api.ejemplo.com/notificaciones", "POST", "{\"mensaje\": \"Hola\"}");
        nuevaPeticion1.ejecutar();

        PeticionServidor nuevaPeticion2 = poolPeticiones.obtenerObjeto();
        nuevaPeticion2.configurarPeticion("https://api.ejemplo.com/estadisticas", "GET", "");
        nuevaPeticion2.ejecutar();

        // Mostrar estado final
        poolPeticiones.mostrarInfoDetallada();

        // Liberar todas las conexiones
        System.out.println("--- Liberando todas las conexiones ---");
        poolPeticiones.liberarObjeto(peticiones[2]);
        poolPeticiones.liberarObjeto(peticiones[3]);
        poolPeticiones.liberarObjeto(peticiones[4]);
        poolPeticiones.liberarObjeto(nuevaPeticion1);
        poolPeticiones.liberarObjeto(nuevaPeticion2);

        poolPeticiones.mostrarInfoDetallada();
    }
}
