package com.leszeknowinski.App;

public class UserData {

    private static UserData userData = null;
    private String usernameMemory;
    private String userTypeMemory;

    private UserData(){}

    public static UserData getInstance(){
        if(userData == null){
            userData = new UserData();
        }
        return userData;
    }

    public String getUsernameMemory() {
        return usernameMemory;
    }

    public void setUsernameMemory(String usernameMemory) {
        this.usernameMemory = usernameMemory;
    }

    public String getUserTypeMemory() {
        return userTypeMemory;
    }

    public void setUserTypeMemory(String userTypeMemory) {
        this.userTypeMemory = userTypeMemory;
    }


}
