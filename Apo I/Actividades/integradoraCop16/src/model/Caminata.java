package model;

public class Caminata {
    //Atributos
    private int cantidadParticipantes;
    private int cantidadGuias;
    private double temperatura;
    private double humedadRelativa;

    //Constantes
    public final static int CAPACIDADBUSES = 25;
    
    //Metodos    
    /**
     * @param cantidadParticipantes Cantidad de participantes que asistirn a la caminata.
     * @param cantidadGuias Cantidad de guías que asistiran a la caminata.
     * @param temperatura Temperatura ambiente.
     * @param humedadRelativa Humedad relativa.
     */
    public Caminata(int cantidadParticipantes, int cantidadGuias, double temperatura, double humedadRelativa){
        this.cantidadParticipantes = cantidadParticipantes;
        this.cantidadGuias = cantidadGuias;
        this.temperatura = temperatura;
        this.humedadRelativa = humedadRelativa;
    }

    /**
     * @return El número de buses necesarios para la caminata.
     */
    public int calcularBuses(){
        int numeroBuses = 0;
        int total = cantidadParticipantes + cantidadGuias;
        numeroBuses = (int) Math.ceil((double) total / CAPACIDADBUSES);

        return numeroBuses;
    }

    /**
     * @return Un mensaje de los buses requeridos.
     */
    public String toStringBus(){
        int total = cantidadParticipantes + cantidadGuias;
        String mensaje = "\nAl ser un total de " + total + " personas que harán parte de la actividad, se necesitarán un total de: " + calcularBuses() + " buses para llevarla a cabo de manera exitosa. ¡Nos vemos en la COP16!";
    return mensaje;
    }

    /**
     * @return boolean = true si las condiciones climáticas son adecuadas, `false` en caso de que no sean adecuadas.
     */
    public boolean verificarClima(){

        boolean booleanoTemp;
        boolean booleanoHumedad;

        boolean booleanofinal;

        if((temperatura>=20)&&(temperatura<=25)){
            booleanoTemp = true;
        }else{
            booleanoTemp = false;
        }

        if((humedadRelativa>=40)&&(humedadRelativa<=60)){
            booleanoHumedad = true;
        }else{
            booleanoHumedad = false;
        }

        if((booleanoTemp == true)&&(booleanoHumedad == true)){
            booleanofinal = true;
        }else{
            booleanofinal = false;
        }
        return booleanofinal;
    }

    /**
     * @return Un mensaje meteorológico.
     */
    public String toString(){
        String mensaje = "";
        if(verificarClima() == true){
            mensaje = "¡Hace un buen dia para caminar por Cali!";
        }else{
            mensaje = "No hace un buen dia para caminar por Cali.";
        }
        return mensaje;
    }
}
