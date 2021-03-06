package com.leszeknowinski.User;

public class Admin {
    private int id;
    private String name;
    private String surname;
    private String pesel;
    private String phone;
    private String username;
    private String password;

    public Admin(String name, String surname, String pesel, String phone, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public Admin(int id, String name, String surname, String pesel, String phone, String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public Admin() {
    }

    public String getPesel() {
        return pesel;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "id - " + id + ", name and surname - " + name + " " + surname +
                ", username - " + username + ".";

    }
}
