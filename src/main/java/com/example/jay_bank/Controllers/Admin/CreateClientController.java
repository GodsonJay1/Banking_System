package com.example.jay_bank.Controllers.Admin;

import com.example.jay_bank.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {
    public TextField fname_field;
    public TextField lname_field;
    public PasswordField password_field;
    public CheckBox pAddress_box;
    public Label pAddress_lbl;
    public CheckBox cur_acc_box;
    public TextField cur_account_fld;
    public CheckBox sv_acc_box;
    public TextField sv_account_fld;
    public Button create_client_btn;
    public Label error_lbl;

    private String payeeAddress;
    private boolean createCurrentAccountFlag = false;
    private boolean createSavingsAccountFlag = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create_client_btn.setOnAction(event -> createClient());
        pAddress_box.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                payeeAddress = createPayeeAddress();
                onCreatePayeeAddress();
            }
        });
        cur_acc_box.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                createCurrentAccountFlag = true;
            }
        });
        sv_acc_box.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                createSavingsAccountFlag = true;
            }
        });
    }

    private void createClient() {
        // Create Current Account
        if (createCurrentAccountFlag) {
            createAccount("Current");
        }
        // Create Savings Account
        if (createSavingsAccountFlag) {
            createAccount("Savings");
        }
        // Create Client
        String fName = fname_field.getText();
        String lName = lname_field.getText();
        String password = password_field.getText();
        Model.getInstance().getDatabaseDriver().createClient(fName, lName, payeeAddress, password, LocalDate.now());
        error_lbl.setStyle("-fx-text-fill: blue; -fx-font-size: 1.3em; -fx-font-weight: bold;");
        error_lbl.setText("Client Created Successfully");
        emptyFields();
    }

    // Create Account Number
    private void createAccount(String accountType) {
        double balance = Double.parseDouble(cur_account_fld.getText());
        // Generate Account Number
        String firstSection = "3201";
        String lastSection = Integer.toString((new Random().nextInt(9999) + 1000));
        String accountNumber = firstSection + lastSection;
        // Create the Current and Savings Account
        if (accountType.equals("Current")) {
            Model.getInstance().getDatabaseDriver().createCurrentAccount(payeeAddress, accountNumber, 10, balance);
        } else {
            Model.getInstance().getDatabaseDriver().createSavingsAccount(payeeAddress, accountNumber, 2000, balance);
        }
    }

    private void onCreatePayeeAddress() {
        if (fname_field.getText() != null && lname_field.getText() != null) {
            pAddress_lbl.setText(payeeAddress);
        }
    }

    private String createPayeeAddress() {
        int id = Model.getInstance().getDatabaseDriver().getLastClientsId() + 1;
        char fChar = Character.toLowerCase(fname_field.getText().charAt(0));
        return "@"+fChar+lname_field.getText()+id;
    }

    private void emptyFields() {
        fname_field.setText("");
        lname_field.setText("");
        password_field.setText("");
        pAddress_box.setSelected(false);
        pAddress_lbl.setText("");
        cur_acc_box.setSelected(false);
        cur_account_fld.setText("");
        sv_acc_box.setSelected(false);
        sv_account_fld.setText("");

    }
}
