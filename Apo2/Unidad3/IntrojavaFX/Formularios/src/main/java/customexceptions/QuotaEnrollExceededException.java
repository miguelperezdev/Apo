package customexceptions;

public class QuotaEnrollExceededException extends Exception{

    private final int quota;

    public QuotaEnrollExceededException(int q){
        this.quota = q;
    }

    @Override
    public String getMessage(){
        return "Este curso ya está lleno, el cupo maximo del curso es de " + quota + " estudiantes.";
    }
}
