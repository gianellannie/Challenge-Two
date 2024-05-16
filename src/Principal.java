import com.google.gson.JsonSyntaxException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int inicio = -1;
        int opcion = -1;
        double valorInicial;
        double valorFinal;
        String monedaBase;
        String monedaDestino;
        String errorOpcion = "<<ERROR: Debe ingresar una opción válida.>>";
        String errorValor = "<<ERROR: Valor inválido.>>";
        Historial historial = new Historial();
        try{
            while (inicio!=0){
                System.out.println("***************************************");
                System.out.println("Bienvenido(a) al Conversor de Moneda");
                System.out.println("1) Ingresar con código de moneda");
                System.out.println("2) Ingresar con opciones limitadas");
                System.out.println("3) Lista de códigos de moneda");
                System.out.println("4) Historial de conversiones");
                System.out.println("0) Salir");
                System.out.println("***************************************");
                System.out.print("Ingresar una opción válida: ");
                inicio = lectura.nextInt();
                lectura.nextLine();
                switch (inicio){
                    case 1:
                        try {
                            System.out.print("Ingresar el código de la moneda base: ");
                            monedaBase = lectura.nextLine().toUpperCase();
                            if (new Conversor().codigoValido(monedaBase)){
                                throw new NullPointerException();
                            }
                            System.out.print("Ingresar el código de la moneda de destino: ");
                            monedaDestino = lectura.nextLine().toUpperCase();
                            if (new Conversor().codigoValido(monedaDestino)){
                                throw new NullPointerException();
                            }
                            System.out.print("Ingresar el valor que desea convertir: ");
                            valorInicial = lectura.nextDouble();
                            lectura.nextLine();
                            if (valorInicial <= 0) {
                                throw new ValorInvalido(errorValor);
                            }
                            Conversor conversor = new Conversor();
                            valorFinal = conversor.valorFinal(monedaBase, monedaDestino, valorInicial);
                            historial.agregar(conversor);
                            String resultado = String.format(
                                    ">> El valor %.2f (%s) corresponde al valor final de %.2f (%s).",
                                    valorInicial, monedaBase, valorFinal, monedaDestino
                            );
                            System.out.println(resultado);
                        } catch (NullPointerException | JsonSyntaxException e) {
                            System.out.println("<<ERROR: Código de moneda desconocido.>>");
                        } catch (ValorInvalido e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        while (opcion != 0) {
                            System.out.println("***************************************");
                            System.out.println("1) Dólar =>> Peso Colombiano");
                            System.out.println("2) Dólar =>> Peso Argentino");
                            System.out.println("3) Dólar =>> Peso Chileno");
                            System.out.println("4) Dólar =>> Real Brasileño");
                            System.out.println("5) Dólar =>> Boliviano");
                            System.out.println("6) Real Brasileño =>> Peso Colombiano");
                            System.out.println("7) Real Brasileño =>> Peso Argentino");
                            System.out.println("8) Real Brasileño =>> Peso Chileno");
                            System.out.println("9) Real Brasileño =>> Dólar");
                            System.out.println("10) Real Brasileño =>> Boliviano");
                            System.out.println("11) Boliviano =>> Peso Colombiano");
                            System.out.println("12) Boliviano =>> Peso Argentino");
                            System.out.println("13) Boliviano =>> Peso Chileno");
                            System.out.println("14) Boliviano =>> Real Brasileño");
                            System.out.println("15) Boliviano =>> Dólar");
                            System.out.println("0) Salir");
                            System.out.println("***************************************");
                            System.out.print("Ingresar una opción válida: ");
                            opcion = lectura.nextInt();
                            lectura.nextLine();
                            if (opcion > 0 && opcion < 16) {
                                try {
                                    System.out.print("Ingresar el valor que desea convertir: ");
                                    valorInicial = lectura.nextDouble();
                                    lectura.nextLine();
                                    if (valorInicial <= 0) {
                                        throw new ValorInvalido(errorValor);
                                    }
                                    OpcionesLimitadas opciones = new OpcionesLimitadas();
                                    valorFinal = opciones.valorFinal(opcion, valorInicial);
                                    monedaBase = opciones.getMonedaBase();
                                    monedaDestino = opciones.getMonedaDestino();
                                    historial.agregar(opciones.getConversor());
                                    String resultado = String.format(
                                            ">> El valor %.2f (%s) corresponde al valor final de %.2f (%s).",
                                            valorInicial, monedaBase, valorFinal, monedaDestino
                                    );
                                    System.out.println(resultado);
                                } catch (ValorInvalido e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                        break;
                    case 3:
                        Conversor conversor = new Conversor();
                        conversor.codigosAdmitidos();
                        break;
                    case 4:
                        historial.getHistorial();
                        break;
                    case 0:
                        System.out.println(">> Salió exitosamente del programa.");
                        break;
                    default:
                        System.out.println(errorOpcion);
                        break;
                }
            }
        }catch (InputMismatchException e){
            System.out.println(errorOpcion);
        }
    }
}