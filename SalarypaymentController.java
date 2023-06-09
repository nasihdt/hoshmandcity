package Controller;

import Model.Data;
import Model.Salary;
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

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalarypaymentController {
    @FXML
    private TextField code_payment;
    @FXML
    private TextField amount;
    @FXML
    private TextField date;
    @FXML
    private TextField time;
    @FXML
    private TextField madrascode;

    @FXML
    private ComboBox<String> combo_type;
    @FXML
    private ComboBox<String> combo_banknm;

    @FXML
    private TextArea txt_recid;
    @FXML
    private TableView table;

    @FXML
    private TableColumn<String, Salary> paymentcd_column;
    @FXML
    private TableColumn<String, Salary> amount_column;
    @FXML
    private TableColumn<String, Salary> type_column;
    @FXML
    private TableColumn<String, Salary> name_column;
    @FXML
    private TableColumn<String, Salary> date_column;
    @FXML
    private TableColumn<String, Salary> time_column;
    @FXML
    private TableColumn<String, Salary> madrascd_column;

    public  static String [] paymenttypelist = {"Online","In person"};
    public  static  String [] banknamelist = {"Melli","Saderat","Keshavarzi","Ayandeh","Sepah"};

    public void initialize(){
        listnamebank();
        listtype();
    }
    public void listtype(){
        List<String> listtype = new ArrayList<>();
        for (String data: paymenttypelist) {
            listtype.add(data);
        }
        ObservableList list = FXCollections.observableArrayList(listtype);
        combo_type.setItems(list);
    }
    public void listnamebank(){
        List<String> listnamebank = new ArrayList<>();
        for (String data: banknamelist) {
            listnamebank.add(data);
        }
        ObservableList list = FXCollections.observableArrayList(listnamebank);
        combo_banknm.setItems(list);
    }


    @FXML
    public void payment(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();
        if(code_payment.getText().isEmpty() || amount.getText().isEmpty() || date.getText().isEmpty() || time.getText().isEmpty() || madrascode.getText().isEmpty()){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should first write information.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else {
            try {
                  for(int i=0;i<paymenttypelist.length;i++){
                      if(combo_type.getSelectionModel().isSelected(i)){

                          for(int j=0;j<banknamelist.length;j++){
                              if(combo_banknm.getSelectionModel().isSelected(j)) {
                                  if (regexdate() && regextime()){
                                    for (int n = 0; n < Data.teacherlist.size(); n++) {
                                      if (madrascode.getText().equals(Data.teacherlist.get(n).getCodeTeacher())) {
                                          Data.salaryTeach = new Salary(code_payment.getText(), amount.getText(), paymenttypelist[i], banknamelist[j], date.getText(), time.getText(), madrascode.getText());
                                          Data.salarylist.add(Data.salaryTeach);
                                          for (int k = 0; k < Data.salarylist.size(); k++) {
                                              System.out.println(Data.salarylist.get(k).getPaymentcode() + "-" + Data.salarylist.get(k).getAmount() + "-" + Data.salarylist.get(k).getPaymenttype() + "-" + Data
                                                      .salarylist.get(k).getDate() + "-" + Data.salarylist.get(k).getTime() + "-" + Data.salarylist.get(k).getBankname() + "-" + Data.salarylist.get(k).getMadrascode());
                                          }
                                          paymentcd_column.setCellValueFactory(new PropertyValueFactory<>("Paymentcode"));
                                          amount_column.setCellValueFactory(new PropertyValueFactory<>("Amount"));
                                          type_column.setCellValueFactory(new PropertyValueFactory<>("paymenttype"));
                                          name_column.setCellValueFactory(new PropertyValueFactory<>("Bankname"));
                                          date_column.setCellValueFactory(new PropertyValueFactory<>("Date"));
                                          time_column.setCellValueFactory(new PropertyValueFactory<>("Time"));
                                          madrascd_column.setCellValueFactory(new PropertyValueFactory<>("Madrascode"));
                                          table.getItems().add(Data.salaryTeach);
                                          txt_recid.setText(banknamelist[j] + "\n" + "*mission accomplished.*" + "\n" + "Teacher" + madrascode.getText() + "salary was paid." + "\n" + "Date :" + date.getText() + "\n" +
                                                  "Time :" + time.getText() + "\n" + "Amount :" + amount.getText());
                                      }
                                    }

                                  }
                                  else if(!regextime() && !regexdate()){
                                      dialog.setTitle("Dialog box");
                                      ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                                      dialog.setContentText("time and date are not correct.");
                                      dialog.getDialogPane().getButtonTypes().add(type);
                                      dialog.showAndWait();
                                  }
                                  else if(!regexdate()){
                                      dialog.setTitle("Dialog box");
                                      ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                                      dialog.setContentText("date is not correct.");
                                      dialog.getDialogPane().getButtonTypes().add(type);
                                      dialog.showAndWait();
                                  }
                                  else if(!regextime()){
                                      dialog.setTitle("Dialog box");
                                      ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                                      dialog.setContentText("time is not correct.");
                                      dialog.getDialogPane().getButtonTypes().add(type);
                                      dialog.showAndWait();
                                  }

                              }
                          }

                      }
                  }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public boolean regexdate(){
        String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date.getText());
        return matcher.matches();
    }
    public boolean regextime(){
        String regex = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(time.getText());
        return matcher.matches();
    }
    @FXML
    public void gotobackmenuReg(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/PageReg.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,641,672));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
