package controller;
import java.util.Scanner;

import model;

public class Controller {
    private Team[] teams;
    private int teamCount;
    private Referee[] referees;
    

    public Controller() {
        teams = new Team[8]; 
        teamCount=0;
        referees = new Referee[3]; // Precargar 1 central y 2 asistentes

        // Precargar el equipo de Colombia
        preloadColombiaTeam();

        // Precargar árbitros
        referees[0] = new Referee("Mario Ruiz", "Colombia", "005", "Central");
        referees[1] = new Referee("Ana Torres", "México", "006", "Asistente");
        referees[2] = new Referee("Luis Fernández", "Argentina", "007", "Asistente");
    }

    private void preloadColombiaTeam() {
        // Director técnico
        Coach coachColombia = new Coach("Néstor Lorenzo", "Colombia", "001");

        // Crear el equipo
        Team colombiaTeam = new Team("Colombia", "Colombia", coachColombia);

        // Precargar jugadores con números reales de camiseta
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

        // Agregar el equipo a la lista de equipos
        teams[teamCount++] = colombiaTeam;
    }
    }

    public void addTeam(Team team) {
        if (teamCount < 8) {
            teams[teamCount++] = team; // Añade el equipo
        } else {
            System.out.println("Cannot add more teams. Maximum limit reached.");
        }
    }

    public void showTeams() {
        for (Team team : teams) {
            team.showTeamInfo();
        }
    }

    public void showReferees() {
        for (Referee referee : referees) {
            System.out.println(referee);
        }


        public void loadInitialData() {
            // Pre-carga de datos
            Coach coach1 = new Coach("Carlos Fernández", "Argentina");
            Team team1 = new Team("Los Tigres", "Argentina", coach1);
            
            Coach coach2 = new Coach("Juan Pérez", "Colombia");
            Team team2 = new Team("Los Guerreros", "Colombia", coach2);
    
            addTeam(team1);
            addTeam(team2);
        }
    
        public void inputTeamData() {
            Scanner scanner = new Scanner(System.in);
    
            // Ingresar datos del equipo
            System.out.print("Enter team name: ");
            String teamName = scanner.nextLine();
    
            System.out.print("Enter team country: ");
            String teamCountry = scanner.nextLine();
    
            // Ingresar datos del entrenador
            System.out.print("Enter coach name: ");
            String coachName = scanner.nextLine();
    
            System.out.print("Enter coach country: ");
            String coachCountry = scanner.nextLine();
    
            // Crear el entrenador y el equipo
            Coach newCoach = new Coach(coachName, coachCountry);
            Team newTeam = new Team(teamName, teamCountry, newCoach);
    
            addTeam(newTeam); // Añadir el nuevo equipo al controlador
        }
    
        public void showAllTeams() {
            for (int i = 0; i < teamCount; i++) {
                teams[i].showTeamInfo(); // Muestra la información de cada equipo
            }
        }
    }
}
