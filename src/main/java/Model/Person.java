package Model;

import com.example.hoshmandcity.Roles;
import javafx.beans.property.*;
import javafx.scene.control.DatePicker;

import java.sql.Date;

public class Person  {
    private String name;
    private String lastname;
    private String personelynumber;
    private String hire_date;
    private String salary;
    private String sabeghe;
    private Roles roles;
    public Person(String name, String lastname, String personelynumber, String hire_date, String salary, String sabeghe){
        this.name= name;
        this.lastname=lastname;
        this.personelynumber = personelynumber;
        this.hire_date = hire_date;
        this.salary = salary;
        this.sabeghe = sabeghe;
    }

    public Person() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setPersonelynumber(String personelynumber) {
        this.personelynumber = personelynumber;
    }

    public String getPersonelynumber() {
        return personelynumber;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSalary() {
        return salary;
    }

    public void setSabeghe(String sabeghe) {
        this.sabeghe = sabeghe;
    }

    public String getSabeghe() {
        return sabeghe;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getHire_date() {
        return hire_date;
    }

    public Roles getRoles() {
        return roles;
    }


    @Override
    public String toString(){
        return name + " " + lastname+" "+personelynumber+" "+hire_date+" "+salary+" "+sabeghe;
    }
}
