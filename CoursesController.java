package Controller;

import Model.Course;
import Model.Data;
import Model.Meetings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoursesController {
    @FXML
    private TextField instructor;
    @FXML
    private TextField coursecode;
    @FXML
    private TextField numbermeet;
    @FXML
    private TextField time;
    @FXML
    private TextField date;
    @FXML
    private TextField coursename;
    @FXML
    private TextField coursefee;

    @FXML
    private TableView table1;

    @FXML
    private TextField delete_code;
    @FXML
    private TextArea txt_result;
    @FXML
    private ComboBox<String> courses;
    @FXML
    private TableColumn<String, Course> course_column;
    @FXML
    private TableColumn<String, Course> cucd_column;
    @FXML
    private TableColumn<String, Course> cuname_column;
    @FXML
    private TableColumn<String, Course> cufee_column;
    @FXML
    private TableColumn<String, Course> instructor_column;
    @FXML
    private TableColumn<String, Course> Educate_column;
    @FXML
    private TableColumn<String, Course> date_column;
    @FXML
    private TableColumn<String, Course> time_column;

    private File file;
    public static int num;
    public static String[] meetings = new String[100];
    static FileChooser fileChooser = new FileChooser();

    public static ArrayList<Meetings> meetlist = new ArrayList<>();


    private static String[] courselist = {"step1", "step2", "step3", "step4", "step5", "step6", "step8", "step9", "step10"};

    @FXML
    public void chooseFile(ActionEvent event) {
        Stage stage = new Stage();
        fileChooser.setTitle("Open file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All files", "*.*"));
         file = fileChooser.showOpenDialog(stage);
        if(file != null){
            txt_result.setText(file.getAbsolutePath() + "selected");
        }

    }
    public void initialize(){
      Listcourse();
    }
    public void Listcourse(){
        List<String> crslist = new ArrayList<>();
        for (String data: courselist) {
            crslist.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(crslist);
        courses.setItems(listData);

    }

    @FXML
    public void insertcourse(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();
        if(coursename.getText().isEmpty() || coursecode.getText().isEmpty() || coursefee.getText().isEmpty() || instructor.getText().isEmpty()){
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should first write information.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        else {
            try {
                 for(int n=0;n<courselist.length;n++) {
                     if (courses.getSelectionModel().isSelected(n)) {
                         if (regexdate() && regextime()) {

                             Data.course = new Course(coursecode.getText(), coursename.getText(), courselist[n],
                                     coursefee.getText(), instructor.getText(), meetlist);

                             Data.courseslist.add(Data.course);
                             for (int i = 0; i < Data.courseslist.size(); i++) {
                                 System.out.println(Data.courseslist.get(i).getCoursecode() + "-" + Data.courseslist.get(i).getCoursename() + "-" +
                                         Data.courseslist.get(i).getCoursesection() + "-" + Data.courseslist.get(i).getCoursefee()+"-"+Data.courseslist.get(i).meeti.get(i).getDatehold()
                                         +"-"+Data.courseslist.get(i).meeti.get(i).getClockhold()+"-"+Data.courseslist.get(i).meeti.get(i).getEducationalcontent());
//                                 for (int j = 0; j < num + 2; j += 3) {
//                                     System.out.println("Course " + (i + 1) + " :" + Data.courseslist.get(i).meetings[j].toString() + "-" + Data.courseslist.get(i).meetings[j + 1].toString() + "-" +
//                                             Data.courseslist.get(i).meetings[j + 2].toString());
//                                 }

                             }

                             course_column.setCellValueFactory(new PropertyValueFactory<>("coursesection"));
                             cuname_column.setCellValueFactory(new PropertyValueFactory<>("coursename"));
                             cucd_column.setCellValueFactory(new PropertyValueFactory<>("coursecode"));
                             cufee_column.setCellValueFactory(new PropertyValueFactory<>("coursefee"));
                             instructor_column.setCellValueFactory(new PropertyValueFactory<>("courseinstructor"));
//                        date_column.setCellValueFactory(new PropertyValueFactory<>("datehold"));
//                        time_column.setCellValueFactory(new PropertyValueFactory<>("clockhold"));
                             Educate_column.setCellValueFactory(new PropertyValueFactory<>("meetings"));
                             table1.getItems().add(Data.course);
                         } else if (!regextime() && !regexdate()) {
                             dialog.setTitle("Dialog box");
                             ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                             dialog.setContentText("time and date are not correct.");
                             dialog.getDialogPane().getButtonTypes().add(type);
                             dialog.showAndWait();

                         } else if (!regexdate()) {
                             dialog.setTitle("Dialog box");
                             ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                             dialog.setContentText(" date in not correct.");
                             dialog.getDialogPane().getButtonTypes().add(type);
                             dialog.showAndWait();
                         } else if (!regextime()) {
                             dialog.setTitle("Dialog box");
                             ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                             dialog.setContentText("time in not correct.");
                             dialog.getDialogPane().getButtonTypes().add(type);
                             dialog.showAndWait();
                         }

                     }
                 }


            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void updatecourses(ActionEvent event){
        try {
            String newname= coursename.getText();
            String newfee = coursefee.getText();
            String newinstructor = instructor.getText();
            if(courses.getSelectionModel().isSelected(0)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[0]);
                        table1.refresh();
                    }
                }
            }
            else if(courses.getSelectionModel().isSelected(1)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[1]);
                        table1.refresh();
                    }
                }
            }
            else if(courses.getSelectionModel().isSelected(2)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[2]);
                        table1.refresh();
                    }
                }
            }
            else if(courses.getSelectionModel().isSelected(3)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[3]);
                        table1.refresh();
                    }
                }
            }
            else if(courses.getSelectionModel().isSelected(4)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[4]);
                        table1.refresh();
                    }
                }
            }
            else if(courses.getSelectionModel().isSelected(5)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[5]);
                        table1.refresh();
                    }
                }
            }
            else if(courses.getSelectionModel().isSelected(6)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[6]);
                        table1.refresh();
                    }
                }
            }
            else if(courses.getSelectionModel().isSelected(7)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[7]);
                        table1.refresh();
                    }
                }
            }
            else if(courses.getSelectionModel().isSelected(8)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[8]);
                        table1.refresh();
                    }
                }
            }
            else if(courses.getSelectionModel().isSelected(9)){
                for(int i=0;i<Data.courseslist.size();i++){
                    if(coursecode.getText().equals(Data.courseslist.get(i).getCoursecode())){
                        Data.courseslist.get(i).setCoursename(newname);
                        Data.courseslist.get(i).setCoursefee(newfee);
                        Data.courseslist.get(i).setCourseinstructor(newinstructor);
                        Data.courseslist.get(i).setCoursesection(courselist[9]);
                        table1.refresh();
                    }
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void Deletecourses(ActionEvent event){
        try {
            Dialog<String> dialog = new Dialog<>();
            for (int i = 0; i < Data.courseslist.size(); i++) {
                if (delete_code.getText().equals(Data.courseslist.get(i).getCoursecode())) {
                    table1.getItems().remove(Data.courseslist.get(i));
                    Data.courseslist.remove(i);

                }
                else if (!delete_code.getText().equals(Data.courseslist.get(i).getCoursecode())) {
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
            Firstpage.setTitle("Login page");
            Firstpage.setScene(new Scene(root,641,672));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void clickbtnmeet(ActionEvent event){
//            num = Integer.parseInt(numbermeet.getText());
//            meetings[num] = file.getAbsolutePath();
//            meetings[num + 1] = time.getText();
//            meetings[num + 2] = date.getText();

            meetlist.add(new Meetings(date.getText(),time.getText(),file.getAbsolutePath(),numbermeet.getText()));

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

}
