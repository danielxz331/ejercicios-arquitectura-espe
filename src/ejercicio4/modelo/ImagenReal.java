package ejercicio4.modelo;

public class ImagenReal implements Imagen {
    
    private String nombre;
    private String datos;

    public ImagenReal(String nombre) {
        this.nombre = nombre;
        cargarDesdeDirectorio();
    }


    private void cargarDesdeDirectorio() {
        System.out.println("    [ImagenReal] Cargando imagen '" + nombre + "' desde el directorio...");

        try {
            Thread.sleep(1000); // Simula 1 segundo de carga
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
