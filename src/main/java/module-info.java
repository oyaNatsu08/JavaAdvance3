module com.example.javaadvance3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaadvance3 to javafx.fxml;
    exports com.example.javaadvance3;
}