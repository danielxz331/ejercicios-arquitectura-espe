package ejercicio2.factory;

import ejercicio2.builder.EmpleadoBuilder;
import ejercicio2.builder.EstudianteBuilder;
import ejercicio2.modelo.Persona;

public class PersonaFactory {

    public static Persona crearEstudiante(String nombres, String apellidos, String programaAcademico) {
        EstudianteBuilder builder = new EstudianteBuilder();
        builder.setNombres(nombres);
        builder.setApellidos(apellidos);
        builder.setProgramaAcademico(programaAcademico);
        return builder.build();
    }

    public static Persona crearEmpleado(String nombres, String apellidos, String cargo) {
        EmpleadoBuilder builder = new EmpleadoBuilder();
        builder.setNombres(nombres);
        builder.setApellidos(apellidos);
        builder.setCargo(cargo);
        return builder.build();
    }
}
