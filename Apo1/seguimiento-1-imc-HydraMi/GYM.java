import java.util.Scanner; 

public class GYM {
    public static void main(String[] args) {

        Scanner escaner = new Scanner (System.in);

    //Bienvenida 
     System.out.println(" ");
     System.out.println("Hola ¡Supermega maquina! bienvenido al GYM Ardnol's :) ");
     System.out.println(" ");
     System.out.println("El dia de hoy voy a testear tu indice de masa corporal (IMC) ");
        
    //tipo de nombre
    System.out.println("Pero...¿y tu como te llamas,No era Arnold Schwarzenegger?, Nahhh andas flaco mejor digita tu nombre ");
    String nombre= escaner.nextLine();
    
        System.out.println("Nombre: "+ nombre);
System.out.println("------------------------------------------------------------------------------------");

        System.out.println("Ahora megamaquina vamos a ver cuanto cuanto pesas en (Kg) ¿Acaso estas flacow? (Recuerda que este programa no admite los puntos (.) solo admite las comas (,))");
    double peso= escaner.nextDouble();
    
        System.out.println("peso: "+ peso);
        System.out.println("-------------------------------------------------------------------------------------------");

        System.out.println("Nahhh te falta ganar 20kg mas en musculo, mejor ahora dime ¿cual es tu altura? (Recuerda que este programa no admite los puntos (.) solo admite las comas (,))");
    double altura= escaner.nextDouble();
    
        System.out.println("Altura: "+ altura); 

    double altut = altura * altura ;
    double IMC = peso / altut;
System.out.println("--------------------------------------------------------------------------------------------");
System.out.println("Este es tu resultado de Indice de Masa Corporal (IMC): ");

    System.out.println("Wow " + nombre + ",\nTu peso es: " + peso + " kg,\nTu altura: " + altura + " m,\nTu Índice De Masa Corporal Es: " + IMC);
    System.out.println("--------------------------------------------------------------------------------------------");


    if (IMC < 18.5) {
    System.out.println("Estas Bajo de peso,Wow deberias comer mas. ");
} else if (IMC >= 18.5 && IMC <= 24.9) {
    System.out.println("Estas Normal, sigue asi.");
} else if (IMC >= 25 && IMC <= 29.9) {
    System.out.println("Sobrepeso, Vamos a hacer cardio y metele al GYM.");
} else if (IMC >= 30 && IMC <= 34.9) {
    System.out.println("Obesidad I, Pon cuidado metele al GYM.");
} else if (IMC >= 35 && IMC <= 39.9) {
    System.out.println("Obesidad II, Cuidate metele al GYM.");
} else if (IMC >= 40 && IMC <= 49.9) {
    System.out.println("Obesidad III, ¿Que pasa? cuidatee metele al GYM.");
} else { 
    System.out.println("Obesidad IV, Es enserio, Cuidate metele al GYM.");
}

System.out.println("Espero que tus resultados sean los esperados, tambien que estes bien y recuerda 'Mejor que ayer peor que mañana'"+ "\n Byee...");
 
    }
}