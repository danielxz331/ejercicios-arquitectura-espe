package ejercicio2.builder;

import ejercicio2.modelo.Estudiante;
import ejercicio2.modelo.Persona;

public class EstudianteBuilder implements PersonaBuilder {
    private String nombres;
    private String apellidos;
    private String programaAcademico;

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

    public EstudianteBuilder setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
        return this;
    }

    @Override
    public Persona build() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombres(this.nombres);
        estudiante.setApellidos(this.apellidos);
        estudiante.setProgramaAcademico(this.programaAcademico);
        return estudiante;
    }
}
