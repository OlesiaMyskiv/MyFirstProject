package com.example.myfirstproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EditController {
    @FXML
    private BorderPane rootPane; // Додайте ID до кореневого елемента BorderPane в FXML файлі.

    @FXML
    private TextField PIP;

    @FXML
    private TextField Phone;

    @FXML
    private Button buttOK;

    @FXML
    private Button buttСancel;


    public void initialize(URL location, ResourceBundle resources) {
        rootPane.getStylesheets().add(getClass().getResource("my.css").toExternalForm());
    }
}