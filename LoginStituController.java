package Controller;

import Model.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class LoginStituController {
    @FXML
    private TextField name;

    @FXML
    public void loginmenuinstitute(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();

        if(name.getText().isEmpty()){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should enter your name and lastname.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else{
            try {
                 for(int i=0;i<Data.languagelist.size();i++){
                     if(name.getText().equals(Data.languagelist.get(i).getNamePlace())){
                         FXMLLoader loader = new FXMLLoader();
                         ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
                         Stage Firstpage = new Stage();
                         Pane root = loader.load(Paths.get("src/main/java/View/MenuInstitute.fxml").toUri().toURL());
                         Firstpage.setTitle("login page");
                         Firstpage.setScene(new Scene(root, 768, 581));
                         Firstpage.setResizable(false);
                         Firstpage.show();
                     }
                 }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @FXML
    private  void backmenupageinst(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Menupagesh1.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,610,621));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
