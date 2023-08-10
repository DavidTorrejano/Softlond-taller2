package tallerDos.ejercicioCuatro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SitioDeReservas {

    private List<Hotel> hoteles = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    private Optional<Cliente> existeCliente (String idCorporativo) {
        for (Cliente cliente: clientes) {
            if (cliente.getIdCorporativo().equalsIgnoreCase(idCorporativo)){
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }
    private Optional<Hotel> existeHotel(String nombreHotel){
        for (Hotel hotel: hoteles) {
            if (hotel.getNombreHotel().equalsIgnoreCase(nombreHotel)){
                return Optional.of(hotel);
            }
        }
        return Optional.empty();
    }
    private Optional<Hotel> existeReserva(int numeroReserva) {
        for (Hotel hotel: hoteles){
            boolean reservaExiste = hotel.getReservas()
                    .stream().anyMatch(x -> x.getNumeroReserva() == numeroReserva);
            if (reservaExiste){
                return Optional.of(hotel);
            }
        }
        return Optional.empty();
    }

    public void registrarHotel(Hotel hotel){
        hoteles.add(hotel);
    }

    public void registrarClienteCorporativo(String nombreCompleto, String idCorporativo){

        if (existeCliente(idCorporativo).isPresent()){
            System.out.println("El cliente ya existe. ");
        }else {
            Cliente nuevoCliente = new Cliente(nombreCompleto, idCorporativo);
            clientes.add(nuevoCliente);
        }
    }

    public void reservarHabitacion(String idCorporativo, String nombreHotel,
                                   String numeroHabitacion, String nombreHuesped,
                                   String cedulaHuesped){
        boolean reservado = false;

        if (existeCliente(idCorporativo).isEmpty()){
            System.out.println("El cliente no se encuentra registrado.");
        } else if(existeHotel(nombreHotel).isEmpty()){
            System.out.println("El Hotel indicado NO EXISTE.");
        } else {
            reservado = existeHotel(nombreHotel)
                    .get()
                    .hacerReserva(existeCliente(idCorporativo).get(),
                            numeroHabitacion,
                            nombreHuesped,
                            cedulaHuesped);
        }
        if (reservado){
            System.out.println("La reserva se ha hecho satisfactoriamente.");
        } else {
            System.out.println("No se ha podido generar la reserva.");
        }

    }

    public void cancelarReserva(String idCorporativo, int numeroReserva){
        if (existeCliente(idCorporativo).isEmpty()){
            System.out.println("El cliente no existe.");
        } else if (existeReserva(numeroReserva).isEmpty()){
            System.out.println("No existe la reserva.");
        } else {
            Hotel hotel = existeReserva(numeroReserva).get();
            hotel.eliminarReserva(numeroReserva);
            System.out.println("La reserva ha sido cancelada.");
        }
    }

    public void listarTodasHabitaciones(){
        hoteles.forEach(hotel -> {
            System.out.println("\n*** Hotel: " + hotel.getNombreHotel() + " ***");
            System.out.println("--------------------------");
            hotel.listarHabitaciones();
        });
    }

    public void mostrarReservas(String idCorporativo){
        if (clientes.stream().noneMatch(x-> x.getIdCorporativo().equalsIgnoreCase(idCorporativo))){
            System.out.println("El cliente no está registrado.");
            return;
        }
        for (Hotel hotel: hoteles){
            hotel.getReservas().forEach(reserva -> {
                if (reserva.getCliente().getIdCorporativo().equalsIgnoreCase(idCorporativo)){
                    System.out.print("Hotel -> ");
                    System.out.println(hotel.getNombreHotel());
                    System.out.println(reserva);
                }
            });
        }
    }

}
