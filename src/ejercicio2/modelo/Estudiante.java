package ejercicio2.modelo;

public class Estudiante extends Persona {
    private String programaAcademico;

    public Estudiante() {
    }

    public String programaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", programaAcademico='" + programaAcademico + '\'' +
                '}';
    }
}
