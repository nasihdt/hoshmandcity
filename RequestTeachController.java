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
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RequestTeachController {

    @FXML
    private TextField name;
    @FXML
    private TextField yourname;
    @FXML
    private TextField code;
    @FXML
    private TextField fee;
    @FXML
    private TextField date;
    @FXML
    private TextField time;
    @FXML
    private ComboBox<String> course_combo;
    @FXML
    private TextField numbermeet;

    @FXML
    private TextArea txt1;
    @FXML
    private TextArea txt2;

    static int count=0;
    static int num;
    static FileChooser fileChooser = new FileChooser();
    private File file;
    private String[] courselist = {"step1", "step2", "step3", "step4", "step5", "step6", "step8", "step9", "step10"};
    public static String[] meetings = new String[100];
    public static ArrayList<Meetings> meet = new ArrayList<>();
    public void initialize(){
        Listcourse();
    }
    public void Listcourse(){
        List<String> crslist = new ArrayList<>();
        for (String data: courselist) {
            crslist.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(crslist);
        course_combo.setItems(listData);

    }
    @FXML
    public void chooseFile(ActionEvent event) {
        Stage stage = new Stage();
        fileChooser.setTitle("Open file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All files", "*.*"));
        file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            txt1.setText(file.getAbsolutePath() + "selected");
        }
    }
    @FXML
    public void request(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();
        if (name.getText().isEmpty() || yourname.getText().isEmpty() || code.getText().isEmpty() || fee.getText().isEmpty() || date.getText().isEmpty()|| time.getText().isEmpty()) {
            dialog.setTitle("Dialog box");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("You should fill blanks.");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();

        }
        else {
            try {

                for(int i=0;i<courselist.length;i++) {
                    for (int n=0;n<Data.teacherlist.size();n++) {
                        if (regexdate() && regextime()) {
                            if (course_combo.getSelectionModel().isSelected(i)) {
                                if (Data.teacherlist.get(LoginControllerTeacher.num).getNationalnumber().equals(Data.teacherlist.get(n).getNationalnumber()))
                                    Data.request = new Course(code.getText(), name.getText(), courselist[i], fee.getText(), yourname.getText(), meet);
                                Data.requestcourseteacher.add(Data.request);

                                for (int j = 0; j < Data.requestcourseteacher.size(); j++) {
                                    System.out.println("\n");
                                    System.out.println(Data.requestcourseteacher.get(j).getCoursecode() + "-" + Data.requestcourseteacher.get(j).getCoursename() + "-" + Data.requestcourseteacher.get(j).getCoursesection() + "-" +
                                            Data.requestcourseteacher.get(j).getCoursefee() + "-" + Data.requestcourseteacher.get(j).getCourseinstructor()+"-"+Data.requestcourseteacher.get(j).getMeeti().get(i).getCodecourse());

//                                    for (int k = 0; k < num + 3; k += 3) {
//                                        System.out.println(Data.requestcourseteacher.get(j).meetings[k] + "-" + Data.requestcourseteacher.get(j).meetings[k + 1] + "-" + Data.requestcourseteacher.get(j).meetings[k + 2]
//                                        );
//                                    }
                                }
                                txt2.setText("Your request has been sent to the registrar.");
                            }
                    }
                    else if (!regextime() && !regexdate()) {
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
    public void gotobackmenuteach(ActionEvent event){
        try {

            Stage stage =new Stage();
            FXMLLoader loader = new FXMLLoader();
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            Stage Firstpage = new Stage();
            Pane root = loader.load(Paths.get("src/main/java/View/PageOfTeach.fxml").toUri().toURL());
            Firstpage.setTitle("Menu page");
            Firstpage.setScene(new Scene(root,872,822));
            Firstpage.setResizable(false);
            Firstpage.show();

        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
    @FXML
    public void clickbtnmeet(ActionEvent event){
        Dialog<String> dialog = new Dialog<>();

        for (int i=0;i<Data.courseslist.size();i++) {
            if (time.getText().equals(Data.courseslist.get(i).meetings[num + 1])) {
                dialog.setTitle("Dialog box");
                ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                dialog.setContentText("The time is repeated, you cannot apply again at this time." + "\n" + " Please enter another time.");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();

            }

        }
//                num = Integer.parseInt(numbermeet.getText());
//                meetings[num] = file.getAbsolutePath();
//                meetings[num + 1] = time.getText();
//                meetings[num + 2] = date.getText();
        meet.add(new Meetings(date.getText(),time.getText(),file.getAbsolutePath(),numbermeet.getText()));

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
