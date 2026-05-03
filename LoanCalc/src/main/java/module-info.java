module com.example.loancalc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.loancalc to javafx.fxml;
    exports com.example.loancalc;
}