package ejercicio2.modelo;

public abstract class Persona {
    protected String nombres;
    protected String apellidos;

    public abstract String toString();

    public void setNombres(String obj) {
        this.nombres = obj;
    }

    public void setApellidos(String obj) {
        this.apellidos = obj;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
}
