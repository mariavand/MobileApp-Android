package com.example.mobile_app.ui.vaccination;

public class Vaccination {

    //Declaring variables
    private String name;
    private String surname;
    private String amka;
    private String phone;
    private String email;
    private String date;
    private String time;

    //An empty constructor
    public Vaccination() {
    }

    //A constructor with all fields
    public Vaccination(String name, String surname, String amka, String phone, String email, String date, String time) {

        this.name = name;
        this.surname = surname;
        this.amka = amka;
        this.phone = phone;
        this.email = email;
        this.date = date;
        this.time = time;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
