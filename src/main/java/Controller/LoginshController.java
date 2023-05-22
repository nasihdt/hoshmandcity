package Controller;

import Model.Data;
import javafx.event.ActionEvent;
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

public class LoginshController{
    @FXML
    private TextField namesh;
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
    private TextField lastnamesh;
    @FXML
    private void loginsh(ActionEvent event) {
        String name = namesh.getText().toString();
        String lastname = lastnamesh.getText().toString();
        Dialog<String> dialog = new Dialog<>();

         if(name.isEmpty() && lastname.isEmpty()){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should enter your name and lastname.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }

        else if (name.equals(Data.shahrdar.getName()) && lastname.equals(Data.shahrdar.getLastname())) {
            try {

                FXMLLoader loader = new FXMLLoader();
                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
                Stage Firstpage = new Stage();
                Pane root = loader.load(Paths.get("src/main/java/View/Menupagesh.fxml").toUri().toURL());
                Firstpage.setTitle("Menu page");
                Firstpage.setScene(new Scene(root, 610, 621));
                Firstpage.setResizable(false);
                Firstpage.show();
            } catch (Exception e) {
                e.fillInStackTrace();
            }
       }
        else if(!name.equals(Data.shahrdar.getName()) && !lastname.equals(Data.shahrdar.getLastname())){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Your informations are not correct.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else if(!name.equals(Data.shahrdar.getName())){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Your name are not correct.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else if(!lastname.equals(Data.shahrdar.getLastname())){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Your lastname are not correct.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }

    }
     @FXML
    private  void backmenupage(ActionEvent event){
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
}
