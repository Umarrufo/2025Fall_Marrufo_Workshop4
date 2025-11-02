package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface
{
    private Dealership dealership;

    public UserInterface()
    {
        init();
    }

    private void init()
    {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
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
            System.out.println("6)  Show Vehicles by Type (Car, Truck, SUV, Van)");
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
                    processGetContractRequest();
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

        while(gettingPrice)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What is the minimum price for the vehicle?");
            double minimumPrice = scanner.nextDouble();
            System.out.println("What is the maximum price for the vehicle?");
            double maximumPrice = scanner.nextDouble();

            if(minimumPrice < maximumPrice)
            {
                System.out.printf("Here are all the vehicles between %f and %f", minimumPrice, maximumPrice);
                List<Vehicle> vehicleList = dealership.getVehiclesByPrice(minimumPrice, maximumPrice);
                displayVehicles(vehicleList);
                gettingPrice = false;

            }

        }

    }

    public void processGetByMakeModelRequest()
    {
        boolean gettingMakeModel = true;

        while(gettingMakeModel)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What is the make of the vehicle?");
            String vehicleMake = scanner.nextLine().toLowerCase();
            System.out.println("What is the model of the vehicle?");
            String vehicleModel = scanner.nextLine().toLowerCase();

            List<Vehicle> vehicleList = dealership.getVehiclesByMakeModel(vehicleMake, vehicleModel);
            displayVehicles(vehicleList);
            gettingMakeModel = false;

        }
    }

    public void processGetByYearRequest()
    {
        boolean gettingYear = true;

        while(gettingYear)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What is the minimum year for the vehicle?");
            int minimumYear = scanner.nextInt();
            System.out.println("What is the maximum year for the vehicle?");
            int maximumYear = scanner.nextInt();

            if(minimumYear < maximumYear)
            {
                System.out.printf("Here are all the vehicles between %d and %d", minimumYear, maximumYear);
                List<Vehicle> vehicleList = dealership.getVehiclesByYear(minimumYear, maximumYear);
                displayVehicles(vehicleList);
                gettingYear = false;

            }
        }


    }

    public void processGetByColorRequest()
    {
        boolean gettingColor = true;

        while(gettingColor)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What is the color of the vehicle?");
            String vehicleColor = scanner.nextLine();

            List<Vehicle> vehicleList = dealership.getVehiclesByColor(vehicleColor);
            displayVehicles(vehicleList);
            gettingColor = false;

        }

    }

    public void processGetByMileageRequest()
    {
        boolean gettingMileage = true;

        while(gettingMileage)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What is the minimum mileage for the vehicle?");
            int minimumPrice = scanner.nextInt();
            System.out.println("What is the maximum mileage for the vehicle?");
            int maximumPrice = scanner.nextInt();

            if(minimumPrice < maximumPrice)
            {
                System.out.printf("Here are all the vehicles between %d and %d", minimumPrice, maximumPrice);
                List<Vehicle> vehicleList = dealership.getVehiclesByMileage(minimumPrice, maximumPrice);
                displayVehicles(vehicleList);
                gettingMileage = false;
            }
        }

    }

    public void processGetByVehicleTypeRequest()
    {
        boolean gettingType = true;

        while(gettingType)
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What is the type of the vehicle?");
            String vehicleType = scanner.nextLine().toLowerCase();

            List<Vehicle> vehicleList = dealership.getVehiclesByType(vehicleType);
            displayVehicles(vehicleList);
            gettingType = false;
        }
    }

    public void processGetAllVehicleRequest()
    {
        dealership.getAllVehicles();

    }

    public void processAddVehicleRequest()
    {


    }

    public void processRemoveVehicleRequest()
    {

    }

    private void displayVehicles(List<Vehicle> vehicles)
    {
        for (Vehicle vehicle : vehicles)
        {
            System.out.printf(("\n%d | %d  | %s | %s | %s | %s | %d | %f"),
                    vehicle.getVin(), vehicle.getYear(),
                    vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(), vehicle.getOdometer(),
                    vehicle.getPrice());
        }
    }

    private void processGetContractRequest()
    {
        //
    }
}
