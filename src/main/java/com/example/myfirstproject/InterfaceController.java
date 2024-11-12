package com.example.myfirstproject;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.ListChangeListener;

public class InterfaceController {
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnEdit;
    @FXML
    private TableView<Person> tableAddressBook;
    @FXML
    private TextField txtSearch;
    @FXML
    private Label labelCount;
    @FXML
    private Button btnOtherLabs;
    @FXML
    private TableColumn<Person, String> columnPIP;
    @FXML
    private TableColumn<Person, String> columnPhone;
    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    @FXML
    void showDialog(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Edit.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            stage.setScene(scene);

            stage.setTitle("Редагування");
            stage.setMinHeight(600);
            stage.setMinWidth(600);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnAdd.getScene().getWindow());
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Метод для показу сповіщення про успішне видалення

    @FXML
    void handleDeleteButtonAction(ActionEvent event) {
        // Викликаємо метод для показу сповіщення
        showDeleteAlert();
    }
    private void showDeleteAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Видалення");

        alert.setContentText("Ви впевненні, що хочете видалити запис? ");

        if (alert.showAndWait().get() == null) {
            this.btnDelete.setText("No selection!");
        } else if (alert.showAndWait().get() == ButtonType.OK) {
            this.btnDelete.setText("Запис видалено!");
        } else if (alert.showAndWait().get() == ButtonType.CANCEL) {
            this.btnDelete.setText("Відмінено!");
        } else {
            this.btnDelete.setText("-");
        }
    }

    @FXML
    void choosePage(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/myfirstproject/otherLabs.fxml"));

        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            stage.setScene(scene);

            stage.setTitle("Інші практичні");
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        columnPIP.setCellValueFactory(new PropertyValueFactory<Person, String>("PIP"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("Phone"));

        // Додаємо слухача змін до списку
        addressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel1();
            }
        });

        // Заповнення тестовими даними
        addressBookImpl.fillTestData();
        tableAddressBook.setItems(addressBookImpl.getPersonList());

        // Оновлення лейблу з кількістю записів
        updateCountLabel1();
    }

    private void updateCountLabel1() {
        labelCount.setText("Кількість записів: " + addressBookImpl.getPersonList().size());
    }

}