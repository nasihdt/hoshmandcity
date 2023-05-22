package Controller;


import Model.Shahrdar;
import com.example.hoshmandcity.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class MenupageController {
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
    private void initializeCols(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/EditSh.fxml").toUri().toURL());
            Firstpage.setTitle("Edit shahrdar");
            Firstpage.setScene(new Scene(root,1127,676));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }

    @FXML
    public void gotocreationM(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/EditAs.fxml").toUri().toURL());
            Firstpage.setTitle("Creation Assistant");
            Firstpage.setScene(new Scene(root,1084,667));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotocreationBz(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/EditBz.fxml").toUri().toURL());
            Firstpage.setTitle("Creation Bazras");
            Firstpage.setScene(new Scene(root,1163,738));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotoseeusers(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Seeuser.fxml").toUri().toURL());
            Firstpage.setTitle("Users");
            Firstpage.setScene(new Scene(root,1066,772));

            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotocreationhs(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/EditHs.fxml").toUri().toURL());
            Firstpage.setTitle("Creation Herasat");
            Firstpage.setScene(new Scene(root,1223,733));

            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void gotocreationemp(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Editemp.fxml").toUri().toURL());
            Firstpage.setTitle("Creation Employee");
            Firstpage.setScene(new Scene(root,1163,738));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    private void gotologinpage(ActionEvent event) {
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Enteredcontroller.fxml").toUri().toURL());
            Firstpage.setTitle("Login page");
            Firstpage.setScene(new Scene(root,600,400));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    private void loginsh(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/loginsh.fxml").toUri().toURL());
            Firstpage.setTitle("Login page");
            Firstpage.setScene(new Scene(root,728,486));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void handleCloseButtonAction(ActionEvent event){
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

 }

