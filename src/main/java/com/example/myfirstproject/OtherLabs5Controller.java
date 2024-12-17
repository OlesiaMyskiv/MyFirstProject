package com.example.myfirstproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class OtherLabs5Controller {
    @FXML
    private Button pauseButton; // Кнопка Pause
    @FXML
    private MediaView mediaView; // Елемент для відображення відео
    @FXML
    private Button playButton; // Кнопка Play
    @FXML
    private Button resetButton; // Кнопка Reset

    private File file; // Об'єкт для відеофайлу
    private Media media; // Медійний контент
    private MediaPlayer mediaPlayer; // Програвач медіа

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Завантаження відеофайлу
        file = new File("/video.mp4"); // Ім'я вашого відеофайлу
        if (!file.exists()) {
            System.out.println("Відеофайл не знайдено! Перевірте розташування файлу.");
            return;
        }

        media = new Media(file.toURI().toString()); // Перетворення шляху файлу у URI
        mediaPlayer = new MediaPlayer(media); // Ініціалізація MediaPlayer
        mediaView.setMediaPlayer(mediaPlayer); // Прив'язка MediaPlayer до MediaView

        // Налаштування кнопок
        playButton.setOnAction(this::playButton_method);
        pauseButton.setOnAction(this::pauseButton_method);
        resetButton.setOnAction(this::resetButton_method);
    }

    @FXML
    void playButton_method(ActionEvent event) {
        mediaPlayer.play(); // Запуск відео
        System.out.println("Відео запущено.");
    }

    @FXML
    void pauseButton_method(ActionEvent event) {
        mediaPlayer.pause(); // Пауза
        System.out.println("Відео на паузі.");
    }

    @FXML
    void resetButton_method(ActionEvent event) {
        mediaPlayer.stop(); // Зупинка і перемотування
        mediaPlayer.seek(mediaPlayer.getStartTime());
        System.out.println("Відео скинуто до початку.");
    }
}