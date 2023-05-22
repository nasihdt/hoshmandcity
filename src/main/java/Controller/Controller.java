package Controller;

import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Controller {

    //public static  EnteredController controller = new EnteredController();
    @FXML
    public static User user = new User();
    @FXML

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
    private Button btn_login;

    @FXML
    public void handleCloseButtonAction(ActionEvent event){
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        }
    @FXML
    public void gotologin(ActionEvent event) throws IOException {
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

    }



