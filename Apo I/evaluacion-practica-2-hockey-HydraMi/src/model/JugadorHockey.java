package model;



public class JugadorHockey extends Persona implements IDesplazarseEnPistaConPalo, IPasarDisco {
    protected String nombre;
    protected int numero;
    protected Posicion posicion;

    public JugadorHockey(String nombre, int edad, int opPosicion) {
        super(nombre, edad);

        switch (opPosicion) {
            case 1:
                this.posicion = Posicion.PORTERO;
                break;
            case 2:
                this.posicion = Posicion.DEFENSA;
                break;
            case 3:
                this.posicion = Posicion.ALA;
                break;
            case 4:
                this.posicion = Posicion.CENTRO;
                break;
            default:
                break;
        }
        
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public String getNombrePosicion() {
        return posicion.toString();
    }

    @Override
    public String desplazarseConPalo() {
        if (posicion != Posicion.PORTERO) {
            return nombre + " se desplaza en la pista con el palo.";
        } else {
            return nombre + " es el portero y no se desplaza más allá de media pista.";
        }
    }

    @Override 
    public String pasar() {
        return " le pasa el disco a ";
    }

    public String hacerGol() {
        return getNombre() + " pasa el disco por la red. Gol!!";
    }
}