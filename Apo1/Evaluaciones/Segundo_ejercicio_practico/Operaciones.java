import java.util.Scanner; //para que se importa ?

public class Operaciones {
    public static void main(String[] args) {

        Scanner escaner = new Scanner (System.in);
        
        
    //tipo de nombre
    System.out.println("Por favor digite su nombre ");
    String nombre= escaner.nextLine();
    
        System.out.println("Nombre: "+ nombre);

        System.out.println("Por favor digite su edad");
    int edad= escaner.nextInt();
    
        System.out.println("Edad: "+ edad);

        System.out.println("Por favor digite su altura");
    double altura= escaner.nextDouble();
    
        System.out.println("Altura: "+ altura);
        
        
        
        /*
        // Declarar una variable
        int num= 30; 
        int Onum= 30; 

        // Inicializar una variable
    
    int suma = num + Onum ;
    int resta = num - Onum ;
    int multiplicacion= num * Onum ;
    int division = num / Onum ;
    int modulo= num % Onum ;

        // Desplegar estos ejemplos a través de System.out.println
            System.out.println("Suma : " + suma);
            System.out.println("Resta : " + resta);
            System.out.println("multiplicacion : " + multiplicacion);
            System.out.println("division : " + division);
            System.out.println("modulo: " + modulo);
    */    

    }
}