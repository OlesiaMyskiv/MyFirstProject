package com.example.myfirstproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditController {
    @FXML
    private TextField txtPIP;

    @FXML
    private Button btnOK;

    @FXML
    private Button cancel;

    @FXML
    private TextField txtPhone;

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;

        txtPIP.setText(person.getPip());
        txtPhone.setText(person.getPhone());
    }

    @FXML
    private void handleOkButtonAction() {
        if (!txtPIP.getText().isEmpty() && !txtPhone.getText().isEmpty()) {
            if (person == null) {
                person = new Person(txtPIP.getText(), txtPhone.getText());
            } else {
                person.setPip(txtPIP.getText());
                person.setPhone(txtPhone.getText());
            }
            closeDialog();
        } else {
            System.out.println("Виберіть ім'я або телефон");
        }
    }

    @FXML
    private void handleCancelButtonAction() {
        closeDialog();
    }

    private void closeDialog() {
        ((Stage) cancel.getScene().getWindow()).close();
    }
}