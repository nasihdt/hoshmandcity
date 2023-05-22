package Model;

import javafx.scene.control.TextField;

public class Employee extends Person {
    private String workhour;
    public Employee(String name, String lastname , String personelynumber,String date, String salary , String sabeghe,String workhour){
        super(name,lastname,personelynumber,date,salary,sabeghe);
        this.workhour = workhour;
    }

    public void setWorkhour(String workhour) {
        this.workhour = workhour;
    }

    public String getWorkhour() {
        return workhour;
    }
}
