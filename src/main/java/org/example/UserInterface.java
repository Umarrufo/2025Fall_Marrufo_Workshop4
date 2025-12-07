package org.example;

import dao.VehicleDao;

import java.util.List;
import java.util.Scanner;

public class UserInterface
{
    private static String dbURL;
    private static String dbUser;
    private static String dbPass;

    public UserInterface(String dbURL, String dbUser, String dbPass)
    {
        this.dbURL = dbURL;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public void display()
    {
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while(isRunning)
        {
            System.out.println("\nPlease choose an option:");
            System.out.println("1)  Show Vehicles by Price");
            System.out.println("2)  Show Vehicles by Make/Model");
            System.out.println("3)  Show Vehicles by Year");
            System.out.println("4)  Show Vehicles by Color");
            System.out.println("5)  Show Vehicles by Mileage");
            System.out.println("6)  Show Vehicles by Type (Sedan, Truck, SUV)");
            System.out.println("7)  Show All Vehicles");
            System.out.println("8)  Add a Vehicle");
            System.out.println("9)  Remove a Vehicle");
            System.out.println("10  Contracts");
            System.out.println("0)  Exit");

            String mainMenuInput = scanner.nextLine();

            if(mainMenuInput.isBlank())
            {
                System.out.println("Please type something in.");
                continue;
            }

            switch (mainMenuInput)
            {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehicleRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "10":
                    processGetSalesContractRequest();
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Choice - Please Try Again");
            }
        }
        scanner.close();
    }

    public void processGetByPriceRequest()
    {
        boolean gettingPrice = true;

        VehicleDao dao = new VehicleDao(dbURL, dbUser, dbPass);

        while(gettingPrice)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nWhat is the minimum price for the vehicle?");
            double minimumPrice = scanner.nextDouble();
            System.out.println("What is the maximum price for the vehicle?");
            double maximumPrice = scanner.nextDouble();

            if(minimumPrice < maximumPrice)
            {
                System.out.printf("Here are all the vehicles between %.2f and %.2f", minimumPrice, maximumPrice);

                System.out.println();

                List<Vehicle> vehicleList = dao.getVehicleByPrice(minimumPrice, maximumPrice);
                vehicleList.stream().forEach(x -> System.out.println(x.toString()));

                gettingPrice = false;
            }
        }
    }

    public void processGetByMakeModelRequest()
    {
        boolean gettingMakeModel = true;

        VehicleDao dao = new VehicleDao(dbURL, dbUser, dbPass);

        while(gettingMakeModel)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nWhat is the make of the vehicle?");
            String vehicleMake = scanner.nextLine().toLowerCase();
            System.out.println("What is the model of the vehicle?");
            String vehicleModel = scanner.nextLine().toLowerCase();

            System.out.println();

            List<Vehicle> vehicleList = dao.getVehicleByMakeModel(vehicleMake, vehicleModel);
            vehicleList.stream().forEach(x -> System.out.println(x.toString()));

            gettingMakeModel = false;
        }
    }

    public void processGetByYearRequest()
    {
        boolean gettingYear = true;

        VehicleDao dao = new VehicleDao(dbURL, dbUser, dbPass);

        while(gettingYear)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nWhat is the minimum year for the vehicle?");
            int minimumYear = scanner.nextInt();
            System.out.println("What is the maximum year for the vehicle?");
            int maximumYear = scanner.nextInt();

            if(minimumYear < maximumYear)
            {
                System.out.printf("Here are all the vehicles between %d and %d", minimumYear, maximumYear);

                System.out.println();

                List<Vehicle> vehicleList = dao.getVehicleByYear(minimumYear, maximumYear);
                vehicleList.stream().forEach(x -> System.out.println(x.toString()));

                gettingYear = false;
            }
        }
    }

    public void processGetByColorRequest()
    {
        boolean gettingColor = true;

        VehicleDao dao = new VehicleDao(dbURL, dbUser, dbPass);

        while(gettingColor)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nWhat is the color of the vehicle?");
            String vehicleColor = scanner.nextLine();

            System.out.println();

            List<Vehicle> vehicleList = dao.getVehicleByColor(vehicleColor);
            vehicleList.stream().forEach(x -> System.out.println(x.toString()));

            gettingColor = false;
        }
    }

    public void processGetByMileageRequest()
    {
        boolean gettingMileage = true;

        VehicleDao dao = new VehicleDao(dbURL, dbUser, dbPass);

        while(gettingMileage)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nWhat is the minimum mileage for the vehicle?");
            int minimumPrice = scanner.nextInt();
            System.out.println("What is the maximum mileage for the vehicle?");
            int maximumPrice = scanner.nextInt();

            if(minimumPrice < maximumPrice)
            {
                System.out.printf("Here are all the vehicles between %d and %d", minimumPrice, maximumPrice);

                System.out.println();

                List<Vehicle> vehicleList = dao.getVehicleByMileRange(minimumPrice, maximumPrice);
                vehicleList.stream().forEach(x -> System.out.println(x.toString()));

                gettingMileage = false;
            }
        }
    }

    public void processGetByVehicleTypeRequest()
    {
        boolean gettingType = true;

        VehicleDao dao = new VehicleDao(dbURL, dbUser, dbPass);

        while(gettingType)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nWhat is the type of the vehicle?");
            String vehicleType = scanner.nextLine().toLowerCase();

            System.out.println();

            List<Vehicle> vehicleList = dao.getVehicleByVehicleType(vehicleType);
            vehicleList.stream().forEach(x -> System.out.println(x.toString()));

            gettingType = false;
        }
    }

    public void processGetAllVehicleRequest()
    {
        VehicleDao dao = new VehicleDao(dbURL, dbUser, dbPass);

        List<Vehicle> vehicleList = dao.getAllVehicles();
        vehicleList.stream().forEach(x -> System.out.println(x.toString()));
    }

    public void processAddVehicleRequest()
    {
        VehicleDao dao = new VehicleDao(dbURL, dbUser, dbPass);

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter the VIN number of the vehicle (Only Numbers):");
        int vinNumber = scanner.nextInt();
        System.out.println("Enter the year of the vehicle:");
        int vehicleYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the make of the vehicle:");
        String vehicleMake = scanner.nextLine();
        System.out.println("Enter the model of the vehicle:");
        String vehicleModel = scanner.nextLine();
        System.out.println("Enter the vehicle type:");
        String vehicleType = scanner.nextLine();
        System.out.println("Enter the vehicle color:");
        String vehicleColor = scanner.nextLine();
        System.out.println("Enter the odometer reading of the vehicle:");
        int vehicleOdometer = scanner.nextInt();
        System.out.println("Enter the price of the vehicle");
        double vehiclePrice = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vinNumber, vehicleYear, vehicleMake, vehicleModel, vehicleType, vehicleColor, vehicleOdometer, vehiclePrice);

        dao.addVehicle(newVehicle);
    }

    public void processRemoveVehicleRequest()
    {
        VehicleDao dao = new VehicleDao(dbURL, dbUser, dbPass);

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter the VIN number of the vehicle (Only Numbers):");
        int vinNumber = scanner.nextInt();

        dao.removeVehicle(vinNumber);
    }


    private void processGetSalesContractRequest()
    {
        //
    }

    private void processGetLeaseContractRequest()
    {
        //
    }

}
