package model;

public class Office implements Comparable<Office>{

    private String code;
    private int floor;

    private Office nextOffice;
    private Professor professor;

    public Office(String code, int floor) {
        this.code = code;
        this.floor = floor;
        this.professor = new Professor("Juan José", "123456789");
    }

    public String getCode() {
        return code;
    }

    public int getFloor() {
        return floor;
    }

    public Office getNextOffice() {
        return nextOffice;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setNextOffice(Office nextOffice) {
        this.nextOffice = nextOffice;
    }

    @Override
    public int compareTo(Office o) {
        if(this.code.compareTo(o.getCode()) == 1){
            return 1;
        }
        else if(this.code.compareTo(o.getCode()) == -1){
            return -1;
        }
        else{
            return 0;
        }
    }
}
