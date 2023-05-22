package Controller;

import Model.Data;
import Model.Shahrdar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class SeeUserController {
    @FXML
    private TableView table_sh;
    @FXML
    private TableColumn<Shahrdar ,String> namesh_column;
    @FXML
    private TableColumn<Shahrdar ,String> lassh_column;
    @FXML
    private TableColumn<Shahrdar ,String> prssh_column;
    @FXML
    private TableColumn<Shahrdar ,String> datesh_column;
    @FXML
    private TableColumn<Shahrdar ,String> salarsh_column;
    @FXML
    private TableColumn<Shahrdar ,String> sabeghsh_column;

    @FXML
    private TableView table_assis;
    @FXML
    private TableColumn<Shahrdar ,String> nameas_column;
    @FXML
    private TableColumn<Shahrdar ,String> lasas_column;
    @FXML
    private TableColumn<Shahrdar ,String> prsas_column;
    @FXML
    private TableColumn<Shahrdar ,String> dateas_column;
    @FXML
    private TableColumn<Shahrdar ,String> salaras_column;
    @FXML
    private TableColumn<Shahrdar ,String> sabeghas_column;

    @FXML
    private TableView table_bz;
    @FXML
    private TableColumn<Shahrdar ,String> namebz_column;
    @FXML
    private TableColumn<Shahrdar ,String> lasbz_column;
    @FXML
    private TableColumn<Shahrdar ,String> prsbz_column;
    @FXML
    private TableColumn<Shahrdar ,String> datebz_column;
    @FXML
    private TableColumn<Shahrdar ,String> salarbz_column;
    @FXML
    private TableColumn<Shahrdar ,String> sabeghbz_column;
    @FXML
    private TableColumn<Shahrdar ,String> hourbz_column;

    @FXML
    private TableView table_emp;
    @FXML
    private TableColumn<Shahrdar ,String> nameemp_column;
    @FXML
    private TableColumn<Shahrdar ,String> lasemp_column;
    @FXML
    private TableColumn<Shahrdar ,String> prsemp_column;
    @FXML
    private TableColumn<Shahrdar ,String> dateemp_column;
    @FXML
    private TableColumn<Shahrdar ,String> salaremp_column;
    @FXML
    private TableColumn<Shahrdar ,String> sabeghemp_column;
    @FXML
    private TableColumn<Shahrdar ,String> houremp_column;

    @FXML
    private TableView table_hs;
    @FXML
    private TableColumn<Shahrdar ,String> namehs_column;
    @FXML
    private TableColumn<Shahrdar ,String> lashs_column;
    @FXML
    private TableColumn<Shahrdar ,String> prshs_column;
    @FXML
    private TableColumn<Shahrdar ,String> datehs_column;
    @FXML
    private TableColumn<Shahrdar ,String> salarhs_column;
    @FXML
    private TableColumn<Shahrdar ,String> sabeghhs_column;
    @FXML
    private TableColumn<Shahrdar ,String> numshifths_column;
    @FXML
    private TableColumn<Shahrdar ,String> shifths_column;


    @FXML
    public void seeusers(ActionEvent event){
        try {

        namesh_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        lassh_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        prssh_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
        datesh_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
        salarsh_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
        sabeghsh_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));
        table_sh.getItems().add(Data.shahrdar);


        nameas_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        lasas_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        prsas_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
        dateas_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
        salaras_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
        sabeghas_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));

        for (int i=0;i<Data.assislist.size();i++){
            table_assis.getItems().add(Data.assislist.get(i));
        }


        namebz_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        lasbz_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        prsbz_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
        datebz_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
        salarbz_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
        sabeghbz_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));
        hourbz_column.setCellValueFactory(new PropertyValueFactory<>("workhour"));
            for (int i=0;i<Data.bazraslist.size();i++){
                table_bz.getItems().add(Data.bazraslist.get(i));
            }

        nameemp_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        lasemp_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        prsemp_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
        dateemp_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
        salaremp_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
        sabeghemp_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));
        houremp_column.setCellValueFactory(new PropertyValueFactory<>("workhour"));
            for (int i=0;i<Data.emplist.size();i++){
                table_emp.getItems().add(Data.emplist.get(i));
            }

        namehs_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        lashs_column.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        prshs_column.setCellValueFactory(new PropertyValueFactory<>("personelynumber"));
        datehs_column.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
        salarhs_column.setCellValueFactory(new PropertyValueFactory<>("salary"));
        sabeghhs_column.setCellValueFactory(new PropertyValueFactory<>("sabeghe"));
        numshifths_column.setCellValueFactory(new PropertyValueFactory<>("numberofshift"));
        shifths_column.setCellValueFactory(new PropertyValueFactory<>("datatypeshift"));
            for (int i=0;i< Data.herasatlist.size();i++){
                table_hs.getItems().add(Data.herasatlist.get(i));
            }


        }
        catch (Exception e){

            throw e;
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
            Firstpage.setTitle("Login page");
            Firstpage.setScene(new Scene(root,700,600));
            Firstpage.setResizable(false);
            Firstpage.show();
        }
        catch (Exception e){
            e.fillInStackTrace();
        }
    }
}
