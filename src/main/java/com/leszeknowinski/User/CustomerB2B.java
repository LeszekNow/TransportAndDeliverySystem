package com.leszeknowinski.User;

public class CustomerB2B {
    private int id;
    private String company;
    private String nip;
    private String phone;
    private String username;
    private String password;
    private CustomerType customerType;

    public CustomerB2B(String company, String nip, String phone, String username, String password, CustomerType customerType){
        this.company = company;
        this.nip = nip;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.nip = nip;
        this.customerType = customerType;
    }

    public CustomerB2B(int id, String company, String nip, String phone, String username, String password, CustomerType customerType){
        this.id = id;
        this.company = company;
        this.nip = nip;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.nip = nip;
        this.customerType = customerType;
    }

    public CustomerB2B() {
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Company: " + company + ", phone number - " + phone + ", NIP - " + nip + ".";
    }
}
