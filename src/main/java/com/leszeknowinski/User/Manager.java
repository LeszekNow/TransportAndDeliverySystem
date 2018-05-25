package com.leszeknowinski.User;

public class Manager extends Admin{
    public Manager(String name, String surname, String pesel, String phone, String username, String password) {
        super(name, surname, pesel, phone, username, password);
    }

    public Manager(UserDataWrapper userDataWrapper) {
        super(userDataWrapper);
    }

    public Manager(int id, String name, String surname, String pesel, String phone, String username, String password) {
        super(id, name, surname, pesel, phone, username, password);
    }

    public Manager() {
    }

    @Override
    public String toString() {
        return "Manager: - " + super.toString();
    }
}
