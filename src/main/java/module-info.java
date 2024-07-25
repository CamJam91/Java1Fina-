module com.example.java1final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java1final to javafx.fxml;
    exports com.example.java1final;
}