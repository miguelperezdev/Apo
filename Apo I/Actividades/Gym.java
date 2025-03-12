import java.util.Scanner; //importamos el scaner 

public class Gym {
    public static void main(String[] args) {

        Scanner escaner = new Scanner (System.in);

    //Bienvenida 
     System.out.println("Hola ¡Supermega maquina! bienvenido al GYM Ardnol's :) ");
     System.out.println("El dia de hoy voy a testear tu indice de masa corporal (IMC) ");
        
    //tipo de nombre
    System.out.println("Pero...¿y tu como te llamas,No era Arnold Schwarzenegger?, Nahhh andas flaco mejor digita tu nombre ");
    String nombre= escaner.nextLine();
    
        System.out.println("Nombre: "+ nombre);

        System.out.println("Ahora megamaquina vamos a ver cuanto cuanto pesas en (Kg) ¿Acaso estas flacow?");
    double peso= escaner.nextDouble();
    
        System.out.println("peso: "+ peso);

        System.out.println("Nahhh te falta ganar 20kg mas en musculo, mejor ahora dime ¿cual es tu altura? (Recuerda que este programa no admite los puntos (.) solo las comas (,))");
    double altura= escaner.nextDouble();
    
        System.out.println("Altura: "+ altura); 

    double altut = altura * altura ;
    double IMC = peso / altut;

System.out.println("Este es tu resultado de Indice de Masa Corporal (IMC)");
    System.out.println("Tu Indice De Masa Corporal Es: "+ IMC); 

    if (IMC < 18.5) {
    System.out.println("Bajo peso");
} else if (IMC >= 18.5 && IMC <= 24.9) {
    System.out.println("Normal");
} else if (IMC >= 25 && IMC <= 29.9) {
    System.out.println("Sobrepeso");
} else if (IMC >= 30 && IMC <= 34.9) {
    System.out.println("Obesidad I");
} else if (IMC >= 35 && IMC <= 39.9) {
    System.out.println("Obesidad II");
} else if (IMC >= 40 && IMC <= 49.9) {
    System.out.println("Obesidad III");
} else { 
    System.out.println("Obesidad IV");
}




    }
}