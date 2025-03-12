package model;

public class Team {
    private String name;
    private String country;
    private String coachName;   // Atributo para el nombre del entrenador
    private String coachCountry; // Atributo para el país del entrenador
    private Player[] players;
    private int playerCount;

    public Team(String name, String country, String coachName, String coachCountry) {
        this.name = name;
        this.country = country;
        this.coachName = coachName;
        this.coachCountry = coachCountry;
        this.players = new Player[20]; // Capacidad para 20 jugadores
        this.playerCount = 0;
    }

    // Método para añadir jugadores al equipo
    public void addPlayer(Player player) {
        if (playerCount < players.length) {
            players[playerCount++] = player;
        } else {
            System.out.println("No more players can be added, team is full.");
        }
    }

    // Método para mostrar la información del equipo
    public void showTeamInfo() {
        System.out.println("Team: " + name + " (" + country + ")");
        System.out.println("Coach: " + coachName + " from " + coachCountry);
        System.out.println("Players: ");
        for (int i = 0; i < playerCount; i++) {
            System.out.println(players[i]);
        }
    }
}
