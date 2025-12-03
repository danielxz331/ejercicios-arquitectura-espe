package ejercicio2.builder;

import ejercicio2.modelo.Empleado;
import ejercicio2.modelo.Persona;

public class EmpleadoBuilder implements PersonaBuilder {
    private String nombres;
    private String apellidos;
    private String cargo;

    @Override
    public PersonaBuilder setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    @Override
    public PersonaBuilder setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public EmpleadoBuilder setCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    @Override
    public Persona build() {
        Empleado empleado = new Empleado();
        empleado.setNombres(this.nombres);
        empleado.setApellidos(this.apellidos);
        empleado.setCargo(this.cargo);
        return empleado;
    }
}
