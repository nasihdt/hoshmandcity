package Controller;


import com.example.hoshmandcity.Main;
import Model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class EnteredController {

     private User user ;
     @FXML
     private TextField tx_username;
     @FXML
     private PasswordField tx_password;
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
     public EnteredController(){
           user = new User();
     }
    @FXML
    private void loginClick(ActionEvent event){
        String username = tx_username.getText().toString();
        String password = tx_password.getText().toString();
        Dialog<String> dialog = new Dialog<>();
        if(username.equals(user.getAdminusername()) && password.equals(user.getAdminuserpassword())){

            try {

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
        else if(!username.equals(user.getAdminusername()) && !password.equals(user.getAdminuserpassword())){

            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should enter your username and password.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else if(!username.equals(user.getAdminusername())){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Your username are not correct.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else if(!password.equals(user.getAdminuserpassword())){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Your password are not correct.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }

    }
    @FXML
    private void backclick(ActionEvent event){
             try {
                 ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                 Main.FirstPage();

             }
              catch (Exception e){
                 e.fillInStackTrace();
             }
    }


}

