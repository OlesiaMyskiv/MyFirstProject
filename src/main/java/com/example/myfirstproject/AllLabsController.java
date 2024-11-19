package com.example.myfirstproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AllLabsController {
    @FXML
    private Button butOne;

    @FXML
    private Button butThree;

    @FXML
    private Button butTwo;

    @FXML
    void choosePageOne(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/myfirstproject/otherLabs.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            stage.setScene(scene);

            stage.setTitle("Інші практичні 1");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void choosePageTwo(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/myfirstproject/otherLabs1.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 1000, 400);
            stage.setScene(scene);

            stage.setTitle("Інші практичні 2");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Помилка завантаження FXML: " + e.getMessage());
        }
    }


}
