//package org.example;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ContractFileManager
//{
//    public Contract getContract()
//    {
//        Contract contract = null;
//        List<Contract> contracts = new ArrayList<>();
//
//        try {
//            FileReader fr = new FileReader("src/main/resources/contract.csv");
//            BufferedReader reader = new BufferedReader(fr);
//
//            String line;
//
//            while((line = reader.readLine()) != null)
//            {
//                String[] contractData = line.split("\\|");
//                //[0] = vin, [1] = year, [2] = make, [3] = model, [4] = vehicleType, [5] = color, [6] = odometer, [7] = price
//                Contract newContract = new Contract() {}
//                newVehicle.setVin(Integer.parseInt(contractData[0]));
//                newVehicle.setYear(Integer.parseInt(contractData[1]));
//                newVehicle.setMake(contractData[2]);
//                newVehicle.setModel(contractData[3]);
//                newVehicle.setVehicleType(contractData[4]);
//                newVehicle.setColor(contractData[5]);
//                newVehicle.setOdometer(Integer.parseInt(contractData[6]));
//                newVehicle.setPrice(Double.parseDouble(contractData[7]));
//
//                vehicles.add(newVehicle);
//            }
//
//            reader.close();
//
//        } catch (FileNotFoundException ex3) {
//            System.out.println("Could not find the file");
//        } catch (IOException ex2) {
//            System.out.println("File had a problem with it");
//        }
//
//        return contract;
//    }
//
//    public void saveContract(Contract contract) {
//        //File writer used when asking for user input
//        try {
//            FileWriter fileWriter = new FileWriter("src/main/resources/contract .csv");
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//
//
//            bufferedWriter.close();
//        } catch (IOException ex) {
//            System.out.println("Something went wrong with the file, try again");
//        }
//    }
//}