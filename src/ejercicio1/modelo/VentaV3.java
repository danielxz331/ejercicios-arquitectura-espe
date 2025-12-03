package ejercicio1.modelo;

public class VentaV3 {
    private double precioBase;
    private int edadCliente;

    public VentaV3() {
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    @Override
    public String toString() {
        return "VentaV3{" +
                "precioBase=" + precioBase +
                ", edadCliente=" + edadCliente +
                '}';
    }
}
