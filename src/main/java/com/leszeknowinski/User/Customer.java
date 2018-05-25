package com.leszeknowinski.User;

public class Customer extends Admin {
    private String customerType;

    public Customer(String name, String surname, String pesel, String phone, String username, String password, String customerType) {
        super(name, surname, pesel, phone, username, password);
        this.customerType = customerType;
    }

    public Customer(int id, String name, String surname, String pesel, String phone,
                    String username, String password, String customerType) {
        super(id, name, surname, pesel, phone, username, password);
        this.customerType = customerType;
    }

    public Customer(UserDataWrapper userDataWrapper, String customerType) {
        super(userDataWrapper);
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Customer(){}

    @Override
    public String toString() {
        return "Customer: " + super.toString();
    }
}
