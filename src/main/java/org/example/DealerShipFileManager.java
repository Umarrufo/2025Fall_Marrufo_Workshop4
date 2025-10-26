package org.example;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DealerShipFileManager
{
    public static List<Vehicle> inventoryHelper() {
        List<Vehicle> vehicles = new ArrayList<>();


        //File reader to see transaction history
        try {
            FileReader fr = new FileReader("src/main/resources/inventory.csv");
            BufferedReader reader = new BufferedReader(fr);

            String line;
            while ((line = reader.readLine()) != null) {
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
            reader.close();

        }
        catch (FileNotFoundException ex1)
        {
            System.out.println("Could not find the file");
        }
        catch (IOException ex2) {
            System.out.println("File had a problem with it");
        }

        return vehicles;
    }

    public static void writeVehicle (Vehicle vehicle)
    {
        //File writer used when asking for user input
        try
        {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            FileWriter fileWriter = new FileWriter("src/main/resources/Transactions.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //[0] = vin, [1] = year, [2] = make, [3] = model, [4] = vehicleType, [5] = color, [6] = odometer, [7] = price

            bufferedWriter.write("\n" + vehicle.getVin()
                    + "|" + vehicle.getYear()
                    + "|" + vehicle.getMake()
                    + "|" + vehicle.getModel()
                    + "|" + vehicle.getVehicleType()
                    + "|" + vehicle.getColor()
                    + "|" + vehicle.getOdometer()
                    + "|" + vehicle.getPrice());

            bufferedWriter.close();
        }
        catch(IOException ex)
        {
            System.out.println("Something went wrong with the file, try again");
        }
    }
}
