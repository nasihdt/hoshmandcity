package Model;

import javafx.scene.control.TextField;

public class Herasat extends Person {
    private String numberofshift;
    private  String datatypeshift;
    public Herasat(String name, String lastname , String personelynumber,String date, String salary , String sabeghe,String numberofshift,String datatypeshift){
        super(name,lastname,personelynumber,date,salary,sabeghe);
        this.numberofshift = numberofshift;
        this.datatypeshift = datatypeshift;
    }

    public void setNumberofshift(String numberofshift) {
        this.numberofshift = numberofshift;
    }

    public String getNumberofshift() {
        return numberofshift;
    }

    public void setDatatypeshift(String datatypeshift) {
        this.datatypeshift = datatypeshift;
    }

    public String getDatatypeshift() {
        return datatypeshift;
    }
}
