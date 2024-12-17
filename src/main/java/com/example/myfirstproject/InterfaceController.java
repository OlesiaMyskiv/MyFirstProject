package com.example.myfirstproject;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.collections.ListChangeListener;

public class InterfaceController {
    final private CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button remove;

    @FXML
    private Button btnSearch;

    @FXML
    private Label labelCount;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableColumn<Person, String> columnNumber;

    @FXML
    private TableView<Person> tableAddressBook;

    @FXML
    private TextField textField;
    @FXML
    private Button btnOtherLabs;


    @FXML
    public void initialize(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("pip"));
        columnNumber.setCellValueFactory(new PropertyValueFactory<Person,String >("phone"));
        addressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });
        addressBookImpl.fillTestData();
        tableAddressBook.setItems(addressBookImpl.getPersonList());}

    private void updateCountLabel() {
        labelCount.setText("Кількість записів: " + addressBookImpl.getPersonList().size());
    }

    @FXML
    void openWindow(ActionEvent event) {
        try {
            Button clickedButton = (Button) event.getSource();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit.fxml"));
            Parent root = loader.load();

            EditController editController = loader.getController();

            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root));

            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());

            switch (clickedButton.getId()) {
                case "buttonAdd":
                    editController.setPerson(new Person("",""));

                    stage.setTitle("Додати контакт");
                    break;
                case "buttonEdit":
                    editController.setPerson((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                    stage.setTitle("Редагувати контакт");
                    break;
                case "remove":
                    addressBookImpl.delete((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                    return;
            }

            stage.showAndWait();

            Person newPerson = editController.getPerson();

            if (newPerson != null && clickedButton.getId().equals("buttonAdd")) {
                addressBookImpl.add(newPerson);
                tableAddressBook.setItems(addressBookImpl.getPersonList());
                updateCountLabel();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void openWindowEdit(ActionEvent event) {
        Person selectedPerson = tableAddressBook.getSelectionModel().getSelectedItem();

        if (selectedPerson != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit.fxml"));
                Parent root = loader.load();

                EditController editController = loader.getController();
                editController.setPerson(selectedPerson);

                Stage stage = new Stage();
                stage.setTitle("Редагувати контакт");
                stage.setResizable(false);
                stage.setScene(new Scene(root));

                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node) event.getSource()).getScene().getWindow());

                stage.showAndWait();

                tableAddressBook.setItems(addressBookImpl.getPersonList());
                updateCountLabel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Виберіть контакт для редагування ");
        }
    }

    @FXML
    public void deleteContact() {
        Person personToDelete = tableAddressBook.getSelectionModel().getSelectedItem();
        if (personToDelete != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Підтвердження видалення");
            alert.setHeaderText("Ви дійсно хочете видалити цей контакт?");
            alert.setContentText("Контакт: " + personToDelete.getPip() + ", " + personToDelete.getPhone());

            if (alert.showAndWait().get() == ButtonType.OK) {
                addressBookImpl.delete(personToDelete);
                tableAddressBook.setItems(addressBookImpl.getPersonList());
                updateCountLabel();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Помилка");
            alert.setHeaderText("Контакт не вибрано");
            alert.setContentText("Будь ласка, виберіть контакт для видалення.");
            alert.showAndWait();
        }
    }

    @FXML
    private void searchContact() {
        String query = textField.getText().toLowerCase();
        ObservableList<Person> searchResults = FXCollections.observableArrayList();

        for (Person person : addressBookImpl.getPersonList()) {
            if (person.getPip().toLowerCase().contains(query) || person.getPhone().toLowerCase().contains(query)) {
                searchResults.add(person);
            }
        }

        tableAddressBook.setItems(searchResults);

    }
    // Метод для відкриття нового вікна при натисканні кнопки
    public void choosePage(ActionEvent event) {
        try {
            // Завантажуємо FXML файл для лабораторних
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/myfirstproject/allLabs.fxml"));
            VBox otherLabsPage = loader.load();  // Використовуємо VBox, а не AnchorPane

            // Створюємо нову сцену з цією панеллю
            Scene scene = new Scene(otherLabsPage);

            // Створюємо нове вікно
            Stage newStage = new Stage();
            newStage.setTitle("Інші практичні");
            newStage.setScene(scene);

            // Показуємо нове вікно
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}