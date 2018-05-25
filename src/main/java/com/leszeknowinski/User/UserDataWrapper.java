package com.leszeknowinski.User;

import java.util.Scanner;

public class UserDataWrapper {
    String name;
    String surname;
    String pesel;
    String phone;
    String username;
    String password;



    public static UserDataWrapper readMainUserData(){
        UserDataWrapper udw = new UserDataWrapper();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        udw.name = scanner.nextLine();
        System.out.println("Enter your surname: ");
        udw.surname = scanner.nextLine();
        System.out.println("Enter your PESEL number: ");
        udw.pesel = scanner.nextLine();
        System.out.println("Enter phone number: ");
        udw.phone = scanner.nextLine();
        System.out.println("Enter your username: ");
        udw.username = scanner.nextLine();
        System.out.println("Enter your password: \n" +
                "--- It has to contain at least 8 characters including letters, numbers and special digits ---\n" +
                "-----------------------------------");
        udw.password = scanner.nextLine();
        return udw;
    }

}
