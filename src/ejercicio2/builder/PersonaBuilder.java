package ejercicio2.builder;

import ejercicio2.modelo.Persona;

public interface PersonaBuilder {
    PersonaBuilder setNombres(String nombres);
    PersonaBuilder setApellidos(String apellidos);
    Persona build();
}
