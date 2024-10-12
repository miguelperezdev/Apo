package model;

public class Representante {

    //Atributos
    private String nombreRepresentante;
    private String celularRepresentante;

    //Metodos
    /**
     * @param nombreRepresentante Nombre del representante de la comunidad.
     * @param celularRepresentante Número de celular del representante de la comunidad.
     */
    public Representante(String nombreRepresentante, String celularRepresentante){
        this.nombreRepresentante = nombreRepresentante;
        this.celularRepresentante = celularRepresentante;
    }
}
