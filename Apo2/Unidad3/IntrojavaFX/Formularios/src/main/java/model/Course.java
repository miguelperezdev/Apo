package model;

import java.util.LinkedList;

public class Course {

    private String name;
    private String nrc;
    private String classroom;
    private int size ;
    private LinkedList<Student> students;

    public Course(String name, String nrc, String classroom, int size) {
        this.name = name;
        this.nrc = nrc;
        this.classroom = classroom;
        this.size = size;
        this.students = new LinkedList<>(); // List void
    }

    public boolean addStudent (Student student){
        if (students.size() < size) {
            students.add(student);
            return true;
        }else{
            return false;
        }
    }

    public LinkedList<Student> getStudents() {
        return students;
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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
