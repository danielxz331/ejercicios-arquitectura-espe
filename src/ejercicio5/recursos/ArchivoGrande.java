package ejercicio5.recursos;

import ejercicio5.pool.Poolable;

public class ArchivoGrande implements Poolable {
    
    private static int contadorId = 0;
    
    private int id;
    private String nombre;
    private String contenido;
    private long tamanioBytes;
    private boolean disponible;

    public ArchivoGrande() {
        this.id = ++contadorId;
        this.nombre = "";
        this.contenido = "";
        this.tamanioBytes = 0;
        this.disponible = true;

        System.out.println("    [ArchivoGrande-" + id + "] Creando instancia de archivo grande...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("    [ArchivoGrande-" + id + "] Instancia creada.");
    }

    public void cargarArchivo(String nombre, long tamanioBytes) {
        this.nombre = nombre;
        this.tamanioBytes = tamanioBytes;
        
        System.out.println("    [ArchivoGrande-" + id + "] Cargando archivo: " + nombre + 
                          " (" + formatearTamanio(tamanioBytes) + ")");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        this.contenido = "Contenido del archivo: " + nombre;
        System.out.println("    [ArchivoGrande-" + id + "] Archivo cargado exitosamente.");
    }

    public void procesar() {
        System.out.println("    [ArchivoGrande-" + id + "] Procesando archivo: " + nombre);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("    [ArchivoGrande-" + id + "] Procesamiento completado.");
    }

    private String formatearTamanio(long bytes) {
        if (bytes >= 1024 * 1024) {
            return String.format("%.2f MB", bytes / (1024.0 * 1024.0));
        } else if (bytes >= 1024) {
            return String.format("%.2f KB", bytes / 1024.0);
        }
        return bytes + " bytes";
    }

    @Override
    public void reset() {
        this.nombre = "";
        this.contenido = "";
        this.tamanioBytes = 0;
        System.out.println("    [ArchivoGrande-" + id + "] Objeto reiniciado para reutilización.");
    }

    @Override
    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "ArchivoGrande{id=" + id + ", nombre='" + nombre + "', tamaño=" + formatearTamanio(tamanioBytes) + "}";
    }
}
