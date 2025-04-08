package model;

public class Employee implements Comparable<Employee>{

    private String id;
    private String name;
    private int office;

    private Employee Parent;
    private Employee Left;
    private Employee Right;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public Employee(String id, String name, int office) {
        this.id = id;
        this.name = name;
        this.office = office;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOffice() {
        return office;
    }

    public Employee getParent() {
        return Parent;
    }

    public Employee getLeft() {
        return Left;
    }

    public Employee getRight() {
        return Right;
    }

    public void setParent(Employee parent) {
        Parent = parent;
    }

    public void setLeft(Employee left) {
        Left = left;
    }

    public void setRight(Employee right) {
        Right = right;
    }

    @Override
    public int compareTo(Employee emp) {
        String anotherId = emp.getId();
        if(id.compareTo(anotherId) > 0){
            return 1;
        }
        else if(id.compareTo(anotherId) < 0){
            return -1;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString(){
        return "Id: " + this.id;
    }
}
