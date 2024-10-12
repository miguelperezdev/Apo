package model;

public class Voluntario {
    //Atributos
    private String nombre;
    private String id;

    //Metodos
     /**
     * @param nombre Nombre del voluntario.
     * @param id Identificación del voluntario.
     */
    public Voluntario(String nombre, String id){
        this.nombre = nombre;
        this.id = id;

    }
    /**
     * @return mensaje de bienvenida 
     */
    public String toString(){
        String mensaje = "¡Bienvenido, " + nombre + "!";
        return mensaje;
    }
}
