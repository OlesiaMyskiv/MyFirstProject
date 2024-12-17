package com.example.myfirstproject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CollectionAddressBook implements AddressBook {
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void edit(Person editedPerson) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getPhone().equals(editedPerson.getPhone())) {
                personList.set(i, editedPerson);
                break;
            }
        }
    }

    public void delete(Person person) {
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void print() {
        int number = 0;
        System.out.println();
        for (Person person : personList) {
            number++;
            System.out.println(number + ") ПІП: " + person.getPip() + "; Телефон: " +
                    person.getPhone());
        }
    }

    public void fillTestData() {
        personList.add(new Person("Olesia", "0988140192"));

    }
}
