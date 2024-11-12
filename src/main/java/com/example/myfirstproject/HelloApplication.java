package com.example.myfirstproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 600);

        scene.getStylesheets().add(getClass().getResource("/com/example/myfirstproject/my.css").toExternalForm());


        stage.setScene(scene);
        stage.show();
        testData();
    }
    private void testData(){
        CollectionAddressBook addressBook = new CollectionAddressBook();
        addressBook.fillTestData();
        addressBook.print();
    }
    public static void main(String[] args) {
        launch();
    }
}