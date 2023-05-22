package Controller;

import Model.Assistants;
import Model.Data;

import Model.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class EditasController {
    @FXML
    private  TextField name;
    @FXML
    private  TextField lastname;
    @FXML
    private  TextField personely;
    @FXML
    private  TextField salary;
    @FXML
    private  TextField sabeghe;
    @FXML
    private TextField date;


    @FXML
    private TextField edit_name;
    @FXML
    private TextField edit_lastname;
    @FXML
    private TextField edit_salary;
    @FXML
    private TextField edit_sabeghe;
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
    private TableColumn<Assistants , String> name_column;
    @FXML
    private TableColumn<Assistants , String> las_column;
    @FXML
    private TableColumn<Assistants , String> prs_column;
    @FXML
    private TableColumn<Assistants , String> date_column;
    @FXML
    private TableColumn<Assistants , String> salary_column;
    @FXML
    private TableColumn<Assistants , String> sabeghe_column;

    @FXML
    private TableView<Assistants> table;
    @FXML
    private TextField prs;
    @FXML
    private TextArea txtResult;


    @FXML
    private void updateAssistant(ActionEvent event){
         try {
                String newname = edit_name.getText();
                String newlas = edit_lastname.getText();
                String newsal = edit_salary.getText();
                String newsabeghe = edit_sabeghe.getText();

                for (int i = 0; i < Data.assislist.size() ; i++) {
                    if(prs.getText().equals( Data.assislist.get(i).getPersonelynumber())){
                        int count = Integer.parseInt(newsabeghe), sal = Integer.parseInt(newsal), m, n,s;
                        m = sal * 5 * count;
                        n=m/100;
                        s = sal + n;
                        String sl = String.valueOf(s);

                        Data.assislist.get(i).setName(newname);
                        Data.assislist.get(i).setLastname(newlas);
                        Data.assislist.get(i).setSalary(sl);
                        Data.assislist.get(i).setSabeghe(newsabeghe);
                       txtResult.setText("Informations are updated!\n"+ Data.assislist.get(i).getName()+"\n"+ Data.assislist.get(i).getLastname()
                               +"\n"+ Data.assislist.get(i).getSalary()+"\n"+ Data.assislist.get(i).getSabeghe());
                        table.refresh();
                        File.writeassistant("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\2.Assistant",Data.assislist);
                    }
                }



         }
         catch (Exception e){
             txtResult.setText("Problem occurred while inserting employee " + e);
             throw e;
         }
    }

    @FXML
    private void insertAssistant(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();
        if(name.getText().isEmpty() || lastname.getText().isEmpty() ||personely.getText().isEmpty() || salary.getText().isEmpty()|| sabeghe.getText().isEmpty() || date.getText().isEmpty()){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should first write information.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        try {
            int count = Integer.parseInt(sabeghe.getText()), sal = Integer.parseInt(salary.getText()), m, n,s;
            m = sal * 5 * count;
            n=m/100;
            s = sal + n;
            String sl = String.valueOf(s);

            if(regexdate() && regexprs()){

            Data.assistants = new Assistants(name.getText(),lastname.getText(),personely.getText(),date.getText(),sl,sabeghe.getText());
            Data.assislist.add(Data.assistants);
            txtResult.setText("Assistant inserted! \n" + name.getText() + "\n" + lastname.getText() + "\n" + personely.getText() + "\n" + date.getText() + "\n" + sl.toString() + "\n" + sabeghe.getText());
                        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                        las_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        prs_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
                        date_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
                        salary_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
                        sabeghe_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));
                        table.getItems().add(Data.assistants);
                File.writeassistant("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\2.Assistant",Data.assislist);
            }
            else if(!regexprs() && !regexdate()){
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


        } catch (Exception e) {
            txtResult.setText("Problem occurred while inserting employee " + e);
            throw e;
        }
    }

    @FXML
    private void deleteAssistant(ActionEvent event){
        try {
            Dialog<String> dialog = new Dialog<>();
            for (int i = 0; i <  Data.assislist.size(); i++) {
                if(prs.getText().equals( Data.assislist.get(i).getPersonelynumber())){
                    table.getItems().remove( Data.assislist.get(i));
                    Data.assislist.remove(i);
                    txtResult.setText("*Assistant's information "+prs.getText()+" are deleted!*");

                }
//                else if(!prs.getText().equals(Data.assislist.get(i).getPersonelynumber())){
//                    dialog.setTitle("Dialog box");
//                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
//                    dialog.setContentText("This number is not exist.");
//                    dialog.getDialogPane().getButtonTypes().add(type);
//                    dialog.showAndWait();
//                }
                    File.writeassistant("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\2.Assistant",Data.assislist);
            }
        }
        catch (Exception e){
            txtResult.setText("Problem occurred while inserting employee " + e);
            throw e;
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



}
