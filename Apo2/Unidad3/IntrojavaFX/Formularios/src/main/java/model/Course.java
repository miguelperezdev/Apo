package model;

import customexceptions.DuplicateStudentException;
import customexceptions.QuotaEnrollExceededException;
import javafx.scene.image.Image;
import java.time.LocalDate;
import java.util.ArrayList;


public class Course {

    private String name;
    private String nrc;
    private int group;
    private int totalStu;
    private int credits;

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

    public Course(String name, String nrc, int group, int credits ) {
        this.name = name;
        this.nrc = nrc;
        this.group = group;
        this.credits = credits;
        this.students = new ArrayList<>(); // List void
    }


    public String addStudent(String name, String lastName, String code, Career career, Gender gender,
                             int age, int semester, LocalDate dateAdmission, Image photo, String email, String id) throws QuotaEnrollExceededException,
            DuplicateStudentException {
        String message = "";
        if(totalStu<29){
            if(!checkForDuplicateStudent(email)){
                students.add(new Student(name, lastName, code, career, gender, age, semester, dateAdmission, photo, email, id));
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getTotalStu() {
        return totalStu;
    }

    public void setTotalStu(int totalStu) {
        this.totalStu = totalStu;
    }
    public boolean addStudent(Student student){
        students.add(student);
        return false;
    }

    public void removeStudent(Student student){
        students.remove(student);
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }


    public static void setInstance(Course instance) {
        Course.instance = instance;
    }
}
