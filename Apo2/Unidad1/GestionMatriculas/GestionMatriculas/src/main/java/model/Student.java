package model;

public class Student {
    private String id;
    private double[] grades;

    public Student(String identifier, int totalGrades) {
        grades = new double[totalGrades];
    }

    public void setGrade(int gradeNumber, double grade) throws ArrayIndexOutOfBoundsException{
        grades[gradeNumber] = grade;
    }

    public double getGrade(int gradeNumber) throws ArrayIndexOutOfBoundsException{
        return grades[gradeNumber];
    }

    public String getId() {
        return id;
    }
}