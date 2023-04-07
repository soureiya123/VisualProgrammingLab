module com.example.fourthsemester {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fourthsemester to javafx.fxml;
    exports com.example.fourthsemester;
}