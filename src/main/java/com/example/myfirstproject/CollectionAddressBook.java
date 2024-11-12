package com.example.myfirstproject;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

public class CollectionAddressBook implements AddressBook{
    private ObservableList<Person> personList = FXCollections.observableArrayList();
    @Override
    public void add(Person person) {

    }
    @Override
    public void update(Person person) {

    }
    @Override
    public void delete(Person person) {

    }
    public ObservableList<Person> getPersonList(){return personList;}
    public void print() {
        int number = 0;
        System.out.println();
        for (Person person : personList) {
            number++;
            System.out.println(number + ") ПІП: " + person.getPIP() + "; Телефон: " + person.getPhone());
        }
    }
    public void fillTestData(){
        personList.add(new Person("Olesia", "19191919"));
        personList.add(new Person("Vanessa", "22222222"));
        personList.add(new Person("Alʹona", "17171717"));
    }

}