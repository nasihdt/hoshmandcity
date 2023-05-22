module com.example.hoshmandcity {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.sql.rowset;

    opens com.example.hoshmandcity to javafx.fxml;
    exports com.example.hoshmandcity;
    exports Controller;
    opens Controller to javafx.fxml;
    exports Model;
    opens Model to javafx.fxml;
    exports View;

    opens View to javafx.fxml;

}