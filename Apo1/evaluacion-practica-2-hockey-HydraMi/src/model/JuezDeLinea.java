package model;

public class JuezDeLinea extends Arbitro {
    public JuezDeLinea(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String desplazarse() {
        return super.desplazarse() + " sobre la linea.";
    }

    @Override
    public String presentarse() {
        return super.presentarse() + "De linea.";
    } 
}