package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MenupageshController {
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
    public void gotocreationuni(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/CtnUniver.fxml").toUri().toURL());
            Firstpage.setTitle("Creation univercity");
            Firstpage.setScene(new Scene(root,975,566));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotocreationhos(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/CtnHospital.fxml").toUri().toURL());
            Firstpage.setTitle("Creation Hospital");
            Firstpage.setScene(new Scene(root,975,566));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotocreationair(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/CtnAirport.fxml").toUri().toURL());
            Firstpage.setTitle("Creation Airport");
            Firstpage.setScene(new Scene(root,975,566));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotocreationlib(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Ctnlib.fxml").toUri().toURL());
            Firstpage.setTitle("Creation Library");
            Firstpage.setScene(new Scene(root,975,566));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotocreationlang(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/CtnStitute.fxml").toUri().toURL());
            Firstpage.setTitle("Creation Language institute");
            Firstpage.setScene(new Scene(root,975,566));
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
            Pane root = loader.load(Paths.get("src/main/java/View/loginsh.fxml").toUri().toURL());
            Firstpage.setTitle("Login page");
            Firstpage.setScene(new Scene(root,700,600));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
//    @FXML
//    public void login(ActionEvent event){
//        try {
//
//            FXMLLoader loader = new FXMLLoader();
//            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
//            Stage Firstpage = new Stage();
//            Pane root = loader.load(Paths.get("src/main/java/View/LoginReg.fxml").toUri().toURL());
//            Firstpage.setTitle("Login page");
//            Firstpage.setScene(new Scene(root,599,483));
//          //  Firstpage.setResizable(false);
//            Firstpage.show();
//        }
//        catch (Exception e){
//            e.fillInStackTrace();
//        }
//
//    }
//    @FXML
//    public void login2(ActionEvent event){
//        try {
//
//            FXMLLoader loader = new FXMLLoader();
//            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
//            Stage Firstpage = new Stage();
//            Pane root = loader.load(Paths.get("src/main/java/View/LoginTeacher.fxml").toUri().toURL());
//            Firstpage.setTitle("Login page");
//            Firstpage.setScene(new Scene(root,919,530));
//              Firstpage.setResizable(false);
//            Firstpage.show();
//        }
//        catch (Exception e){
//            e.fillInStackTrace();
//        }
//
//    }
    @FXML
    public void loginmenu(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/LoginStitute.fxml").toUri().toURL());
            Firstpage.setTitle("login page");
            Firstpage.setScene(new Scene(root, 778, 301));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }

    }
}
