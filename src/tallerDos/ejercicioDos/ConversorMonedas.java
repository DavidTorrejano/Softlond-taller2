package tallerDos.ejercicioDos;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

public class ConversorMonedas {

    public HashMap<String, Double> iniciarListaMonedas(){

        HashMap<String, Double> monedas = new HashMap<>();

        double USDToCOP = 4028.85;
        monedas.put("COP", USDToCOP);
        double USDToEUR = 0.91;
        monedas.put("EUR", USDToEUR);
        double USDToGBP = 0.78;
        monedas.put("GBP", USDToGBP);
        double USDToJPY = 142.43;
        monedas.put("JPY", USDToJPY);
        double USDToARS = 283.16;
        monedas.put("ARS", USDToARS);
        double USDToUSD = 1;
        monedas.put("USD", USDToUSD);

        return monedas;
    }

    public void convertirDivisa(String monedaOrigen, String monedaDestino, double cantidad){

        HashMap<String, Double> monedas = iniciarListaMonedas();
        String origenMayus = monedaOrigen.toUpperCase();
        String destinoMayus = monedaDestino.toUpperCase();
        DecimalFormat df = new DecimalFormat("#,###.##");
        df.setRoundingMode(RoundingMode.CEILING);


        if (origenMayus.equals("USD")){
            String deUsdAOtro = df.format(+monedas.get(destinoMayus)*cantidad);

            System.out.println("La conversión de USD a " + destinoMayus
                    + " es: " + deUsdAOtro + " " + destinoMayus);
        } else {
            double aUsd = cantidad/monedas.get(origenMayus);
            String aMonedaDestino = df.format(aUsd*monedas.get(destinoMayus));
            System.out.println("La conversión de " + origenMayus + " a " + destinoMayus
            + " es: " + aMonedaDestino + " " + destinoMayus);
        }
    }


}
