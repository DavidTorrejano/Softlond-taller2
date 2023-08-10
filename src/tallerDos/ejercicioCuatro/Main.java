package tallerDos.ejercicioCuatro;

public class Main {
    public static SitioDeReservas hotelesPuntoCom = new SitioDeReservas();
    public static void iniciarHoteles(){
        // Hotel 1
        Hotel hotel1 = new Hotel("Oriente");
        hotel1.construirHabitacion("A01", 50000);
        hotel1.construirHabitacion("A02", 45000);
        hotel1.construirHabitacion("A03", 39000);

        // Hotel 2
        Hotel hotel2 = new Hotel("Central");
        hotel2.construirHabitacion("B01", 90000);
        hotel2.construirHabitacion("B02", 65000);
        hotel2.construirHabitacion("B03", 47000);

        // Hotel 3
        Hotel hotel3 = new Hotel("Diagonal");
        hotel3.construirHabitacion("C01", 35000);
        hotel3.construirHabitacion("C02", 55000);
        hotel3.construirHabitacion("C03", 79000);


        hotelesPuntoCom.registrarHotel(hotel1);
        hotelesPuntoCom.registrarHotel(hotel2);
        hotelesPuntoCom.registrarHotel(hotel3);
    }

    public static void main(String[] args) {
        iniciarHoteles();

//        hotelesPuntoCom.listarTodasHabitaciones();
        hotelesPuntoCom.registrarClienteCorporativo("Telecom", "telecom");
        hotelesPuntoCom.reservarHabitacion("telecom", "Diagonal", "C01",
                "Jorge Rentón", "11965");

        hotelesPuntoCom.registrarClienteCorporativo("Motorola", "mototo");
        hotelesPuntoCom.reservarHabitacion("mototo", "Central", "B03",
                "Armando Casas", "789856");

//        hotelesPuntoCom.listarTodasHabitaciones();
        hotelesPuntoCom.mostrarReservas("telecom");
        hotelesPuntoCom.mostrarReservas("mototo");
        hotelesPuntoCom.mostrarReservas("patt");
        hotelesPuntoCom.cancelarReserva("telecom", 100);
        hotelesPuntoCom.listarTodasHabitaciones();


    }
}
