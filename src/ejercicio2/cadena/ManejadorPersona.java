package ejercicio2.cadena;

import ejercicio2.modelo.Persona;

public abstract class ManejadorPersona {
    protected ManejadorPersona siguiente;

    public void setSiguiente(ManejadorPersona siguiente) {
        this.siguiente = siguiente;
    }

    public abstract void manejar(Persona persona);

    protected void pasarAlSiguiente(Persona persona) {
        if (siguiente != null) {
            siguiente.manejar(persona);
        }
    }
}
