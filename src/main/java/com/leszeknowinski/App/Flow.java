//package com.leszeknowinski.App;
//
//import com.leszeknowinski.GPS.GeoHelper;
//import com.leszeknowinski.User.UserRepository;
//import com.leszeknowinski.Vehicle.VehicleHelper;
//import com.leszeknowinski.Vehicle.VehicleRepository;
//
//public class Flow {
//
//    public static void start() {
//        boolean exit = false;
//        do {
//            Menu.displayStartMenu();
//            switch (VehicleHelper.intScanner("Choice: ")) {
//                case 1:
//                    executeCustomerTypeChoose();
//                    break;
//                case 2:
//                    executeEmployeeTypeChoose();
//                    break;
//                case 3:
//                    exit = true;
//                    break;
//            }
//
//        } while (!exit);
//        System.exit(0);
//    }
//
//    public static void executeCustomerTypeChoose() {
//        Menu.displayCustomerTypeSelection();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                executeCustomerMenu();
//                break;
//            case 2:
//                executeCustomerB2BMenu();
//                break;
//            case 3:
//                //back
//                break;
//            case 4:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeEmployeeTypeChoose() {
//        Menu.displayEmployeeTypeSelection();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                executeAdminMenu();
//                break;
//            case 2:
//                executeDriverMenu();
//                break;
//            case 3:
//                executeManagerMenu();
//                break;
//            case 4:
//                //back
//                break;
//            case 5:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeCustomerMenu() {
//        boolean exit = false;
//        do {
//            Menu.displayCustomerMenu();
//            switch (VehicleHelper.intScanner("Choice: ")) {
//                case 1:
//                    LogIn.logIn("client");
//                    executeCustomerMainMenu("customer");
//                    break;
//                case 2:
//                    Registration.createCustomer();
//                    break;
//                case 3:
//                    //services
//                    break;
//                case 4:
//                    //prices
//                    break;
//                case 5:
//                    executeVehiclesShow();
//                    break;
//                case 6:
//                    //wróć
//                    break;
//                case 7:
//                    exit = true;
//                    break;
//            }
//        } while (!exit);
//        System.exit(0);
//    }
//
//    public static void executeCustomerB2BMenu() {
//        boolean exit = false;
//        do {
//            Menu.displayCustomerMenu();
//            switch (VehicleHelper.intScanner("Choice: ")) {
//                case 1:
//                    LogIn.logIn("client");
//                    executeCustomerMainMenu("customerb2b");
//                    break;
//                case 2:
//                    Registration.createB2BCustomer();
//                    break;
//                case 3:
//                    //usługi
//                    break;
//                case 4:
//                    //cennik
//                    break;
//                case 5:
//                    executeVehiclesShow();
//                    break;
//                case 6:
//                    //wróc
//                    break;
//                case 7:
//                    exit = true;
//                    break;
//            }
//        } while (!exit);
//        System.exit(0);
//    }
//
//    public static void executeDriverMenu() {
//        Menu.displayEmployeeMenu();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                LogIn.logIn("driver");
//                executeDriverMainMenu();
//                break;
//            case 2:
//                //Back
//            case 3:
//                System.exit(0);
//                break;
//
//        }
//    }
//
//    public static void executeAdminMenu() {
//        Menu.displayEmployeeMenu();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                LogIn.logIn("admin");
//                Menu.displayAdminAndManagerMainMenu();
//                executeAdminAndManagerMainMenu();
//                break;
//            case 2:
//                //back
//                break;
//            case 3:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeManagerMenu() {
//        Menu.displayEmployeeMenu();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                LogIn.logIn("manager");
//                executeAdminAndManagerMainMenu();
//                break;
//            case 2:
//                //Back
//                break;
//            case 3:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeCustomerMainMenu(String customerType) {
//        boolean exit = false;
//        do {
//            Menu.displayCustomerMainMenu();
//            switch (VehicleHelper.intScanner("Choice: ")) {
//                case 1:
//                    //new order
//                    //insertOrder
//                    //back info to a client
//                    break;
//                case 2:
//                    //delete order
//                    break;
//                case 3:
//                    //show terms
//                    break;
//                case 4:
//                    //edit order
//                    break;
//                case 5:
//                    Registration.deleteCustomerAccount(customerType);
//                    break;
//                case 6:
//                    exit = true;
//                    break;
//            }
//        } while (!exit);
//        System.exit(0);
//    }
//
//    public static void executeAdminAndManagerMainMenu() {
//        boolean exit = false;
//        do {
//            Menu.displayAdminAndManagerMainMenu();
//            switch (VehicleHelper.intScanner("Choice: ")) {
//                case 1:
//                    executeVehicleCreation();
//                    break;
//                case 2:
//                    executeEmployeeCreation();
//                    break;
//                case 3:
//                    executeVehicleRemoval();
//                    break;
//                case 4:
//                    executeEmployeeRemoval();
//                    break;
//                case 5:
//                    executeCustomerDisplay();
//                    break;
//                case 6:
//                    executeCustomerDisplayAndCustomerRemoval();
//                    break;
//                case 7:
//                    executeVehiclesShow();
//                    break;
//                case 8:
//
//                    break;
//                case 9:
//                    //delete location
//                    break;
//                case 10:
//                    //add route?
//                    break;
//                case 11:
//                    //delete route?
//                    break;
//                case 12:
//                    //calculations
//                    break;
//                case 13:
//                    //track vehicles
//                    break;
//                case 14:
//                    //Back
//                    break;
//                case 15:
//                    exit = true;
//                    break;
//            }
//        } while (!exit);
//        System.exit(0);
//    }
//
//    public static void executeDriverMainMenu() {
//        boolean exit = false;
//        do {
//            Menu.displayDriverMainMenu();
//            switch (VehicleHelper.intScanner("Choice: ")) {
//                case 1:
//                    //New order
//                    break;
//                case 2:
//                    //delete order
//                    break;
//                case 3:
//                    //show terms
//                    break;
//                case 4:
//                    //edit order
//                    break;
//                case 5:
//                    exit = true;
//                    break;
//            }
//        } while (!exit);
//        System.exit(0);
//    }
//
//    public static void executeEmployeeCreation() {
//        Menu.displayEmployeeTypeSelection();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                Registration.createAdmin();
//                break;
//            case 2:
//                Registration.createDriver();
//                break;
//            case 3:
//                Registration.createManager();
//                break;
//            case 4:
//                //back
//                break;
//            case 5:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeVehicleCreation() {
//        Menu.displayVehicleType();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                VehicleHelper.createBus();
//                break;
//            case 2:
//                VehicleHelper.createCarOrTruck("car");
//                break;
//            case 3:
//                VehicleHelper.createMotorcycle();
//                break;
//            case 4:
//                VehicleHelper.createCarOrTruck("truck");
//                break;
//            case 5:
//                VehicleHelper.createVan();
//                break;
//            case 6:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeCargoCreation() {
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                //com.leszeknowinski.Cargo.CargoHelper.createCargoAndAdjustVehicle();
//                break;
//            case 2:
//                //back
//                break;
//            case 3:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeEmployeeRemoval() {
//        Menu.displayEmployeeType();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                Registration.deleteEmployeeAccount("driver");
//                break;
//            case 2:
//                Registration.deleteEmployeeAccount("manager");
//                break;
//            case 3:
//                Registration.deleteEmployeeAccount("admin");
//                break;
//            case 4:
//                //Back
//                break;
//            case 5:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeVehicleRemoval() {
//        Menu.displayVehicleType();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                removeVehicleByCriteria("bus");
//                break;
//            case 2:
//                removeVehicleByCriteria("car");
//                break;
//            case 3:
//                removeVehicleByCriteria("motorcycle");
//                break;
//            case 4:
//                removeVehicleByCriteria("truck");
//                break;
//            case 5:
//                removeVehicleByCriteria("van");
//                break;
//            case 6:
//                removeVehicleByCriteria("vehicle");
//                break;
//            case 7:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void removeVehicleByCriteria(String vehicleType) {
//        System.out.println("-----------------------------------\nRemove:\n1.By id\n2.By mileage\n3.All\n4.Exit");
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                if (vehicleType.equals("bus")) {
//                    VehicleRepository.showBuses(VehicleRepository.getBuses());
//                    System.out.println("----------------------------------------------------------------------");
//                    VehicleHelper.deleteVehicleById("bus");
//                } else if (vehicleType.equals("car")) {
//                    VehicleRepository.showCars(VehicleRepository.getCars());
//                    System.out.println("----------------------------------------------------------------------");
//                    VehicleHelper.deleteVehicleById("car");
//                } else if (vehicleType.equals("motorcycle")) {
//                    VehicleRepository.showMotorcycles(VehicleRepository.getMotorcycles());
//                    System.out.println("----------------------------------------------------------------------");
//                    VehicleHelper.deleteVehicleById("motorcycle");
//                } else if (vehicleType.equals("truck")) {
//                    VehicleRepository.showTrucks(VehicleRepository.getTrucks());
//                    System.out.println("----------------------------------------------------------------------");
//                    VehicleHelper.deleteVehicleById("truck");
//                } else if (vehicleType.equals("van")) {
//                    VehicleRepository.showVans(VehicleRepository.getVans());
//                    System.out.println("----------------------------------------------------------------------");
//                    VehicleHelper.deleteVehicleById("van");
//                }else if(vehicleType.equals("vehicle")){
//                    VehicleRepository.showVehicles(VehicleRepository.getAllVehicles());
//                    System.out.println("----------------------------------------------------------------------");
//                    VehicleHelper.deleteVehicleById("vehicle");
//            }
//                break;
//            case 2:
//                if (vehicleType.equals("bus")) {
//                    VehicleHelper.deleteVehicleByMileage("bus");
//                } else if (vehicleType.equals("car")) {
//                    VehicleHelper.deleteVehicleByMileage("car");
//                } else if (vehicleType.equals("motorcycle")) {
//                    VehicleHelper.deleteVehicleByMileage("motorcycle");
//                } else if (vehicleType.equals("truck")) {
//                    VehicleHelper.deleteVehicleByMileage("truck");
//                } else if (vehicleType.equals("van")) {
//                    VehicleHelper.deleteVehicleByMileage("van");
//                }else if(vehicleType.equals("vehicle")){
//                    VehicleHelper.deleteVehicleByMileage("vehicle");
//                }
//                break;
//            case 3:
//                if (vehicleType.equals("bus")) {
//                    VehicleHelper.deleteAllVehicles("bus");
//                } else if (vehicleType.equals("car")) {
//                    VehicleHelper.deleteAllVehicles("car");
//                } else if (vehicleType.equals("motorcycle")) {
//                    VehicleHelper.deleteAllVehicles("motorcycle");
//                } else if (vehicleType.equals("truck")) {
//                    VehicleHelper.deleteAllVehicles("truck");
//                } else if (vehicleType.equals("van")) {
//                    VehicleHelper.deleteAllVehicles("van");
//                }else if (vehicleType.equals("vehicle")){
//                    VehicleHelper.deleteAllVehicles("vehicle");
//                }
//                break;
//            case 4:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeVehiclesShow() {
//        Menu.displayVehicleTypeToShow();
//        switch (VehicleHelper.intScanner("Choice: ")) {
//            case 1:
//                VehicleRepository.showBuses(VehicleRepository.getBuses());
//                break;
//            case 2:
//                VehicleRepository.showCars(VehicleRepository.getCars());
//                break;
//            case 3:
//                VehicleRepository.showMotorcycles(VehicleRepository.getMotorcycles());
//                break;
//            case 4:
//                VehicleRepository.showTrucks(VehicleRepository.getTrucks());
//                break;
//            case 5:
//                VehicleRepository.showVans(VehicleRepository.getVans());
//                break;
//            case 6:
//                VehicleRepository.showVehicles(VehicleRepository.getAllVehicles());
//                break;
//            case 7:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public static void executeOrderCreationMenu() {
//    }
//    public static void executeCustomerDisplay(){
//        System.out.println("Choose type of customer:\n1.Customer\n2.Customer b2b(VAT)\n3.Exit");
//        switch (VehicleHelper.intScanner("choose")){
//            case 1:
//                UserRepository.showCustomers(UserRepository.getCustomer());
//                break;
//            case 2:
//                UserRepository.showCustomersB2B(UserRepository.getCustomerB2B());
//                break;
//            case 3:
//                break;
//        }
//    }
//
//    public static void executeCustomerDisplayAndCustomerRemoval(){
//        System.out.println("Choose type of customer:\n1.Customer\n2.Customer b2b(VAT)\n3.Exit");
//        switch (VehicleHelper.intScanner("choose")){
//            case 1:
//                UserRepository.showCustomers(UserRepository.getCustomer());
//                Registration.deleteCustomerAccountByEmployee("customer");
//                break;
//            case 2:
//                UserRepository.showCustomersB2B(UserRepository.getCustomerB2B());
//                Registration.deleteCustomerAccountByEmployee("customerb2b");
//                break;
//            case 3:
//                break;
//        }
//    }
//
//}