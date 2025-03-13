package customExceptions;

public class QuotaEnrollExceedException extends Exception{

    private int quota;

    public QuotaEnrollExceedException(int q){
        this.quota = q;
    }

    public int getQuota() {
        return quota;
    }

    public String getMessage(){
        return "This course has quota already full " + "The max. quota of this course is " + quota;
    }
}
