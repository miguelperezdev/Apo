package customExceptions;

public class OutOfRangeGradeException extends IllegalArgumentException{
    public final static String OVER_EXCEDEED = "Grade is over range";
    public final static String UNDER_EXCEDEED = "Grade is under range";

    private String typeOfOut;
    private double grade;

    public OutOfRangeGradeException(double grade, double minGrade, double maxGrade) {
        this.grade = grade;
    }

    public void calculateTypeOfOut(){

    }

    public String getTypeOfOut() {
        return typeOfOut;
    }

    public double getGrade() {
        return grade;
    }

    public String getMessage(){
        return "";
    }
}
