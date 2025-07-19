package modelos;

public class Conversiones {
    private String estado;
    private String cambioBase;
    private String cambioDeaseado;
    private double valorPrevio;
    private double valor;
    private String fecha;

    public Conversiones(String estado, String cambioBase, String cambioDeaseado,double valorPrevio, double valor, String fecha) {
        this.estado = estado;
        this.cambioBase = cambioBase;
        this.cambioDeaseado = cambioDeaseado;
        this.valorPrevio = valorPrevio;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Conversiones(){

    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCambioBase() {
        return cambioBase;
    }

    public void setCambioBase(String cambioBase) {
        this.cambioBase = cambioBase;
    }

    public String getCambioDeaseado() {
        return cambioDeaseado;
    }

    public void setCambioDeaseado(String cambioDeaseado) {
        this.cambioDeaseado = cambioDeaseado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValorPrevio() {
        return valorPrevio;
    }

    public void setValorPrevio(double valorPrevio) {
        this.valorPrevio = valorPrevio;
    }
}
