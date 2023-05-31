package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class LoginRegController {

    @FXML
    private TextField loginUsernameTextField;
    @FXML
    private PasswordField loginPasswordPasswordField;

    @FXML
    public void login(ActionEvent event){
        try {
               String user = "nas";
               String pas = "123";

               if(loginUsernameTextField.getText().equals(user) && loginPasswordPasswordField.getText().equals(pas)){
                   Stage stage =new Stage();
                   FXMLLoader loader = new FXMLLoader();
                   ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
                   Stage Firstpage = new Stage();
                   Pane root = loader.load(Paths.get("src/main/java/View/PageReg.fxml").toUri().toURL());
                   Firstpage.setTitle("Login page");
                   Firstpage.setScene(new Scene(root,641,672));
                   Firstpage.setResizable(false);
                   Firstpage.show();
               }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
