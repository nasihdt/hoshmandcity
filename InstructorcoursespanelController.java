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

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

public class InstructorcoursespanelController {
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
    private TableColumn<String, Course> Educate_column;
    @FXML
    private TableView table;
    @FXML
    private TextArea txt;
    @FXML
    private TextField code;
    static int num;

    public void initialize(){
        showtable();
    }
    public void showtable(){
        for (int i=0;i< Data.teacherlist.size();i++) {
            if (Data.teacherlist.get(LoginControllerTeacher.num).getNationalnumber().equals(Data.teacherlist.get(i).getNationalnumber())) {

                course_column.setCellValueFactory(new PropertyValueFactory<>("coursesection"));
                name_column.setCellValueFactory(new PropertyValueFactory<>("coursename"));
                code_column.setCellValueFactory(new PropertyValueFactory<>("coursecode"));
                fee_column.setCellValueFactory(new PropertyValueFactory<>("coursefee"));
                teach_column.setCellValueFactory(new PropertyValueFactory<>("courseinstructor"));
                Educate_column.setCellValueFactory(new PropertyValueFactory<>("meetings"));
                for (int j=0;j<Data.courseslist.size();j++){

                    if (Data.courseslist.get(j).getCourseinstructor().equals(Data.teacherlist.get(LoginControllerTeacher.num).getName())) {
                      //  if (Data.courseslist.get(j).getCoursecode().equals(Data.teacherlist.get(LoginControllerTeacher.num).coursecode[EditTeachController.num])) {
                            table.getItems().add(Data.courseslist.get(j));
                       // }
                    }
                }
            }
        }
    }

    @FXML
    public void optout(ActionEvent event){
        if(table.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Select");
            alert.setHeaderText("Choose the sport you like:");

            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No");

            alert.getButtonTypes().clear();

            alert.getButtonTypes().addAll(yes, no);

            // option != null.
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == yes) {
                for (int i = 0; i < Data.teacherlist.size(); i++) {
                    if (Data.teacherlist.get(CoursesController.num).getNationalnumber().equals(Data.teacherlist.get(i).getNationalnumber())) {
                        Data.teacherlist.remove(i);
                        txt.setText("Your account deleted.");

                    }
                }

            } else if (option.get() == no) {
                alert.close();
            }
        }
        else {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You are not allowed to withdraw"+"\n"+"because you are teaching the course.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();

        }
    }
    @FXML
    public void Seemeetings(ActionEvent event){
        try {

           for (int i=0;i<Data.courseslist.size();i++){
                   if(code.getText().equals(Data.courseslist.get(i).getCoursecode())){
                       num = i;
                       Stage stage =new Stage();
                       FXMLLoader loader = new FXMLLoader();
                       ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                       Stage Firstpage = new Stage();
                       Pane root = loader.load(Paths.get("src/main/java/View/SeeMeetingsCourse.fxml").toUri().toURL());
                       Firstpage.setTitle("See meetings");
                       Firstpage.setScene(new Scene(root,872,539));
                       //Firstpage.setResizable(false);
                       Firstpage.show();
                   }
           }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void scorestudent(ActionEvent event){

    }
    @FXML
    public void gotobackmenuteach(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/PageOfTeach.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,872,822));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
