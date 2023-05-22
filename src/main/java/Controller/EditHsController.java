package Controller;

import Model.Bazras;
import Model.Data;
import Model.File;
import Model.Herasat;
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
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditHsController {

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
    private TextField shift;


    @FXML
    private CheckBox morning;
    @FXML
    private CheckBox Evening;
    @FXML
    private CheckBox night;

    @FXML
    private TextField edit_name;
    @FXML
    private TextField edit_lastname;
    @FXML
    private TextField edit_salary;
    @FXML
    private TextField edit_sabeghe;
    @FXML
    private TextField edit_shift;

    @FXML
    private CheckBox edit_morning;
    @FXML
    private CheckBox edit_evening;
    @FXML
    private CheckBox edit_night;
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
    private TableColumn<Herasat,String> name_column;
    @FXML
    private TableColumn<Herasat,String> las_column;
    @FXML
    private TableColumn<Herasat,String> prs_column;
    @FXML
    private TableColumn<Herasat,String> date_column;
    @FXML
    private TableColumn<Herasat,String> salar_column;
    @FXML
    private TableColumn<Herasat,String> sabeghe_column;
    @FXML
    private TableColumn<Herasat,String> numshift_column;
    @FXML
    private TableColumn<Herasat,String> shift_column;


    @FXML
    public void insertherasat(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();
        if(name.getText().isEmpty() || lastname.getText().isEmpty() || personely.getText().isEmpty() || salary.getText().isEmpty()|| sabeghe.getText().isEmpty() || date.getText().isEmpty() || date.getText().isEmpty()){
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
                int n,m,stotal;
                int numbershift = Integer.parseInt(shift.getText());

                if (morning.isSelected()){
                  m = 2*sal*count;
                  m=m/100;
                  n = 1*sal*numbershift*1;
                  stotal = (sal+m+n)*30;
                  String s = String.valueOf(stotal);
                  if (regexdate()&&regexprs()){

                   Data.herasat = new Herasat(name.getText(),lastname.getText(),personely.getText(),date.getText(),s.toString(),sabeghe.getText(),shift.getText(),"morning");
                   Data.herasatlist.add(Data.herasat);
                    txt_result.setText("Bazras inserted! \n" + name.getText() + "\n" + lastname.getText() + "\n" + personely.getText() + "\n" + date.getText() + "\n" + s.toString() + "\n" + sabeghe.getText() + "\n" + shift.getText() + "\n"+ "morning");

                    name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                    las_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                    prs_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
                    date_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
                    salar_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
                    sabeghe_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));
                    numshift_column.setCellValueFactory(new PropertyValueFactory<>("numberofshift"));
                    shift_column.setCellValueFactory(new PropertyValueFactory<>("datatypeshift"));
                    table.getItems().add(Data.herasat);
                      File.writeHeras("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Heras",Data.herasatlist);
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
                else if(Evening.isSelected()){
                    String check = String.valueOf(Evening);
                    m = 2*sal*count;
                    m=m/100;
                    n = 1*sal*numbershift*1;
                    stotal = (sal+m+n)*30;
                    String s = String.valueOf(stotal);
                    if (regexprs() && regexdate()){

                    Data.herasat = new Herasat(name.getText(),lastname.getText(),personely.getText(),date.getText(),s.toString(),sabeghe.getText(),shift.getText(),"evening");
                    Data.herasatlist.add(Data.herasat);
                    txt_result.setText("Bazras inserted! \n" + name.getText() + "\n" + lastname.getText() + "\n" + personely.getText() + "\n" + date.getText() + "\n" + s.toString() + "\n" + sabeghe.getText() + "\n" + shift.getText() + "\n"+ "evening");

                    name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                    las_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                    prs_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
                    date_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
                    salar_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
                    sabeghe_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));
                    numshift_column.setCellValueFactory(new PropertyValueFactory<>("numberofshift"));
                    shift_column.setCellValueFactory(new PropertyValueFactory<>("datatypeshift"));
                    table.getItems().add(Data.herasat);
                        File.writeHeras("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Heras",Data.herasatlist);
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
                else if(night.isAllowIndeterminate()){

                    m = 2*sal*count;
                    m=m/100;
                    n = 1*sal*numbershift*2;
                    stotal = (sal+m+n)*30;
                    String s = String.valueOf(stotal);
                    if (regexdate()&& regexprs()){

                    Data.herasat = new Herasat(name.getText(),lastname.getText(),personely.getText(),date.getText(),s.toString(),sabeghe.getText(),shift.getText(),"night");
                    Data.herasatlist.add(Data.herasat);
                    txt_result.setText("Bazras inserted! \n" + name.getText() + "\n" + lastname.getText() + "\n" + personely.getText() + "\n" + date.getText() + "\n" + s.toString() + "\n" + sabeghe.getText() + "\n" + shift.getText() + "\n"+ "night");

                    name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                    las_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                    prs_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
                    date_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
                    salar_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
                    sabeghe_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));
                    numshift_column.setCellValueFactory(new PropertyValueFactory<>("numberofshift"));
                    shift_column.setCellValueFactory(new PropertyValueFactory<>("datatypeshift"));
                    table.getItems().add(Data.herasat);
                        File.writeHeras("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Heras",Data.herasatlist);
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


            } catch (Exception e) {
                txt_result.setText("Problem occurred while inserting employee " + e);
                throw e;
            }
        }
    }

    @FXML
    public void updateherasat(ActionEvent event){
          try {
                 Dialog<String> dialog = new Dialog<>();
                 String newname = edit_name.getText();
                 String newlas = edit_lastname.getText();
                 String newsalar = edit_salary.getText();
                 String newsabegh = edit_sabeghe.getText();
                 String newnumshift = edit_shift.getText();
                 int count = Integer.parseInt(newsabegh);
                 int sal = Integer.parseInt(newsalar);
                 int n,m,stotal;
                 int numbershift = Integer.parseInt(newnumshift);
                 if(edit_morning.isSelected()){
                     for (int i = 0;i<Data.herasatlist.size() ;i++) {
                         if (prs.getText().equals(Data.herasatlist.get(i).getPersonelynumber())) {
                             m = 2 * sal * count;
                             m = m / 100;
                             n = 1 * sal * numbershift * 1;
                             stotal = (sal + m + n) * 30;
                             String s = String.valueOf(stotal);

                             Data.herasatlist.get(i).setName(newname);
                             Data.herasatlist.get(i).setLastname(newlas);
                             Data.herasatlist.get(i).setSalary(s);
                             Data.herasatlist.get(i).setSabeghe(newsabegh);
                             Data.herasatlist.get(i).setNumberofshift(newnumshift);
                             Data.herasatlist.get(i).setDatatypeshift("morning");
                             txt_result.setText("Informations are updated!\n" + Data.herasatlist.get(i).getName() + "\n" + Data.herasatlist.get(i).getLastname()
                                     + "\n" + Data.herasatlist.get(i).getSalary() + "\n" + Data.herasatlist.get(i).getSabeghe());
                             table.refresh();
                             File.writeHeras("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Heras",Data.herasatlist);

                         }
                     }


                 }
                 else if(edit_evening.isSelected()){
                     for (int i = 0;i<Data.herasatlist.size() ;i++) {
                         if (prs.getText().equals(Data.herasatlist.get(i).getPersonelynumber())) {
                             m = 2 * sal * count;
                             m = m / 100;
                             n = 1 * sal * numbershift * 1;
                             stotal = (sal + m + n) * 30;
                             String s = String.valueOf(stotal);

                             Data.herasatlist.get(i).setName(newname);
                             Data.herasatlist.get(i).setLastname(newlas);
                             Data.herasatlist.get(i).setSalary(s);
                             Data.herasatlist.get(i).setSabeghe(newsabegh);
                             Data.herasatlist.get(i).setNumberofshift(newnumshift);
                             Data.herasatlist.get(i).setDatatypeshift("evening");
                             txt_result.setText("Informations are updated!\n" + Data.herasatlist.get(i).getName() + "\n" + Data.herasatlist.get(i).getLastname()
                                     + "\n" + Data.herasatlist.get(i).getSalary() + "\n" + Data.herasatlist.get(i).getSabeghe());
                             table.refresh();
                             File.writeHeras("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Heras",Data.herasatlist);

                         }
                     }
                 }
                 else if(edit_night.isSelected()){
                     for (int i = 0;i<Data.herasatlist.size() ;i++) {
                         if (prs.getText().equals(Data.herasatlist.get(i).getPersonelynumber())) {
                             m = 2 * sal * count;
                             m = m / 100;
                             n = 1 * sal * numbershift * 2;
                             stotal = (sal + m + n) * 30;
                             String s = String.valueOf(stotal);

                             Data.herasatlist.get(i).setName(newname);
                             Data.herasatlist.get(i).setLastname(newlas);
                             Data.herasatlist.get(i).setSalary(s);
                             Data.herasatlist.get(i).setSabeghe(newsabegh);
                             Data.herasatlist.get(i).setNumberofshift(newnumshift);
                             Data.herasatlist.get(i).setDatatypeshift("night");
                             txt_result.setText("Informations are updated!\n" + Data.herasatlist.get(i).getName() + "\n" + Data.herasatlist.get(i).getLastname()
                                     + "\n" + Data.herasatlist.get(i).getSalary() + "\n" + Data.herasatlist.get(i).getSabeghe());
                             table.refresh();
                             File.writeHeras("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Heras",Data.herasatlist);

                         }
                     }
                 }
          }
          catch (Exception e){
              txt_result.setText("Problem occurred while inserting employee " + e);
              throw e;
          }
    }
    @FXML
    private void deleteherasat(ActionEvent event){
        try {
            Dialog<String> dialog = new Dialog<>();
            for (int i = 0; i < Data.herasatlist.size(); i++) {
                if(prs.getText().equals(Data.herasatlist.get(i).getPersonelynumber())){
                    table.getItems().remove(Data.herasatlist.get(i));
                    Data.herasatlist.remove(i);
                    txt_result.setText("*Herasat's information "+prs.getText()+" are deleted!*");
                }
                else if(!prs.getText().equals(Data.herasatlist.get(i).getPersonelynumber())){
                    dialog.setTitle("Dialog box");
                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    dialog.setContentText("This number is not exist.");
                    dialog.getDialogPane().getButtonTypes().add(type);
                    dialog.showAndWait();
                }
                    File.writeHeras("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\5.Heras",Data.herasatlist);
            }
        }
        catch (Exception e){
            txt_result.setText("Problem occurred while inserting herasat " + e);
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
