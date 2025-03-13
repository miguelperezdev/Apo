package model;

import customExceptions.QuotaEnrollExceedException;

import java.util.Scanner;

public class Controller {

    public Course course;

    public Controller(){
    }

    public void createCourse(String name, int totalGradesAmount, int quota, double min, double max){
        Course myCourse;
        myCourse = new Course(name, totalGradesAmount, max, min, quota);
        this.course = myCourse;
    }

    public String enroll(String studentID){
        try{
            course.enroll(studentID);
            return "Student has been enrolled";
        } catch (QuotaEnrollExceedException e) {
            return e.getMessage();
        }
    }
}
