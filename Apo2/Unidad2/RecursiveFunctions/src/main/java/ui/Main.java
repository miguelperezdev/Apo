package ui;

public class Main {

    public static void main(String[] args){
        System.out.println(factorial(4));
        System.out.println(fibonacci(5));
        System.out.println(sum(5));
        System.out.println(power(2,5));
    }

    public static int factorial(int num){
        //Caso base
        if(num==0){
            return 1;
        }
        //Caso recursivo
        else{
            return num*factorial(num-1);
        }
    }

    public static int fibonacci(int num){
        //Caso base 1
        if(num==0){
            return 0;
        }
        //Caso base 2
        else if(num==1){
            return 1;
        }
        //Caso recursivo
        else{
            return fibonacci(num-1)+fibonacci(num-2);
        }
    }

    public static int sum(int N){
        //Caso Base
        if(N == 1){
            return 1;
        }
        //Caso recursivo
        else{
            return N+sum(N-1);
        }
    }

    public static int power(int b, int e){
        if(e==0){
            return 1;
        }
        else if(e==1){
            return b;
        }
        else{
            return b*power(b,e-1);
        }
    }
}
