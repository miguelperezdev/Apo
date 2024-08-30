import java.util.Scanner;

public class n1cop16 {
    public static void main(String[] args) {

        Scanner escaner = new Scanner(System.in);

        System.out.println("\n# Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali - Colombia.\n ");

        System.out.println("# Digita tu nombre:");
        System.out.print("> ");
        String nombre = escaner.nextLine();

        cedula(escaner, nombre);
    }

    public static void cedula(Scanner escaner, String nombre) {

        System.out.println("# Digita tu cedula: ");
        System.out.print("> ");
        int cedula = escaner.nextInt();

        rutas(escaner, nombre);
    }

    public static void rutas(Scanner escaner, String nombre) {

        System.out.print("¡Bienvenido, " + nombre + "!");

        System.out.println("\n# Ahora dime ¿cual de las 3 rutas deseas elegir?");

        System.out.println("# Coloca el numero (1) para elegir la ruta de Ladera");
        System.out.println("# Coloca el numero (2) para elegir la ruta de Oriente");
        System.out.println("# Coloca el numero (3) para elegir la ruta de Farallones");
        System.out.print("> ");
        int option = escaner.nextInt();

        String ruta = "# Elegiste la ruta destino hacia: ";
        String encuentro = "# Punto de encuentro: ";
        String inicio = "# Hora de inicio de la actividad: ";
        String finals = "# Hora de finalizacion de la actividad: ";

        switch (option) {
            case 1:
                System.out.println(ruta + "Ladera");
                System.out.println(encuentro + "Bulevar del Rio");
                System.out.println(inicio + "7:00");
                System.out.println(finals + "13:30");
                break;

            case 2:
                System.out.println(ruta + "Oriente");
                System.out.println(encuentro + "Bulevar del Rio");
                System.out.println(inicio + "7:00");
                System.out.println(finals + "13:00");
                break;

            case 3:
                System.out.println(ruta + "Farallones");
                System.out.println(encuentro + "Calle 16 - Universidad del Valle");
                System.out.println(inicio + "6:40");
                System.out.println(finals + "14:30");
                break;

            default:
                System.out.println("Opcion no valida");
                break;
        }

        metereo(escaner);
    }

    public static void metereo(Scanner escaner) {

        System.out.println("\n# Ahora ingresa los datos meteorologicos para decirte que tal estara el dia");
        System.out.println("\n# Digita la temperatura en grados centigrados °C");
        System.out.print("> ");
        double grados = escaner.nextDouble();

        System.out.println("\n# Digita el porcentaje relativo de humedad");
        System.out.print("> ");
        double humedad = escaner.nextDouble();

        if (grados >= 20 && grados <= 25 && humedad >= 40 && humedad <= 60) {
            System.out.println("\n# Hace un buen dia para caminar por Cali!");
        } else {
            System.out.println("\n# No hace un buen dia para caminar por Cali :(");
        }
    }
}

