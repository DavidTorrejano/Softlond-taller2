package tallerDos.ejercicioCuatro;

public class Reserva {

    private static int generadorNumeros = 100;

    private Cliente cliente;
    private Habitacion habitacion;
    private Huesped huesped;
    private final int numeroReserva;


    public Reserva(Cliente cliente, Habitacion habitacion, Huesped huesped) {
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.cliente = cliente;
        this.numeroReserva = generadorNumeros++;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Nombre Empresa: " + cliente.getNombreEmpresa() +
                "\nNombre: " + huesped.getNombre() +
                "\nCédula: " + huesped.getDocumentoIdentidad() +
                "\nHabitación asignada: " + habitacion.getNumeroHabitacion() +
                "\nNúmero de reserva: " + getNumeroReserva() +
                "\n------------------------------------";
    }
}
