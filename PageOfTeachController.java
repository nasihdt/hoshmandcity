package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PageOfTeachController {
    @FXML
    private ComboBox<String> courses;

    public static int num;
    public static String[] courselist = {"step1", "step2", "step3", "step4", "step5", "step6", "step8", "step9", "step10"};
    public void initialize(){
        Listcourse();
    }
    public void Listcourse(){
        List<String> crslist = new ArrayList<>();
        for (String data: courselist) {
            crslist.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(crslist);
        courses.setItems(listData);


    }
    @FXML
    public void exam(ActionEvent event){
        try {

           for (int i=0;i<courselist.length;i++) {
               if (courses.getSelectionModel().isSelected(i)) {
                    num=i;
                   FXMLLoader loader = new FXMLLoader();
                  // ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                   Stage Firstpage = new Stage();
                   Pane root = loader.load(Paths.get("src/main/java/View/CreatQuestion.fxml").toUri().toURL());
                   Firstpage.setTitle("Creation question");
                   Firstpage.setScene(new Scene(root, 985, 646));
                   Firstpage.setResizable(false);
                   Firstpage.show();

               }
           }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    public void useraccount(ActionEvent event){
        try {


            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/SeeInformation.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,978,360));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotoseesalary(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/SeeSalary.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,798,354));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotoseeCourses(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/SeeCoursesoffered.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,918,601));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotorequest(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/RequestTeach.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,1023,561));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotoseeyourcourse(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Instructorcoursespanel.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,950,582));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    private  void backmenupage4(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/MenuInstitute.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,768,581));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }

}
