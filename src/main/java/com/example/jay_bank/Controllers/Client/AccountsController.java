package com.example.jay_bank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountsController implements Initializable {
    public Label cur_acc_num;
    public Label transaction_limit;
    public Label cur_acc_date;
    public Label cur_acc_bal;
    public Label savings_acc_num;
    public Label withdrawal_limit;
    public Label sav_acc_date;
    public Label sav_acc_bal;
    public TextField amount_to_sav;
    public Button trans_to_sav_btn;
    public TextField amount_to_cur;
    public Button trans_to_cur_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
