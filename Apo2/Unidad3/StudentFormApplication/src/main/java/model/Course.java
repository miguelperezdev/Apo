package model;

import customexceptions.DuplicateStudentException;
import customexceptions.QuotaEnrollExceededException;

import java.time.LocalDate;
import java.util.ArrayList;

public class Course {

    private final String name;
    private final String nrc;
    private final int group;
    private int totalStu;
    private final int credits;
    //Singleton
    private static Course instance;

    //Singleton https://refactoring.guru/es/design-patterns/singleton/java/example
    public static Course getInstance() {
        if (instance == null) {
            instance = new Course("APO II", "11336", 5, 3);
        }
        return instance;
    }

    private final ArrayList<Student> students;

    public Course(String name, String nrc, int group, int credits) {
        this.name = name;
        this.nrc = nrc;
        this.group = group;
        this.credits = credits;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNrc() {
        return nrc;
    }

    public int getGroup() {
        return group;
    }

    public int getTotalStu() {
        return totalStu;
    }

    public int getCredits() {
        return credits;
    }

    public ArrayList<Student> getStudents() {return students;}

    public String addStudent(String name, String lastname,
                             Carreer carreer, String email, int semester,
                             double grade, LocalDate dateEntry,
                             String image) throws QuotaEnrollExceededException,
                                 DuplicateStudentException {
        String message = "";
        if(totalStu<29){
            if(!checkForDuplicateStudent(email)){
                students.add(new Student(name, lastname, carreer, email, semester, grade, dateEntry, image));
                totalStu++;
                message += "Estudiante adicionado con exito!" +
                        "\nEstudiantes matriculados: " + totalStu
                        + "\nCupo total: " + 29;
            }
            else{
                throw new DuplicateStudentException(email);
            }
        }
        else{
            throw new QuotaEnrollExceededException(totalStu);
        }
        return message;
    }

    public boolean checkForDuplicateStudent(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
