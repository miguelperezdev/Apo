package customexceptions;

public class DuplicateStudentException extends Exception{

    private final String email;

    public DuplicateStudentException(String email) {
        this.email = email;
    }

    @Override
    public String getMessage(){
        return "Este estudiante ya se encuentra matriculado " + email;
    }
}
