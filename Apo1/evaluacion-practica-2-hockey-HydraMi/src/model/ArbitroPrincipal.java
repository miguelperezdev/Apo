package model;

public class ArbitroPrincipal extends Arbitro {
    public ArbitroPrincipal(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String desplazarse() {
        return super.desplazarse() + " sobre la pista.";
    }

    @Override
    public String presentarse() {
        return super.presentarse() + "Principal.";
    } 
}