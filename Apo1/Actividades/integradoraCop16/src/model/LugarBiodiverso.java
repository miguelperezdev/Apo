package model;

public class LugarBiodiverso {
    
    //Atributos
    private String nombreLugar;
    private double areaLugar;
    private String imagenLugar;
    private int aperturaAño;
    private int aperturaMes;
    private int aperturaDia;
    private double recursosEconomicos;
    private int numDepartamento;
    private int contadorEspecies = 0;
    
    //Relaciones con enumeración 
    public Comunidad escogerComunidad;
    private EnumDepartamento departamento;
    public Comunidad[] comunidades;
    public Especie[] especies;

    //Constantes
    public final static int MAXESPECIES = 50;

    //Metodos
    /**
     * @param nombreLugar Nombre del lugar biodiverso.
     * @param areaLugar Área del lugar en kilómetros cuadrados.
     * @param imagenLugar Ruta de la imagen del lugar.
     * @param aperturaAño Año de apertura del lugar.
     * @param aperturaMes Mes de apertura del lugar.
     * @param aperturaDia Día de apertura del lugar.
     * @param recursosEconomicos Recursos económicos necesarios para mantener el lugar.
     * @param numDepartamento Número que representa el departamento en el que se encuentra el lugar (1. Chocó, 2. Valle, 3. Cauca, 4. Nariño).
     * @param escogerComunidad Comunidad a la que pertenece el lugar biodiverso.
     */
    public LugarBiodiverso(String nombreLugar, double areaLugar, String imagenLugar, int aperturaAño, int aperturaMes, int aperturaDia, double recursosEconomicos, int numDepartamento, Comunidad escogerComunidad){ 
        this.nombreLugar = nombreLugar;
        this.areaLugar = areaLugar;
        this.imagenLugar = imagenLugar;
        this.aperturaAño = aperturaAño;
        this.aperturaMes = aperturaMes;
        this.aperturaDia = aperturaDia;
        this.recursosEconomicos = recursosEconomicos;
        this.numDepartamento = numDepartamento;
        this.escogerComunidad = escogerComunidad;
        
        this.especies = new Especie[MAXESPECIES];//Lista de especies

        switch(numDepartamento){

            case 1:
            departamento = EnumDepartamento.CHOCO;
            break;

            case 2:
            departamento = EnumDepartamento.VALLE;
            break;

            case 3:
            departamento = EnumDepartamento.CAUCA;
            break;

            case 4:
            departamento = EnumDepartamento.NARIÑO;
            break;


        }
    
    }

     /**
     * @return El arreglo de especies del lugar biodiverso.
     */
    public Especie[] getEspecies() {
        return especies;
    }

    /**
     * @param newEspecie La nueva especie a agregar al lugar.
     * @return boolean, "true" si la especie se agrego con exito o "false" si no se pudo agregar.
     */
    public boolean agregarEspecie(Especie newEspecie){

        for(int i=0; i<MAXESPECIES; i++){
           if(especies[i]!=null){
            especies[i] = newEspecie;
            contadorEspecies++;
            return true;//especie agregada correctamente
            }
        }
        return false;//no se pudo agregar la especie
    }
    
    /**
     * @return El área del lugar(km2).
     */
    public double getAreaLugar(){
        return areaLugar;
    }

    /**
     * @return El nombre del lugar biodiverso.
     */
    public String getNombreLugar(){
        return nombreLugar;
    }

    /**
     * @return La enumeración del departamento.
     */
    public EnumDepartamento getDepartamento(){
        return departamento;
    }

    /**
    * @return contadorEspecies Número de especies registradas.
    */    
    public int getContadorEspecies(){
        return contadorEspecies;
    }

    /**
    * @return contadorEspecies Número de especies registradas.
    */
    public boolean anadirEspecie(String nombreEspecie, String imagenEspecie, int cantidadEjemplares, int numEspecie){

        boolean valorFinal;

        if(contadorEspecies<MAXESPECIES){
            especies[contadorEspecies] = new Especie(nombreEspecie, imagenEspecie, cantidadEjemplares, numEspecie);
            contadorEspecies ++;
            valorFinal = true;//se agrego la especie
        }else{
            valorFinal = false;//supera la capacidad de especies entonces no se puede agregar
        }
        return valorFinal;
    }

    /**
    * @return mensaje Un mensaje que contiene la lista de especies registradas en el lugar o un mensaje indicando que no hay especies.
    */
    public String mostrarEspecies(){
        String mensaje = "";
        int contador = 0;
        for(int i = 0; i<especies.length; i++){
            if(especies[i] != null){
                mensaje += "\n" + (i+1) + ". " + especies[i].getNombreEspecie();
                contador = 1;
            }
        }
        if(contador == 0){
            mensaje = "No existen especies registradas en el lugar.";
        }

        return mensaje;
    }

    /**
     * @param seleccionEspecie   El número de la especie que se desea modificar (índice en el arreglo `especies`).
     * @param numEspecie         El número que representa el tipo de especie (1 para Fauna, 2 para Flora).
     * @param imagenEspecie      La URL o nombre del archivo de imagen que representa a la especie.
     * @param cantidadEjemplares La nueva cantidad de ejemplares de la especie.
     * @param atributoEspecie    El atributo que se desea modificar (1. Tipo de especie, 2. Imagen de la especie, 3. Cantidad de ejemplares).
     * @return mensaje Un mensaje indicando el resultado de la modificación, ya sea exitoso o indicando si hubo algún problema.
     */
    public String modificarEspecies(int seleccionEspecie, int numEspecie, String imagenEspecie, int cantidadEjemplares, int atributoEspecie){
        String mensaje = "";
        switch (atributoEspecie) {
            case 1:
                especies[seleccionEspecie-1].setNumEspecie(numEspecie);
                mensaje = "Tipo de especie modificado correctamente.";
                break;

            case 2:
                especies[seleccionEspecie-1].setImagenEspecie(imagenEspecie);
                mensaje = "Foto de especie modificada correctamente";
                break;

            case 3:
                especies[seleccionEspecie-1].setCantidadEjemplares(cantidadEjemplares);
                mensaje = "Numero de ejemplares modificado correctamente";
                break;
        }

        return mensaje;
    }

}

