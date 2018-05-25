package com.leszeknowinski.User;

public class Driver extends Admin {
    private String drivingLicence;
    private int experience;
    private boolean arrested;

    public Driver(String name, String surname, String pesel, String phone, String username,
                  String password, String drivingLicence, int experience, boolean arrested) {
        super(name, surname, pesel, phone, username, password);
        this.drivingLicence = drivingLicence;
        this.experience = experience;
        this.arrested = arrested;
    }

    public Driver(int id, String name, String surname, String pesel, String phone,
                  String username, String password, String drivingLicence, int experience, boolean arrested) {
        super(id, name, surname, pesel, phone, username, password);
        this.drivingLicence = drivingLicence;
        this.experience = experience;
        this.arrested = arrested;
    }

    public Driver(UserDataWrapper userDataWrapper, String drivingLicence, int experience, boolean arrested) {
        super(userDataWrapper);
        this.drivingLicence = drivingLicence;
        this.experience = experience;
        this.arrested = arrested;
    }

    public Driver(){}


    public boolean getArrested() {
        return arrested;
    }

    public void setArrested(boolean arrested) {
        this.arrested = arrested;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public int getExperience() {
        return experience;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return super.toString() + ", experience - " + experience + ", arrested - " + arrested + ".";
    }
}
