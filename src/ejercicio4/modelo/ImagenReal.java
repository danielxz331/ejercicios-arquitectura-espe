package ejercicio4.modelo;

/**
 * Clase real que representa una imagen cargada desde disco/base de datos.
 * La carga es una operación costosa (simulada con un delay).
 */
public class ImagenReal implements Imagen {
    
    private String nombre;
    private String datos;

    public ImagenReal(String nombre) {
        this.nombre = nombre;
        cargarDesdeDirectorio();
    }

    /**
     * Simula la carga de la imagen desde el directorio o base de datos.
     * Esta es una operación costosa.
     */
    private void cargarDesdeDirectorio() {
        System.out.println("    [ImagenReal] Cargando imagen '" + nombre + "' desde el directorio...");
        
        // Simular tiempo de carga (operación costosa)
        try {
            Thread.sleep(1000); // Simula 1 segundo de carga
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Simular datos de la imagen
        this.datos = "Datos binarios de la imagen: " + nombre;
        System.out.println("    [ImagenReal] Imagen '" + nombre + "' cargada exitosamente.");
    }

    @Override
    public void mostrar() {
        System.out.println("    [ImagenReal] Mostrando imagen: " + nombre);
        System.out.println("    [ImagenReal] " + datos);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "ImagenReal{nombre='" + nombre + "'}";
    }
}
