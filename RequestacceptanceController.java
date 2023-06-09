package Controller;

import Model.Course;
import Model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class RequestacceptanceController {
    @FXML
    private TableView table;
    @FXML
    private TableColumn<String, Course> course_column;
    @FXML
    private TableColumn<String, Course> code_column;
    @FXML
    private TableColumn<String, Course> name_column;
    @FXML
    private TableColumn<String, Course> fee_column;
    @FXML
    private TableColumn<String, Course> teach_column;
    @FXML
    private TableColumn<String, Course> edu_column;
    @FXML
    private TextField Row;
    @FXML
    private TextField teach;
    @FXML
    private TextArea txt;

    public void initialize(){
           showrequest();
    }
    public void showrequest(){
        course_column.setCellValueFactory(new PropertyValueFactory<>("coursesection"));
        name_column.setCellValueFactory(new PropertyValueFactory<>("coursename"));
        code_column.setCellValueFactory(new PropertyValueFactory<>("coursecode"));
        fee_column.setCellValueFactory(new PropertyValueFactory<>("coursefee"));
        teach_column.setCellValueFactory(new PropertyValueFactory<>("courseinstructor"));
//                        date_column.setCellValueFactory(new PropertyValueFactory<>("datehold"));
//                        time_column.setCellValueFactory(new PropertyValueFactory<>("clockhold"));
        edu_column.setCellValueFactory(new PropertyValueFactory<>("meetings"));
        for (int i=0;i<Data.requestcourseteacher.size();i++) {
            table.getItems().add(Data.requestcourseteacher.get(i));
        }
    }
    @FXML
    public void accept(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();
        if(Row.getText().isEmpty()){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should first write information.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else {
            try {
                for (int i =0;i<Data.requestcourseteacher.size();i++){
                    if(Row.getText().equals(String.valueOf(i))){
                       if(teach.getText().equals(Data.requestcourseteacher.get(i).getCourseinstructor())) {
                           Data.courseslist.add(Data.requestcourseteacher.get(i));

                           txt.setText("The request has been accepted and added to the list of courses.");

                       }
                       if(Data.requestcourseteacher.isEmpty()){
                           dialog.setTitle("Dialog box");
                           ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                           dialog.setContentText("There is no information that you want to accept.");
                           dialog.getDialogPane().getButtonTypes().add(type);
                           dialog.showAndWait();
                       }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void rejection(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();
        if(Row.getText().isEmpty()){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should first write information.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else {
            try {
                for (int i =0;i<Data.requestcourseteacher.size();i++){
                    if(Row.getText().equals(String.valueOf(i))){
                        if(teach.getText().equals(Data.requestcourseteacher.get(i).getCourseinstructor())) {
                            table.getItems().remove(Data.requestcourseteacher.get(i));
                            Data.requestcourseteacher.remove(i);
                            table.refresh();
                            txt.setText("The request was not accepted and removed from the list of courses.");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void gotobackmenuReg(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/PageReg.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,641,672));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
