package com.example.myfirstproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OtherLabsController {
    @FXML
    private ImageView imageView;
    @FXML
    private Button choose;
    @FXML
    private Label textWelcome;
    // Початкове зображення
    private Image image = new Image(getClass().getResourceAsStream("/com/example/myfirstproject/secondImage.jpg"));

    @FXML
    void changeLabel(ActionEvent event) {
        // Зміна зображення в ImageView
        imageView.setImage(image);
        // Зміна тексту на етикетці
        textWelcome.setText("Ви успішно змінили картинку!");

        // Вимкнення кнопки після натискання
        choose.setDisable(true);
        choose.setVisible(false);
    }

    @FXML
    private void initialize() {
        assert choose != null : "fx:id=\"choose\" was not injected: check your FXML file.";
        assert imageView != null : "fx:id=\"imageView\" was not injected: check your FXML file.";
    }

}
