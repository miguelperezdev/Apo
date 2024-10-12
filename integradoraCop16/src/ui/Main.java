package ui;

import java.util.Scanner;
import model.ControllerCop;

public class Main {

    // Variables globales
    public static Scanner scanner; 
    public static ControllerCop objController;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("Bienvenido voluntario a la aplicación de Interacción de Rutas Ecológicas COP 16 Cali - Colombia.");

        Main mainInstance = new Main(); 
        mainInstance.crearControllerCop();
        mainInstance.mostrarMenu(); 
    }

    public void crearControllerCop() {
        objController = new ControllerCop();
    }


    public void mostrarMenu() {
        System.out.println("Bienvenido voluntario a la aplicación de Gestión de Lugares Biodiversos COP 16 Cali - Colombia.");

        boolean terminar = true;
        while (terminar) {
            System.out.println("Te presentamos las siguientes opciones, ingresa:" + 
            "\n1. Para registrar un lugar con diversidad biológica" +  
            "\n2. Para consultar los lugares ordenados de menor a mayor con respecto al área" +
            "\n3. Para consultar el departamento que tiene más lugares con diversidad biológica registrados hasta el momento." + 
            "\n4. Para registrar una caminata." +
            "\n5. Para registrar una comunidad." +
            "\n6. Para registrar una especie." +
            "\n7. Para modificar datos de la especie." + 
            "\n8. Para consultar información de las comunidades que presentan problemas como falta de hospital o escuela." +
            "\n9. Para Consultar el nombre del lugar con mayor cantidad de especies." +
            "\n10. Para salir del programa.");
            int respuesta = scanner.nextInt();
            scanner.nextLine();
            
            switch (respuesta) {
                case 1:
                    registrarLugarBiodiverso();
                    break;

                case 2:
                    System.out.println("Los lugares ordenados de menor a mayor con respecto al área hasta el momento son:");
                    System.out.println(objController.ordenarLugarPorArea());
                    break;

                case 3:
                    System.out.println(objController.mostrarDepartamentoMasLugares());
                    break;

                case 4:
                    registrarVoluntario();
                    registrarCaminata();
                    break;
                case 5:
                    registrarComunidad();
                break;
                case 6: 
                    agregarEspecieEnLugar();
                break;
                case 7:
                    modificarEspecie();
                break;

                case 8:
                    buscarComunidadConProblema();
                break;
                
                case 9:
                    buscarLugarConMasEspecies();
                break;

                case 10:
                    System.out.println("Gracias por usar la COP 16.");
                    terminar = false;
                break;

                default:
                    System.out.println("Ingresaste una opción inválida.");
                    break;
            }
        }
    }
    public void registrarLugarBiodiverso() {

        System.out.println("Ingresa el nombre del lugar biodiverso");
        String nombreLugar = scanner.nextLine();

        System.out.println("Ingresa el número del departamento en el cual está el lugar: " + 
                           "\n1. Choco" + "\n2. Valle" + "\n3. Cauca" + "\n4. Nariño");
        int departamento = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Ingresa la cantidad de kilómetros cuadrados que abarca el lugar");
        double areaLugar = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingresa la ruta de la foto del lugar: ");
        String imagenLugar = scanner.nextLine();

        System.out.println("Ingrese la fecha de apertura del lugar " + nombreLugar + "\nAño: ");
        int aperturaAño = scanner.nextInt();

        System.out.println("Mes: ");
        int aperturaMes = scanner.nextInt();

        System.out.println("Día: ");
        int aperturaDia = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresa los recursos económicos necesarios para mantener el lugar: ");
        double recursosEconomicos = scanner.nextDouble();
        scanner.nextLine();
        
        String mostrarComunidades = objController.mostrarComunidades();

        System.out.println(objController.mostrarComunidades());
        if(mostrarComunidades != "No existen comunidades registradas en el sistema. Por favor, registre una comunidad desde el ménu."){
            int numComunidad = scanner.nextInt();
            scanner.nextLine();
        
        int lugarRegistrado = objController.registrarLugarBiodiverso(nombreLugar, areaLugar, imagenLugar, aperturaAño, aperturaMes, aperturaDia, recursosEconomicos, departamento, numComunidad);

        if (lugarRegistrado == 0) {
            System.out.println("Lugar ingresado con éxito.");
            } else {
            System.out.println("Error, el lugar no se ha podido registrar");
            }
        }
    }

    public void registrarVoluntario() {
        System.out.println("¿Cuál es tu nombre?");
        String nombre = scanner.nextLine();

        System.out.println("Por favor, digite la cédula");
        String id = scanner.nextLine();

        System.out.println(objController.registrarVoluntario(nombre, id));
    }

    public void registrarCaminata() {
        System.out.println("¿Qué ruta registrarás el día de hoy?");
        System.out.println(objController.mostrarRuta());
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (objController.rutaEscogida(opcion)) {
            System.out.println(objController.mostrarInformacionRuta(opcion));
            System.out.println("¿Cuántos participantes asistirán a la caminata el día de hoy?");
            int cantidadParticipantes = scanner.nextInt();

            System.out.println("¿Cuántos guías asistirán a la caminata el día de hoy?");
            int cantidadGuias = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingresar la temperatura en °C");
            double temperatura = scanner.nextDouble();

            System.out.println("Digitar el porcentaje de humedad relativa");
            double humedadRelativa = scanner.nextDouble();
            scanner.nextLine();

            System.out.println(objController.registrarCaminata(cantidadParticipantes, cantidadGuias, temperatura, humedadRelativa));
        } else {
            System.out.println("Ingresaste una opción inválida.");
        }
    }

    public void registrarComunidad(){
        System.out.println("Inrese el nombre de la comunidad");
        String nombreComunidad = scanner.nextLine();

        System.out.println("Ingrese el nombre del representate");
        String nombreRepresentante = scanner.nextLine();

        System.out.println("Ingrese el celular del representante");
        String celularRepresentate = scanner.nextLine();

        System.out.println("Ingrese el número de habitantes de la comunidad " + nombreComunidad);
        int cantidadHabitantes = scanner.nextInt();

        System.out.println("Ingrese el tipo de raza de la comunidad: \n1. Afrocolombiano. \n2. Indigena. \n3. Raizal.");
        int numRaza = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el tipo de problema en la comunidad: \n1. Falta de hospital. \n2. Falta de escuela. \n3. Falta de agua potable. \n4. Falta de acceso a alimentos basicos.");
        int numProblemas = scanner.nextInt();

        System.out.println(objController.registrarComunidad(nombreComunidad, cantidadHabitantes, numRaza, numProblemas, nombreRepresentante, celularRepresentate));
        }

    public static void agregarEspecieEnLugar(){
        System.out.println(objController.mostrarLugares());
        int opcion = scanner.nextInt();
        scanner.nextLine();
    
        System.out.println("Ingrese el nombre de la especie que quieres relacionar: ");
        String nombreEspecie = scanner.nextLine();

        System.out.println("Ingrese el tipo de especie; \n1. Flora \n2. Fauna ");
        int numEspecie = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la ruta de la foto de la especie: ");
        String imagenEspecie = scanner.nextLine();

        System.out.println("Ingrese la cantidad de ejemplares de la especie en un lugar: ");
        int cantidadEjemplares = scanner.nextInt();
        scanner.nextLine();

        if(cantidadEjemplares<=0){
            System.out.println("Error, la cantidad de ejemplares debe ser mayor a cero.");
            return;
        }

        System.out.println(objController.agregarEspecieEnLugar(opcion, nombreEspecie, imagenEspecie, cantidadEjemplares, numEspecie));
    }
    
    public static void mostrarLugares(){
        System.out.println(objController.mostrarLugares());
    }

    public static void modificarEspecie(){

        boolean finalWhile2 = true;
        while (finalWhile2 == true) {
            System.out.println("Ingresa el numero del lugar al que quieres modificar datos de alguna de sus especies.");

            System.out.println(objController.mostrarLugares());
            int opcion = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Las especies registradas en el lugar " + objController.buscarLugar(opcion) + " son: ");

            System.out.println(objController.mostrarEspecies(opcion));

            if (objController.mostrarEspecies(opcion) != "No existen especies registradas en el lugar."){

                System.out.println("Selecciona una: ");
                int seleccionEspecie = scanner.nextInt();
                scanner.nextLine();
                
                boolean finalWhile3 = true;
                while (finalWhile3 == true) {
                    System.out.println("¿Que deseas modificar? \n1. Tipo de la especie (Fauna, Flora) \n2. Foto de la especie. \n3. Numero de ejemplares.");
                    int atributoEspecie = scanner.nextInt();
                    scanner.nextLine();

                    int opcionEspecieModificar;
                    switch (atributoEspecie) {
                        case 1:
                            boolean finalWhile5 = true;
                            while (finalWhile5 == true) {
                                System.out.println("Ingresa el nuevo numero de tipo de especie: \n1. Fauna. \n2. Flora.");
                                int nuevoTipo = scanner.nextInt();
                                scanner.nextLine();

                                if ((nuevoTipo == 1) || (nuevoTipo == 2)){
                                    System.out.println(objController.modificarEspecie(opcion, seleccionEspecie, nuevoTipo, "", 0, 1));
                                    finalWhile5 = false;
                                    finalWhile3 = false;
                                }
                                else{
                                    System.out.println("Ingresaste una opcion invalida.");
                                }
                            }

                            
                            finalWhile3 = false;
                            break;

                        case 2:
                            System.out.println("Ingresa la nueva ruta de la foto de la especie: ");
                            String nuevaImagen = scanner.nextLine();

                            System.out.println(objController.modificarEspecie(opcion, seleccionEspecie, 0, nuevaImagen, 0, 2));
                            finalWhile3 = false;
                            break;

                        case 3:
                            System.out.println("Ingresa el nuevo numero de ejemplares en la especie: ");
                            int nuevaCantidad = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println(objController.modificarEspecie(opcion, seleccionEspecie, 0, "", nuevaCantidad, 3));
                            finalWhile3 = false;
                            break;
                    
                        default:
                            System.out.println("Ingresa una opcion valida.");
                            break;
                    }
                }
                
                    boolean finalWhile4 = true;
                    while (finalWhile4 == true) {
                        System.out.println("Deseas modificar algo mas? (s/n)");
                        String decisionModificar = scanner.nextLine();
                        
                        switch (decisionModificar.toLowerCase()) {
                            case "s":
                                finalWhile3 = true;
                                finalWhile4 = false;
                                break;
    
                            case "n":
                                finalWhile4 = false;
                                finalWhile3 = false;
                                finalWhile2 = false;
                                break;
                        
                            default:
                                System.out.println("Ingresaste una opcion invalida");
                                break;
                        }
                    }
            }

            else{
                finalWhile2 = false;
            }
        }
    }

    public static void buscarComunidadConProblema(){
        boolean finalWhile6 = true;
        while (finalWhile6 == true) {
            System.out.println("Ingresa el número del problema del quieres conocer que comunidades lo poseen: \n1. Falta de hospital. \n2. Falta de escuela");
            int opcionProblema = scanner.nextInt();
            scanner.nextLine();

            switch (opcionProblema) {
                case 1:
                    System.out.println(objController.buscarComunidadConProblema(1));
                    finalWhile6 = false;
                    break;

                case 2:
                System.out.println(objController.buscarComunidadConProblema(2));
                    finalWhile6 = false;
                    break;
            
                default:
                    System.out.println("Ingresa una opcion valida.");
                    break;
            }
        }
    }

    public static void buscarLugarConMasEspecies(){
        System.out.println(objController.mostrarLugarConMasEspecies());
    }  
}
