package com.leszeknowinski.User;

public class Customer extends Admin {
    private CustomerType customerType;

    public Customer(String name, String surname, String pesel, String phone, String username, String password, CustomerType customerType) {
        super(name, surname, pesel, phone, username, password);
        this.customerType = customerType;
    }

    public Customer(int id, String name, String surname, String pesel, String phone,
                    String username, String password, CustomerType customerType) {
        super(id, name, surname, pesel, phone, username, password);
        this.customerType = customerType;
    }

    public Customer(UserDataWrapper userDataWrapper, CustomerType customerType) {
        super(userDataWrapper);
        this.customerType = customerType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Customer(){}

    @Override
    public String toString() {
        return "Customer: " + super.toString();
    }
}
