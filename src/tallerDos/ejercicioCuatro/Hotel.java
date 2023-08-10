package tallerDos.ejercicioCuatro;

import java.util.ArrayList;
import java.util.Optional;

public class Hotel {

    private String nombreHotel;
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private Habitacion habitacion;

    public Hotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public boolean existeHabitacion(String numeroHabitacion){
        boolean existe = false;
        for(Habitacion habitacion: habitaciones){
            if (habitacion.getNumeroHabitacion().equalsIgnoreCase(numeroHabitacion)){
                this.habitacion = habitacion;
                existe = true;
            }
        }
        return existe;
    }

    public Optional<Reserva> existeReserva(int numeroReserva){
        for (Reserva reserva: reservas) {
            if (reserva.getNumeroReserva() == numeroReserva){
                return Optional.of(reserva);
            }
        }
        return Optional.empty();
    }

    public String getNombreHotel(){
        return nombreHotel;
    }

    public void construirHabitacion(String numeroHabitacion, double precioNoche){
        Habitacion habitacion = new Habitacion(numeroHabitacion, precioNoche);
        habitaciones.add(habitacion);
    }

    public boolean hacerReserva(Cliente cliente, String numHabitacion, String nombreHuesped, String cedulaHuesped){
        if (existeHabitacion(numHabitacion)){
            if (habitacion.isOcupado()){
                System.out.println("La habitación está ocupada.");
                return false;
            } else {
                Huesped huesped = new Huesped(nombreHuesped, cedulaHuesped);
                habitacion.setHuesped(huesped);
                habitacion.setOcupado(true);
                Reserva reserva = new Reserva(cliente, habitacion, huesped);
                reservas.add(reserva);
                return true;
            }
        } else {
            System.out.println("La habitación no existe.");
            return false;
        }
    }

    public void eliminarReserva(int numeroReserva){
        if (existeReserva(numeroReserva).isPresent()){
            existeReserva(numeroReserva).ifPresent(x ->{
                x.getHabitacion().setOcupado(false);
                reservas.remove(Optional.of(x).get());
            });
        }
    }

    public void listarHabitaciones(){
        habitaciones.forEach(x -> {
            System.out.println("Número de habitación: " + x.getNumeroHabitacion());
            System.out.println("Precio por noche: " + x.getPrecioNoche());
            if (x.isOcupado()){
                System.out.println("Ocupada");
            } else {
                System.out.println("Disponible");
            }
            System.out.println("--------------------------");
        });
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}
