package model;

public class Team {
    private String name;
    private String country;
    private Player[] players;
    private int playerCount;
    private Coach coach;

    public Team(String name, String country, Coach coach) {
        this.name = name;
        this.country = country;
        this.players = new Player[20];
        this.playerCount = 0;
        this.coach = coach;
    }

    public void addPlayer(Player player) {
        if (playerCount < 20) {
            players[playerCount++] = player;
        } else {
            System.out.println("Team is full.");
        }
    }

    public void showTeamInfo() {
        System.out.println("Team [Name=" + name + ", Country=" + country + "]");
        System.out.println("Coach: " + coach);
        System.out.println("Players: ");
        for (int i = 0; i < playerCount; i++) {
            System.out.println(players[i]);
        }
    }
}
