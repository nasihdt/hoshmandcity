package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CtnHosController {
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField txtaddress;
    @FXML
    private TextArea txt_result;
    @FXML
    private TextField numemp;
    @FXML
    private TextField namebos;

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
    private TableView table;
    @FXML
    private TableColumn<Hospital,String> name_column;
    @FXML
    private TableColumn<Hospital,String> phone_column;
    @FXML
    private TableColumn<Hospital,String> address_column;
    @FXML
    private TableColumn<Hospital,String> namebos_column;
    @FXML
    private TableColumn<Hospital,String> numemp_column;

    @FXML
    public void insertHospital(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();
        try {

            if(name.getText().isEmpty() || phone.getText().isEmpty() || txtaddress.getText().isEmpty()){
                dialog.setTitle("Dialog box");
                ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("You should first write information.");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
            else {
                if ( regexforphone()) {
                    Data.hospital = new Hospital(name.getText(), phone.getText(), txtaddress.getText(), namebos.getText(), numemp.getText());
                    Data.hoslist.add(Data.hospital);
                    txt_result.setText("*A university was built.*\n" + "with the following information:\n" + name.getText() + "\n" + phone.getText() + "\n" + txtaddress.getText() + "\n" + namebos.getText() + "\n" + numemp.getText());
                    name_column.setCellValueFactory(new PropertyValueFactory<>("namePlace"));
                    phone_column.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                    address_column.setCellValueFactory(new PropertyValueFactory<>("addressPlace"));
                    namebos_column.setCellValueFactory(new PropertyValueFactory<>("namebos"));
                    numemp_column.setCellValueFactory(new PropertyValueFactory<>("numberofemp"));

                    table.getItems().add(Data.hospital);
                    File.writehost("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\4.Hospital",Data.hoslist);
                }
                else if(!regexforphone()){
                    dialog.setTitle("Dialog box");
                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    dialog.setContentText("!You should  write number for phonenumber!.");
                    dialog.getDialogPane().getButtonTypes().add(type);
                    dialog.showAndWait();
                }
//                else if(!regexfornumber()){
//                    dialog.setTitle("Dialog box");
//                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
//                    dialog.setContentText("!You should  write number for number of emp!.");
//                    dialog.getDialogPane().getButtonTypes().add(type);
//                    dialog.showAndWait();
//                }
//                else if(!regexforname()){
//                    dialog.setTitle("Dialog box");
//                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
//                    dialog.setContentText("!You should  write letters!.");
//                    dialog.getDialogPane().getButtonTypes().add(type);
//                    dialog.showAndWait();
//                }

            }
        }
        catch (Exception e){
            txt_result.setText("Problem occurred while inserting Univercity " + e);
            throw e;
        }

    }

    @FXML
    private  void backmenupage(ActionEvent event){
        try {

            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/Menupagesh.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page shahrdar");
            Firstpage.setScene(new Scene(root,610,621));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    public boolean regexforphone(){
        String regex = "^0[0-9]{2,}[0-9]{7,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone.getText());
        return matcher.matches();
    }
//    public boolean regexforname(){
//        String regex = "[a-zA-Z]";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(name.getText());
//        return matcher.matches();
//
//    }
//    public boolean regexfornumber(){
//        String regex = "[0-9]";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(numemp.getText());
//        return matcher.matches();
//    }




}
