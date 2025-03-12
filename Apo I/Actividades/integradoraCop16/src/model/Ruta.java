package model;

public class Ruta {

    //Atributos
    private String nombreRuta;
    private String puntoEncuentro;
    private String horaInicio;
    private String minutoInicio;
    private String horaFinal;
    private String minutoFinal;

    //Metodos
    /**
     * @param nombreRuta Nombre de la ruta.
     * @param puntoEncuentro Punto de encuentro de la ruta.
     * @param horaInicio Hora de inicio de la ruta (horas).
     * @param minutoInicio Minuto de inicio de la ruta.
     * @param horaFinal Hora de finalización de la ruta (horas).
     * @param minutoFinal Minuto de finalización de la ruta.
     */
    public Ruta(String nombreRuta, String puntoEncuentro, String horaInicio, String minutoInicio, String horaFinal, String minutoFinal){
    this.nombreRuta = nombreRuta;
    this.puntoEncuentro = puntoEncuentro;
    this.horaInicio = horaInicio;
    this.minutoInicio = minutoInicio;
    this.horaFinal = horaFinal;
    this.minutoFinal = minutoFinal;
    }

    /**
     * @return El nombre de la ruta.
     */
    public String getNombreRuta(){
        return nombreRuta;
    }
    /**
     * @return Un mensaje que contiene la información sobre la ruta elegida.
     */
    public String toString(){
        String mensaje = "";
        
        mensaje = "¡Excelente! La ruta de " + nombreRuta + " tiene como punto de encuentro " + puntoEncuentro + " iniciando a las " + horaInicio + ":" + minutoInicio + " finaliza a las " + horaFinal + ":" + minutoFinal + "."; 

        return mensaje;
    }
}
