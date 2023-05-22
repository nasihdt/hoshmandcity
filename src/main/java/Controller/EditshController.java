package Controller;

//import Model.DAOshahrdar;
import Model.Data;
import Model.File;
import Model.Shahrdar;

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
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditshController {
      @FXML
      private TextField name;
      @FXML
      private TextField lastname;
      @FXML
      private TextField personely;
      @FXML
      private TextField salary;
      @FXML
      private TextField date;
      @FXML
      private TextField sabeghe;

      @FXML
      private TextField nameEdit;
      @FXML
      private TextField lasEdit;
      @FXML
      private TextField salarEdit;
      @FXML
      private TextField sabeghEdit;



      @FXML
      private TextField prs;
      @FXML
      private TextArea txtResult;
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
      private TableColumn<Shahrdar,String> name_column;
      @FXML
      private TableColumn<Shahrdar,String> las_column;
      @FXML
      private TableColumn<Shahrdar,String> prs_column;
      @FXML
      private TableColumn<Shahrdar, String> hire_column;
      @FXML
      private TableColumn<Shahrdar,String> salar_column;
      @FXML
      private TableColumn<Shahrdar,String> sabegh_column;
      @FXML
      private TableView<Shahrdar> table;
      static int number = 0;

      @FXML
      private void updatShahrdarinfo(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
            try {
                  String editname = nameEdit.getText();
                  String editlast = lasEdit.getText();
                  String editsalar = salarEdit.getText();
                  String editsabegh = sabeghEdit.getText();
                  int count = Integer.parseInt(sabeghe.getText()), sal = Integer.parseInt(salary.getText()), m, n,s;
                  m = sal * 5 * count;
                  n=m/100;
                  s = sal + n;
                  String sl = String.valueOf(s);
                  if(!Data.shahrdar.getName().equals(editname) || !Data.shahrdar.getLastname().equals(editlast) || !Data.shahrdar.getSalary().equals(editsalar) || !Data.shahrdar.getSabeghe().equals(editsabegh)){
                        Data.shahrdar.setName(editname);
                        Data.shahrdar.setLastname(editlast);
                        Data.shahrdar.setSalary(sl);
                        Data.shahrdar.setSabeghe(editsabegh);
                        //ShahrdarDAO.updateShinfo(prs.getText(),editname,editlast,editsalar,editsabegh);
                        //File.writeshahrdar("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\1.Shahrdar");
                        txtResult.setText("information is updated.\n"+Data.shahrdar.getName()+"\n"+Data.shahrdar.getLastname()+"\n"+sl+"\n"+Data.shahrdar.getSabeghe());
                        table.refresh();


                  }
            }
            catch (Exception e){
                  txtResult.setText("Problem occurred while inserting employee " + e);
                  throw e;
            }

      }

      @FXML
      private void insertShahrdar(ActionEvent actionEvent){

            number ++;
            Dialog<String> dialog = new Dialog<>();
            if(name.getText().isEmpty() || lastname.getText().isEmpty() ||personely.getText().isEmpty() || salary.getText().isEmpty()|| sabeghe.getText().isEmpty() || date.getText().isEmpty()){
                  dialog.setTitle("Dialog box");
                  ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                  dialog.setContentText("You should first write information.");
                  dialog.getDialogPane().getButtonTypes().add(type);
                  dialog.showAndWait();
            }
            else {
                  if (number == 1) {
                        try {
                              int count = Integer.parseInt(sabeghe.getText()), sal = Integer.parseInt(salary.getText()), m, n,s;
                              m = sal * 5 * count;
                              n=m/100;
                              s = sal + n;
                              String sl = String.valueOf(s);
                              if(regexdate() && regexprs()) {

                                    Data.shahrdar = new Shahrdar(name.getText(), lastname.getText(), personely.getText(), date.getText(), sl.toString(), sabeghe.getText());

                                    //ShahrdarDAO.insertsh(name.getText(),lastname.getText(),personely.getText(),date.getText(),salary.getText(),sabeghe.getText());

                                    txtResult.setText("Shahrdar inserted! \n" + name.getText() + "\n" + lastname.getText() + "\n" + personely.getText() + "\n" + date.getText() + "\n" + sl.toString() + "\n" + sabeghe.getText());

                                    name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                                    las_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                                    prs_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
                                    hire_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
                                    salar_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
                                    sabegh_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));

                                    table.getItems().add(Data.shahrdar);
                                   File.writeshahrdar("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\1.Shahrdar");

                              }
                              else if (!regexdate()){
                                    dialog.setTitle("Dialog box");
                                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                                    dialog.setContentText("The date that you write it is not correct.");
                                    dialog.getDialogPane().getButtonTypes().add(type);
                                    dialog.showAndWait();
                              }
                              else if(!regexprs()){
                                    dialog.setTitle("Dialog box");
                                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                                    dialog.setContentText("The personely that you write it is not correct.");
                                    dialog.getDialogPane().getButtonTypes().add(type);
                                    dialog.showAndWait();
                              }

                        } catch (Exception e) {
                              txtResult.setText("Problem occurred while inserting employee " + e);
                              throw e;
                        }


                  }
                  else if (number>1){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("There should be only one mayor.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                  }
            }
      }
      public boolean regexdate(){
            String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(date.getText());
            return matcher.matches();
      }
      public boolean regexprs(){
            String regex = "^(?:-(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))|(?:0|(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))))(?:.\\d+|)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(personely.getText());
            return matcher.matches();
      }


      @FXML
      private void deletesh(ActionEvent actionEvent){
             try {
                   Dialog<String> dialog = new Dialog<>();
                   String chooseprs = prs.getText();
                   if (chooseprs.equals(Data.shahrdar.getPersonelynumber())){
                           table.getItems().remove(Data.shahrdar);
                           //ShahrdarDAO.deleteshwithprs(prs.getText());
                           txtResult.setText("Informations are deleted.");
                   }
                   //File.writeshahrdar("C:\\Users\\Asus\\IdeaProjects\\hoshmandcity\\src\\main\\java\\Model\\1.Shahrdar");
//                   else if(!chooseprs.equals(Data.shahrdar.getPersonelynumber())){
//                         dialog.setTitle("Dialog box");
//                         ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
//                         dialog.setContentText("This number is not exist.");
//                         dialog.getDialogPane().getButtonTypes().add(type);
//                         dialog.showAndWait();
//                   }
             }
             catch (Exception e){
                   txtResult.setText("Problem occurred while inserting employee " + e);

             }

      }

      @FXML
      private void gotomenupage(ActionEvent event) {
            try {

                  Stage stage =new Stage();
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