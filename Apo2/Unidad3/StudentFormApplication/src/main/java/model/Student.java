package model;

import java.time.LocalDate;

public class Student {
    private String id;
    private final String name;
    private final String lastName;
    private Carreer carreer;
    private final String email;
    private int semester;
    private double grade;
    private final LocalDate dateEntry;
    private String image;


    public Student(String name, String lastName, Carreer carreer, String email, int semester, double grade, LocalDate dateEntry, String image) {
        this.id = generateShortId();
        this.name = name;
        this.lastName = lastName;
        this.carreer = carreer;
        this.email = email;
        this.semester = semester;
        this.grade = grade;
        this.dateEntry = dateEntry;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Carreer getCarreer() {
        return carreer;
    }

    public String getEmail() {
        return email;
    }

    public int getSemester() {
        return semester;
    }

    public double getGrade() {
        return grade;
    }

    public LocalDate getDateEntry() {
        return dateEntry;
    }

    public String getImage() {return image;}

    public void setCarreer(Carreer carreer) {
        this.carreer = carreer;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //También se puede usar la Java.util.UUID
    private String generateShortId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
}
