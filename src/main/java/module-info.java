module com.example.jay_bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.jay_bank to javafx.fxml;
    exports com.example.jay_bank;
    exports com.example.jay_bank.Controllers;
    exports com.example.jay_bank.Controllers.Admin;
    exports com.example.jay_bank.Controllers.Client;
    exports com.example.jay_bank.Models;
    exports com.example.jay_bank.Views;
}