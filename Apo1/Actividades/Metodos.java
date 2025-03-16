/*
import java.util.Scanner;

public class Metodos {
    public static void main (String[] args) {

        Scanner escaner = new Scanner(System.in); 
         
         System.out.println("Por favor escribe lo que quieres expresar: ");
          String mensaje = escaner.nextLine();
             imprimirMensaje(mensaje);

    }
     // el void me permite que no retorne     
    public static void imprimirMensaje (String msg) {
        System.out.println("El mensaje es: " + msg) ;
    }
}

*/

import java.util.Scanner;

public class Metodos {
    public static void main (String[] args) {
            Scanner escaner = new Scanner(System.in); 
         
            System.out.println("Por favor escribe el primer numero a multuplicar: ");

             int numero1 = escaner.nextInt();

             System.out.println("Por favor escribe el segundo numero a multuplicar: ");

             int numero2 = escaner.nextInt();
             

             imprimirMensaje(multiplicar(numero1, numero2));

    }
         
    public static void imprimirMensaje (int res) {
        System.out.println("El resultado es: " + res) ;
    }

    public static int multiplicar (int entero1, int entero2) {
        int resultado = entero1 * entero2; 
        return resultado;

    }

}
