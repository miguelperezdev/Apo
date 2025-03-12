package model;

public class Especie {
    
    //Atributos
    private String nombreEspecie;
    private String imagenEspecie;
    private int cantidadEjemplares;
    private int numEspecie;

    //Relaciones
    private EnumEspecie enumEspecie;
    public Especie[] especies;
    
    //Constantes
    public final static int MAXIMOESPECIES = 50;//cantidad maxima de especies ha registrar.
    
    //Metodos
    /**
     * @param nombreEspecie Nombre de la especie.
     * @param imagenEspecie Ruta de la imagen relacionada con la especie.
     * @param cantidadEjemplares Cantidad de ejemplares de la especie.
     * @param numEspecie Número que representa el tipo de especie (1. Flora, 2. Fauna).
     */
    public Especie(String nombreEspecie, String imagenEspecie, int cantidadEjemplares, int numEspecie){
        
        especies = new Especie[MAXIMOESPECIES];//inicializar arreglo

        this.nombreEspecie = nombreEspecie;
        this.imagenEspecie = imagenEspecie;
        this.cantidadEjemplares = cantidadEjemplares;

        switch(numEspecie){//asignar el tipo especie
            case 1:
            enumEspecie = EnumEspecie.FLORA;
            break;

            case 2: 
            enumEspecie = EnumEspecie.FAUNA;
            break;
        }
    }
     /**
     * @param nombreEspecie Nombre de la especie.
     */
    public void setNombreEspecie(String nombreEspecie){
        this.nombreEspecie = nombreEspecie;
    }

     /**
     * @param numEspecie Número del tipo de especie.
     */
    public void setNumEspecie(int numEspecie){
        this.numEspecie = numEspecie;
    }

     /**
     * @param imagenEspecie Ruta de la imagen a establecer.
     */
    public void setImagenEspecie(String imagenEspecie){
        this.imagenEspecie = imagenEspecie;
    }

     /**
     * @param cantidadEjemplares Cantidad de ejemplares a esteblecer.
     */
    public void setCantidadEjemplares(int cantidadEjemplares){
        this.cantidadEjemplares = cantidadEjemplares;
    }

     /**
     * @return nombre de la especie.
     */
    public String getNombreEspecie() {
        return nombreEspecie;
    }
}
