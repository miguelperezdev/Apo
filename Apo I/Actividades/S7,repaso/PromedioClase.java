import java.util.Scanner;

public class PromedioClase{

    public static void main(String[] args){
        
        Scanner entrada = new Scanner(System.in);
        int total = 0; 
        int contadorCalificaciones = 0; 

        System.out.println("¿Que deseas hacer hoy?" );

        System.out.print("Elige (1) para  ingresar una nueva asignatura o (2) para salir del programa" );

        switch{

        case 1: 


        case 2: 
                
        }
        System.out.print("Escriba la calificacion o -1 para terminar:" );
        int calificacion = entrada.nextInt();



        while (calificacion != -1){
        total = total + calificacion; 
        contadorCalificaciones = contadorCalificaciones + 1; 

        System.out.print("Escriba la calificacion o -1 para terminar: ");
        calificacion = entrada.nextInt();

        }
        
        if (contadorCalificaciones != 0){
        double promedio = (double) total / contadorCalificaciones;

        System.out.printf("\nEl total de las calificaciones introducidas es ",contadorCalificaciones);
        System.out.printf("El promedio de la clase es", promedio);
        }
        else{
        System.out.println("No se introdujeron calificaciones");
        }
    } 
}
