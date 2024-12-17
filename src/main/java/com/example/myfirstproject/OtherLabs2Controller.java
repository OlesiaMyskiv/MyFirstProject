package com.example.myfirstproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OtherLabs2Controller {
    @FXML
    private Label dateLabel;
    @FXML
    private Label sliderLabel;
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private ColorPicker myColorPicker;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Slider mySlider;
    @FXML
    private Button chooseImageButton;
    @FXML
    private ImageView imgView;
    private int score; // Оголошення змінної


    @FXML
    void getDate (ActionEvent event){
        LocalDate myDate = myDatePicker.getValue();
        System.out.println(myDate.toString());
        String dateFormatter = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        dateLabel.setText(dateFormatter);
    }

    @FXML
    void changeColor(ActionEvent event) {
        Color myColor = myColorPicker.getValue(); // Колір із JavaFX
        scenePane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
    }

    public void initialize() {
        mySlider.valueProperty().addListener (new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                score = (int) mySlider.getValue();
                sliderLabel.setText(score + " балів");
            }
        });
    }
    @FXML
    void FileChooser(ActionEvent event) {
        // Створення FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Вибрати зображення");

        // Додаємо фільтр для зображень
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Зображення", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        // Отримуємо поточне вікно
        Stage stage = (Stage) scenePane.getScene().getWindow();

        // Відображаємо діалогове вікно
        File file = fileChooser.showOpenDialog(stage);

        // Завантажуємо зображення, якщо файл вибрано
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imgView.setImage(image); // Встановлюємо зображення у ImageView
        }
    }

}
