package com.leszeknowinski.Cargo;

import java.util.ArrayList;

public class CargoRepository {
    static ArrayList<Cargo> cargoList = new ArrayList<Cargo>();

    public static void showCargo() {
        for (Cargo cargo : cargoList) {
            System.out.println(cargo.toString());
        }
    }
}
