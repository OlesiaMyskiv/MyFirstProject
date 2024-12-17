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
    private Button butTwo;

    @FXML
    private Button butThree;

    @FXML
    private Button butFour;

    @FXML
    private Button butFive;

    @FXML
    private Button butSix;



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
    @FXML
    void choosePageThree(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/myfirstproject/otherLabsMenu.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            stage.setScene(scene);

            stage.setTitle("Інші практичні 3");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Помилка завантаження FXML: " + e.getMessage());
        }
    }
    @FXML
    void choosePageFour(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/myfirstproject/otherLabs2.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            stage.setScene(scene);

            stage.setTitle("Інші практичні 4");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void choosePageFive(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/myfirstproject/otherLabs5.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            stage.setScene(scene);

            stage.setTitle("Інші практичні 5");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void choosePageSix(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/myfirstproject/otherLabs5.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 300);
            stage.setScene(scene);

            stage.setTitle("Інші практичні 6");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
