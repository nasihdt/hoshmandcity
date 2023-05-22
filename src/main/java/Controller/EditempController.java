package Controller;

import Model.Bazras;
import Model.Data;
import Model.Employee;
import Model.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditempController {
    @FXML
    private TextField name;
    @FXML
    private TextField lastname;
    @FXML
    private TextField personely;
    @FXML
    private TextField date;
    @FXML
    private TextField salary;
    @FXML
    private TextField sabeghe;
    @FXML
    private TextField hour;

    @FXML
    private TextField edit_name;
    @FXML
    private TextField edit_las;
    @FXML
    private TextField edit_salar;
    @FXML
    private TextField edit_sabeghe;
    @FXML
    private TextField edit_hour;

    static FileHandler handler;
    static {
        try {
            handler = new FileHandler("logger.log",true);
        }
        catch (IOException e) {
            Logger logger = Logger.getLogger("com.javacodesgeeks.snippets.core");
            logger.addHandler(handler);
            logger.warning("warning message");
        }
    }
    @FXML
    private TextField prs;
    @FXML
    private TextArea txt_result;
    @FXML
    private TableView table;

    @FXML
    private TableColumn<Bazras,String> name_column;
    @FXML
    private TableColumn<Bazras,String>  las_column;
    @FXML
    private TableColumn<Bazras,String>  prs_column;
    @FXML
    private TableColumn<Bazras,String>  date_column;
    @FXML
    private TableColumn<Bazras,String>  salar_column;
    @FXML
    private TableColumn<Bazras,String>  sabegh_column;
    @FXML
    private TableColumn<Bazras,String>  hour_column;


    @FXML
    private void insertemployee(ActionEvent event){
            Dialog<String> dialog = new Dialog<>();
            if(name.getText().isEmpty() || lastname.getText().isEmpty() || personely.getText().isEmpty() || salary.getText().isEmpty()|| sabeghe.getText().isEmpty() || date.getText().isEmpty() || hour.getText().isEmpty()){
                dialog.setTitle("Dialog box");
                ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("You should first write information.");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
           else {
                try {
                    int count = Integer.parseInt(sabeghe.getText());
                    int sal = Integer.parseInt(salary.getText());
                    int hwork = Integer.parseInt(hour.getText());
                    int n,m,s;
                    n= sal * 4*hwork*7;
                    m=3*count*sal;
                    m=m/100;
                    s = m+n;
                    String sl = String.valueOf(s);

                    if (regexdate() && regexprs()){

                    Data.employee = new Employee(name.getText(),lastname.getText(),personely.getText(),sl,sabeghe.getText(),date.getText(),hour.getText());
                    Data.emplist.add(Data.employee);
                    txt_result.setText("Employee inserted! \n" + name.getText() + "\n" + lastname.getText() + "\n" + personely.getText() + "\n" + date.getText() + "\n" + sl.toString() + "\n" + sabeghe.getText() + "\n" + hour.getText());
                    name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                    las_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                    prs_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
                    date_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
                    salar_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
                    sabegh_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));
                    hour_column.setCellValueFactory(new PropertyValueFactory<>("workhour"));
                    table.getItems().add(Data.employee);
                        File.writeEmp("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\4.Employee",Data.emplist);
                    }
                    else if(!regexprs() && !regexdate()) {
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("date and personely that you wrote those are not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexdate()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The date that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexprs()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The personely that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }

                }
                catch (Exception e) {

                    txt_result.setText("Problem occurred while inserting employee " + e);
                    throw e;
                }
            }
        }

    @FXML
    private void updateemployee(ActionEvent event){
        try {
            String newname = edit_name.getText();
            String newlas = edit_las.getText();
            String newsal = edit_salar.getText();
            String newsabeghe = edit_sabeghe.getText();
            String newhour = edit_hour.getText();

            int count = Integer.parseInt(newsabeghe);
            int sal = Integer.parseInt(newsal);
            int hwork = Integer.parseInt(newhour);
            int m,n,s;

            for (int i = 0; i < Data.emplist.size() ; i++) {
                if(prs.getText().equals(Data.emplist.get(i).getPersonelynumber())){
                    n= sal * 4*hwork*7;
                    m=3*count*sal;
                    m=m/100;
                    s = m+n;

                    String sl = String.valueOf(s);


                    Data.emplist.get(i).setName(newname);
                    Data.emplist.get(i).setLastname(newlas);
                    Data.emplist.get(i).setSalary(sl);
                    Data.emplist.get(i).setSabeghe(newsabeghe);
                    Data.emplist.get(i).setWorkhour(newhour);

                    txt_result.setText("Informations are updated!\n"+Data.emplist.get(i).getName()+"\n"+Data.emplist.get(i).getLastname()
                            +"\n"+Data.emplist.get(i).getSalary()+"\n"+Data.emplist.get(i).getSabeghe());
                    table.refresh();
                    File.writeEmp("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\4.Employee",Data.emplist);

                }
            }



        }
        catch (Exception e){
            txt_result.setText("Problem occurred while inserting employee " + e);
            throw e;
        }
    }

    @FXML
    private void deleteemployee(ActionEvent event){
        try {
            Dialog<String> dialog = new Dialog<>();
            for (int i = 0; i < Data.emplist.size(); i++) {
                if(prs.getText().equals(Data.emplist.get(i).getPersonelynumber())){
                    table.getItems().remove(Data.emplist.get(i));
                    Data.emplist.remove(i);
                    txt_result.setText("*Bazras's information "+prs.getText()+" are deleted!*");
                }
                    File.writeEmp("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\4.Employee",Data.emplist);
//                else if(!prs.getText().equals(Data.emplist.get(i).getPersonelynumber())){
//                    dialog.setTitle("Dialog box");
//                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
//                    dialog.setContentText("This number is not exist.");
//                    dialog.getDialogPane().getButtonTypes().add(type);
//                    dialog.showAndWait();
//                }
            }
        }
        catch (Exception e){
            txt_result.setText("Problem occurred while inserting employee " + e);
            throw e;
        }
    }

    @FXML
    private void gotomenupage(ActionEvent event) {
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Menupage.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,700,600));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    public boolean regexdate(){
        String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date.getText());
        return matcher.matches();
    }
    public boolean regexprs(){
        String regex = "^(?:-(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))|(?:0|(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))))(?:.\\d+|)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(personely.getText());
        return matcher.matches();
    }

}

