import acciones.ListaConversiones;

import java.util.InputMismatchException;
import java.util.Scanner;

import static acciones.GenerandoConversion.opcionElegidaConversion;

public class Principal {
    static Scanner lectura = new Scanner(System.in);
    static String baseCambio, cambio;
    static ListaConversiones listaConversiones = new ListaConversiones();
    public static void main(String[] args) {
        int opc = 0;
        do{
            opc = menuDeOpcion();
            switch (opc){
                case 1:
                    baseCambio = "USD";
                    cambio = "MXN";
                    opcionElegidaConversion(baseCambio, cambio, listaConversiones);
                    break;
                case 2:
                    baseCambio = "MXN";
                    cambio = "USD";
                    opcionElegidaConversion(baseCambio, cambio, listaConversiones);
                    break;
                case 3:
                    baseCambio = "USD";
                    cambio = "ARS";
                    opcionElegidaConversion(baseCambio, cambio, listaConversiones);
                    break;
                case 4:
                    baseCambio = "ARS";
                    cambio = "USD";
                    opcionElegidaConversion(baseCambio, cambio, listaConversiones);
                    break;
                case 5:
                    baseCambio = "USD";
                    cambio = "BRL";
                    opcionElegidaConversion(baseCambio, cambio, listaConversiones);
                    break;
                case 6:
                    baseCambio = "BRL";
                    cambio = "USD";
                    opcionElegidaConversion(baseCambio, cambio, listaConversiones);
                    break;
                case 7:
                    System.out.println("Historial De Conversiones\n");
                    listaConversiones.mostrarLista();
                    break;
                case 8:
                    listaConversiones.generarJson("historialConversiones.JSON");

                    break;
                case 9:
                    System.out.println("**************************************************************");
                    System.out.println("Proyecto desarrollado por: Jose Oswaldo Valencia [OswaV12]\n" +
                            "Como parte del programa ONE G8\n" +
                            "Con Fecha de 18/07/2025\n\n");

                    System.out.println("REQUERIMIENTOS\n" +
                            "Se necesita API KEY de ExchangeRate-API para su correcto funcionamiento\n" +
                            "La cual se coloca en el archivo acciones/ConvirtiendoConexion en la\n" +
                            "variable apikey.");
                    System.out.println("**************************************************************");
                    break;
                case 11:
                    System.out.println("Intentelo de Nuevo");
                    break;
            }
        }while(opc != 10);
    } // FIN


    static int menuDeOpcion(){
        try{
            int opcion;
            System.out.println("----------------------------------");
            System.out.println("Bienvenidos a mi proyecto de conversor de monedas\n");
            System.out.println("1) Dolar =>> Peso Mexicano");
            System.out.println("2) Peso Mexicano =>> Dolar");
            System.out.println("3) Dolar =>> Peso Argentino");
            System.out.println("4) Peso Argentino =>> Dolar");
            System.out.println("5) Dolar =>> Real Brasileno");
            System.out.println("6) Real Brasileno =>> Dolar");
            System.out.println("7) Historial De Conversiones");
            System.out.println("8) Generar Archivo Con Reegistro");
            System.out.println("9) Acerca de...");
            System.out.println("10) Salir");
            System.out.println("----------------------------------");
            System.out.print("Ingrese la opción deseada: ");
            return opcion = lectura.nextInt();

        }catch (InputMismatchException e){
            System.out.println("Caracter no valido: "+e.getCause());
        }
        return 10;
    }
}
