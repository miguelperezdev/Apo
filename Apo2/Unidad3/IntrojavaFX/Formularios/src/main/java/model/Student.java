package model;
import java.awt.*;
import java.util.jar.Attributes;

public class Student {

    private String name;
    private String lastName;
    private String code;
    private String career;
    private String gender;
    private int age;
    private int semester;
    private String dateAdmission;
    private Image photo ;

    // Constructor
    public Student(String name, String lastName, String code, String career, String gender,
                   int age, int semester, String dateAdmission, Image photo) {
        this.name = name;
        this.lastName = lastName;
        this.code = code;
        this.career = career;
        this.gender = gender;
        this.age = age;
        this.semester = semester;
        this.dateAdmission = dateAdmission;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(String dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

}
