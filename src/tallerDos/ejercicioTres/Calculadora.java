package tallerDos.ejercicioTres;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Calculadora calcular = new Calculadora();
        Scanner entrada = new Scanner(System.in);
        double num1 = 0, num2 = 0;
        int seleccion;
        String continuar;

        do {
            System.out.println("""
                    *** Calculadora ***
                    1. Sumar
                    2. Restar
                    3. Multiplicar
                    4. Dividir
                    5. Salir.
                    """);

                System.out.print("Por favor seleccione una opción (1 - 5): ");
                seleccion = entrada.nextInt();
                if (seleccion != 5) {
                    System.out.print("Por favor ingrese el primer número: ");
                    num1 = entrada.nextDouble();
                    System.out.print("Por favor ingrese el segundo número: ");
                    num2 = entrada.nextDouble();
                }

            switch (seleccion) {
                case 1 -> {
                    System.out.println("A elegido sumar dos números: ");
                    System.out.println(num1 + " + " + num2 + "= " + calcular.suma(num1, num2));
                }
                case 2 -> {
                    System.out.println("A elegido restar dos números: ");
                    System.out.println(num1 + " - " + num2 + "= " + calcular.resta(num1, num2));

                }
                case 3 -> {
                    System.out.println("A elegido multiplicar dos números: ");
                    System.out.println(num1 + " * " + num2 + "= " + calcular.multiplica(num1, num2));
                }
                case 4 -> {
                    System.out.println("A elegido dividir dos números: ");
                    System.out.println(num1 + " / " + num2 + "= " + calcular.divide(num1, num2));
                }
            }
            if (seleccion != 5) {
                System.out.println("¿Desea continuar? (y-n)");
                entrada.nextLine();
                continuar = entrada.nextLine();
                if (continuar.equalsIgnoreCase("n")) {
                    break;
                }
            }
        } while(seleccion != 5);
    }

    public double suma(double num1, double num2){
        return num1+num2;
    }

    public double multiplica(double num1, double num2){
        return num1*num2;
    }

    public double divide(double num1, double num2){
        return num1/num2;
    }

    public double resta(double num1, double num2){
        return num1-num2;
    }
}
