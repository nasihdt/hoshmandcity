package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PageOfRegController {

    @FXML
    public void gotoeditteacher(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/EditTeacher.fxml").toUri().toURL());

            Firstpage.setTitle("Login page");
            Firstpage.setScene(new Scene(root,1132,661));
              Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotoCreatCourse(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/CreationCourses.fxml").toUri().toURL());

            Firstpage.setTitle("Login page");
            Firstpage.setScene(new Scene(root,1242,560));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotoCreatStudent(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/EditStudent.fxml").toUri().toURL());

            Firstpage.setTitle("Login page");
            Firstpage.setScene(new Scene(root,1145,533));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    private void gotoseeTeachStu(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/SeeTechStu.fxml").toUri().toURL());

            Firstpage.setTitle("See Teachers and Students");
            Firstpage.setScene(new Scene(root,1134,654));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    private void gotopayment(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Salarypeyment.fxml").toUri().toURL());

            Firstpage.setTitle("Payment salary");
            Firstpage.setScene(new Scene(root,1148,640));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    private void gotoacceptedrequest(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Requestacceptance.fxml").toUri().toURL());

            Firstpage.setTitle("Request accepted");
            Firstpage.setScene(new Scene(root,875,519));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    private  void backmenupage(ActionEvent event){
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


