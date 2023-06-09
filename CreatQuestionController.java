package Controller;

import Model.Answer;
import Model.Data;
import Model.Question;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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

public class CreatQuestionController {

    @FXML
    private TextArea txt;
    @FXML
    private TextField op1;
    @FXML
    private TextField op2;
    @FXML
    private TextField op3;
    @FXML
    private TextField op4;
    @FXML
    private TextField code;
    @FXML
    private TextField correct;
    @FXML
    private TableView table;
    @FXML
    private TableColumn<Question,String> ques_column;

    @FXML
    public void  Writequestionforstudent(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
       // Question question = new Question();
        Answer reply[] = new Answer[4];
        for (int i = 0; i < PageOfTeachController.courselist.length; i++) {
            if (PageOfTeachController.courselist[PageOfTeachController.num].equals(PageOfTeachController.courselist[i])) {
                if (code.getText().equals(Data.teacherlist.get(i).getCoursecod())) {
                    if (regexsentence() && regexfornumberop1() && regexfornumberop2() && regexfornumberop3() && regexfornumberop4() && regexfornumber()) {
                        if (correct.getText().equals(String.valueOf(1))) {

                            reply[0] = new Answer(op1.getText(), true);
                            reply[1] = new Answer(op2.getText(), false);
                            reply[2] = new Answer(op3.getText(), false);
                            reply[3] = new Answer(op4.getText(), false);

                        } else if (correct.getText().equals(String.valueOf(2))) {
                            reply[0] = new Answer(op1.getText(), false);
                            reply[1] = new Answer(op2.getText(), true);
                            reply[2] = new Answer(op3.getText(), false);
                            reply[3] = new Answer(op4.getText(), false);

                        } else if (correct.getText().equals(String.valueOf(3))) {
                            reply[0] = new Answer(op1.getText(), false);
                            reply[1] = new Answer(op2.getText(), false);
                            reply[2] = new Answer(op3.getText(), true);
                            reply[3] = new Answer(op4.getText(), false);

                        } else if (correct.getText().equals(String.valueOf(4))) {
                            reply[0] = new Answer(op1.getText(), false);
                            reply[1] = new Answer(op2.getText(), false);
                            reply[2] = new Answer(op3.getText(), false);
                            reply[3] = new Answer(op4.getText(), true);

                        }
                        Data.question = new Question(txt.getText(), reply, code.getText(), PageOfTeachController.courselist[i]);
                        Data.questionlist.add(Data.question);
                        ques_column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitlequestion()));
                        table.setItems(getdata());
                    }
                    else if(!regexsentence() && regexfornumberop1() && regexfornumberop2() && regexfornumberop3() && regexfornumberop4() && regexfornumber()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("All of information is not correct");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }

                    else if(!regexfornumber()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write number.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumberop1()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write a number for option1.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumberop2()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write a number for option2.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumberop3()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write a number for option3.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                    else if(!regexfornumberop4()){
                        dialog.setTitle("Dialog box");
                        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                        dialog.setContentText("You should write a number for option4.");
                        dialog.getDialogPane().getButtonTypes().add(type);
                        dialog.showAndWait();
                    }
                }
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

    public ObservableList<Question> getdata(){
        ObservableList<Question> list = FXCollections.observableArrayList();
        for(int i=0;i<Data.questionlist.size();i++){
            list.add(Data.questionlist.get(i));
        }
        return list;
    }
    public boolean regexsentence(){
        String regex = "^\\s+[a-zA-Z\\s]+[.?!]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt.getText());
        return matcher.matches();
    }
    public boolean regexfornumber(){
        String regex = "[0-9]{1,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code.getText());
        return matcher.matches();
    }
    public boolean regexfornumberop1(){
        String regex = "[0-9]{1,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(op1.getText());
        return matcher.matches();
    }
    public boolean regexfornumberop2(){
        String regex = "[0-9]{1,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(op2.getText());
        return matcher.matches();
    }
    public boolean regexfornumberop3(){
        String regex = "[0-9]{1,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(op3.getText());
        return matcher.matches();
    }
    public boolean regexfornumberop4(){
        String regex = "[0-9]{1,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(op4.getText());
        return matcher.matches();
    }

}
