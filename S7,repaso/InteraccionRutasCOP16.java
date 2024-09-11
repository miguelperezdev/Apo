import java.util.Scanner;

public class InteraccionRutasCOP16 {

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);

        System.out.println("\n# Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali - Colombia.\n ");
        System.out.println("# Digita tu nombre:");
        System.out.print("> ");
        String nombre = escaner.nextLine();

        solicitarCedula(escaner);
        seleccionarRuta(escaner, nombre);
        ingresarDatosMeteorologicos(escaner);

        escaner.close(); // Cerrar el scanner para liberar recursos
    }

    public static void solicitarCedula(Scanner escaner) {
        System.out.println("# Digita tu cédula (sin puntos ni comas): ");
        System.out.print("> ");

        // Validación simple de cédula como entero
        while (!escaner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número válido.");
            System.out.print("> ");
            escaner.next(); // Consumir la entrada inválida
        }
        int cedula = escaner.nextInt();
        System.out.println("# Cédula ingresada: " + cedula);
    }

    public static void seleccionarRuta(Scanner escaner, String nombre) {
        System.out.println("\n¡Bienvenido, " + nombre + "!");
        System.out.println("# Ahora dime ¿cuál de las 3 rutas deseas elegir?");
        System.out.println("# Coloca el número (1) para elegir la ruta de Ladera");
        System.out.println("# Coloca el número (2) para elegir la ruta de Oriente");
        System.out.println("# Coloca el número (3) para elegir la ruta de Farallones");
        System.out.print("> ");

        // Validar que la opción sea un número válido
        int opcion = 0;
        while (opcion < 1 || opcion > 3) {
            while (!escaner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                System.out.print("> ");
                escaner.next();
            }
            opcion = escaner.nextInt();
            if (opcion < 1 || opcion > 3) {
                System.out.println("Opción no válida. Por favor, selecciona entre 1 y 3.");
            }
        }

        mostrarInformacionRuta(opcion);
    }

    public static void mostrarInformacionRuta(int opcion) {
        String ruta, encuentro, inicio, fin;

        switch (opcion) {
            case 1:
                ruta = "Ladera";
                encuentro = "Bulevar del Río";
                inicio = "7:00";
                fin = "13:30";
                break;
            case 2:
                ruta = "Oriente";
                encuentro = "Bulevar del Río";
                inicio = "7:00";
                fin = "13:00";
                break;
            case 3:
                ruta = "Farallones";
                encuentro = "Calle 16 - Universidad del Valle";
                inicio = "6:40";
                fin = "14:30";
                break;
            default:
                ruta = "Desconocida";
                encuentro = "Desconocido";
                inicio = "Desconocido";
                fin = "Desconocido";
                break;
        }

        System.out.println("\n# Elegiste la ruta destino hacia: " + ruta);
        System.out.println("# Punto de encuentro: " + encuentro);
        System.out.println("# Hora de inicio de la actividad: " + inicio);
        System.out.println("# Hora de finalización de la actividad: " + fin);
    }

    public static void ingresarDatosMeteorologicos(Scanner escaner) {
        System.out.println("\n# Ahora ingresa los datos meteorológicos para decirte qué tal estará el día");
        System.out.println("# Digita la temperatura en grados centígrados °C (si es decimal usa , )");
        System.out.print("> ");
        
        while (!escaner.hasNextDouble()) {
            System.out.println("Por favor, ingresa un valor numérico válido.");
            System.out.print("> ");
            escaner.next();
        }
        double grados = escaner.nextDouble();

        System.out.println("# Digita el porcentaje relativo de humedad (si es decimal usa , )");
        System.out.print("> ");

        while (!escaner.hasNextDouble()) {
            System.out.println("Por favor, ingresa un valor numérico válido.");
            System.out.print("> ");
            escaner.next();
        }
        double humedad = escaner.nextDouble();

        if (grados >= 20 && grados <= 25 && humedad >= 40 && humedad <= 60) {
            System.out.println("\n# Hace un buen día para caminar por Cali!");
        } else {
            System.out.println("\n# No hace un buen día para caminar por Cali :(");
        }
    }
}
