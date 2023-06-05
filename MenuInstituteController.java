package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class MenuInstituteController {
    @FXML
    public void loginteacher(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/LoginTeacher.fxml").toUri().toURL());
            Firstpage.setTitle("Login page");
            Firstpage.setScene(new Scene(root,919,530));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
        @FXML

        public void loginreg(ActionEvent event){
            try {

                FXMLLoader loader = new FXMLLoader();
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                Stage Firstpage = new Stage();
                Pane root = loader.load(Paths.get("src/main/java/View/LoginReg.fxml").toUri().toURL());
                Firstpage.setTitle("Login page");
                Firstpage.setScene(new Scene(root,599,483));
                //  Firstpage.setResizable(false);
                Firstpage.show();
            }
            catch (Exception e){
                e.fillInStackTrace();
            }
    }
    @FXML
    private  void backmenupage1(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/LoginStitute.fxml").toUri().toURL());
            Firstpage.setTitle("login page");
            Firstpage.setScene(new Scene(root,778, 301));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
}