package tallerDos.ejercicioDos;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConversorMonedas conversor = new ConversorMonedas();

        Scanner entrada = new Scanner(System.in);
        System.out.println("""
                *** Conversor de monedas ***
                       __Monedas__
                * USD (United States Dolar)
                * COP (Colombian Peso)
                * EUR (Euro)
                * GBP (British pound sterling)
                * JPY (Japanese Yen)
                * ARS (Argentine Peso)
                Por favor, para convertir monedas utilice la abreviación de cada una de ellas ej:
                Para convertir de PesO Colombiano a Dólar estadounidense use ->
                "Moneda origen: COP"
                "Moneda destino: USD"
                """);

        System.out.print("Por favor ingrese la moneda desde la cual desea convertir: ");
        String monedaOrigen = entrada.nextLine();

        System.out.print("Por favor ingrese la a la cual desea convertir: ");
        String monedaDestino = entrada.nextLine();

        System.out.print("Por favor ingrese la cantidad a convertir: ");
        double cantidad = entrada.nextDouble();

        conversor.convertirDivisa(monedaOrigen, monedaDestino, cantidad);
    }
}
