package ejercicio5.recursos;

import ejercicio5.pool.Poolable;

/**
 * Representa una conexión/petición a un servidor.
 * Recurso limitado que debe ser gestionado por el pool.
 */
public class PeticionServidor implements Poolable {
    
    private static int contadorId = 0;
    
    private int id;
    private String urlServidor;
    private String metodoHttp;
    private String datos;
    private int codigoRespuesta;
    private String respuesta;
    private boolean disponible;
    private long tiempoConexion;

    public PeticionServidor() {
        this.id = ++contadorId;
        this.urlServidor = "";
        this.metodoHttp = "";
        this.datos = "";
        this.codigoRespuesta = 0;
        this.respuesta = "";
        this.disponible = true;
        this.tiempoConexion = System.currentTimeMillis();
        
        // Simular establecimiento de conexión
        System.out.println("    [Peticion-" + id + "] Estableciendo conexión con el servidor...");
        try {
            Thread.sleep(400); // Simula 400ms para establecer conexión
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("    [Peticion-" + id + "] Conexión establecida.");
    }

    /**
     * Configura la petición
     */
    public void configurarPeticion(String url, String metodo, String datos) {
        this.urlServidor = url;
        this.metodoHttp = metodo;
        this.datos = datos;
        System.out.println("    [Peticion-" + id + "] Configurada: " + metodo + " " + url);
    }

    /**
     * Ejecuta la petición al servidor (simulado)
     */
    public void ejecutar() {
        System.out.println("    [Peticion-" + id + "] Ejecutando petición " + metodoHttp + " a " + urlServidor);
        
        try {
            // Simular tiempo de respuesta del servidor
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Simular respuesta exitosa
        this.codigoRespuesta = 200;
        this.respuesta = "{ \"status\": \"success\", \"message\": \"Operación completada\", \"peticion_id\": " + id + " }";
        
        System.out.println("    [Peticion-" + id + "] Respuesta recibida: HTTP " + codigoRespuesta);
    }

    /**
     * Obtiene la respuesta de la petición
     */
    public String obtenerRespuesta() {
        return respuesta;
    }

    @Override
    public void reset() {
        this.urlServidor = "";
        this.metodoHttp = "";
        this.datos = "";
        this.codigoRespuesta = 0;
        this.respuesta = "";
        this.tiempoConexion = System.currentTimeMillis();
        System.out.println("    [Peticion-" + id + "] Conexión reiniciada para reutilización.");
    }

    @Override
    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    @Override
    public String toString() {
        return "PeticionServidor{id=" + id + ", url='" + urlServidor + "', metodo='" + metodoHttp + "', codigo=" + codigoRespuesta + "}";
    }
}
