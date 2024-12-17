package com.example.myfirstproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml")); // Використовуємо fxmlLoader
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Адресна книга");
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);

        // Додавання CSS-стилів
        primaryStage.getScene().getStylesheets().add(getClass().getResource("/com/example/myfirstproject/my.css").toExternalForm());

        primaryStage.show(); // Показуємо головне вікно
        testData();
    }
    private void testData() {
        CollectionAddressBook addressBook = new CollectionAddressBook();
        addressBook.fillTestData();
        addressBook.print();
    }

    public static void main(String[] args) {
        launch();
    }


}