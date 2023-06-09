package Controller;

import Model.Coursecode;
import Model.Data;
import Model.Teacher;
//import com.sun.javafx.charts.Legend;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditTeachController{

    @FXML
    private TextField name;
    @FXML
    private TextField lsname;
    @FXML
    private TextField nationalnum;
    @FXML
    private TextField age;
    @FXML
    private TextField phonenumber;
    @FXML
    private TextField cdregister;
    @FXML
    private TextField cdteacher;

    @FXML
    private CheckBox man_check;
    @FXML
    private CheckBox woman_check;
    @FXML
    private CheckBox lis_check;
    @FXML
    private CheckBox fogh_check;
    @FXML
    private CheckBox doc_check;


    @FXML
    private TextField address;
    @FXML
    private TextField cd_delete;
    @FXML
    private TextField courcode;
    @FXML
    private TextField numbercode;


    @FXML
    private Button btn_code;
    @FXML
    private TableView table;

    @FXML
    private TableColumn<String, Teacher> name_column;
    @FXML
    private TableColumn<String, Teacher> lsname_column;
    @FXML
    private TableColumn<String, Teacher> national_column;
    @FXML
    private TableColumn<String, Teacher> age_column;
    @FXML
    private TableColumn<String, Teacher> gender_column;
    @FXML
    private TableColumn<String, Teacher> phone_column;
    @FXML
    private TableColumn<String, Teacher> cdteach_column;
    @FXML
    private TableColumn<String, Teacher> course_column;
    @FXML
    private TableColumn<String, Teacher> cdreg_column;
    @FXML
    private TableColumn<String, Teacher> educ_column;
    @FXML
    private TableColumn<String, Teacher> address_column;

    public static int num;
    public static String coursecode [] = new String[100];
    static ArrayList<Coursecode> coursecodes1 = new ArrayList<>();
    //public static ArrayList<Teacher> course1 = new ArrayList<>();
    @FXML
    public void insertteacher(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();

        if (name.getText().isEmpty() || lsname.getText().isEmpty() || nationalnum.getText().isEmpty() || age.getText().isEmpty() || phonenumber.getText().isEmpty() || cdregister.getText().isEmpty() || cdteacher.getText().isEmpty() || address.getText().isEmpty()) {
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should fill blanks.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else {
            try {

                if(man_check.isSelected() && lis_check.isSelected()){

                    if (regexforname() && regexfornationalnumber() && regexfornumbers() && regexforphone()) {
                        Data.teacher = new Teacher(name.getText(), lsname.getText(), nationalnum.getText(), age.getText(), "Man",
                                phonenumber.getText(), address.getText(), cdteacher.getText(), "Lisans", cdregister.getText(),coursecodes1);

                        Data.teacherlist.add(Data.teacher);
                        for (int i = 0; i < Data.teacherlist.size(); i++) {

                                System.out.println(Data.teacherlist.get(i).getName() + "-" + Data.teacherlist.get(i).getLastname() + "-" + Data.teacherlist.get(i).getNationalnumber() + "-" +
                                        Data.teacherlist.get(i).getAge() + "-" + "man" + "-" + Data.teacherlist.get(i).getPhonenumber() + "-" + Data.teacherlist.get(i).getAddress() + "-" +
                                        cdteacher.getText().toString() + "-" + "lisans" + "-" +
                                        Data.teacherlist.get(i).getRgcode() + "-" + Data.teacherlist.get(i).getCoursecod().get(i).getCode());

//                            for (int j = 0; j < num + 1; j++) {
//                                System.out.print("[" + Data.teacherlist.get(i).coursecode[j].toString() + "]");
//                            }
                        }
                        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                        lsname_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        national_column.setCellValueFactory(new PropertyValueFactory<>("nationalnumber"));
                        age_column.setCellValueFactory(new PropertyValueFactory<>("age"));
                        gender_column.setCellValueFactory(new PropertyValueFactory<>("gender"));
                        phone_column.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
                        cdteach_column.setCellValueFactory(new PropertyValueFactory<>("codeTeacher"));
                        educ_column.setCellValueFactory(new PropertyValueFactory<>("dgeducation"));
                        cdreg_column.setCellValueFactory(new PropertyValueFactory<>("Rgcode"));
                        course_column.setCellValueFactory(new PropertyValueFactory<>("coursecode"));
                        table.getItems().add(Data.teacher);
                    }
                    else if(!regexforname() && ! regexfornationalnumber() && !regexforphone() && !regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The data that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforname()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The name that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornationalnumber()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The nationalnumber that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforphone()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The phone that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write number for age.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                }
                else if(man_check.isSelected() && fogh_check.isSelected()){
                    if (regexforname() && regexfornationalnumber() && regexfornumbers() && regexforphone()) {
                        Data.teacher = new Teacher(name.getText(), lsname.getText(), nationalnum.getText(), age.getText(), "Man",
                                phonenumber.getText(), address.getText(), cdteacher.getText(), "Fogh_lisans", cdregister.getText(), coursecodes1);

                        Data.teacherlist.add(Data.teacher);
                        for (int i = 0; i < Data.teacherlist.size(); i++) {
                            System.out.println(Data.teacherlist.get(i).getName() + "-" + Data.teacherlist.get(i).getLastname() + "-" + Data.teacherlist.get(i).getNationalnumber() + "-" +
                                    Data.teacherlist.get(i).getAge() + "-" + "man" + "-" + Data.teacherlist.get(i).getPhonenumber() + "-" + address.getText().toString() + "-" +
                                    cdteacher.getText().toString() + "-" + "Foghlisans" + "-" +
                                    cdregister.getText().toString() + "-");

//                            for (int j = 0; j < num + 1; j++) {
//                                System.out.print("[" + Data.teacherlist.get(i).coursecode[j].toString() + "]");
//                            }
                        }
                        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                        lsname_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        national_column.setCellValueFactory(new PropertyValueFactory<>("nationalnumber"));
                        age_column.setCellValueFactory(new PropertyValueFactory<>("age"));
                        gender_column.setCellValueFactory(new PropertyValueFactory<>("gender"));
                        phone_column.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
                        cdteach_column.setCellValueFactory(new PropertyValueFactory<>("codeTeacher"));
                        educ_column.setCellValueFactory(new PropertyValueFactory<>("dgeducation"));
                        cdreg_column.setCellValueFactory(new PropertyValueFactory<>("Rgcode"));
                        course_column.setCellValueFactory(new PropertyValueFactory<>("coursecode"));
                        table.getItems().add(Data.teacher);
                    }
                    else if(!regexforname() && ! regexfornationalnumber() && !regexforphone() && !regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The data that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforname()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The name that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornationalnumber()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The nationalnumber that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforphone()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The phone that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write number for age.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                }
                else if(man_check.isSelected() && doc_check.isSelected()){
                    if (regexforname() && regexfornationalnumber() && regexfornumbers() && regexforphone()) {
                        Data.teacher = new Teacher(name.getText(), lsname.getText(), nationalnum.getText(), age.getText(), "Man",
                                phonenumber.getText(), address.getText(), cdteacher.getText(), "Doctora", cdregister.getText(), coursecodes1);

                        Data.teacherlist.add(Data.teacher);
                        for (int i = 0; i < Data.teacherlist.size(); i++) {
                            System.out.print(Data.teacherlist.get(i).getName() + "-" + Data.teacherlist.get(i).getLastname() + "-" + Data.teacherlist.get(i).getNationalnumber() + "-" +
                                    Data.teacherlist.get(i).getAge() + "-" + "man" + "-" + Data.teacherlist.get(i).getPhonenumber() + "-" + address.getText().toString() + "-" +
                                    cdteacher.getText().toString() + "-" + "Doctora" + "-" +
                                    cdregister.getText().toString() + "-");

//                            for (int j = 0; j < num + 1; j++) {
//                                System.out.print("[" + Data.teacherlist.get(i).coursecode[j].toString() + "]");
//                            }
                        }
                        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                        lsname_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        national_column.setCellValueFactory(new PropertyValueFactory<>("nationalnumber"));
                        age_column.setCellValueFactory(new PropertyValueFactory<>("age"));
                        gender_column.setCellValueFactory(new PropertyValueFactory<>("gender"));
                        phone_column.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
                        cdteach_column.setCellValueFactory(new PropertyValueFactory<>("codeTeacher"));
                        educ_column.setCellValueFactory(new PropertyValueFactory<>("dgeducation"));
                        cdreg_column.setCellValueFactory(new PropertyValueFactory<>("Rgcode"));
                        course_column.setCellValueFactory(new PropertyValueFactory<>("coursecode"));
                        table.getItems().add(Data.teacher);
                    }
                    else if(!regexforname() && ! regexfornationalnumber() && !regexforphone() && !regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The data that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforname()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The name that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornationalnumber()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The nationalnumber that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforphone()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The phone that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write number for age.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                }
                else if(woman_check.isSelected() && lis_check.isSelected()){
                    if (regexforname() && regexfornationalnumber() && regexfornumbers() && regexforphone()) {

                            Data.teacher = new Teacher(name.getText(), lsname.getText(), nationalnum.getText(), age.getText(), "Woman",
                                    phonenumber.getText(), address.getText(), cdteacher.getText(), "Lisans", cdregister.getText(),coursecodes1);
//
                        Data.teacherlist.add(Data.teacher);
                        for (int i = 0; i < Data.teacherlist.size(); i++) {
                            System.out.print(Data.teacherlist.get(i).getName() + "-" + Data.teacherlist.get(i).getLastname() + "-" + Data.teacherlist.get(i).getNationalnumber() + "-" +
                                    Data.teacherlist.get(i).getAge() + "-" + "woman" + "-" + Data.teacherlist.get(i).getPhonenumber() + "-" + address.getText().toString() + "-" +
                                    cdteacher.getText().toString() + "-" + "lisans" + "-" +
                                    cdregister.getText().toString() + "-");

//                           for (int j = 0; j < num+1 ; j++) {
//                                System.out.print("[" + Data.teacherlist.get(i).coursecode[j].toString() + "]");
//                            }
                        }
                        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                        lsname_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        national_column.setCellValueFactory(new PropertyValueFactory<>("nationalnumber"));
                        age_column.setCellValueFactory(new PropertyValueFactory<>("age"));
                        gender_column.setCellValueFactory(new PropertyValueFactory<>("gender"));
                        phone_column.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
                        cdteach_column.setCellValueFactory(new PropertyValueFactory<>("codeTeacher"));
                        educ_column.setCellValueFactory(new PropertyValueFactory<>("dgeducation"));
                        cdreg_column.setCellValueFactory(new PropertyValueFactory<>("Rgcode"));
                        course_column.setCellValueFactory(new PropertyValueFactory<>("coursecode"));
                        table.getItems().add(Data.teacher);
                    }
                    else if(!regexforname() && ! regexfornationalnumber() && !regexforphone() && !regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The data that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforname()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The name that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornationalnumber()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The nationalnumber that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforphone()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The phone that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write number for age.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                }
                else if(woman_check.isSelected()&&fogh_check.isSelected()){
                    if (regexforname() && regexfornationalnumber() && regexfornumbers() && regexforphone()) {
                        Data.teacher = new Teacher(name.getText(), lsname.getText(), nationalnum.getText(), age.getText(), "Woman",
                                phonenumber.getText(), address.getText(), cdteacher.getText(), "Fogh_lisans", cdregister.getText(), coursecodes1);

                        Data.teacherlist.add(Data.teacher);
                        for (int i = 0; i < Data.teacherlist.size(); i++) {
                            System.out.print(Data.teacherlist.get(i).getName() + "-" + Data.teacherlist.get(i).getLastname() + "-" + Data.teacherlist.get(i).getNationalnumber() + "-" +
                                    Data.teacherlist.get(i).getAge() + "-" + "woman" + "-" + Data.teacherlist.get(i).getPhonenumber() + "-" + address.getText().toString() + "-" +
                                    cdteacher.getText().toString() + "-" + "foghlisans" + "-" +
                                    cdregister.getText().toString() + "-");

//                            for (int j = 0; j < num + 1; j++) {
//                                System.out.print("[" + Data.teacherlist.get(i).coursecode[j].toString() + "]");
//                            }
                        }
                        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                        lsname_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        national_column.setCellValueFactory(new PropertyValueFactory<>("nationalnumber"));
                        age_column.setCellValueFactory(new PropertyValueFactory<>("age"));
                        gender_column.setCellValueFactory(new PropertyValueFactory<>("gender"));
                        phone_column.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
                        cdteach_column.setCellValueFactory(new PropertyValueFactory<>("codeTeacher"));
                        educ_column.setCellValueFactory(new PropertyValueFactory<>("dgeducation"));
                        cdreg_column.setCellValueFactory(new PropertyValueFactory<>("Rgcode"));
                        course_column.setCellValueFactory(new PropertyValueFactory<>("coursecode"));
                        table.getItems().add(Data.teacher);

                    }
                    else if(!regexforname() && ! regexfornationalnumber() && !regexforphone() && !regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The data that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforname()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The name that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornationalnumber()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The nationalnumber that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforphone()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The phone that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write number for age.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                }
                else if(woman_check.isSelected()&& doc_check.isSelected()){
                    if (regexforname() && regexfornationalnumber() && regexfornumbers() && regexforphone()) {
                        Data.teacher = new Teacher(name.getText(), lsname.getText(), nationalnum.getText(), age.getText(), "Woman",
                                phonenumber.getText(), address.getText(), cdteacher.getText(), "Doctora", cdregister.getText(), coursecodes1);

                        Data.teacherlist.add(Data.teacher);
                        for (int i = 0; i < Data.teacherlist.size(); i++) {
                            System.out.print(Data.teacherlist.get(i).getName() + "-" + Data.teacherlist.get(i).getLastname() + "-" + Data.teacherlist.get(i).getNationalnumber() + "-" +
                                    Data.teacherlist.get(i).getAge() + "-" + "woman" + "-" + Data.teacherlist.get(i).getPhonenumber() + "-" + address.getText().toString() + "-" +
                                    cdteacher.getText().toString() + "-" + "doctora" + "-" +
                                    cdregister.getText().toString() + "-");

//                            for (int j = 0; j < num + 1; j++) {
//                                System.out.println("[" + Data.teacherlist.get(i).coursecode[j].toString() + "]");
//                            }
                        }
                        name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
                        lsname_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
                        national_column.setCellValueFactory(new PropertyValueFactory<>("nationalnumber"));
                        age_column.setCellValueFactory(new PropertyValueFactory<>("age"));
                        gender_column.setCellValueFactory(new PropertyValueFactory<>("gender"));
                        phone_column.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
                        address_column.setCellValueFactory(new PropertyValueFactory<>("address"));
                        cdteach_column.setCellValueFactory(new PropertyValueFactory<>("codeTeacher"));
                        educ_column.setCellValueFactory(new PropertyValueFactory<>("dgeducation"));
                        cdreg_column.setCellValueFactory(new PropertyValueFactory<>("Rgcode"));
                        course_column.setCellValueFactory(new PropertyValueFactory<>("coursecode"));
                        table.getItems().add(Data.teacher);
                    }
                    else if(!regexforname() && ! regexfornationalnumber() && !regexforphone() && !regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The data that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforname()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The name that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornationalnumber()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The nationalnumber that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexforphone()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("The phone that you write it is not correct.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumbers()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write number for age.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    @FXML
    public void pressbtncode(ActionEvent event){
        try {


//              int code = Integer.parseInt(numbercode.getText());
//                 num = code;
//                 coursecode[code] = courcode.getText();
                 coursecodes1.add(new Coursecode(courcode.getText()));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void updateTeacher(ActionEvent event){
        try {
             String newname = name.getText();
             String newlastname = lsname.getText();
             String newphone = phonenumber.getText();
             String newaddress = address.getText();

             if(man_check.isSelected() && lis_check.isSelected()){
                 for (int i=0;i<Data.teacherlist.size();i++){
                     if(cdteacher.getText().equals(Data.teacherlist.get(i).getCodeTeacher())){
                        Data.teacherlist.get(i).setName(newname);
                        Data.teacherlist.get(i).setLastname(newlastname);
                        Data.teacherlist.get(i).setPhonenumber(newphone);
                        Data.teacherlist.get(i).setAddress(newaddress);
                        Data.teacherlist.get(i).setGender("man");
                        Data.teacherlist.get(i).setDgeducation("lisans");
                        table.refresh();
                     }
                 }
                 for (int i=0;i<Data.teacherlist.size();i++){

                 System.out.println(Data.teacherlist.get(i).getName()+"-"+Data.teacherlist.get(i).getLastname());
                 }
             }
             else if(man_check.isSelected() && fogh_check.isSelected()){
                 for (int i=0;i<Data.teacherlist.size();i++){
                     if(cdteacher.getText().equals(Data.teacherlist.get(i).getCodeTeacher())){
                         Data.teacherlist.get(i).setName(newname);
                         Data.teacherlist.get(i).setLastname(newlastname);
                         Data.teacherlist.get(i).setPhonenumber(newphone);
                         Data.teacherlist.get(i).setAddress(newaddress);
                         Data.teacherlist.get(i).setGender("man");
                         Data.teacherlist.get(i).setDgeducation("fogh_lisans");
                         table.refresh();
                     }
                 }
             }
             else if(man_check.isSelected() && doc_check.isSelected()){
                 for (int i=0;i<Data.teacherlist.size();i++){
                     if(cdteacher.getText().equals(Data.teacherlist.get(i).getCodeTeacher())){
                         Data.teacherlist.get(i).setName(newname);
                         Data.teacherlist.get(i).setLastname(newlastname);
                         Data.teacherlist.get(i).setPhonenumber(newphone);
                         Data.teacherlist.get(i).setAddress(newaddress);
                         Data.teacherlist.get(i).setGender("man");
                         Data.teacherlist.get(i).setDgeducation("doctora");
                         table.refresh();
                     }
                 }
             }
             else if (woman_check.isSelected() && lis_check.isSelected()){
                 for (int i=0;i<Data.teacherlist.size();i++){
                     if(cdteacher.getText().equals(Data.teacherlist.get(i).getCodeTeacher())){
                         Data.teacherlist.get(i).setName(newname);
                         Data.teacherlist.get(i).setLastname(newlastname);
                         Data.teacherlist.get(i).setPhonenumber(newphone);
                         Data.teacherlist.get(i).setAddress(newaddress);
                         Data.teacherlist.get(i).setGender("woman");
                         Data.teacherlist.get(i).setDgeducation("lisans");
                         table.refresh();
                     }
                 }
             }
             else if(woman_check.isSelected() && fogh_check.isSelected()){
                 for (int i=0;i<Data.teacherlist.size();i++){
                     if(cdteacher.getText().equals(Data.teacherlist.get(i).getCodeTeacher())){
                         Data.teacherlist.get(i).setName(newname);
                         Data.teacherlist.get(i).setLastname(newlastname);
                         Data.teacherlist.get(i).setPhonenumber(newphone);
                         Data.teacherlist.get(i).setAddress(newaddress);
                         Data.teacherlist.get(i).setGender("woman");
                         Data.teacherlist.get(i).setDgeducation("fogh_lisans");
                         table.refresh();
                     }
                 }
             }
             else if(woman_check.isSelected() && doc_check.isSelected()){
                 for (int i=0;i<Data.teacherlist.size();i++){
                     if(cdteacher.getText().equals(Data.teacherlist.get(i).getCodeTeacher())){
                         Data.teacherlist.get(i).setName(newname);
                         Data.teacherlist.get(i).setLastname(newlastname);
                         Data.teacherlist.get(i).setPhonenumber(newphone);
                         Data.teacherlist.get(i).setAddress(newaddress);
                         Data.teacherlist.get(i).setGender("woman");
                         Data.teacherlist.get(i).setDgeducation("doctora");
                         table.refresh();
                     }
                 }
             }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    public void deleteTeacher(ActionEvent event) {
        try {
            Dialog<String> dialog = new Dialog<>();
            for (int i = 0; i < Data.teacherlist.size(); i++) {
                if (cd_delete.getText().equals(Data.teacherlist.get(i).getCodeTeacher())) {
                    table.getItems().remove(Data.teacherlist.get(i));
                    Data.teacherlist.remove(i);

                }
                else if (!cd_delete.getText().equals(Data.teacherlist.get(i).getCodeTeacher())) {
                    dialog.setTitle("Dialog box");
                    ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    dialog.setContentText("This number is not exist.");
                    dialog.getDialogPane().getButtonTypes().add(type);
                    dialog.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public boolean regexforphone(){
        String regex = "^0[0-9]{2,}[0-9]{7,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phonenumber.getText());
        return matcher.matches();
    }
    public boolean regexfornationalnumber(){
        String regex = "^([0-9]){10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nationalnum.getText());
        return matcher.matches();
    }
    public boolean regexforname(){
        String regex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name_column.getText());
        return matcher.matches();
    }
    public boolean regexfornumbers(){
        String regex = "([1-9]|[1-9][0-9]|[1-9][0-9][0-9]|1000)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(age.getText());
        return matcher.matches();
    }
}
