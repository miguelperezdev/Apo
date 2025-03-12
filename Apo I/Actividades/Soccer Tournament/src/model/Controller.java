package model;

import java.util.Scanner;

import model.Person;
import model.Player;
import model.Position;
import model.Referee;
import model.Registrable;
import model.Team;
import model.TypeR;

public class Controller {
    private Team[] teams;
    private int teamCount;
    private Referee[] referees;
    private int refereeCount;

    public Controller() {
        teams = new Team[8]; 
        teamCount = 0;
        referees = new Referee[3]; 
        refereeCount = 0;
        preloadTeam();
    }

    // Precarga de equipos
    private void preloadTeam() {
        // Precarga del equipo de Colombia
        Team colombiaTeam = new Team("Colombia", "Colombia", "Néstor Lorenzo", "Colombia");
        colombiaTeam.addPlayer(new Player("David Ospina", "Colombia", "1", Position.GOALKEEPER));
        colombiaTeam.addPlayer(new Player("Juan Cuadrado", "Colombia", "11", Position.DEFENDER));
        colombiaTeam.addPlayer(new Player("Davinson Sánchez", "Colombia", "3", Position.DEFENDER));
        colombiaTeam.addPlayer(new Player("Yerry Mina", "Colombia", "13", Position.DEFENDER));
        colombiaTeam.addPlayer(new Player("William Tesillo", "Colombia", "2", Position.DEFENDER));
        colombiaTeam.addPlayer(new Player("Wilmar Barrios", "Colombia", "5", Position.MIDFIELDER));
        colombiaTeam.addPlayer(new Player("Mateus Uribe", "Colombia", "8", Position.MIDFIELDER));
        colombiaTeam.addPlayer(new Player("James Rodríguez", "Colombia", "10", Position.MIDFIELDER));
        colombiaTeam.addPlayer(new Player("Juan Guillermo Cuadrado", "Colombia", "7", Position.MIDFIELDER));
        colombiaTeam.addPlayer(new Player("Luis Díaz", "Colombia", "14", Position.FORWARD));
        colombiaTeam.addPlayer(new Player("Radamel Falcao", "Colombia", "9", Position.FORWARD));
        colombiaTeam.addPlayer(new Player("Duván Zapata", "Colombia", "20", Position.FORWARD));
        colombiaTeam.addPlayer(new Player("Luis Sinisterra", "Colombia", "18", Position.FORWARD));
        colombiaTeam.addPlayer(new Player("Steven Mendoza", "Colombia", "15", Position.FORWARD));
        colombiaTeam.addPlayer(new Player("Carlos Bacca", "Colombia", "19", Position.FORWARD));
        colombiaTeam.addPlayer(new Player("Edwin Cardona", "Colombia", "16", Position.MIDFIELDER));
        colombiaTeam.addPlayer(new Player("Gustavo Cuéllar", "Colombia", "17", Position.MIDFIELDER));
        colombiaTeam.addPlayer(new Player("Deiver Machado", "Colombia", "22", Position.DEFENDER));
        colombiaTeam.addPlayer(new Player("Cristian Medina", "Colombia", "23", Position.MIDFIELDER));
        colombiaTeam.addPlayer(new Player("Jhon Córdoba", "Colombia", "21", Position.FORWARD));
        teams[teamCount++] = colombiaTeam;

        // Precarga del equipo de Brasil
        Team brazilTeam = new Team("Brazil", "Brazil", "Tite", "Brazil");
        brazilTeam.addPlayer(new Player("Alisson Becker", "Brazil", "1", Position.GOALKEEPER));
        brazilTeam.addPlayer(new Player("Danilo", "Brazil", "2", Position.DEFENDER));
        brazilTeam.addPlayer(new Player("Thiago Silva", "Brazil", "3", Position.DEFENDER));
        brazilTeam.addPlayer(new Player("Marquinhos", "Brazil", "4", Position.DEFENDER));
        brazilTeam.addPlayer(new Player("Alex Sandro", "Brazil", "6", Position.DEFENDER));
        brazilTeam.addPlayer(new Player("Casemiro", "Brazil", "5", Position.MIDFIELDER));
        brazilTeam.addPlayer(new Player("Fred", "Brazil", "8", Position.MIDFIELDER));
        brazilTeam.addPlayer(new Player("Lucas Paquetá", "Brazil", "11", Position.MIDFIELDER));
        brazilTeam.addPlayer(new Player("Neymar Jr.", "Brazil", "10", Position.FORWARD));
        brazilTeam.addPlayer(new Player("Vinícius Júnior", "Brazil", "20", Position.FORWARD));
        brazilTeam.addPlayer(new Player("Gabriel Jesus", "Brazil", "9", Position.FORWARD));
        brazilTeam.addPlayer(new Player("Richarlison", "Brazil", "7", Position.FORWARD));
        brazilTeam.addPlayer(new Player("Rodrygo", "Brazil", "21", Position.FORWARD));
        brazilTeam.addPlayer(new Player("Everton Ribeiro", "Brazil", "17", Position.MIDFIELDER));
        brazilTeam.addPlayer(new Player("Bruno Guimarães", "Brazil", "22", Position.MIDFIELDER));
        brazilTeam.addPlayer(new Player("Antony", "Brazil", "19", Position.FORWARD));
        brazilTeam.addPlayer(new Player("Gabriel Martinelli", "Brazil", "25", Position.FORWARD));
        brazilTeam.addPlayer(new Player("Eder Militão", "Brazil", "23", Position.DEFENDER));
        brazilTeam.addPlayer(new Player("Weverton", "Brazil", "12", Position.GOALKEEPER));
        brazilTeam.addPlayer(new Player("Ederson", "Brazil", "13", Position.GOALKEEPER));
        teams[teamCount++] = brazilTeam;

        // Precarga del equipo de Costa Rica
        Team costaRicaTeam = new Team("Costa Rica", "Costa Rica", "Luis Fernando Suárez", "Costa Rica");
        costaRicaTeam.addPlayer(new Player("Keylor Navas", "Costa Rica", "1", Position.GOALKEEPER));
        costaRicaTeam.addPlayer(new Player("Juan Pablo Vargas", "Costa Rica", "2", Position.DEFENDER));
        costaRicaTeam.addPlayer(new Player("Francisco Calvo", "Costa Rica", "3", Position.DEFENDER));
        costaRicaTeam.addPlayer(new Player("Oscar Duarte", "Costa Rica", "4", Position.DEFENDER));
        costaRicaTeam.addPlayer(new Player("Cristian Gamboa", "Costa Rica", "5", Position.DEFENDER));
        costaRicaTeam.addPlayer(new Player("Celso Borges", "Costa Rica", "6", Position.MIDFIELDER));
        costaRicaTeam.addPlayer(new Player("Gerson Torres", "Costa Rica", "7", Position.MIDFIELDER));
        costaRicaTeam.addPlayer(new Player("Yeltsin Tejeda", "Costa Rica", "8", Position.MIDFIELDER));
        costaRicaTeam.addPlayer(new Player("Bryan Ruiz", "Costa Rica", "10", Position.MIDFIELDER));
        costaRicaTeam.addPlayer(new Player("Jonathan Moya", "Costa Rica", "9", Position.FORWARD));
        costaRicaTeam.addPlayer(new Player("Joel Campbell", "Costa Rica", "11", Position.FORWARD));
        costaRicaTeam.addPlayer(new Player("Anthony Contreras", "Costa Rica", "20", Position.FORWARD));
        costaRicaTeam.addPlayer(new Player("Manfred Ugalde", "Costa Rica", "21", Position.FORWARD));
        costaRicaTeam.addPlayer(new Player("David Guzmán", "Costa Rica", "16", Position.MIDFIELDER));
        costaRicaTeam.addPlayer(new Player("Júnior Díaz", "Costa Rica", "19", Position.DEFENDER));
        costaRicaTeam.addPlayer(new Player("Carlos Martínez", "Costa Rica", "22", Position.DEFENDER));
        costaRicaTeam.addPlayer(new Player("Esteban Alvarado", "Costa Rica", "12", Position.GOALKEEPER));
        costaRicaTeam.addPlayer(new Player("Aaron Suárez", "Costa Rica", "14", Position.MIDFIELDER));
        costaRicaTeam.addPlayer(new Player("Dylan Flores", "Costa Rica", "15", Position.MIDFIELDER));
        costaRicaTeam.addPlayer(new Player("Luis Díaz", "Costa Rica", "17", Position.FORWARD));
        teams[teamCount++] = costaRicaTeam;

        // Precarga del equipo de Paraguay
        Team paraguayTeam = new Team("Paraguay", "Paraguay", "Eduardo Berizzo", "Paraguay");
        paraguayTeam.addPlayer(new Player("Antony Silva", "Paraguay", "1", Position.GOALKEEPER));
        paraguayTeam.addPlayer(new Player("Gustavo Gómez", "Paraguay", "2", Position.DEFENDER));
        paraguayTeam.addPlayer(new Player("Paulo Da Silva", "Paraguay", "3", Position.DEFENDER));
        paraguayTeam.addPlayer(new Player("Fabián Balbuena", "Paraguay", "4", Position.DEFENDER));
        paraguayTeam.addPlayer(new Player("Mathías Villasanti", "Paraguay", "5", Position.DEFENDER));
        paraguayTeam.addPlayer(new Player("Miguel Almirón", "Paraguay", "8", Position.MIDFIELDER));
        paraguayTeam.addPlayer(new Player("Óscar Romero", "Paraguay", "10", Position.MIDFIELDER));
        paraguayTeam.addPlayer(new Player("Adrián Cubas", "Paraguay", "7", Position.MIDFIELDER));
        paraguayTeam.addPlayer(new Player("Derlis González", "Paraguay", "11", Position.FORWARD));
        paraguayTeam.addPlayer(new Player("Matías Rojas", "Paraguay", "9", Position.FORWARD));
        paraguayTeam.addPlayer(new Player("Angel Romero", "Paraguay", "16", Position.FORWARD));
        paraguayTeam.addPlayer(new Player("Valentín Barco", "Paraguay", "15", Position.DEFENDER));
        paraguayTeam.addPlayer(new Player("Sergio Díaz", "Paraguay", "17", Position.FORWARD));
        paraguayTeam.addPlayer(new Player("Nicolás Domingo", "Paraguay", "14", Position.MIDFIELDER));
        paraguayTeam.addPlayer(new Player("Gonzalo Plata", "Paraguay", "13", Position.FORWARD));
        paraguayTeam.addPlayer(new Player("Luis Ojeda", "Paraguay", "12", Position.GOALKEEPER));
        teams[teamCount++] = paraguayTeam;
    }



    // Método para agregar un nuevo equipo
    public void addTeam(String teamName, String country, String coachName, String coachCountry) {
        if (teamCount < 8) {
            Team newTeam = new Team(teamName, country, coachName, coachCountry);
            teams[teamCount++] = newTeam;
            System.out.println("Team added: " + teamName);
        } else {
            System.out.println("Cannot add more teams. Maximum limit reached.");
        }
    }

    // Mostrar todos los equipos
    public void showAllTeams() {
        for (int i = 0; i < teamCount; i++) {
            teams[i].showTeamInfo();
        }
    }

    // Agregar un árbitro
    public void addReferee(String name, String country, String id, TypeR typeR) { // Modificado para usar TypeR
        if (refereeCount < 3) {
            referees[refereeCount++] = new Referee(name, country, id, typeR);
            System.out.println("Referee added: " + name);
        } else {
            System.out.println("Cannot add more referees. Maximum limit reached.");
        }
    }

    // Mostrar los árbitros
    public void showReferees() {
        for (int i = 0; i < refereeCount; i++) {
            System.out.println(referees[i]);
        }
    }

    // Precargar otros equipos
    public void loadInitialData() {
        addTeam("Los Tigres", "Argentina", "Carlos Fernández", "Argentina");
        addTeam("Los Guerreros", "Colombia", "Juan Pérez", "Colombia");
    }

    // Registrar un nuevo equipo a través de la entrada del usuario
    public void inputTeamData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();

        System.out.print("Enter team country: ");
        String teamCountry = scanner.nextLine();

        System.out.print("Enter coach name: ");
        String coachName = scanner.nextLine();

        System.out.print("Enter coach country: ");
        String coachCountry = scanner.nextLine();

        addTeam(teamName, teamCountry, coachName, coachCountry); 
        System.out.println("Team registered successfully.");
    }
}
