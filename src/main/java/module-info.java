module com.example.jay_bank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jay_bank to javafx.fxml;
    exports com.example.jay_bank;
}