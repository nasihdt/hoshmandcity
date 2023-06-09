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

public class LoginControllerTeacher {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public static int num;

    @FXML
    public void Loginteach(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();

        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should fill blanks.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();

        }
        else {
            try {
                for (int i = 0; i < Data.teacherlist.size(); i++) {
                    if (username.getText().equals(Data.teacherlist.get(i).getCodeTeacher()) && password.getText().equals(Data.teacherlist.get(i).getNationalnumber())) {
                        num= i;
                        Stage stage = new Stage();
                        FXMLLoader loader = new FXMLLoader();
                        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
                        Stage Firstpage = new Stage();
                        Pane root = loader.load(Paths.get("src/main/java/View/PageOfTeach.fxml").toUri().toURL());
                        Firstpage.setTitle("Menu page");
                        Firstpage.setScene(new Scene(root, 872, 822));
                        Firstpage.setResizable(false);
                        Firstpage.show();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void gotoback(ActionEvent event){
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
