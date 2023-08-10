package tallerDos.ejercicioCuatro;

public class Habitacion {
    private String numeroHabitacion;
    private double precioNoche;
    private boolean ocupado;
    private Huesped huesped;

    public Habitacion(String numeroHabitacion, double precioNoche) {
        this.numeroHabitacion = numeroHabitacion;
        this.precioNoche = precioNoche;
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getNumeroHabitacion(){
        return numeroHabitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
}
