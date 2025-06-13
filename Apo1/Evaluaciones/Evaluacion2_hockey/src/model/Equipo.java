package model;



public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;
    protected String nombreEquipo;
    private JugadorHockey[] jugadores;

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.jugadores = new JugadorHockey[CANTIDAD_JUGADORES];
    }

    public void agregarJugador(JugadorHockey jugador, int numero) {
        if (jugadores[numero-1]==null) {
            jugadores[numero-1] = jugador;
        }
    }

    public String getNombre() {
        return nombreEquipo;
    }

    public JugadorHockey[] getJugadores() {
        return jugadores;
    }

    public void crearJugador(String nombre, int edad, int opPosicion, int numero) {
        JugadorHockey jugador = new JugadorHockey(nombre, edad, opPosicion);

        agregarJugador(jugador, numero);
    }

}