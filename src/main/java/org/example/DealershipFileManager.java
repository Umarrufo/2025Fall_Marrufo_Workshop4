package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager
{
    public Dealership getDealership()
    {
        Dealership dealership = null;
        List<Vehicle> vehicles = new ArrayList<>();

        try
        {
            FileReader fr = new FileReader("src/main/resources/inventory.csv");
            BufferedReader reader = new BufferedReader(fr);

            String firstLine = reader.readLine();

            if(firstLine != null)
            {
                String[] dealershipData = firstLine.split("\\|");
                dealership = new Dealership(dealershipData[0], dealershipData[1], dealershipData[2]);
            }

            String line;

            while((line = reader.readLine()) != null)
            {
                String[] vehicleData = line.split("\\|");
                //[0] = vin, [1] = year, [2] = make, [3] = model, [4] = vehicleType, [5] = color, [6] = odometer, [7] = price
                Vehicle newVehicle = new Vehicle();
                newVehicle.setVin(Integer.parseInt(vehicleData[0]));
                newVehicle.setYear(Integer.parseInt(vehicleData[1]));
                newVehicle.setMake(vehicleData[2]);
                newVehicle.setModel(vehicleData[3]);
                newVehicle.setVehicleType(vehicleData[4]);
                newVehicle.setColor(vehicleData[5]);
                newVehicle.setOdometer(Integer.parseInt(vehicleData[6]));
                newVehicle.setPrice(Double.parseDouble(vehicleData[7]));

                vehicles.add(newVehicle);
            }

            if(dealership != null)
            {
                for(Vehicle vehicle : vehicles)
                {
                    dealership.addVehicle(vehicle);
                }
            }

            reader.close();

        }
        catch (FileNotFoundException ex1)
        {
            System.out.println("Could not find the file");
        }
        catch (IOException ex2) {
            System.out.println("File had a problem with it");
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership)
    {
        //File writer used when asking for user input
        try
        {
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bufferedWriter.newLine();

            //[0] = vin, [1] = year, [2] = make, [3] = model, [4] = vehicleType, [5] = color, [6] = odometer, [7] = price
            for(Vehicle vehicle : dealership.getAllVehicles())
            {
                bufferedWriter.write(
                        vehicle.getVin()
                        + "|" + vehicle.getYear()
                        + "|" + vehicle.getMake()
                        + "|" + vehicle.getModel()
                        + "|" + vehicle.getVehicleType()
                        + "|" + vehicle.getColor()
                        + "|" + vehicle.getOdometer()
                        + "|" + vehicle.getPrice() + "\n");
            }

            bufferedWriter.close();
        }
        catch(IOException ex)
        {
            System.out.println("Something went wrong with the file, try again");
        }
    }
}
