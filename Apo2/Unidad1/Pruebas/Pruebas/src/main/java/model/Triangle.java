package model;

public class Triangle {

    public final static String EQUILATERAL = "EQUILATERAL";
    public final static String ISOSCELES = "ISOSCELES";
    public final static String SCALENE = "SCALENE";
    public final static String NO_TRIANGLE = "NO_TRIANGLE";

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide3() {
        return side3;
    }

    public String whatType(){
        if(this.side1==this.side2 && this.side2 == this.side3){
            return EQUILATERAL;
        }
        return "";
    }

    public double area(){
        return 0.0;
    }

    public double perimeter(){
        return 0.0;
    }

    public double sumOfAngles(){
        return 0.0;
    }
}
