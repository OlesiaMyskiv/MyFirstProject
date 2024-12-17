package com.example.myfirstproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;

public class OtherLabs6Controller {
    @FXML
    private Slider volume;
    @FXML
    private ProgressBar audioProgress;
    @FXML
    private Label label_audio;

    private ArrayList<File> songs;
    private Media media;
    private MediaPlayer mediaPlayer;
    private int songNumber = 0;

    @FXML
    public void initialize() {
        // Ініціалізація списку пісень
        songs = new ArrayList<>();

        // Завантаження файлів із директорії
        File directory = new File("01 Wonderful Life.m4p"); // Вкажіть реальний шлях до аудіофайлів
        File[] files = directory.listFiles();

        if (files != null) {
            for (File f : files) {
                songs.add(f);
                System.out.println("Завантажено: " + f.getName());
            }
        }

        // Ініціалізація першого медіафайлу, якщо список не порожній
        if (!songs.isEmpty()) {
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
        }

        // Додавання "слухача" для регулювання гучності
        volume.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                if (mediaPlayer != null) {
                    mediaPlayer.setVolume(volume.getValue() * 0.01);
                }
            }
        });
    }

    @FXML
    void play(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.play();
            label_audio.setText(songs.get(songNumber).getName());
        }
    }

    @FXML
    void pause(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            label_audio.setText(songs.get(songNumber).getName());
        }
    }

    @FXML
    void next(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        songNumber = (songNumber + 1) % songs.size();
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        label_audio.setText(songs.get(songNumber).getName());
        mediaPlayer.play();
    }

    @FXML
    void previous(ActionEvent event) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        songNumber = (songNumber - 1 + songs.size()) % songs.size();
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        label_audio.setText(songs.get(songNumber).getName());
        mediaPlayer.play();
    }
}
