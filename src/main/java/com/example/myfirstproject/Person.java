package com.example.myfirstproject;

public class Person {
    private String PIP;

    private String Phone;

    public String getPIP() {
        return PIP;
    }

    public void setPIP(String PIP) {
        this.PIP = PIP;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


    public Person(String PIP, String phone) {
        this.PIP = PIP;
        Phone = phone;
    }


}
