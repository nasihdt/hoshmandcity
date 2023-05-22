package Model;

import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Assistants extends Person {
    public Assistants(String name, String lastname , String personelynumber, String datePicker, String salary , String sabeghe){
        super(name,lastname,personelynumber,datePicker,salary,sabeghe);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
