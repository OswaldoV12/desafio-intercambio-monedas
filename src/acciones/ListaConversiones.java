package acciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Conversiones;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaConversiones {
    private List<Conversiones> historialConversiones;

    public ListaConversiones() {
        historialConversiones = new ArrayList<>();
    }

    public void agregarConversion(Conversiones conversion){
        this.historialConversiones.add(conversion);
    }

    public void mostrarLista(){
        for (Conversiones conversion: historialConversiones){
            System.out.println(
                    "Status: "+conversion.getEstado()+"\n" +
                    "Moneda Base ["+conversion.getCambioBase()+"]\n"+
                    "Moneda Conversión ["+conversion.getCambioDeaseado()+"]\n" +
                            "Valor Inicial: "+conversion.getValorPrevio()+"\n"+
                            "Resultado: "+conversion.getValor()+" ["+conversion.getCambioDeaseado()+"]\n" +
                            "Fecha: "+conversion.getFecha()+"\n"+
                    "##########\n");
        }
    }

    public void generarJson(String ruta){
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // JSON bonito
        String json = gson.toJson(historialConversiones);

        try (FileWriter writer = new FileWriter(ruta)) {
            writer.write(json);
            System.out.println("Historial guardado como JSON bonito.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo JSON: " + e.getMessage());
        }
    }
}
