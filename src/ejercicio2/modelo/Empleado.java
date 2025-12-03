package ejercicio2.modelo;

public class Empleado extends Persona {
    private String cargo;

    public Empleado() {
    }

    public String cargoAsignado() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
