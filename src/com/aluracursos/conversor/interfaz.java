package com.aluracursos.conversor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class interfaz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        consultaApi consultaTasa = new consultaApi();


        String menu = """
                \n***********************************************
                Bienvenido al Conversor de Moneda.
                
                1. Dolar(USD) => Peso Argentino(ARS)
                2. Peso Argentino(ARS) => Dolar(USD)
                3. Dolar(USD) => Real Brasileño(BRL)
                4. Real Brasileño(BRL) => Dolar(USD)
                5. Dolar(USD) => Peso Colombiano(COP)
                6. Peso Colombiano(COP) => Dolar(USD)
                7. Salir
                Elija una opcion valida:
                ***********************************************
                """;

        while(true) {
            try {
                System.out.print(menu);
                int opcion = scanner.nextInt();

                if (opcion == 7) break;
                if (opcion < 1 || opcion > 7) {
                    System.out.println("opcion no valida, ingrese una opcion del menu");
                } else {

                    System.out.println("Ingrese el valor a convertir:");
                    double valor = scanner.nextDouble();

                    switch (opcion) {
                        case 1:
                            consultaTasa.tasasDeCambio(CurrencyCodes.USD, CurrencyCodes.ARS, valor);
                            break;
                        case 2:
                            consultaTasa.tasasDeCambio(CurrencyCodes.ARS, CurrencyCodes.USD, valor);
                            break;
                        case 3:
                            consultaTasa.tasasDeCambio(CurrencyCodes.USD, CurrencyCodes.BRL, valor);
                            break;
                        case 4:
                            consultaTasa.tasasDeCambio(CurrencyCodes.BRL, CurrencyCodes.USD, valor);
                            break;
                        case 5:
                            consultaTasa.tasasDeCambio(CurrencyCodes.USD, CurrencyCodes.COP, valor);
                            break;
                        case 6:
                            consultaTasa.tasasDeCambio(CurrencyCodes.COP, CurrencyCodes.USD, valor);
                            break;

                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Ingrese solo numeros");
                scanner.nextLine();
            }
        }

        System.out.println("Programa Finalizado");
        scanner.close();
    }

    private static class ConsultarTasaCambio {
    }
}
