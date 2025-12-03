package ejercicio5.recursos;

import ejercicio5.pool.Poolable;

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

        System.out.println("    [Peticion-" + id + "] Estableciendo conexión con el servidor...");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("    [Peticion-" + id + "] Conexión establecida.");
    }

    public void configurarPeticion(String url, String metodo, String datos) {
        this.urlServidor = url;
        this.metodoHttp = metodo;
        this.datos = datos;
        System.out.println("    [Peticion-" + id + "] Configurada: " + metodo + " " + url);
    }

    public void ejecutar() {
        System.out.println("    [Peticion-" + id + "] Ejecutando petición " + metodoHttp + " a " + urlServidor);
        
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.codigoRespuesta = 200;
        this.respuesta = "{ \"status\": \"success\", \"message\": \"Operación completada\", \"peticion_id\": " + id + " }";
        
        System.out.println("    [Peticion-" + id + "] Respuesta recibida: HTTP " + codigoRespuesta);
    }

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

    @Override
    public String toString() {
        return "PeticionServidor{id=" + id + ", url='" + urlServidor + "', metodo='" + metodoHttp + "', codigo=" + codigoRespuesta + "}";
    }
}
