package acciones;

import modelos.Convercion;
import modelos.Conversiones;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerandoConversion {
    static Scanner lectura = new Scanner(System.in);
    static String baseCambio, cambio, fecha, mensaje;
    static double valor;
    static ConvirtiendoConexion conexion = new ConvirtiendoConexion();
    //static ListaConversiones listaConversiones = new ListaConversiones();

    public static void opcionElegidaConversion(String baseCambio, String cambio, ListaConversiones listaConversiones) {
        try {
            System.out.print("Ingrese el valor en formato [XXXX.XXXX]: ");
            valor = lectura.nextDouble();

            Convercion consulta = conexion.convirtiendoValor(baseCambio, cambio, valor);
            fecha = generandoFechas();

            mensaje = "\nEl valor " + valor + " [" + baseCambio + "] equivale al valor de =>> " + consulta.conversion_result() + " [" + cambio + "]";
            System.out.println(mensaje);

            Conversiones conversion = new Conversiones(consulta.result(), baseCambio, cambio, valor, consulta.conversion_result(), fecha);
            listaConversiones.agregarConversion(conversion);

        } catch (InputMismatchException e) {
            System.out.println("Error: Número mal escrito " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        limpioVariables();

    }
    static void limpioVariables(){
        baseCambio = "";
        cambio = "";
        valor = 0;
    }

    static String generandoFechas(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = ahora.format(formato);

        return fechaFormateada;
    }
}
